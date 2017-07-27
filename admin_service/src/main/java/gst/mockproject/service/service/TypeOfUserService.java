package gst.mockproject.service.service;

import gst.mockproject.database.domain.ReaderType;
import gst.mockproject.databaseaccess.DAO.TypeOfUserDAO;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by Kama on 3/6/2017.
 */
@Service
@ComponentScan
public class TypeOfUserService {
    @Autowired
    SpringDAOFactory springDAOFactory;

    public void SaveTypeOfUser(ReaderType readerType)
    {
        springDAOFactory.getTypeOfUserDAO().save(readerType);
    }

    public void DeleteTypeOfUser(int id)
    {
        springDAOFactory.getTypeOfUserDAO().deleteById(id);
    }
    public ReaderType SearchTypeOfUser(int id)
    {
        return springDAOFactory.getTypeOfUserDAO().findOne(id);
    }


    public ReaderType FindByID(int id)
    {
        return springDAOFactory.getTypeOfUserDAO().findOne(id);
    }

    public void ChangeTypeOfUser(ReaderType readerType)
    {
        ReaderType temp=springDAOFactory.getTypeOfUserDAO().findOne(readerType.getId());
        temp.setTypeName(readerType.getTypeName());
        temp.setNumberOfBookAllowedToBorrow(readerType.getNumberOfBookAllowedToBorrow());
        temp.setReservationPeriod(readerType.getReservationPeriod());
        springDAOFactory.getTypeOfUserDAO().save(temp);
    }
    public Collection<ReaderType> findAll()
    {
        return springDAOFactory.getTypeOfUserDAO().findAll();
    }
    public Page<ReaderType> findAll(Pageable pageable)
    {
        return springDAOFactory.getTypeOfUserDAO().findAll(pageable);
    }

    public ReaderType findOne(int id)
    {
        return springDAOFactory.getTypeOfUserDAO().findOne(id);
    }
    public long count()
    {
        return springDAOFactory.getTypeOfUserDAO().count();
    }
}
