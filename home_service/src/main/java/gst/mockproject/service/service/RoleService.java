package gst.mockproject.service.service;

import gst.mockproject.database.domain.Role;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by dinhv on 3/26/2017.
 */
@Service
public class RoleService {
    @Autowired
    SpringDAOFactory springDAOFactory;
    public Collection<Role> findAll()
    {
        return springDAOFactory.getRoleDAO().findAll();
    }
}
