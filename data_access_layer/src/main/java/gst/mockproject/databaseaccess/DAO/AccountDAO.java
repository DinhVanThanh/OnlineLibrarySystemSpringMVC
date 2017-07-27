package gst.mockproject.databaseaccess.DAO;

import gst.mockproject.databaseaccess.Repository.AccountRepository;
import gst.mockproject.database.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by dinhv on 2/8/2017.
 */
@Component
@ComponentScan(basePackages = "gst.mockproject.databaseaccess")
@EntityScan(basePackages = "gst.mockproject.database")
@EnableJpaRepositories(basePackages = "gst.mockproject.databaseaccess")
public class AccountDAO implements AbstractDAO<Account> {

    @Autowired
    AccountRepository AcccountRepo;

    @Override
    public Account findOne(Integer id) {
        return AcccountRepo.findOne(id);
    }

    @Override
    public Collection<Account> findAllSortASC(String ColumnName) {
        return AcccountRepo.findAll(new Sort(Sort.Direction.ASC, ColumnName));
    }

    @Override
    public Collection<Account> findAllSortDESC(String ColumnName) {
        return AcccountRepo.findAll(new Sort(Sort.Direction.DESC, ColumnName));
    }

    @Override
    public Collection<Account> findAll() {
        return AcccountRepo.findAll();
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return AcccountRepo.findAll(pageable);
    }

    @Override
    public boolean save(Account object) {
        return (AcccountRepo.save(object) != null)?true:false;
    }

    @Override
    public void deleteByObject(Account object) {
         AcccountRepo.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        AcccountRepo.delete(id);
    }

    @Override
    public long count() {
        return AcccountRepo.count();
    }

    @Override
    public boolean exists(Integer id) {
        return AcccountRepo.exists(id);
    }


    public Account findByUsername(String username)
    {
        return AcccountRepo.findByUsername(username);
    }

    public Account findByReaderId(int id){return AcccountRepo.findByReader_Id(id);}
}

