package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.Help;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface HelpRepository extends BaseRepository<Help, Integer> {
    @Override
    Page<Help> findAll(Pageable pageable);
}
