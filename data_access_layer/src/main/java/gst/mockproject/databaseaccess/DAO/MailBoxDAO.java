package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.MailBoxRepository;
import gst.mockproject.database.domain.MailBox;
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
public class MailBoxDAO implements AbstractDAO<MailBox> {

    @Autowired
    MailBoxRepository MailBoxRepo;

    @Override
    public MailBox findOne(Integer id) {
        return MailBoxRepo.findOne(id);
    }

    @Override
    public Collection<MailBox> findAll() {
        return MailBoxRepo.findAll();
    }

    @Override
    public Page<MailBox> findAll(Pageable pageable) {
        return MailBoxRepo.findAll(pageable);
    }

    @Override
    public Collection<MailBox> findAllSortASC(String ColumnName) {
        return MailBoxRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<MailBox> findAllSortDESC(String ColumnName) {
        return MailBoxRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(MailBox object) {
        return (MailBoxRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(MailBox object) {
        MailBoxRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        MailBoxRepo.delete(id);
    }

    @Override
    public long count() {
        return MailBoxRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return MailBoxRepo.exists(id);
    }
}
