package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.MailRepository;
import gst.mockproject.database.domain.Mail;
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
public class MailDAO implements AbstractDAO<Mail>{

    @Autowired
    MailRepository MailRepo;

    @Override
    public Mail findOne(Integer id) {
        return MailRepo.findOne(id);
    }

    @Override
    public Collection<Mail> findAll() {
        return MailRepo.findAll();
    }

    @Override
    public Page<Mail> findAll(Pageable pageable) {
        return MailRepo.findAll(pageable);
    }

    @Override
    public Collection<Mail> findAllSortASC(String ColumnName) {
        return MailRepo.findAll(new Sort(Sort.Direction.ASC,ColumnName));
    }

    @Override
    public Collection<Mail> findAllSortDESC(String ColumnName) {
        return MailRepo.findAll(new Sort(Sort.Direction.DESC,ColumnName));
    }

    @Override
    public boolean save(Mail object) {
        return (MailRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Mail object) {
        MailRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        MailRepo.delete(id);
    }

    @Override
    public long count() {
        return MailRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return MailRepo.exists(id);
    }
}
