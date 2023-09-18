package volunteering.SPP.DBEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "EventCategory")
@Getter
@Setter
public class EventCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long idCategory;

    @Column(name = "category_name")
    private String categoryName;

    // Getters and setters

}

