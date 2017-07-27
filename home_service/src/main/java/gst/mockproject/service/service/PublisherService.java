package gst.mockproject.service.service;

import gst.mockproject.database.domain.Publisher;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dinhv on 3/5/2017.
 */
@Service
public class PublisherService implements AbstractService<Publisher> {
    @Autowired
    SpringDAOFactory DAOFactory;

    @Override
    public long count() {
        return DAOFactory.getPublisherDAO().count();
    }

    @Override
    public List<Publisher> findAll() {
        return (List<Publisher>) DAOFactory.getPublisherDAO().findAll();
    }
}
