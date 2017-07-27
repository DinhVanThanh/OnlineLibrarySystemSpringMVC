package gst.mockproject.service.service;

import gst.mockproject.database.domain.ReaderType;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dinhv on 3/10/2017.
 */
@Service
public class ReaderTypeService implements AbstractService<ReaderType> {
    @Autowired
    SpringDAOFactory springDAOFactory;

    public ReaderType findOne(int id)
    {
        return springDAOFactory.getTypeOfUserDAO().findOne(id);
    }

    @Override
    public long count() {
        return springDAOFactory.getTypeOfUserDAO().count();
    }

    @Override
    public List<ReaderType> findAll() {
        return (List<ReaderType>) springDAOFactory.getTypeOfUserDAO().findAll();
    }
}
