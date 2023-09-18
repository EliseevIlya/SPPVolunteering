/*
package volunteering.SPP.Security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.DBEntity.Role;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String gender;
    private String contactDetails;
    private String login;
    private String password;
    private String about;
    private Role role;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(DBUser dbUser) {
        List<GrantedAuthority> authorityList = List.of(new SimpleGrantedAuthority(dbUser.getRole().getRole()));
        return new UserDetailsImpl(
                dbUser.getUser_id(),
                dbUser.getLastName(),
                dbUser.getFirstName(),
                dbUser.getPatronymic(),
                dbUser.getGender(),
                dbUser.getContactDetails(),
                dbUser.getLogin(),
                dbUser.getPassword(),
                dbUser.getAbout(),
                dbUser.getRole(),
                authorityList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
*/
