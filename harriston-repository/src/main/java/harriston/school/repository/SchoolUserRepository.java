package harriston.school.repository;

import harriston.school.core.entities.SchoolUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolUserRepository extends JpaRepository<SchoolUser, Long> {
    SchoolUser findByUsernameAndPassword(String username, String password);
}
