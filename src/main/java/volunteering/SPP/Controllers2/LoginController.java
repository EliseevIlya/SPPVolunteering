/*
package volunteering.SPP.Controllers2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {

    */
/*@Autowired
    private AuthenticationManager authenticationManager;*//*


    @GetMapping("/login")
    public String login(){
        return "login";
    }

   */
/* @PostMapping("/login")
    public String processLogin(@RequestParam String login, @RequestParam String password) {
        // Создание объекта аутентификации и попытка аутентификации
        Authentication auth = new UsernamePasswordAuthenticationToken(login, password);
        Authentication authenticated = authenticationManager.authenticate(auth);
        SecurityContextHolder.getContext().setAuthentication(authenticated);

        // Перенаправление на успешную страницу или главную страницу
        return "redirect:/test";
    }*//*

}
*/
