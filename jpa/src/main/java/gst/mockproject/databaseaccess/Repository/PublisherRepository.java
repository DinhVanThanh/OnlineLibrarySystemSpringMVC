package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface PublisherRepository extends BaseRepository<Publisher, Integer> {
    @Override
    Page<Publisher> findAll(Pageable pageable);

    Publisher findByPublisherName(String publisherName);
}
