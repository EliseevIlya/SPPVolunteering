package volunteering.SPP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import volunteering.SPP.DBEntity.Composition;

import java.util.List;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, Long> {

    @Query(value = "SELECT COUNT(c) FROM Composition c WHERE c.user_id = :userId AND c.event_id = :eventId", nativeQuery = true)
    int countByUserIdAndEventId(@Param("userId") Long userId, @Param("eventId") Long eventId);

    @Modifying
    @Query(value = "DELETE FROM Composition c WHERE c.user_id = :userId AND c.event_id = :eventId",nativeQuery = true)
    void deleteByUserIdAndEventId(@Param("userId") Long userId, @Param("eventId") Long eventId);

    @Modifying
    @Query(value = "DELETE FROM Composition c WHERE c.event_id = :eventId",nativeQuery = true)
    void deleteByEventId(@Param("eventId") Long eventId);

    /*@Query(value = " SELECT NEW volunteering.SPP.dto.EventAddUserInfo('e.event_id', 'e.name', 'e.start_time', " +
            " 'e.location', 'e.event_description', \n" +
            " 'ec.category_id','ec.category_name', 'e.completed', 'u.first_name',\n" +
            " 'u.contact_details', 'u.user_id', 'er.role_name') " +

            "from composition c\n" +
            "join events e on 'c.event_id'='e.event_id'\n" +
            "join users u on 'c.user_id'='u.user_id'\n" +
            "join event_role er on 'c.role_id'='er.role_id'\n" +
            "join event_category ec on 'ec.category_id'='e.category_id'\n" +
            "where 'c.role_id'='1'" , nativeQuery = true)*/
    /*@Query(value = "select e.event_id, e.name, e.start_time, e.location, e.event_description, \n" +
            "ec.category_id,ec.category_name, e.completed, u.first_name,\n" +
            "u.contact_details, u.user_id, er.role_name\n" +
            "from composition c\n" +
            "join events e on c.event_id=e.event_id\n" +
            "join users u on c.user_id=u.user_id\n" +
            "join event_role er on c.role_id=er.role_id\n" +
            "join event_category ec on ec.category_id=e.category_id\n" +
            "where c.role_id='1'", nativeQuery = true)
    List<Object> findEventDataForRole(Long roleId);*/
   /* @Query(value = "CREATE TEMPORARY TABLE Tempo (id BIGINT, user_id BIGINT, user_name VARCHAR(255), role_id BIGINT, role_name VARCHAR(255));\n" +
            "INSERT INTO Tempo SELECT events.event_id, users.user_id, users.first_name, event_role.role_id, event_role.role_name\n" +
            "FROM composition\n" +
            "JOIN events on composition.event_id=events.event_id\n" +
            "JOIN users on composition.user_id=users.user_id\n" +
            "JOIN event_role on event_role.role_id=composition.role_id\n" +
            "WHERE event_role.role_id=1;\n" +
            "SELECT events.event_id, events.name, events.start_time, events.location, events.event_description, event_category.category_id, event_category.category_name, events.completed, Tempo.user_id, Tempo.user_name, Tempo.role_id, Tempo.role_name\n" +
            "FROM composition\n" +
            "JOIN events on composition.event_id=events.event_id\n" +
            "JOIN users on composition.user_id=users.user_id\n" +
            "JOIN event_category on events.category_id=event_category.category_id\n" +
            "JOIN event_role on event_role.role_id=composition.role_id\n" +
            "JOIN Tempo on Tempo.id=events.event_id\n" +
            "where users.user_id=1;", nativeQuery = true )
    List<Object> test();*/

   /* @Query(value = "CREATE TEMPORARY TABLE Tempo (id BIGINT, user_id BIGINT, user_name VARCHAR(255), role_id BIGINT, role_name VARCHAR(255));", nativeQuery = true)
    void createTempTable();

    @Query(value = "INSERT INTO Tempo SELECT events.event_id, users.user_id, users.first_name, event_role.role_id, event_role.role_name FROM composition JOIN events on composition.event_id=events.event_id JOIN users on composition.user_id=users.user_id JOIN event_role on event_role.role_id=composition.role_id WHERE event_role.role_id=1;", nativeQuery = true)
    void insertIntoTempTable();

    @Query(value = "SELECT events.event_id, events.name, events.start_time, events.location, events.event_description, event_category.category_id, event_category.category_name, events.completed, Tempo.user_id, Tempo.user_name, Tempo.role_id, Tempo.role_name FROM composition JOIN events on composition.event_id=events.event_id JOIN users on composition.user_id=users.user_id JOIN event_category on events.category_id=event_category.category_id JOIN event_role on event_role.role_id=composition.role_id JOIN Tempo on Tempo.id=events.event_id where users.user_id=1;", nativeQuery = true)
    List<Object> fetchData();*/

    @Query(value = "SELECT event_id, user_id FROM Composition c WHERE c.user_id = :userId ",nativeQuery = true)
    List<Object[]> findByUserId(@Param("userId") Long userId);

    @Query(value = "select c.event_id, c.user_id , u.first_name, u.last_name, u.patronymic, u.contact_details\n" +
            "from composition c\n" +
            "join users u on c.user_id = u.user_id\n" +
            "where c.event_id = :eventId ",nativeQuery = true)
    List<Object[]> findByEventId(@Param("eventId") Long eventId);

}

