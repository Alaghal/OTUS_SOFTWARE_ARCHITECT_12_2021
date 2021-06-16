package otus.seryakov.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.seryakov.myapp.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userName);
}
