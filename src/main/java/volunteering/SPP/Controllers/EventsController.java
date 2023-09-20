package volunteering.SPP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.DBEntity.Event;
import volunteering.SPP.Repository.CompositionRepository;
import volunteering.SPP.Services.CompositionService;
import volunteering.SPP.Services.EventService;
import volunteering.SPP.annotations.CurrentUser;
import volunteering.SPP.dto.AllUsersInEventID;
import volunteering.SPP.dto.EventAddUserInfo;
import volunteering.SPP.dto.EventAndUserIDFromComposition;
import volunteering.SPP.dto.EventIDdto;

import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(origins = "http://localhost:5656")
public class EventsController {
    @Autowired
    private EventService eventService;
    @Autowired
    private CompositionService compositionService;
    @Autowired
    private CompositionRepository compositionRepository;


    @GetMapping("/test")
    public List<EventAndUserIDFromComposition> test(){
       return eventService.findAllUserEventId(1L);
    }
    @GetMapping("/events/getAll")
    public List<Event> getAllEvents(){
        return eventService.getAll();
    }
    @GetMapping("/event/users")
    public List<AllUsersInEventID> getAllUsersInEventId(@RequestHeader("eventId") String eventID){
        return eventService.findAllParticipantsEventID(Long.valueOf(eventID));
    }
    @GetMapping("/events")
    public List<EventAddUserInfo> getAllNotCompleted(){
        return eventService.findNotCompletedEventCreatorInfo(1L);
    }

    @GetMapping("/eventInfo")
    public EventAddUserInfo geteventInfoWithCreatorInfo(@RequestHeader("eventId") String eventID){
       return eventService.findEventPlusCreatorInfo(1l, Long.valueOf(eventID));
    }
    @PostMapping("/events/reguser")
    public void regUserForEvent(@RequestBody EventIDdto eventID, @CurrentUser DBUser dbUser){
        compositionService.saveUserForEvent(2l, eventID.getEventId(),dbUser);
    }
    @PutMapping("/myevents/change")
    public void changeEvent(@RequestBody Event event/*, @CurrentUser DBUser dbUser*/){
        // проверка может ли юзер менять ивент
        eventService.update(event);
    }
    @DeleteMapping("/myevents/change/delete")
    public void deleteEvent(@RequestBody EventIDdto eventIDdto){
        eventService.deleteEvent(eventIDdto.getEventId());
    }
    @DeleteMapping("/myevents/change/cancelreg")
    public void cancelRegForUser(@RequestBody EventIDdto eventIDdto, @CurrentUser DBUser dbUser) throws Exception {
        compositionService.deleteUserFromEvent(dbUser.getUserId(), eventIDdto.getEventId());
    }
    @PostMapping("/event/create")
    public void eventCreate(@RequestBody Event event,@CurrentUser DBUser dbUser){
        eventService.create(event,dbUser);
    }


}
