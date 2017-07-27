package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.BookOrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 3/9/2017.
 */
@Repository
@Transactional
public interface BookOrderDetailRepository extends BaseRepository<BookOrderDetail, Integer> {
    Page<BookOrderDetail> findByTitleOrCategoryOrPublisherOrAuthorOrQuantity(String title, String Category, String Publisher, String Author, int Quantiy, Pageable pageable);
    BookOrderDetail findByTitle(String title);
    BookOrderDetail findByCategory(String category);
    BookOrderDetail findByPublisher(String publisher);
    BookOrderDetail findByAuthor(String author);
}
