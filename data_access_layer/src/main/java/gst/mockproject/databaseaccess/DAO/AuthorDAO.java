package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.AuthorRepository;
import gst.mockproject.database.domain.Author;
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
public class AuthorDAO implements AbstractDAO<Author> {

    @Autowired
    AuthorRepository AuthorRepo;

    @Override
    public Author findOne(Integer id) {
        return AuthorRepo.findOne(id);
    }

    @Override
    public Collection<Author> findAll() {
        return AuthorRepo.findAll();
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return AuthorRepo.findAll(pageable);
    }

    @Override
    public Collection<Author> findAllSortASC(String ColumnName) {
        return AuthorRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<Author> findAllSortDESC(String ColumnName) {
        return AuthorRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(Author object) {
        return (AuthorRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Author object) {
        AuthorRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        AuthorRepo.delete(id);
    }

    @Override
    public long count() {
        return AuthorRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return AuthorRepo.exists(id);
    }
}
