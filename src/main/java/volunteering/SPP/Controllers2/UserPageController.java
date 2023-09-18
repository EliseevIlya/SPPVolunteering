/*
package volunteering.SPP.Controllers2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volunteering.SPP.Services.EventService;

@RestController
@RequestMapping("/page")
public class UserPageController {
    @Autowired
    EventService eventService;


   @GetMapping("/events")
    public List<Event> getEvents(@CurrentUser DBUser dbUser ){
        return eventService.getAllUserEvents(dbUser.getUserId());
    }

    @GetMapping("/events/{id}")
    public NewClass gg(@PathVariable long id, @CurrentUser DBUser dbUser){}

    @PutMapping("/events/{id}")
    public void Save(@RequestBody Event event, @CurrentUser DBUser dbUser){
        //прописать логику может ли изменять ивент
        Optional<Composition> com = comRepo.getByUserIdAndEventId;
        if (!com.isPresent() || !com.getRole == ADMIN ){
            throw new UserHaventPermission;
        }
        eventRepo.save(event);

    }

    @PostMapping()
    public void createNewEvent(@RequestBody Event event, @CurrentUser DBUser dbUser){
        eventService
    }

}
*/
