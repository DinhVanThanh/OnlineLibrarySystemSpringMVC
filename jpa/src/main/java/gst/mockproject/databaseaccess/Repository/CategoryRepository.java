package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface CategoryRepository extends BaseRepository<Category, Integer> {
    @Override
    Page<Category> findAll(Pageable pageable);

    Category findByCategoryName(String categoryName);
}
