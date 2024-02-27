package harriston.school.repository.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "harriston.school.repository")
public class SchoolRepositoryConfig {
}
