/*
package volunteering.SPP.Controllers2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import volunteering.SPP.DBEntity.Event;
import volunteering.SPP.Services.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllNotCompleted(){
        return eventService.getAllNotCompleted();
    }
    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable long id){
        return eventService.getEventById(id);
    }

}
*/
