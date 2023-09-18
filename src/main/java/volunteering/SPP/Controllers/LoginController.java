package volunteering.SPP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.Services.UserService;
import volunteering.SPP.annotations.CurrentUser;
import volunteering.SPP.dto.UserLoginPassw;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public DBUser login(@RequestBody UserLoginPassw userLoginPassw){
        return userService.findByLoginAndPassword(userLoginPassw);
    }

}
