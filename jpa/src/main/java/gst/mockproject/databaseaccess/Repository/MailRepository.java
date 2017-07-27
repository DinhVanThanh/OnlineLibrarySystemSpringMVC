package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.Mail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface MailRepository extends BaseRepository<Mail, Integer> {
    @Override
    Page<Mail> findAll(Pageable pageable);
}
