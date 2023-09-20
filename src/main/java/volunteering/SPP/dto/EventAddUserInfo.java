package volunteering.SPP.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import volunteering.SPP.DBEntity.EventCategory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventAddUserInfo {
    private Long eventId;
    private String name;
    private String startTime;
    private String location;
    private String eventDescription;
    private Long categoryId;
    private String categoryName;
    private boolean completed;
    private String login;
    private String contactDetails;
    private Long userId;
    private String roleName;
}

