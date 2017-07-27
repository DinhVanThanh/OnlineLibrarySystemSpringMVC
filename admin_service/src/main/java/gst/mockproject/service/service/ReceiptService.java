package gst.mockproject.service.service;

import gst.mockproject.database.domain.Receipt;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kama on 3/8/2017.
 */

@Service
@ComponentScan(basePackages = "gst.mockproject.")
public class ReceiptService {
    @Autowired
    SpringDAOFactory springDAOFactory;
    public Receipt findOne(int id)
    {
        return springDAOFactory.getReceiptDAO().findOne(id);
    }
    public boolean saveReceipt(Receipt receipt)
    {

        return springDAOFactory.getReceiptDAO().save(receipt);
    }
    public Page<Receipt> findAll(Pageable pageable)
    {
        return springDAOFactory.getReceiptDAO().findAll(pageable);
    }
    public List<Receipt> findAll()
    {
        return (List<Receipt>) springDAOFactory.getReceiptDAO().findAll();
    }
    public long count()
    {
        return springDAOFactory.getReceiptDAO().count();
    }
    public Receipt findByBookOrderID(int bookorderid)
    {
        return springDAOFactory.getReceiptDAO().findByBookOrderID(bookorderid);
    }
    public void deleteById(int id)
    {
        springDAOFactory.getReceiptDAO().deleteById(id);
    }

}
