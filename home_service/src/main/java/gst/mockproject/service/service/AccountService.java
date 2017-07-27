package gst.mockproject.service.service;

import gst.mockproject.database.domain.Account;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dinhv on 3/11/2017.
 */
@Service
public class AccountService {
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
}
