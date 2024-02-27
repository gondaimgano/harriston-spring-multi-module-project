package harriston.school.core.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public final class SchoolReport implements ISave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(mappedBy = "schoolReport", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Column(name = "overall_comment")
    private String overallComment;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Staff teacher;

    // No-argument constructor required by JPA
    public SchoolReport() {
    }

    // Constructor with fields
    public SchoolReport(Long id, Student student, List<Comment> comments, String overallComment, Staff teacher) {
        this.id = id;
        this.student = student;
        this.comments = comments;
        this.overallComment = overallComment;
        this.teacher = teacher;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getOverallComment() {
        return overallComment;
    }

    public void setOverallComment(String overallComment) {
        this.overallComment = overallComment;
    }

    public Staff getTeacher() {
        return teacher;
    }

    public void setTeacher(Staff teacher) {
        this.teacher = teacher;
    }
}

