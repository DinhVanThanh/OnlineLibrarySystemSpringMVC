package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.CategoryRepository;
import gst.mockproject.database.domain.Category;
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
public class CategoryDAO implements AbstractDAO<Category> {

    @Autowired
    CategoryRepository CategoryRepo;

    @Override
    public Category findOne(Integer id) {
        return CategoryRepo.findOne(id);
    }

    @Override
    public Collection<Category> findAll() {
        return CategoryRepo.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return CategoryRepo.findAll(pageable);
    }

    @Override
    public Collection<Category> findAllSortASC(String ColumnName) {
        return CategoryRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<Category> findAllSortDESC(String ColumnName) {
        return CategoryRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(Category object) {
        return (CategoryRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Category object) {
        CategoryRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        CategoryRepo.delete(id);
    }

    @Override
    public long count() {
        return CategoryRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return CategoryRepo.exists(id);
    }
}
