package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.BookOrder;
import gst.mockproject.database.domain.Reader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 3/9/2017.
 */
@Repository
@Transactional
public interface ReaderRepository extends BaseRepository<Reader, Integer>{

    Page<BookOrder> findByBookOrderList_Id(int bookorderid, Pageable pageable);
    Reader findByEmail(String email);
    @Modifying
    void deleteByBookOrderList_Id(int bookorderid);
    @Modifying
    void deleteByBookReservationList_Id(int bookreservationid);
}
