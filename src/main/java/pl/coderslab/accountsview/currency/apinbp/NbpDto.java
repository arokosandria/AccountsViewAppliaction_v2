package pl.coderslab.accountsview.currency.apinbp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record NbpDto (String currency, String code, @JsonProperty("rates")List<RateDto> rateDto){
}
