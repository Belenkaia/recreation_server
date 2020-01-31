package su.nsk.comptech.recreation.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "ru.comptech.recreation.api.entities")
@EnableJpaRepositories(basePackages = "ru.comptech.recreation.api.repositories")
public class DatabaseConfig {

}
