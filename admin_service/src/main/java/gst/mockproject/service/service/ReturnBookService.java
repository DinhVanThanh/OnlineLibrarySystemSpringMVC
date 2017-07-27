package gst.mockproject.service.service;

import gst.mockproject.database.domain.ReturnBook;
import gst.mockproject.databaseaccess.DAO.ReturnBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kama on 3/26/2017.
 */
@Service
@ComponentScan(basePackages = "gst.mockproject.")
public class ReturnBookService implements AbstractService<ReturnBook> {
    @Autowired
    ReturnBookDAO service;

    public void saveUser(ReturnBook category)
    {
        service.save(category);
    }

    public void Delete(int id)
    {
        service.deleteById(id);
    }
    public ReturnBook Search(int id)
    {
        return service.findOne(id);
    }

    public List<ReturnBook> GetAll()
    {
        return (List<ReturnBook>) service.findAll();
    }

    public ReturnBook FindByID(int id)
    {
        return service.findOne(id);
    }

    public void ChangePub(ReturnBook publisher)
    {
        ReturnBook temp=service.findOne(publisher.getId());
        //   temp.setCategoryName(publisher.getCategoryName());
        service.save(temp);
    }
    public void DeleteO(int id)
    {
        service.deleteById(id);
    }

    @Override
    public long count() {
        return service.count();
    }

    @Override
    public List<ReturnBook> findAll() {
        return null;
    }
    public Page<ReturnBook> findAll(Pageable pageable)
    {
        return service.findAll(pageable);
    }
}
