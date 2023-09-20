package volunteering.SPP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import volunteering.SPP.DBEntity.Event;

import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    public List<Event> findByCompletedFalse();

    @Query(value = "select e.event_id, e.name, e.start_time, e.location, e.event_description, \n" +
            "ec.category_id,ec.category_name, e.completed, u.login,\n" +
            "u.contact_details, u.user_id, er.role_name\n" +
            "from composition c\n" +
            "join events e on c.event_id=e.event_id\n" +
            "join users u on c.user_id=u.user_id\n" +
            "join event_role er on c.role_id=er.role_id\n" +
            "join event_category ec on ec.category_id=e.category_id\n" +
            "where c.role_id= :roleId and e.completed='false' ", nativeQuery = true)
    List<Object[]> findNotCompletedEventCreatorInfo(@Param("roleId") Long roleId);

    @Query(value = "select e.event_id, e.name, e.start_time, e.location, e.event_description, \n" +
            "ec.category_id,ec.category_name, e.completed, u.login,\n" +
            "u.contact_details, u.user_id, er.role_name\n" +
            "from composition c\n" +
            "join events e on c.event_id=e.event_id\n" +
            "join users u on c.user_id=u.user_id\n" +
            "join event_role er on c.role_id=er.role_id\n" +
            "join event_category ec on ec.category_id=e.category_id\n" +
            "where c.role_id= :roleId and c.event_id = :eventID ", nativeQuery = true)
    List<Object[]> findEventCreatorInfoByEventID(@Param("roleId") Long roleId, @Param("eventID") Long eventID);
    boolean existsByNameAndDescriptionAndStartTime(String name, String description, String startTime);
    Event findByNameAndDescriptionAndStartTime(String name, String description, String startTime);



    // You can define custom query methods here if needed.
}

