package harriston.school.config;

import harriston.school.core.contracts.AdminService;
import harriston.school.core.contracts.ParentService;
import harriston.school.core.contracts.StaffService;
import harriston.school.repository.*;
import harriston.school.service.DefaultAdminService;
import harriston.school.service.DefaultParentService;
import harriston.school.service.DefaultStaffService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolCoreContractConfig {

    @Bean
    public AdminService adminContract(SchoolPositionRepository schoolPositionRepository,
                                      OccupationRepository occupationRepository,
                                      ClassroomRepository classroomRepository,
                                      ParentRepository parentRepository, StaffRepository staffRepository,
                                      StudentRepository studentRepository,
                                      SubjectRepository subjectRepository,
                                      SchoolReportRepository schoolReportRepository,
                                      SchoolUserRepository schoolUserRepository,
                                      CommentRepository commentRepository) {
        return new DefaultAdminService(schoolPositionRepository,
                occupationRepository,
                classroomRepository,
                parentRepository,
                staffRepository,
                studentRepository,
                subjectRepository,
                schoolReportRepository,
                schoolUserRepository,
                commentRepository);
    }

    @Bean
    @Qualifier("parentService")
    public ParentService parentContract(
            SchoolReportRepository schoolReportRepository,
            ParentRepository parentRepository
    ) {
        return new DefaultParentService(schoolReportRepository, parentRepository);
    }

    @Bean
    @Qualifier("staffService")
    public StaffService staffContract(SchoolReportRepository schoolReportRepository,
                                      ParentRepository parentRepository,
                                      StaffRepository staffRepository,
                                      SchoolUserRepository schoolUserRepository, CommentRepository commentRepository) {
        return new DefaultStaffService(schoolReportRepository,
                parentRepository,
                schoolUserRepository,
                staffRepository, commentRepository);
    }
}
