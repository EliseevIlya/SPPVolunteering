package volunteering.SPP.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllUsersInEventID {
    private Long eventid;
    private Long userid;

    private String lastName;
    private String firstName;

    private String patronymic;

    private String contactDetails;
}
