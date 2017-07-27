package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.RoleRepository;
import gst.mockproject.database.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by dinhv on 2/8/2017.
 */
@Component
public class RoleDAO implements AbstractDAO<Role> {

    @Autowired
    RoleRepository RoleRepo;

    @Override
    public Role findOne(Integer id) {
        return RoleRepo.findOne(id);
    }

    @Override
    public Collection<Role> findAll() {
        return RoleRepo.findAll();
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return RoleRepo.findAll(pageable);
    }

    @Override
    public Collection<Role> findAllSortASC(String ColumnName) {
        return RoleRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<Role> findAllSortDESC(String ColumnName) {
        return RoleRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(Role object) {
        return (RoleRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Role object) {
        RoleRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        RoleRepo.delete(id);
    }

    @Override
    public long count() {
        return RoleRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return RoleRepo.exists(id);
    }
}
