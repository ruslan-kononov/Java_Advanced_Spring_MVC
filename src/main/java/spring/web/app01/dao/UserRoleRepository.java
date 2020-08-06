package spring.web.app01.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.web.app01.domain.UserRole;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Integer> {
    @Query("select a.userRole from UserRole a, User b where b.username=?1 and a.userId=b.user_id")
    public List<String> findUserRoleByUserName(String username);
}
