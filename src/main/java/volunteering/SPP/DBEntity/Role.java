package volunteering.SPP.DBEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "Role")
@Getter
@Setter
public class Role implements Serializable {
    @Id
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}


