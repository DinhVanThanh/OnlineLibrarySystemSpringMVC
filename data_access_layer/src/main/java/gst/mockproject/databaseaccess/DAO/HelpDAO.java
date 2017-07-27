package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.HelpRepository;
import gst.mockproject.database.domain.Help;
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
public class HelpDAO implements AbstractDAO<Help> {

    @Autowired
    HelpRepository HelpRepo;

    @Override
    public Help findOne(Integer id) {
        return HelpRepo.findOne(id);
    }

    @Override
    public Collection<Help> findAll() {
        return HelpRepo.findAll();
    }

    @Override
    public Page<Help> findAll(Pageable pageable) {
        return HelpRepo.findAll(pageable);
    }

    @Override
    public Collection<Help> findAllSortASC(String ColumnName) {
        return HelpRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<Help> findAllSortDESC(String ColumnName) {
        return HelpRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(Help object) {
        return (HelpRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Help object) {
        HelpRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        HelpRepo.delete(id);
    }

    @Override
    public long count() {
        return HelpRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return HelpRepo.exists(id);
    }
}
