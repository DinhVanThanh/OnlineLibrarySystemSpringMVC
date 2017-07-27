package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.ReturnBookRepository;
import gst.mockproject.database.domain.ReturnBook;
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
public class ReturnBookDAO implements AbstractDAO<ReturnBook> {

    @Autowired
    ReturnBookRepository ReturnBookRepo;

    @Override
    public ReturnBook findOne(Integer id) {
        return ReturnBookRepo.findOne(id);
    }

    @Override
    public Collection<ReturnBook> findAll() {
        return ReturnBookRepo.findAll();
    }

    @Override
    public Page<ReturnBook> findAll(Pageable pageable) {
        return ReturnBookRepo.findAll(pageable);
    }

    @Override
    public Collection<ReturnBook> findAllSortASC(String ColumnName) {
        return ReturnBookRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<ReturnBook> findAllSortDESC(String ColumnName) {
        return ReturnBookRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(ReturnBook object) {
        return (ReturnBookRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(ReturnBook object) {
        ReturnBookRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        ReturnBookRepo.delete(id);
    }

    @Override
    public long count() {
        return ReturnBookRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return ReturnBookRepo.exists(id);
    }
}
