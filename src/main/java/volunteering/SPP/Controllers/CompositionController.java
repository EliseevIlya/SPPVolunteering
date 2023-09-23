package volunteering.SPP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import volunteering.SPP.Services.CompositionService;
import volunteering.SPP.dto.RegOrNotPlusCreator;

@RestController
@RequestMapping()
public class CompositionController {
    @Autowired
    CompositionService compositionService;
    @GetMapping("/checkUserForEvent")
    public RegOrNotPlusCreator checkUserForEvent(@RequestHeader("ID") String userID, @RequestHeader("eventId") String eventID ){

        return compositionService.checkRegUser(Long.valueOf(userID),Long.valueOf(eventID));
    }
}
