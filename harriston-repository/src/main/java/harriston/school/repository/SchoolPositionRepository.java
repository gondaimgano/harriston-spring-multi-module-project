package harriston.school.repository;

import harriston.school.core.entities.SchoolPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolPositionRepository extends JpaRepository<SchoolPosition, Long> { }
