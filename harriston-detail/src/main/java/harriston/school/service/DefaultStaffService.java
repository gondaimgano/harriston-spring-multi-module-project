package harriston.school.service;

import harriston.school.core.contracts.StaffService;
import harriston.school.core.entities.SchoolReport;
import harriston.school.core.entities.Staff;
import harriston.school.core.entities.SchoolUser;
import harriston.school.repository.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultStaffService extends DefaultParentService implements StaffService {

    private final StaffRepository staffRepository;
    private final SchoolUserRepository schoolUserRepository;

    private final CommentRepository commentRepository;

    public DefaultStaffService(
            @Qualifier
            SchoolReportRepository schoolReportRepository,
            @Qualifier
            ParentRepository parentRepository,
            @Qualifier
            SchoolUserRepository schoolUserRepository,
            StaffRepository staffRepository, CommentRepository commentRepository) {
        super(schoolReportRepository, parentRepository);
        this.staffRepository = staffRepository;
        this.schoolUserRepository = schoolUserRepository;
        this.commentRepository = commentRepository;
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
         var comments = report.getComments();
         var item = schoolReportRepository.save(report);
        comments.replaceAll(s -> {
            s.setSchoolReport(item);
            return s;
        });
        commentRepository.saveAll(comments);
        return item;
    }

    @Override
    public Long archive(Long report) {
        schoolReportRepository.deleteById(report);
        return report;
    }

    @Override
    public List<SchoolReport> listReports(Long staffId) {
        return schoolReportRepository.findByTeacherId(staffId);
    }

}
