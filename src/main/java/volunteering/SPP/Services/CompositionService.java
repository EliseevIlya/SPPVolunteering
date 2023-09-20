package volunteering.SPP.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volunteering.SPP.DBEntity.Composition;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.Repository.CompositionRepository;
import volunteering.SPP.Repository.EventRepository;
import volunteering.SPP.Repository.EventRoleRepository;

@Service
@AllArgsConstructor
public class CompositionService {
    @Autowired
    private CompositionRepository compositionRepository;
    /*@Autowired
    private EventService eventService;*/
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventRoleRepository eventRoleRepository;


    public void saveUserForEvent(Long roleID, Long eventID, DBUser dbUser){
        Composition composition=new Composition();
        composition.setEvent(eventRepository.findById(eventID).orElseThrow());
        composition.setUser(dbUser);
        composition.setEventRole(eventRoleRepository.getById(roleID));
        compositionRepository.save(composition);
    }// добавить проверку зарегестрирован ли уже юзер на ивент

    @Transactional
    public void deleteUserFromEvent(Long userID,Long eventID) throws Exception {
        int count = compositionRepository.countByUserIdAndEventId(userID, eventID);
        if (count == 0){
            throw new Exception("User not registered for this event");
        }
        compositionRepository.deleteByUserIdAndEventId(userID,eventID);
    }
}
