package volunteering.SPP.Services;

import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import volunteering.SPP.DBEntity.Composition;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.DBEntity.Event;
import volunteering.SPP.Repository.CompositionRepository;
import volunteering.SPP.Repository.EventRepository;
import volunteering.SPP.dto.EventAddUserInfo;
import volunteering.SPP.dto.AllUsersInEventID;
import volunteering.SPP.dto.EventAndUserIDFromComposition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CompositionService compositionService;
    @Autowired
    private CompositionRepository compositionRepository;

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public List<Event> getAllNotCompleted() {
        return eventRepository.findByCompletedFalse();
    }


    public Optional<Event> getEventById(long id) throws ResponseStatusException {
        Optional<Event> result = eventRepository.findById(id);
        if (!result.isPresent()) {
            throw new DataIntegrityViolationException("Event not found");
        }
        return result;
    }

    public List<EventAddUserInfo> findNotCompletedEventCreatorInfo(Long roleId) {
        List<Object[]> queryResult = eventRepository.findNotCompletedEventCreatorInfo(roleId);
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
            eventInfo.setLogin((String) row[8]);
            eventInfo.setContactDetails((String) row[9]);
            eventInfo.setUserId((Long) row[10]);
            eventInfo.setRoleName((String) row[11]);
            eventAddUserInfoList.add(eventInfo);
        }

        return eventAddUserInfoList;
    }

    public void update(Event event) {
        long id = event.getEventId();
        if (!eventRepository.existsById(id)) {
            throw new EntityExistsException("Event doesn't exists");
        }
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        eventRepository.save(event);
    }

    @Transactional
    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new EntityExistsException("Event doesn't exists");
        }
        compositionRepository.deleteByEventId(id);
        eventRepository.deleteById(id);
    }

    public void create(Event event, DBUser dbUser) {
        String description = event.getDescription();
        String name = event.getName();
        String time = event.getStartTime();
        if (eventRepository.existsByNameAndDescriptionAndStartTime(name, description, time)) {
            throw new EntityExistsException("Event already exists");
        }
        eventRepository.save(event);
        Long id = eventRepository.findByNameAndDescriptionAndStartTime(name, description, time).getEventId();
        compositionService.saveUserForEvent(1L,id,dbUser);

    }

    public List<EventAndUserIDFromComposition> findAllUserEventId(Long userID) {
        List<Object[]> queryResult =compositionRepository.findByUserId(userID);
        List<EventAndUserIDFromComposition> eventAddUserInfoList = new ArrayList<>();
        for (Object[] row : queryResult) {
            EventAndUserIDFromComposition newInfo = new EventAndUserIDFromComposition();
            newInfo.setEventid((Long) row[0]);
            newInfo.setUserid((Long) row[1]);
            eventAddUserInfoList.add(newInfo);
        }
        return eventAddUserInfoList;
    }
    public List<AllUsersInEventID> findAllParticipantsEventID(Long eventID) {
        List<Object[]> queryResult =compositionRepository.findByEventId(eventID);
        List<AllUsersInEventID> eventAddUserInfoList = new ArrayList<>();
        for (Object[] row : queryResult) {
            AllUsersInEventID newInfo = new AllUsersInEventID();
            newInfo.setEventid((Long) row[0]);
            newInfo.setUserid((Long) row[1]);
            newInfo.setFirstName((String) row[2]);
            newInfo.setLastName((String) row[3]);
            newInfo.setPatronymic((String) row[4]);
            newInfo.setContactDetails((String) row[5]);
            eventAddUserInfoList.add(newInfo);
        }
        return eventAddUserInfoList;
    }

    public EventAddUserInfo findEventPlusCreatorInfo(Long roleId, Long eventId) {
        List<Object[]> queryResult = eventRepository.findEventCreatorInfoByEventID(roleId,eventId);
        EventAddUserInfo eventInfo = new EventAddUserInfo();

        for (Object[] row : queryResult) {

            eventInfo.setEventId((Long) row[0]);
            eventInfo.setName((String) row[1]);
            eventInfo.setStartTime((String) row[2]);
            eventInfo.setLocation((String) row[3]);
            eventInfo.setEventDescription((String) row[4]);
            eventInfo.setCategoryId((Long) row[5]);
            eventInfo.setCategoryName((String) row[6]);
            eventInfo.setCompleted((boolean) row[7]);
            eventInfo.setLogin((String) row[8]);
            eventInfo.setContactDetails((String) row[9]);
            eventInfo.setUserId((Long) row[10]);
            eventInfo.setRoleName((String) row[11]);

        }

        return eventInfo;
    }
}
