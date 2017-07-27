package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.BookOrder;
import gst.mockproject.database.domain.BookReservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface BorrowBookRepository extends BaseRepository<BookReservation, Integer>{
    @Override
    Page<BookReservation> findAll(Pageable pageable);
    Page<BookReservation> findByReader_Id(int readerid, Pageable pageable);
    Page<BookReservation> findByReader_IdAndIdOrBorrowDateContainingOrReturnDateContainingOrStatusAllIgnoreCase(int readerid, int id, Date BorrowDate, Date ReturnDate, boolean Status, Pageable pageable);

}
