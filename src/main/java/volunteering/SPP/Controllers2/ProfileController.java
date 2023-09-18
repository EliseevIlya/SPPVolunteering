/*
package volunteering.SPP.Controllers2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.Repository.UserRepository;
import volunteering.SPP.Services.UserService;
import volunteering.SPP.annotations.CurrentUser;


@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping()
    public DBUser profile(@CurrentUser DBUser dbUser) {
        return dbUser;
    }
    @PutMapping
    public void update(@RequestBody DBUser dbUser){
        */
/*if(!userRepository.findById(dbUser.getUserId()).isPresent()){
            throw new UsernameNotFoundException("User not found");
        }
        userRepository.save(dbUser);*//*

        userService.update(dbUser);
    }


}
*/
