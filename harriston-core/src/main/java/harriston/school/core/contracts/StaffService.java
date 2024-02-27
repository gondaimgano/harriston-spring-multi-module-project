package harriston.school.core.contracts;

import harriston.school.core.entities.SchoolReport;
import harriston.school.core.entities.Staff;
import harriston.school.core.entities.SchoolUser;

import java.util.List;

public interface StaffService extends ParentService {

    SchoolUser manageCredentials(SchoolUser schoolUser);

    Staff viewMyProfile(Long userId);

    SchoolReport create(SchoolReport report);
    Long archive(Long report);

    List<SchoolReport> listReports(Long userId);

}
