package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.TypeOfUserRepository;
import gst.mockproject.database.domain.ReaderType;
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
public class TypeOfUserDAO implements AbstractDAO<ReaderType> {

    @Autowired
    TypeOfUserRepository TypeOfUserRepo;

    @Override
    public ReaderType findOne(Integer id) {
        return TypeOfUserRepo.findOne(id);
    }

    @Override
    public Collection<ReaderType> findAll() {
        return TypeOfUserRepo.findAll();
    }

    @Override
    public Page<ReaderType> findAll(Pageable pageable) {
        return TypeOfUserRepo.findAll(pageable);
    }

    @Override
    public Collection<ReaderType> findAllSortASC(String ColumnName) {
        return TypeOfUserRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<ReaderType> findAllSortDESC(String ColumnName) {
        return TypeOfUserRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(ReaderType object) {
        return (TypeOfUserRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(ReaderType object) {
        TypeOfUserRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        TypeOfUserRepo.delete(id);
    }

    @Override
    public long count() {
        return TypeOfUserRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return TypeOfUserRepo.exists(id);
    }
}
