package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.BookRepository;
import gst.mockproject.database.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by dinhv on 2/8/2017.
 */
@Component
public class BookDAO implements AbstractDAO<Book> {

    @Autowired
    BookRepository BookRepo;
//    count by name
    public Long countByTitleContainingIgnoreCase(String title)
    {
        return BookRepo.countByTitleContainingIgnoreCase(title);
    }
    public Long countByCategoryContainingIgnoreCase(String CategoryName)
    {
        return BookRepo.countByCategory_CategoryNameContainingIgnoreCase(CategoryName);
    }
    public Long countByPublisherContainingIgnoreCase(String PublisherName)
    {
        return BookRepo.countByPublisher_PublisherNameContainingIgnoreCase(PublisherName);
    }
    public Long countByAuthorContainingIgnoreCase(String authorName)
    {
        return BookRepo.countByAuthor_AuthorNameContainingIgnoreCase(authorName);
    }
//    count all
    public Long countByTitleContainingOrCategoryContainingOrPublisherContainingOrAuthorContainingAllIgnoreCase(String title, String category, String publisher, String author)
    {
        return BookRepo.countByTitleContainingOrCategory_CategoryNameContainingOrPublisher_PublisherNameContainingOrAuthor_AuthorNameContainingAllIgnoreCase(title, category, publisher, author);
    }
//  CRUD
    @Override
    public Book findOne(Integer id) {
        return BookRepo.findOne(id);
    }

    @Override
    public Collection<Book> findAll() {
        return BookRepo.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return BookRepo.findAll(pageable);
    }

    @Override
    public Collection<Book> findAllSortASC(String ColumnName) {
        return BookRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<Book> findAllSortDESC(String ColumnName) {

        return BookRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(Book object) {
        return (BookRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Book object) {
        BookRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        BookRepo.delete(id);
    }

    @Override
    public long count() {
        return BookRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return BookRepo.exists(id);
    }

//  fin by Id
    public Page<Book> findByCategoryId(int id, Pageable pageable)
    {
        return BookRepo.findByCategory_Id(id, pageable);
    }

    public Page<Book> findByPublisherId(int id, Pageable pageable)
    {
        return BookRepo.findByPublisher_Id(id, pageable);
    }

//    find by Name
    public Page<Book> findByTitleOrCategoryOrAuthorOrPublisher(String title, String category, String author, String publisher, Pageable pageable)
    {
        return BookRepo.findByTitleContainingOrCategory_CategoryNameContainingOrPublisher_PublisherNameContainingOrAuthor_AuthorNameContainingAllIgnoreCase(title, category, publisher, author,pageable);
    }
    public Page<Book> findByTitleLikeIgnoreCase(String title, Pageable pageable)
    {
        return BookRepo.findByTitleContainingIgnoreCase(title, pageable);
    }

    public Page<Book> findByCategoryNameLikeIgnoreCase(String CategoryName, Pageable pageable)
    {
        return BookRepo.findByCategory_CategoryNameContainingIgnoreCase(CategoryName, pageable);
    }
    public  Page<Book> findByPublisherNameLikeIgnoreCase(String PublisherName, Pageable pageable)
    {
        return BookRepo.findByPublisher_PublisherNameContainingIgnoreCase(PublisherName, pageable);
    }

    public Page<Book> findByAuthorNameLikeIgnoreCase(String AuthorName, Pageable pageable)
    {
        return BookRepo.findByAuthor_AuthorNameContainingIgnoreCase(AuthorName, pageable);
    }
}
