package pl.coderslab.accountsview;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;
import java.util.concurrent.TimeUnit;
@Slf4j
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class AccountsViewApplication {

  public static void main(String[] args) {
    SpringApplication.run(AccountsViewApplication.class, args);

  }

}
