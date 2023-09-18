package volunteering.SPP.Services;

import volunteering.SPP.DBEntity.DBUser;

import java.util.List;
import java.util.UUID;

public interface UserCrudService {
    DBUser create(DBUser user);
    DBUser update(DBUser user);
    void removeById(long id);
    void remove(DBUser user);
    void removeByLogin(String login);
    List<DBUser> getAll();
    DBUser getById(long id);
    DBUser getByLogin(String login);
    boolean existsById(long id);
    boolean existsByLogin(String login);
}
