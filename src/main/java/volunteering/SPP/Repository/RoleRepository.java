package volunteering.SPP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volunteering.SPP.DBEntity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // You can define custom query methods here if needed.
}

