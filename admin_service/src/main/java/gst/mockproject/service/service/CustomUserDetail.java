package gst.mockproject.service.service;

import gst.mockproject.database.domain.Account;
import gst.mockproject.database.domain.Role;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by dinhv on 3/11/2017.
 */
@ComponentScan(basePackages = "gst.mockproject.")
public class CustomUserDetail extends Account implements UserDetails {

    private List<GrantedAuthority> authorities;


    private int readerid;


    public CustomUserDetail(String username, String password, Set<Role> role, boolean isEnabled, List<GrantedAuthority> authorities, int readerid) {
        super(username, password, role, isEnabled);
        this.authorities = authorities;
        this.readerid = readerid;
    }

    public int getReaderid() {
        return readerid;
    }

    public void setReaderid(int readerid) {
        this.readerid = readerid;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
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
        return super.isEnabled();
    }
}
