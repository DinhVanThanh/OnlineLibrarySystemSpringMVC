package gst.mockproject.databaseaccess.Repository;

import gst.mockproject.database.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by dinhv on 2/8/2017.
 */
@Repository
@Transactional
public interface RoleRepository extends BaseRepository<Role, Integer>{
    @Override
    Page<Role> findAll(Pageable pageable);
    Role findByRoleName(String RoleName);
}
