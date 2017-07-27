package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.ReceiptRepository;
import gst.mockproject.database.domain.Receipt;
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
public class ReceiptDAO implements AbstractDAO<Receipt> {

    @Autowired
    ReceiptRepository ReceiptRepo;

    @Override
    public Receipt findOne(Integer id) {
        return ReceiptRepo.findOne(id);
    }

    @Override
    public Collection<Receipt> findAll() {
        return ReceiptRepo.findAll();
    }

    @Override
    public Page<Receipt> findAll(Pageable pageable) {
        return ReceiptRepo.findAll(pageable);
    }

    @Override
    public Collection<Receipt> findAllSortASC(String ColumnName) {
        return ReceiptRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<Receipt> findAllSortDESC(String ColumnName) {
        return ReceiptRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public boolean save(Receipt object) {
        return (ReceiptRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Receipt object) {
        ReceiptRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        ReceiptRepo.delete(id);
    }

    @Override
    public long count() {
        return ReceiptRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return ReceiptRepo.exists(id);
    }

    public Receipt findByBookOrderID(int bookorderid)
    {
        return ReceiptRepo.findByBookOrder_Id(bookorderid);
    }
}
