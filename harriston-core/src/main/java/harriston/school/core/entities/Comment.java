package harriston.school.core.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "result")
    private String result;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "school_report_id")
    @JsonBackReference // Add this annotation
    private SchoolReport schoolReport;

    // No-argument constructor required by JPA
    public Comment() {
    }

    // Constructor with fields
    public Comment(Long id, String text, String result, Subject subject) {
        this.id = id;
        this.text = text;
        this.result = result;
        this.subject = subject;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SchoolReport getSchoolReport() {
        return schoolReport;
    }

    public void setSchoolReport(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }
}

