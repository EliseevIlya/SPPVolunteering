/*
package volunteering.SPP.Security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import volunteering.SPP.DBEntity.DBUser;
import volunteering.SPP.Repository.UserRepository;

import java.util.Optional;

@AllArgsConstructor
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetailsImpl loadUserByUsername(String login) throws UsernameNotFoundException {
        DBUser dbUser=userRepository.findByLogin(login)
                .orElseThrow(()->new UsernameNotFoundException("User '" + login +"' not found"));
        return UserDetailsImpl.build(dbUser);
    }
}
*/
