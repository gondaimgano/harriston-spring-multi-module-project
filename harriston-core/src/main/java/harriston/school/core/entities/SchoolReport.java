package harriston.school.core.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public final class SchoolReport implements ISave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(mappedBy = "schoolReport", cascade = CascadeType.ALL)
    @JsonManagedReference // Add this annotation
    private List<Comment> comments;

    @Column(name = "overall_comment")
    private String overallComment;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Staff teacher;

}

