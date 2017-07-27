package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface BookRepository extends BaseRepository<Book, Integer>  {
    @Override
    Page<Book> findAll(Pageable pageable);
//    count by  name
    Long countByTitleContainingIgnoreCase(String title);

    Long countByCategory_CategoryNameContainingIgnoreCase(String CategoryName);

    Long countByPublisher_PublisherNameContainingIgnoreCase(String publisherName );

    Long countByAuthor_AuthorNameContainingIgnoreCase(String authorName);
//    count all
    Long countByTitleContainingOrCategory_CategoryNameContainingOrPublisher_PublisherNameContainingOrAuthor_AuthorNameContainingAllIgnoreCase(String title, String category, String publisher, String author);
//  find by id
    Page<Book> findByCategory_Id(int id, Pageable pageable);

    Page<Book> findByPublisher_Id(int id, Pageable pageable);
//    find by name
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<Book> findByCategory_CategoryNameContainingIgnoreCase(String categoryName, Pageable pageable);

    Page<Book> findByPublisher_PublisherNameContainingIgnoreCase(String publisherName, Pageable pageable);

    Page<Book> findByAuthor_AuthorNameContainingIgnoreCase(String authorName, Pageable pageable);
//  find by all
    Page<Book> findByTitleContainingOrCategory_CategoryNameContainingOrPublisher_PublisherNameContainingOrAuthor_AuthorNameContainingAllIgnoreCase(String title, String category, String publisher, String author, Pageable pageable);
}
