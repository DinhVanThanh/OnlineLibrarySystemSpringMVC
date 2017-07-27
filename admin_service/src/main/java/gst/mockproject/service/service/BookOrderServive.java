package gst.mockproject.service.service;

import gst.mockproject.database.domain.BookOrder;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by dinhv on 3/9/2017.
 */
@Service
@ComponentScan(basePackages = "gst.mockproject.")
public class BookOrderServive
{
    @Autowired
    private SpringDAOFactory DAOFactory;
    public boolean save(BookOrder bookOrder)
    {
        return DAOFactory.getBookOrderDAO().save(bookOrder);
    }

    public BookOrder findOne(int id)
    {
        return DAOFactory.getBookOrderDAO().findOne(id);
    }

    public Page<BookOrder> findAllPagination(Pageable pageable)
    {
        return DAOFactory.getBookOrderDAO().findAll(pageable);
    }

    public void delete(int id)
    {
        DAOFactory.getBookOrderDAO().deleteById(id);
    }
    public Page<BookOrder> findByReaderId(int readerid, Pageable pageable)
    {
        return DAOFactory.getBookOrderDAO().findByReaderId(readerid, pageable);
    }
    public Collection<BookOrder> findAll()
    {
        return DAOFactory.getBookOrderDAO().findAll();
    }
    public Page<BookOrder> findAll(Pageable pageable)
    {
        return DAOFactory.getBookOrderDAO().findAll(pageable);
    }
    public long count()
    {
        return DAOFactory.getBookOrderDAO().count();
    }
}
