package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.ReaderType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface TypeOfUserRepository extends BaseRepository<ReaderType, Integer> {
    @Override
    Page<ReaderType> findAll(Pageable pageable);

    ReaderType findByTypeName(String typeName);
}
