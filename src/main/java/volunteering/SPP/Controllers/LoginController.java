package volunteering.SPP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.Services.UserService;
import volunteering.SPP.annotations.CurrentUser;
import volunteering.SPP.dto.UserLoginPassw;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:5656")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public DBUser login(@RequestBody UserLoginPassw userLoginPassw){
        return userService.findByLoginAndPassword(userLoginPassw);
    }

}
