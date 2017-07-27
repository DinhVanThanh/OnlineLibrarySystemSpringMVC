package gst.mockproject.service.service;

import gst.mockproject.database.domain.Account;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dinhv on 3/11/2017.
 */
@Service
@ComponentScan(basePackages = "gst.mockproject.")
public class AccountService implements AbstractService<Account> {
    @Autowired
    SpringDAOFactory springDAOFactory;

    public Account findByUsername(String username)
    {
        return springDAOFactory.getAccountDAO().findByUsername(username);
    }

    public Account findOne(int id)
    {
        return springDAOFactory.getAccountDAO().findOne(id);
    }

    public Account findByReaderId(int id){return springDAOFactory.getAccountDAO().findByReaderId(id);}

    public boolean save(Account account)
    {
        return springDAOFactory.getAccountDAO().save(account);
    }

    @Override
    public long count() {
        return springDAOFactory.getAccountDAO().count();
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) springDAOFactory.getAccountDAO().findAll();
    }

    public Page<Account> findAll(Pageable pageable)
    {
        return springDAOFactory.getAccountDAO().findAll(pageable);
    }
    public void DeleteO(int id)
    {
        springDAOFactory.getAccountDAO().deleteById(id);
    }
}
