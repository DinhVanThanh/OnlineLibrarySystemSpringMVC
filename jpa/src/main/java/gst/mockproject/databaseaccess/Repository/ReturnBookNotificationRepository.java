package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.ReturnBookNotification;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface ReturnBookNotificationRepository extends BaseRepository<ReturnBookNotification, Integer> {
}
