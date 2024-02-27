package harriston.school.core.entities;

import jakarta.persistence.*;

@Entity
public final class Classroom implements ISave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "room_name", nullable = false, unique = true)
    private String roomName;

    @Column(name = "minimum_age", nullable = false)
    private Integer minimumAge;

    // No-argument constructor required by JPA
    public Classroom() {
    }

    // Constructor with fields
    public Classroom(Long id, String roomName, Integer minimumAge) {
        this.id = id;
        this.roomName = roomName;
        this.minimumAge = minimumAge;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }
}

