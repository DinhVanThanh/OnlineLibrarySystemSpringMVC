package gst.mockproject.service.service;

import gst.mockproject.database.domain.Book;
import gst.mockproject.databaseaccess.DAO.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kama on 3/26/2017.
 */
@Service
@ComponentScan(basePackages = "gst.mockproject.")
public class BookService {
    @Autowired
    BookDAO service;

    public void savePublisher(Book publisher)
    {
        service.save(publisher);
    }

    public void Delete(int id)
    {
        service.deleteById(id);
    }
    public Book Search(int id)
    {
        return service.findOne(id);
    }

    public List<Book> GetAll()
    {
        return (List<Book>) service.findAll();
    }

    public Book FindByID(int id)
    {
        return service.findOne(id);
    }
    public void ChangePub(Book publisher)
    {
        Book temp=service.findOne(publisher.getId());
        temp.setAuthor(publisher.getAuthor());
        temp.setCategory(publisher.getCategory());
        temp.setEdition(publisher.getEdition());
        temp.setImage(publisher.getImage());
        temp.setPrice((int)publisher.getPrice());
        temp.setQuantity(publisher.getQuantity());
        temp.setPublisher(publisher.getPublisher());
        service.save(temp);
    }
    public void DeleteO(int id)
    {
        service.deleteById(id);
    }
    public long count() {
        return service.count();
    }


    public Page<Book> findAll(Pageable pageable)
    {
        return service.findAll(pageable);
    }
}
