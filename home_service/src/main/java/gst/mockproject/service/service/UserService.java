package gst.mockproject.service.service;

import gst.mockproject.database.domain.BookOrder;
import gst.mockproject.database.domain.Reader;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by dinhv on 3/9/2017.
 */
@Service
public class UserService {
    @Autowired
    SpringDAOFactory DAOFactory;
//    find by id
    public Reader findOne(int id)
    {
        return DAOFactory.getReaderDAO().findOne(id);
    }
    public boolean save(Reader reader)
    {
        return DAOFactory.getReaderDAO().save(reader);
    }
    public Page<BookOrder> findByBookBookOrderListId(int bookorderid, Pageable pageable)
    {
        return DAOFactory.getReaderDAO().findByBookOrderListId(bookorderid, pageable);
    }
    public void deleteByBookOrderListId(int bookorderid)
    {
        DAOFactory.getReaderDAO().deleteByBookOrderListId(bookorderid);
    }
    public void deleteByBookReservationListId(int bookreservationid)
    {
        DAOFactory.getReaderDAO().deleteByBookReservationListId(bookreservationid);
    }
    public Reader findByEmail(String email)
    {
        return DAOFactory.getReaderDAO().findByEmail(email);
    }
    public void deleteById(int id)
    {
        DAOFactory.getReaderDAO().deleteById(id);
    }
    public Collection<Reader> findAll()
    {
        return DAOFactory.getReaderDAO().findAll();
    }
}
