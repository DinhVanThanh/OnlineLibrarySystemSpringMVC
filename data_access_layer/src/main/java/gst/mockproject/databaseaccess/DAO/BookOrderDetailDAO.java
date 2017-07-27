package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.database.domain.BookOrderDetail;
import gst.mockproject.databaseaccess.Repository.BookOrderDetailRepository;
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
public class BookOrderDetailDAO implements AbstractDAO<BookOrderDetail>{
    @Autowired
    BookOrderDetailRepository BookOrderDetailRepo;

    @Override
    public BookOrderDetail findOne(Integer id) {
        return BookOrderDetailRepo.findOne(id);
    }

    @Override
    public Collection<BookOrderDetail> findAll() {
        return BookOrderDetailRepo.findAll();
    }

    @Override
    public Page<BookOrderDetail> findAll(Pageable pageable) {
        return BookOrderDetailRepo.findAll(pageable);
    }

    @Override
    public Collection<BookOrderDetail> findAllSortASC(String ColumnName) {
        return BookOrderDetailRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<BookOrderDetail> findAllSortDESC(String ColumnName) {
        return BookOrderDetailRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(BookOrderDetail object) {
        return (BookOrderDetailRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(BookOrderDetail object) {
        BookOrderDetailRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        BookOrderDetailRepo.delete(id);
    }

    @Override
    public long count() {
        return BookOrderDetailRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return BookOrderDetailRepo.exists(id);
    }
}
