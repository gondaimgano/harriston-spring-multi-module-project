package harriston.school.repository;

import harriston.school.core.entities.SchoolReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolReportRepository extends JpaRepository<SchoolReport,Long> {
    List<SchoolReport> findByStudentId(Long id);

    List<SchoolReport> findByTeacherId(Long id);
}
