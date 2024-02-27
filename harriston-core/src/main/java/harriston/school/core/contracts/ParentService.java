package harriston.school.core.contracts;

import harriston.school.core.entities.SchoolReport;
import harriston.school.core.entities.Student;

import java.util.List;

public interface ParentService {

   List<SchoolReport> viewAllReports(Long parentId);

   List<Student> viewYourChildrenProfile(Long parentId);

}
