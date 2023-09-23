package volunteering.SPP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volunteering.SPP.Services.UserService;
import volunteering.SPP.dto.UserLoginPassw;

@RestController
@RequestMapping("/login")

public class LoginController {
    @Autowired
    private UserService userService;
    private UserLoginPassw ulp;

    @PostMapping
    public void getLoginPassword(@RequestBody UserLoginPassw userLoginPassw){
        ulp=userLoginPassw;

    }
    @GetMapping
    public Long returnUser(){
        return userService.findByLoginAndPassword(ulp).getUserId();
    }

}
