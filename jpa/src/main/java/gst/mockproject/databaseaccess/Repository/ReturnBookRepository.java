package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.ReturnBook;
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
public interface ReturnBookRepository extends BaseRepository<ReturnBook, Integer> {
    @Override
    Page<ReturnBook> findAll(Pageable pageable);

    Page<ReturnBook> findByReader_Id(int readerid, Pageable pageable);

    Page<ReturnBook> findByReturnDate(Date returnDate, Pageable pageable);

    Page<ReturnBook> findByBookReservation_Id(int bookReservationId, Pageable pageable);
}
