package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.MailBox;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface MailBoxRepository extends BaseRepository<MailBox, Integer> {
    @Override
    Page<MailBox> findAll(Pageable pageable);
}
