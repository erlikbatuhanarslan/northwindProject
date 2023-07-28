package kodlama.io.northwindProject.Core.DataAccess;

import kodlama.io.northwindProject.Core.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
