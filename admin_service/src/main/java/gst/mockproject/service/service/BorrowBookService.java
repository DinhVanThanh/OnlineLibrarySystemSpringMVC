package gst.mockproject.service.service;

import gst.mockproject.database.domain.BookReservation;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dinhv on 3/28/2017.
 */
@Service
public class BorrowBookService {
    @Autowired
    SpringDAOFactory springDAOFactory;
    public long count()
    {
        return springDAOFactory.getBorrowBookDAO().count();
    }
    public Page<BookReservation> findAll(Pageable pageable)
    {
        return springDAOFactory.getBorrowBookDAO().findAll(pageable);
    }
    public List<BookReservation> findAll()
    {
        return (List<BookReservation>) springDAOFactory.getBorrowBookDAO().findAll();
    }
}
