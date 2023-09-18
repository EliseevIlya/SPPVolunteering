/*
package volunteering.SPP.Controllers2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.Services.UserService;

import java.util.List;


@RequestMapping("/users")
@RestController

public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<DBUser> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public DBUser getById(@PathVariable("id") long id){
        return userService.getById(id);
    }
    @PutMapping("/{id}")
    public DBUser update(@RequestBody DBUser user, @PathVariable("id") long id){
        return userService.update(user);
    }
    @PostMapping
    public DBUser create(@RequestBody DBUser user){
        return userService.create(user);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") long id){
        userService.removeById(id);
    }
}
*/
