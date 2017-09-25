package beans.services;

import beans.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service ("myUsersDatailService")

public class MyUsersDatailService implements UserDetailsService {

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {

        User user = userService.getUserByEmail(mail);

        if (user == null) {
            throw new UsernameNotFoundException(mail);
        }

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole().getRole());

        return new MyUserPrincipal(user, authority);
    }
}
