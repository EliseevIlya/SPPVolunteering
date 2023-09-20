package volunteering.SPP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private UserLoginPassw ulp;

    @PutMapping
    public void getLoginPassword(@RequestBody UserLoginPassw userLoginPassw){
        ulp=userLoginPassw;

    }
    @GetMapping
    public DBUser returnUser(){
        return userService.findByLoginAndPassword(ulp);
    }

}
