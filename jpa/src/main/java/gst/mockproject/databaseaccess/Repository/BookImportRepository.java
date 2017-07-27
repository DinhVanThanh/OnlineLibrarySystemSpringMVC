package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.BookImport;
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
public interface BookImportRepository extends BaseRepository<BookImport,Integer>  {
    @Override
    Page<BookImport> findAll(Pageable pageable);
    Page<BookImport> findByDateImportOrQuantityOrDateModifiedAllIgnoreCase(Date DateImport, int quantity,Date DateModified, Pageable pageable);
    BookImport findByDateImport(Date DateImport);
    BookImport findByQuantity(int quantity);
    BookImport findByDateModified(Date DateModified);
}
