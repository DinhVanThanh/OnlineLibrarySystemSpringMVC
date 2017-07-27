package gst.mockproject.service.service;

import gst.mockproject.database.domain.Role;
import gst.mockproject.databaseaccess.DAO.RoleDAO;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by dinhv on 3/26/2017.
 */
@Service
public class RoleService implements AbstractService<Role> {
    @Autowired
    RoleDAO service;

    public void savePublisher(Role publisher)
    {
        service.save(publisher);
    }

    public void deleteR(int id)
    {
        service.deleteById(id);
    }
    @Override
    public long count() {
        return service.count();
    }

    public List<Role> findAll()
    {
        return (List<Role>) service.findAll();
    }

    public Page<Role> findAll(Pageable pageable)
    {
        return service.findAll(pageable);
    }

    public Role findbyID(int id)
    {
        return service.findOne(id);
    }
}
