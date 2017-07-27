package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.BorrowBookRepository;
import gst.mockproject.database.domain.BookReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

/**
 * Created by dinhv on 2/8/2017.
 */
@Component
public class BorrowBookDAO implements AbstractDAO<BookReservation> {

    @Autowired
    BorrowBookRepository BorrowBookRepo;

    @Override
    public BookReservation findOne(Integer id) {
        return BorrowBookRepo.findOne(id);
    }

    @Override
    public Collection<BookReservation> findAll() {
        return BorrowBookRepo.findAll();
    }

    @Override
    public Page<BookReservation> findAll(Pageable pageable) {
        return BorrowBookRepo.findAll(pageable);
    }

    @Override
    public Collection<BookReservation> findAllSortASC(String ColumnName) {
        return BorrowBookRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<BookReservation> findAllSortDESC(String ColumnName) {
        return BorrowBookRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(BookReservation object) {
        return (BorrowBookRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(BookReservation object) {
        BorrowBookRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        BorrowBookRepo.delete(id);
    }

    @Override
    public long count() {
        return BorrowBookRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return BorrowBookRepo.exists(id);
    }

    public Page<BookReservation> findByReaderIdOrIdOrBorrowdateContainingOrReturndateContainingOrStatusAllIgnoreCase(int readerid, int id, Date BorrowDate, Date ReturnDate, boolean Status, Pageable pageable)
    {
        return BorrowBookRepo.findByReader_IdAndIdOrBorrowDateContainingOrReturnDateContainingOrStatusAllIgnoreCase(readerid, id, BorrowDate, ReturnDate, Status, pageable);
    }

    public Page<BookReservation> findByReaderId(int readerid, Pageable pageable)
    {
        return BorrowBookRepo.findByReader_Id(readerid, pageable);
    }
}
