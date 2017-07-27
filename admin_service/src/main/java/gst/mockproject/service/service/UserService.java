package gst.mockproject.service.service;

import gst.mockproject.database.domain.Reader;
import gst.mockproject.databaseaccess.DAO.ReaderDAO;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kama on 3/25/2017.
 */
@Service
@ComponentScan(basePackages = "gst.mockproject.databaseaccess")
public class UserService {
    @Autowired
    SpringDAOFactory springDAOFactory;

    public Reader findOne(int id)
    {
        return springDAOFactory.getReaderDAO().findOne(id);
    }
    public Page<Reader> findAll(Pageable pageable){

        return springDAOFactory.getReaderDAO().findAll(pageable);
    }

    public long count()
    {
       return springDAOFactory.getReaderDAO().count();
    }
    public Reader findByEmail(String email)
    {
        return springDAOFactory.getReaderDAO().findByEmail(email);
    }
    public void saveUser(Reader category)
    {
        springDAOFactory.getReaderDAO().save(category);
    }

    public void Delete(int id)
    {
        springDAOFactory.getReaderDAO().deleteById(id);
    }
    public Reader Search(int id)
    {
        return springDAOFactory.getReaderDAO().findOne(id);
    }

    public List<Reader> GetAll()
    {
        return (List<Reader>) springDAOFactory.getReaderDAO().findAll();
    }

    public Reader FindByID(int id)
    {
        return springDAOFactory.getReaderDAO().findOne(id);
    }

    public void ChangePub(Reader publisher)
    {
        Reader temp=springDAOFactory.getReaderDAO().findOne(publisher.getId());
        springDAOFactory.getReaderDAO().save(temp);
    }
    public void DeleteO(int id)
    {
        springDAOFactory.getReaderDAO().deleteById(id);
    }


}
