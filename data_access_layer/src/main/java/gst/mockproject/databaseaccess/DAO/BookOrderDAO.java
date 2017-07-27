package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.BookOrderRepository;
import gst.mockproject.database.domain.BookOrder;
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
public class BookOrderDAO implements AbstractDAO<BookOrder> {

    @Autowired
    BookOrderRepository BookOrderRepo;

    @Override
    public BookOrder findOne(Integer id) {
        return BookOrderRepo.findOne(id);
    }

    @Override
    public Collection<BookOrder> findAll() {
        return BookOrderRepo.findAll();
    }

    @Override
    public Page<BookOrder> findAll(Pageable pageable) {
        return BookOrderRepo.findAll(pageable);
    }

    @Override
    public Collection<BookOrder> findAllSortASC(String ColumnName) {
        return BookOrderRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<BookOrder> findAllSortDESC(String ColumnName) {
        return BookOrderRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(BookOrder object) {
        return (BookOrderRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(BookOrder object) {
        BookOrderRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        BookOrderRepo.delete(id);
    }

    @Override
    public long count() {
        return BookOrderRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return BookOrderRepo.exists(id);
    }

    public Page<BookOrder> findByReaderId(int readerid, Pageable pageable)
    {
        return BookOrderRepo.findByReader_Id(readerid, pageable);
    }
}
