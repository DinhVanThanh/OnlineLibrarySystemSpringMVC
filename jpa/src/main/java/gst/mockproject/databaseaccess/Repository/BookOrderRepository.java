package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.BookOrder;
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
public interface BookOrderRepository extends BaseRepository<BookOrder,Integer>{
    @Override
    Page<BookOrder> findAll(Pageable pageable);

    Page<BookOrder> findByReader_Id(int readerid, Pageable pageable);

    Page<BookOrder> findByOrderDate(Date orderDate, Pageable pageable);
    Page<BookOrder> findByDateOfApproval(Date dateOfApproval, Pageable pageable);
    Page<BookOrder> findByDateModified(Date dateModified, Pageable pageable);

}
