package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.PublisherRepository;
import gst.mockproject.database.domain.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by dinhv on 2/8/2017.
 */
@Component
public class PublisherDAO implements AbstractDAO<Publisher> {

    @Autowired
    PublisherRepository PublisherRepo;

    @Override
    public Publisher findOne(Integer id) {
        return PublisherRepo.findOne(id);
    }

    @Override
    public Collection<Publisher> findAll() {
        return PublisherRepo.findAll();
    }

    @Override
    public Page<Publisher> findAll(Pageable pageable) {
        return PublisherRepo.findAll(pageable);
    }

    @Override
    public Collection<Publisher> findAllSortASC(String ColumnName) {
        return PublisherRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<Publisher> findAllSortDESC(String ColumnName) {
        return PublisherRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(Publisher object) {
        return (PublisherRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Publisher object) {
        PublisherRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        PublisherRepo.delete(id);
    }

    @Override
    public long count() {
        return PublisherRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return PublisherRepo.exists(id);
    }
}
