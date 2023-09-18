package volunteering.SPP.Services;

import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.Repository.UserRepository;
import volunteering.SPP.dto.UserLoginPassw;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService implements UserCrudService  {

    @Autowired
    private UserRepository userRepository;
/*
    private BCryptPasswordEncoder passwordEncoder;
*/


    public DBUser findByLoginAndPassword(UserLoginPassw userLoginPassw){
        String login=userLoginPassw.getLogin();
        String password = userLoginPassw.getPassword();
        return userRepository.findByLoginAndPassword(login,password).orElseThrow(()->{
            throw new DataIntegrityViolationException("Incorrect login :" + login + "or password :" + password);
        });
    }
    @Override
    public DBUser create(DBUser user) {
        if(userRepository.findByLogin(user.getLogin()).isPresent()) {
            throw new EntityExistsException("User :'"+ user.getUserId() +"' already exists");
        }
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public DBUser update(DBUser user) {
        long id=user.getUserId();
        if(!userRepository.existsById(id)) {
            throw new EntityExistsException("User doesn't exists");
        }
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void removeById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void remove(DBUser user) {
        userRepository.delete(user);
    }

    @Override
    public void removeByLogin(String login) {
        userRepository.removeByLogin(login);
    }

    @Override
    public List<DBUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public DBUser getById(long id) {
        return userRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("user with id: " + id + " doesn't exists");
        });
    }

    @Override
    public DBUser getByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(()->{
            throw new UsernameNotFoundException("user with login: " + login
                    + " doesn't exists");
        });
    }

    @Override
    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existsByLogin(String login) {
        return userRepository.findByLogin(login).isPresent();

    }
}
