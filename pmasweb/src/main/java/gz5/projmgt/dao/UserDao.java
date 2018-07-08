package gz5.projmgt.dao;

import gz5.projmgt.domain.User;

public interface UserDao {
    public abstract User findByUsername(String username);
}
