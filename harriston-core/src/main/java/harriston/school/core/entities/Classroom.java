package harriston.school.core.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public final class Classroom implements ISave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "room_name", nullable = false, unique = true)
    private String roomName;

    @Column(name = "minimum_age", nullable = false)
    private Integer minimumAge;

}

