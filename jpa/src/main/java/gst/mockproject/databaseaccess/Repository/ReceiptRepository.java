package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.Receipt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface ReceiptRepository extends BaseRepository<Receipt, Integer>{
    @Override
    Page<Receipt> findAll(Pageable pageable);

    Receipt findByBookOrder_Id(int bookorderid);

}
