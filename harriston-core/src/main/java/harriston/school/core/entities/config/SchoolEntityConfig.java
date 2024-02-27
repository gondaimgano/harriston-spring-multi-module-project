package harriston.school.core.entities.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"harriston.school.core.entities"})
public class SchoolEntityConfig {
}
