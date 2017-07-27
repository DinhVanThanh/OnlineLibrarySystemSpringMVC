package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.LibrarianRepository;
import gst.mockproject.database.domain.Librarian;
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
public class LibrarianDAO implements AbstractDAO<Librarian> {

    @Autowired
    LibrarianRepository LibrarianRepo;

    @Override
    public Librarian findOne(Integer id) {
        return LibrarianRepo.findOne(id);
    }

    @Override
    public Collection<Librarian> findAll() {
        return LibrarianRepo.findAll();
    }

    @Override
    public Page<Librarian> findAll(Pageable pageable) {
        return LibrarianRepo.findAll(pageable);
    }

    @Override
    public Collection<Librarian> findAllSortASC(String ColumnName) {
        return LibrarianRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<Librarian> findAllSortDESC(String ColumnName) {
        return LibrarianRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(Librarian object) {
        return (LibrarianRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Librarian object) {
        LibrarianRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        LibrarianRepo.delete(id);
    }

    @Override
    public long count() {
        return LibrarianRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return LibrarianRepo.exists(id);
    }
}
