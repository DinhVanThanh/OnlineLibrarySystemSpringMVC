package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.ReturnBookNotificationRepository;
import gst.mockproject.database.domain.ReturnBookNotification;
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
public class ReturnBookNotificationDAO implements AbstractDAO<ReturnBookNotification> {

    @Autowired
    ReturnBookNotificationRepository ReturnBookNotiRepo;

    @Override
    public ReturnBookNotification findOne(Integer id) {
        return ReturnBookNotiRepo.findOne(id);
    }

    @Override
    public Collection<ReturnBookNotification> findAll() {
        return ReturnBookNotiRepo.findAll();
    }

    @Override
    public Page<ReturnBookNotification> findAll(Pageable pageable) {
        return ReturnBookNotiRepo.findAll(pageable);
    }

    @Override
    public Collection<ReturnBookNotification> findAllSortASC(String ColumnName) {
        return ReturnBookNotiRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<ReturnBookNotification> findAllSortDESC(String ColumnName) {
        return ReturnBookNotiRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(ReturnBookNotification object) {
        return (ReturnBookNotiRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(ReturnBookNotification object) {
        ReturnBookNotiRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        ReturnBookNotiRepo.delete(id);
    }

    @Override
    public long count() {
        return ReturnBookNotiRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return ReturnBookNotiRepo.exists(id);
    }
}
