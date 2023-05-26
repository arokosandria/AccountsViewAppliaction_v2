package pl.coderslab.accountsview.person;


import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.coderslab.accountsview.address.Address;

import static org.mockito.Mockito.when;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PersonController.class)
public class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonService personService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getPersonByName() throws Exception {
        Address address = new Address(1L, "Czachowskiego", 12, 3, "27-900", "krakow");
        PersonDto person = new PersonDto(1L, "konto_numer1", "karolina.mrowka@interia.pl", LocalDate.parse("2014-03-18"), "karolina", "mrowka", "73120639665", address);

        when(personService.getByName("konto_numer1")).thenReturn(person);
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/persons/{name}", "konto_numer1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("konto_numer1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.is("karolina.mrowka@interia.pl")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthday", Matchers.is("2014-03-18")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("karolina")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("mrowka")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pesel", Matchers.is("73120639665")));
    }

    @Test
    public void givenPersons_whenDeleteByIdOfThatPerson_thenDeleteThatPerson() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.delete("/api/persons/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(personService, Mockito.times(1)).delete(1L);
    }
    @Test
    public void whenCreatePerson_withBirthday_fail() throws Exception {

        Address address = new Address(1L, "Czachowskiego", 12, 3, "27-900", "krakow");
        PersonDto person = new PersonDto(1L, "konto_numer1", "karolina.mrowka@interia.pl", null, "karolina", "mrowka", "73120639665", address);

        mockMvc
                .perform(
                        post("/api/persons")
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(person)))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }
}
