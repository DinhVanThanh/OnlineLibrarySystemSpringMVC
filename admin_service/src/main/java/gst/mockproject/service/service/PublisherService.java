package gst.mockproject.service.service;

import gst.mockproject.database.domain.Publisher;
import gst.mockproject.databaseaccess.DAO.PublisherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Kama on 3/8/2017.
 */
@Service
@ComponentScan(basePackages = "gst.mockproject.")
public class PublisherService implements AbstractService<Publisher> {
    @Autowired
    PublisherDAO service;

    public void savePublisher(Publisher publisher)
    {
        service.save(publisher);
    }

    public void Delete(int id)
    {
        service.deleteById(id);
    }
    public Publisher Search(int id)
    {
        return service.findOne(id);
    }

    public List<Publisher> GetAll()
    {
        return (List<Publisher>) service.findAll();
    }

    public Publisher FindByID(int id)
    {
        return service.findOne(id);
    }
    public void ChangePub(Publisher publisher)
    {
        Publisher temp=service.findOne(publisher.getId());
        temp.setPhoneNumber(publisher.getPhoneNumber());
        temp.setAddress(publisher.getAddress());
        temp.setPublisherName(publisher.getPublisherName());
        temp.setEmail(publisher.getEmail());
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
    public List<Publisher> findAll() {
        return null;
    }
    public Page<Publisher> findAll(org.springframework.data.domain.Pageable pageable) {
        return service.findAll(pageable);
    }
}
