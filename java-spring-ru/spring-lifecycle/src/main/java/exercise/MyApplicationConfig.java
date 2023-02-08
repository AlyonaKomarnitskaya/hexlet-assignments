package exercise;

import java.time.LocalDateTime;

import exercise.daytimes.Daytime;
import exercise.daytimes.Morning;
import exercise.daytimes.Day;
import exercise.daytimes.Evening;
import exercise.daytimes.Night;

// BEGIN
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Аннотация @Configuration указывает, что класс содержит методы, создающие бины
@Configuration
public class MyApplicationConfig {

    @Bean
    public Daytime getDaytime() {
        int currentHour = LocalDateTime.now().getHour();
        if (12 > currentHour && currentHour >= 6) {
            return new Morning();
        }
        if (18 > currentHour && currentHour >= 12) {
            return new Day();
        }
        if (23 > currentHour && currentHour >= 18) {
            return new Evening();
        } else {
                return new Night();
        }
    }
}


// END
