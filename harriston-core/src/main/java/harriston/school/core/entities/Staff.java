package harriston.school.core.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public final class Staff implements ISave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @ManyToOne
    @JoinColumn(name = "school_position_id")
    private SchoolPosition position;

    @Column(name = "is_hod")
    private Boolean isHOD;

    @OneToMany
    private List<Subject> teachSubjects;

    @ManyToMany
    @JoinTable(
            name = "staff_classroom",
            joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id")
    )
    private List<Classroom> classrooms;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "staff_user",
            joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private SchoolUser schoolUserDetails;

}

