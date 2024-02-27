package harriston.school.core.entities;

import jakarta.persistence.*;

@Entity
public final class SchoolPosition implements ISave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "position", nullable = false)
    private String position;

    // No-argument constructor required by JPA
    public SchoolPosition() {
    }

    // Constructor with fields
    public SchoolPosition(Long id, String position) {
        this.id = id;
        this.position = position;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

