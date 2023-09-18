package volunteering.SPP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.Services.UserService;

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:5656")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void registrate(@RequestBody DBUser dbUser){
        userService.create(dbUser);
    }

}
