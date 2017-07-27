package gst.mockproject.service.service;

import gst.mockproject.database.domain.Librarian;
import gst.mockproject.databaseaccess.DAO.LibrarianDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * Created by Kama on 3/6/2017.
 */
@Service
@ComponentScan
public class LibrarianService {
    @Autowired
    LibrarianDAO service;

    public void SaveLirarian(Librarian librarian)
    {
        service.save(librarian);
    }

    public void DeleteLirarian(int id)
    {
        service.deleteById(id);
    }
    public Librarian SearchLirarian(int id)
    {
        return service.findOne(id);
    }

}
