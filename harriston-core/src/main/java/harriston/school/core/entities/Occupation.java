package harriston.school.core.entities;

import jakarta.persistence.*;

@Entity
public final class Occupation implements ISave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = false,unique = true)
    private String description;

    // No-argument constructor required by JPA
    public Occupation() {
    }

    // Constructor with fields
    public Occupation(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

