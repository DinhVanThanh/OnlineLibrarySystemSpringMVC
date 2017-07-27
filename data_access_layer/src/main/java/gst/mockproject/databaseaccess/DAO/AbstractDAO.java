package gst.mockproject.databaseaccess.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;

/**
 * Created by dinhv on 2/8/2017.
 */
public interface AbstractDAO<T> {
    //tìm record theo Primary Key
    public T findOne(Integer id);
    public Collection<T> findAll();
    //xuất tất cả record theo pagination
    public Page<T> findAll(Pageable pageable);
    //xuất tất cả record theo thứ tự tăng dần theo cột
    public Collection<T> findAllSortASC(String ColumnName);
    //xuất tất cả record theo thứ tự  giảm dần theo cột
    public Collection<T> findAllSortDESC(String ColumnName);
    //thêm record mới hoặc cập nhật record
    public boolean save(T object);
    //xóa record theo dạng đối tượng
    public void deleteByObject(T object);
    //xóa record theo Primary Key
    public void deleteById(Integer id);
    //đếm tổng số record trong bảng
    public long count();
    //kiểm tra record có tồn tại trong bảng không
    public boolean exists(Integer id);
}
