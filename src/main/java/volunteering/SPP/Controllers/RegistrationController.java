package volunteering.SPP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.Services.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void registrate(@RequestBody DBUser dbUser){
        userService.create(dbUser);
    }

}
