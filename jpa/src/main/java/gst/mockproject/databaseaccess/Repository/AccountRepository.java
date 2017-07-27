package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface AccountRepository extends BaseRepository<Account, Integer> {
    @Override
    Page<Account> findAll(Pageable pageable);

    Account findByUsername(String username);

    Account findByReader_Id(int id);

    Account findByReader_Name(String ReaderName);

    Account findByRole_RoleName(String rolename);
}
