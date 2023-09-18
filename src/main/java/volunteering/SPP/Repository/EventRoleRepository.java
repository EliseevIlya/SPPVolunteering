package volunteering.SPP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volunteering.SPP.DBEntity.EventRole;

@Repository
public interface EventRoleRepository extends JpaRepository<EventRole, Long> {
    // You can define custom query methods here if needed.
}
