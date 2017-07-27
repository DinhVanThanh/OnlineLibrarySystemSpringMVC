package gst.mockproject.service.service;

import gst.mockproject.database.domain.Account;
import gst.mockproject.database.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dinhv on 3/11/2017.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);
        if(account == null)
            throw new UsernameNotFoundException("Người dùng này không tồn tại");
        List<GrantedAuthority> authorities = buildUserAuthority(account.getRole());
        return buildUserForAuthentication(account, authorities);
    }

    private CustomUserDetail buildUserForAuthentication(Account account, List<GrantedAuthority> authorities) {
//        return new User(account.getUsername(), account.getPassword(),
//                account.isEnabled(), true, true, true, authorities);
        return new CustomUserDetail(account.getUsername(), account.getPassword(), account.getRole(), account.isEnabled(),  authorities, account.getReader().getId() );
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }
}
