package volunteering.SPP.DBEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "Events")
@Getter
@Setter
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "name")
    private String name;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "location")
    private String location;

    @Column(name = "event_description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private EventCategory category;

    @Column(name = "completed")
    private boolean completed;

    // Getters and setters

}

