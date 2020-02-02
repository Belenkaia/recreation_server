package su.nsk.comptech.recreation.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "su.nsk.comptech.recreation.api.entities")
@EnableJpaRepositories(basePackages = "su.nsk.comptech.recreation.api.repositories")
public class DatabaseConfig {

}