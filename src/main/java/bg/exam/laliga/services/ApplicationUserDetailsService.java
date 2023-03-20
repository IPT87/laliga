package bg.exam.laliga.services;

import bg.exam.laliga.domain.entities.UserEntity;
import bg.exam.laliga.domain.entities.UserRoleEntity;
import bg.exam.laliga.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("111111111111111111111111111111");
        return this.userRepository.getUserEntityByUsername(username)
                .map(this::map)
                        .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {
        return new User(userEntity.getEmail(), userEntity.getPassword(), grantedAuthorities(userEntity));
    }

    private List<GrantedAuthority> grantedAuthorities(UserEntity userEntity) {
        return userEntity.getRoles().stream().map(this::mapRole).toList();
    }

    private GrantedAuthority mapRole(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());
    }

}
