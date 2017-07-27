package gst.mockproject.database.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by dinhv on 2/5/2017.
 */
@Entity
@Table(name = "ROLE")
public class Role extends AbstractModel {

    @NotNull @NotEmpty @Column(name = "ROLE_NAME", nullable = false, unique = true)
    private String roleName;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
