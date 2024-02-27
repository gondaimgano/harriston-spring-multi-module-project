package harriston.school.app;

import harriston.school.config.SchoolCoreContractConfig;
import harriston.school.core.entities.config.SchoolEntityConfig;
import harriston.school.repository.config.SchoolRepositoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SchoolRepositoryConfig.class,SchoolEntityConfig.class, SchoolCoreContractConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
