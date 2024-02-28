package harriston.school.service;

import harriston.school.core.contracts.AdminService;
import harriston.school.core.entities.*;
import harriston.school.repository.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultAdminService implements AdminService {
    private final SchoolPositionRepository schoolPositionRepository;
    private final OccupationRepository occupationRepository;
    private final ClassroomRepository classroomRepository;
    private final ParentRepository parentRepository;
    private final StaffRepository staffRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final SchoolReportRepository schoolReportRepository;
    private final SchoolUserRepository schoolUserRepository;
    private final  CommentRepository commentRepository;
    public DefaultAdminService(SchoolPositionRepository schoolPositionRepository,
                               OccupationRepository occupationRepository,
                               ClassroomRepository classroomRepository,
                               ParentRepository parentRepository,
                               StaffRepository staffRepository,
                               StudentRepository studentRepository,
                               SubjectRepository subjectRepository,
                               SchoolReportRepository schoolReportRepository,
                               SchoolUserRepository schoolUserRepository,
                               CommentRepository commentRepository) {
        this.schoolPositionRepository = schoolPositionRepository;
        this.occupationRepository = occupationRepository;
        this.classroomRepository = classroomRepository;
        this.parentRepository = parentRepository;
        this.staffRepository = staffRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.schoolReportRepository = schoolReportRepository;
        this.schoolUserRepository = schoolUserRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public ISave save(ISave type) {
        return switch (type) {
            case Parent parent -> parentRepository.save(parent);
            case SchoolReport schoolReport -> schoolReportRepository.save(schoolReport);
            case Staff staff -> staffRepository.save(staff);
            case Student student -> studentRepository.save(student);
            case Subject subject -> subjectRepository.save(subject);
            case Classroom classroom -> classroomRepository.save(classroom);
            case Occupation occupation -> occupationRepository.save(occupation);
            case SchoolUser schoolUser -> schoolUserRepository.save(schoolUser);
            case SchoolPosition schoolPosition -> schoolPositionRepository.save(schoolPosition);
            case Comment comment -> commentRepository.save(comment);
        };
    }

    @Override
    public List<ISave> listAll(ISave type) {
        return switch (type) {
            case Parent parent -> findAll(parentRepository, parent.getId());
            case SchoolReport schoolReport -> findAll(schoolReportRepository, schoolReport.getId());
            case Staff staff -> findAll(staffRepository, staff.getId());
            case Student student -> findAll(studentRepository, student.getId());
            case Subject subject -> findAll(subjectRepository, subject.getId());
            case Classroom classroom -> findAll(classroomRepository, classroom.getId());
            case Occupation occupation -> findAll(occupationRepository, occupation.getId());
            case SchoolUser schoolUser -> findAll(schoolUserRepository, schoolUser.getId());
            case SchoolPosition schoolPosition -> findAll(schoolPositionRepository, schoolPosition.getId());
            case Comment comment -> findAll(commentRepository, comment.getId());
        };
    }

    private List<ISave> findAll(JpaRepository<? extends ISave, Long> repository, Long id) {
        return Optional.ofNullable(id).map(aLong -> repository.findById(aLong)
                        .stream().map(ISave.class::cast).collect(Collectors.toList()))
                .orElseGet(() -> repository.findAll().stream()
                        .map(ISave.class::cast)
                        .collect(Collectors.toList()));
    }

    @Override
    public void delete(ISave type) {
        switch (type) {
            case Parent parent -> deleteById(parentRepository, parent.getId());
            case SchoolReport schoolReport -> deleteById(schoolReportRepository, schoolReport.getId());
            case Staff staff -> deleteById(staffRepository, staff.getId());
            case Student student -> deleteById(studentRepository, student.getId());
            case Subject subject -> deleteById(subjectRepository, subject.getId());
            case Classroom classroom -> deleteById(classroomRepository, classroom.getId());
            case Occupation occupation -> deleteById(occupationRepository, occupation.getId());
            case SchoolUser schoolUser -> deleteById(schoolUserRepository, schoolUser.getId());
            case SchoolPosition schoolPosition -> deleteById(schoolPositionRepository, schoolPosition.getId());
            case Comment comment -> deleteById(commentRepository, comment.getId());
        };

    }

    private void deleteById(JpaRepository<? extends ISave, Long> repository, Long id){
        repository.deleteById(id);
    }

}
