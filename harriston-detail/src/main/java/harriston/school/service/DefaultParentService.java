package harriston.school.service;

import harriston.school.core.contracts.ParentService;
import harriston.school.core.entities.*;
import harriston.school.repository.ParentRepository;
import harriston.school.repository.SchoolReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultParentService implements ParentService {
    protected final SchoolReportRepository schoolReportRepository;
    protected final ParentRepository parentRepository;

    public DefaultParentService(SchoolReportRepository schoolReportRepository, ParentRepository parentRepository) {
        this.schoolReportRepository = schoolReportRepository;
        this.parentRepository = parentRepository;
    }

    @Override
    public List<SchoolReport> viewAllReports(Long student) {
        return schoolReportRepository.findByStudentId(student);
    }

    @Override
    public List<Student> viewYourChildrenProfile(Long parent) {
        return parentRepository.findById(parent).map(Parent::getStudents).orElseGet(List::of);
    }
}
