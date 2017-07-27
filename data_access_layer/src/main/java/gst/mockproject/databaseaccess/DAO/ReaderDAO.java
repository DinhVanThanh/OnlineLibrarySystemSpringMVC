package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.database.domain.BookOrder;
import gst.mockproject.database.domain.Reader;
import gst.mockproject.databaseaccess.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by dinhv on 3/9/2017.
 */
@Component
public class ReaderDAO implements AbstractDAO<Reader>{

    @Autowired
    ReaderRepository ReaderRepo;

    @Override
    public Reader findOne(Integer id) {
        return ReaderRepo.findOne(id);
    }

    @Override
    public Collection<Reader> findAll() {
        return ReaderRepo.findAll();
    }

    @Override
    public Page<Reader> findAll(Pageable pageable) {
        return ReaderRepo.findAll(pageable);
    }

    @Override
    public Collection<Reader> findAllSortASC(String ColumnName) {
        return ReaderRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<Reader> findAllSortDESC(String ColumnName) {
        return ReaderRepo.findAll(new Sort(Sort.Direction.DESC));
    }

    @Override
    public boolean save(Reader object) {
        return (ReaderRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Reader object) {
            ReaderRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        ReaderRepo.delete(id);
    }

    @Override
    public long count() {
        return ReaderRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return ReaderRepo.exists(id);
    }

    public Page<BookOrder> findByBookOrderListId(int bookorderid, Pageable pageable)
    {
        return ReaderRepo.findByBookOrderList_Id(bookorderid, pageable);
    }

    public void deleteByBookOrderListId(int bookorderid)
    {
        ReaderRepo.deleteByBookOrderList_Id(bookorderid);
    }
    public void deleteByBookReservationListId(int bookreservationid)
    {
        ReaderRepo.deleteByBookReservationList_Id(bookreservationid);
    }

    public Reader findByEmail(String email)
    {
        return ReaderRepo.findByEmail(email);
    }
}
