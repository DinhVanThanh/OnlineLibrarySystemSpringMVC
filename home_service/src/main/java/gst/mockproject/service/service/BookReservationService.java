package gst.mockproject.service.service;

import gst.mockproject.database.domain.BookReservation;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by dinhv on 3/11/2017.
 */
@Service
public class BookReservationService {
    @Autowired
    SpringDAOFactory DAOFactory;

    public boolean save(BookReservation bookReservation)
    {
        return DAOFactory.getBorrowBookDAO().save(bookReservation);
    }

    public Page<BookReservation> findAllPagination(Pageable pageable)
    {
        return DAOFactory.getBorrowBookDAO().findAll(pageable);
    }

    public BookReservation findOne(int id)
    {
        return DAOFactory.getBorrowBookDAO().findOne(id);
    }

    public void deleteById(int id)
    {
        DAOFactory.getBorrowBookDAO().deleteById(id);
    }

    public Page<BookReservation> findByReaderIdOrIdOrBorrowdateContainingOrReturndateContainingOrStatusAllIgnoreCase(int readerid, int id, Date BorrowDate, Date ReturnDate, boolean Status, Pageable pageable)
    {
        return DAOFactory.getBorrowBookDAO().findByReaderIdOrIdOrBorrowdateContainingOrReturndateContainingOrStatusAllIgnoreCase(readerid, id, BorrowDate, ReturnDate, Status, pageable);
    }

    public Page<BookReservation> findByReaderId(int readerid, Pageable pageable)
    {
        return DAOFactory.getBorrowBookDAO().findByReaderId(readerid, pageable);
    }
}
