package gst.mockproject.service.service;

import gst.mockproject.database.domain.Book;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dinhv on 3/4/2017.
 */
@Service
public class BookService implements AbstractService<Book> {

    @Autowired
    SpringDAOFactory DAOFactory;
//  count by name
    public Long countByTitleContainingIgnoreCase(String title)
    {
        return DAOFactory.getBookDAO().countByTitleContainingIgnoreCase(title);
    }
    public Long countByCategoryContainingIgnoreCase(String CategoryName)
    {
        return DAOFactory.getBookDAO().countByCategoryContainingIgnoreCase(CategoryName);
    }
    public Long countByPublisherContainingIgnoreCase(String PublisherName)
    {
        return DAOFactory.getBookDAO().countByPublisherContainingIgnoreCase(PublisherName);
    }
    public Long countByAuthorContainingIgnoreCase(String authorName)
    {
        return DAOFactory.getBookDAO().countByAuthorContainingIgnoreCase(authorName);
    }
    //    count all
    public Long countByTitleContainingOrCategoryContainingOrPublisherContainingOrAuthorContainingAllIgnoreCase(String title, String category, String publisher, String author)
    {
        return DAOFactory.getBookDAO().countByTitleContainingOrCategoryContainingOrPublisherContainingOrAuthorContainingAllIgnoreCase(title, category, publisher, author);
    }

//   CRUD

    @Override
    public long count() {
        return DAOFactory.getBookDAO().count();
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) DAOFactory.getBookDAO().findAll();
    }

    public Page<Book> findAll(Pageable pageable){

        return DAOFactory.getBookDAO().findAll(pageable);
    }

    public Book findByBookID(int id)
    {
        return DAOFactory.getBookDAO().findOne(id);
    }

//  find by Name Like Ignorecase

    public Page<Book> findByTitleLikeIgnoreCase(String title, Pageable pageable)
    {
        return DAOFactory.getBookDAO().findByTitleLikeIgnoreCase(title, pageable);
    }
    public  Page<Book> findByCategoryNameLikeIgnoreCase(String CategoryName, Pageable pageable)
    {
        return DAOFactory.getBookDAO().findByCategoryNameLikeIgnoreCase(CategoryName, pageable);
    }
    public Page<Book> findByPublisherNameLikeIgnoreCase(String PublisherName, Pageable pageable)
    {
        return DAOFactory.getBookDAO().findByPublisherNameLikeIgnoreCase(PublisherName, pageable);
    }
    public Page<Book> findByAuthorNameLikeIgnoreCase(String AuthorName, Pageable pageable)
    {
        return DAOFactory.getBookDAO().findByAuthorNameLikeIgnoreCase(AuthorName, pageable);
    }

//    find by Id
    public Page<Book> findByCategoryId(int category_id, Pageable pageable)
    {
        return DAOFactory.getBookDAO().findByCategoryId(category_id, pageable);
    }
    public Page<Book> findByPublisherId(int category_id, Pageable pageable)
    {
        return DAOFactory.getBookDAO().findByPublisherId(category_id, pageable);
    }


//    find all attribute
    public Page<Book> findByTitleOrCategoryOrAuthorOrPublisher(String title, String category, String author, String publisher, Pageable pageable)
    {
        return DAOFactory.getBookDAO().findByTitleOrCategoryOrAuthorOrPublisher(title, category, publisher, author,pageable);
    }
    
//    search
    public Page<Book> SimpleSearch(String search, String type, PageRequest pageRequest)
    {
        Page<Book> books = null;
        switch(type){
            case "title":
            {
                books =  findByTitleLikeIgnoreCase(search, pageRequest);
                break;
            }
            case "category":
            {
                books = findByCategoryNameLikeIgnoreCase(search, pageRequest);
                break;
            }
            case "publisher":
            {
                books = findByPublisherNameLikeIgnoreCase(search, pageRequest);
                break;
            }
            case "author":
            {
                books = findByAuthorNameLikeIgnoreCase(search, pageRequest);
                break;
            }
            default:
            {
                books = findByTitleOrCategoryOrAuthorOrPublisher(search, search, search, search, pageRequest);
            }
        }
        return books;
    }
//    count by special attribute
    public Long countBy(String type, String search)
    {
        Long a = null;
        switch(type){
            case "title":
            {
                 a = countByTitleContainingIgnoreCase(search);
                break;
            }
            case "category":
            {
                a = countByCategoryContainingIgnoreCase(search);
                break;
            }
            case "publisher":
            {
                a = countByPublisherContainingIgnoreCase(search);
                break;
            }
            case "author":
            {
                a = countByAuthorContainingIgnoreCase(search);
                break;
            }
            default:
            {
                a = countByTitleContainingOrCategoryContainingOrPublisherContainingOrAuthorContainingAllIgnoreCase(search, search,search,search);
            }
        }
        return a;
    }
//    count by All
    public Long countByAll(String booktitle, String category, String publisher, String author)
    {
        return countByTitleContainingOrCategoryContainingOrPublisherContainingOrAuthorContainingAllIgnoreCase(booktitle,category,publisher,author);
    }

//    update
    public boolean save(Book book)
    {
        return DAOFactory.getBookDAO().save(book);
    }
}
