package volunteering.SPP.DBEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "Composition")
@Getter
@Setter
@RequiredArgsConstructor
public class Composition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "record_id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private DBUser user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private EventRole eventRole;

    // Getters and setters

}

