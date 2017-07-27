package gst.mockproject.database.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * Created by dinhv on 2/5/2017.
 */
@Entity
@Table(name = "ACCOUNT")
public class Account extends AbstractModel {

    @NotNull @NotEmpty @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;
    @NotNull @NotEmpty @Column(name = "PASSWORD", nullable = false)
    private String password;
    @NotNull @NotEmpty @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> role;
    @Column(name = "IS_ENABLED")
    private boolean isEnabled;
    @OneToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    public Account() {
    }

    public Account(String username, String password, Set<Role> role, boolean isEnabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.isEnabled = isEnabled;
    }

    public Account(String username, String password, Set<Role> role, boolean isEnabled, Reader reader) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.isEnabled = isEnabled;
        this.reader = reader;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
