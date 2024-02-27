package harriston.school.core.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
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

    // No-argument constructor required by JPA
    public Staff() {
    }

    // Constructor with fields
    public Staff(Long id, String firstName, String surname, Date dob, SchoolPosition position, Boolean isHOD, List<Subject> teachSubjects, List<Classroom> classrooms, SchoolUser schoolUserDetails) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.dob = dob;
        this.position = position;
        this.isHOD = isHOD;
        this.teachSubjects = teachSubjects;
        this.classrooms = classrooms;
        this.schoolUserDetails = schoolUserDetails;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public SchoolPosition getPosition() {
        return position;
    }

    public void setPosition(SchoolPosition position) {
        this.position = position;
    }

    public Boolean getHOD() {
        return isHOD;
    }

    public void setHOD(Boolean HOD) {
        isHOD = HOD;
    }

    public List<Subject> getTeachSubjects() {
        return teachSubjects;
    }

    public void setTeachSubjects(List<Subject> teachSubjects) {
        this.teachSubjects = teachSubjects;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public SchoolUser getUserDetails() {
        return schoolUserDetails;
    }

    public void setUserDetails(SchoolUser schoolUserDetails) {
        this.schoolUserDetails = schoolUserDetails;
    }
}

