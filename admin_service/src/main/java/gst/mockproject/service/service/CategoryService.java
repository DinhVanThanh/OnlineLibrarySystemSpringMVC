package gst.mockproject.service.service;

import gst.mockproject.database.domain.Category;
import gst.mockproject.databaseaccess.DAO.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kama on 3/8/2017.
 */
@Service
@ComponentScan(basePackages = "gst.mockproject.")
public class CategoryService {
    @Autowired
    CategoryDAO service;

    public void saveCate(Category category)
    {
        service.save(category);
    }

    public void Delete(int id)
    {
        service.deleteById(id);
    }
    public Category Search(int id)
    {
        return service.findOne(id);
    }

    public List<Category> GetAll()
    {
        return (List<Category>) service.findAll();
    }

    public Category FindByID(int id)
    {
        return service.findOne(id);
    }

    public void ChangePub(Category publisher)
    {
        Category temp=service.findOne(publisher.getId());
        temp.setCategoryName(publisher.getCategoryName());
        service.save(temp);
    }
    public void DeleteO(int id)
    {
        service.deleteById(id);
    }

    public long count() {
        return service.count();
    }


    public Page<Category> findAll(Pageable pageable)
    {
        return service.findAll(pageable);
    }
}
