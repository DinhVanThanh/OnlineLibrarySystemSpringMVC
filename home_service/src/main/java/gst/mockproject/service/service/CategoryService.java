package gst.mockproject.service.service;

import gst.mockproject.database.domain.Category;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dinhv on 3/5/2017.
 */
@Service
public class CategoryService implements AbstractService<Category> {
    @Autowired
    SpringDAOFactory DAOFactory;

    @Override
    public long count() {
        return DAOFactory.getCategoryDAO().count();
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) DAOFactory.getCategoryDAO().findAll();
    }

}
