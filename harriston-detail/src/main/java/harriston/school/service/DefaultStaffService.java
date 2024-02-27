package harriston.school.service;

import harriston.school.core.contracts.StaffService;
import harriston.school.core.entities.SchoolReport;
import harriston.school.core.entities.Staff;
import harriston.school.core.entities.SchoolUser;
import harriston.school.repository.ParentRepository;
import harriston.school.repository.SchoolReportRepository;
import harriston.school.repository.SchoolUserRepository;
import harriston.school.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultStaffService extends DefaultParentService implements StaffService {

    private final StaffRepository staffRepository;
    private final SchoolUserRepository schoolUserRepository;
    public DefaultStaffService(
            @Qualifier
            SchoolReportRepository schoolReportRepository,
            @Qualifier
            ParentRepository parentRepository,
            @Qualifier
            SchoolUserRepository schoolUserRepository,
            StaffRepository staffRepository) {
        super(schoolReportRepository, parentRepository);
        this.staffRepository = staffRepository;
        this.schoolUserRepository = schoolUserRepository;
    }

    @Override
    public SchoolUser manageCredentials(SchoolUser schoolUser) {
        return schoolUserRepository.save(schoolUser);
    }

    @Override
    public Staff viewMyProfile(Long userId) {
        return staffRepository.findById(userId).orElseThrow();
    }

    @Override
    public SchoolReport create(SchoolReport report) {
        return schoolReportRepository.save(report);
    }

    @Override
    public List<SchoolReport> listReports(Long staffId) {
        return schoolReportRepository.findByTeacherId(staffId);
    }

}
