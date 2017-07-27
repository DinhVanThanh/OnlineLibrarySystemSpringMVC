package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.BookImportRepository;
import gst.mockproject.database.domain.BookImport;
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
public class BookImportDAO implements AbstractDAO<BookImport> {

    @Autowired
    BookImportRepository BookImportRepo;

    @Override
    public BookImport findOne(Integer id) {
        return BookImportRepo.findOne(id);
    }

    @Override
    public Collection<BookImport> findAll() {
        return BookImportRepo.findAll();
    }

    @Override
    public Page<BookImport> findAll(Pageable pageable) {
        return BookImportRepo.findAll(pageable);
    }

    @Override
    public Collection<BookImport> findAllSortASC(String ColumnName) {
        return BookImportRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<BookImport> findAllSortDESC(String ColumnName) {
        return BookImportRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(BookImport object) {
        return (BookImportRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(BookImport object) {
        BookImportRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        BookImportRepo.delete(id);
    }

    @Override
    public long count() {
        return BookImportRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return BookImportRepo.exists(id);
    }
}
