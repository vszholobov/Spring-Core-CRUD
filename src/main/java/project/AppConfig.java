package project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Set;

//@Import({WebConfig.class, JPAConfig.class})
@Configuration
@ComponentScan
@EnableWebMvc
@EnableWebSecurity
public class AppConfig {
    @Bean
    public Set<String> washerFields() {
        return Set.of("weight", "volume", "brand", "ownerName", "password");
    }
}
