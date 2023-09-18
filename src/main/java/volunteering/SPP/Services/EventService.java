package volunteering.SPP.Services;

import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import volunteering.SPP.DBEntity.Event;
import volunteering.SPP.Repository.CompositionRepository;
import volunteering.SPP.Repository.EventRepository;
import volunteering.SPP.dto.EventAddUserInfo;
import volunteering.SPP.dto.EventIDdto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CompositionRepository compositionRepository;

    public List<Event> getAll(){
        return eventRepository.findAll();
    }
    public  List<Event> getAllNotCompleted(){
        return eventRepository.findByCompletedFalse();
    }


    public Optional<Event> getEventById(long id) throws ResponseStatusException {
        Optional<Event> result =  eventRepository.findById(id);
        if (!result.isPresent()){
            throw new DataIntegrityViolationException("Event not found");
        }
        return result ;
    }
    public List<EventAddUserInfo> findNotCompletedEventCreatorInfo(Long roleId) {
        List<Object[]> queryResult =  eventRepository.findNotCompletedEventCreatorInfo(roleId);
        List<EventAddUserInfo> eventAddUserInfoList = new ArrayList<>();

        for (Object[] row : queryResult) {
            EventAddUserInfo eventInfo = new EventAddUserInfo();
            eventInfo.setEventId((Long) row[0]);
            eventInfo.setName((String) row[1]);
            eventInfo.setStartTime((String) row[2]);
            eventInfo.setLocation((String) row[3]);
            eventInfo.setEventDescription((String) row[4]);
            eventInfo.setCategoryId((Long) row[5]);
            eventInfo.setCategoryName((String) row[6]);
            eventInfo.setCompleted((boolean) row[7]);
            eventInfo.setFirstName((String) row[8]);
            eventInfo.setContactDetails((String) row[9]);
            eventInfo.setUserId((Long) row[10]);
            eventInfo.setRoleName((String) row[11]);
            eventAddUserInfoList.add(eventInfo);
        }

        return eventAddUserInfoList;
    }
    public void update(Event event) {
        long id=event.getEventId();
        if(!eventRepository.existsById(id)) {
            throw new EntityExistsException("Event doesn't exists");
        }
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        eventRepository.save(event);
    }
    public void deleteEvent(Long id){
        if(!eventRepository.existsById(id)) {
            throw new EntityExistsException("Event doesn't exists");
        }
        eventRepository.deleteById(id);
    }
    public void create(Event event) {
        long id=event.getEventId();
        if(eventRepository.existsById(id)) {
            throw new EntityExistsException("Event already exists");
        }
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        eventRepository.save(event);
    }
    public List<Object> findAllUserEventId(){
        return compositionRepository.findByUserId(1l);
    }
}
