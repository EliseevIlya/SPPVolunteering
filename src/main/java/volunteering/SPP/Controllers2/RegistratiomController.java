/*
package volunteering.SPP.Controllers2;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.Services.UserService;

@Controller
@AllArgsConstructor
public class RegistratiomController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("DBUser" , new DBUser() );
                return "registration";
    }

    @PostMapping("/registration")
    public String registrationPage(@ModelAttribute("DBUser")  DBUser dbUser, Model model){
        userService.create(dbUser);
        return "redirect:/login";

    }
}
*/
