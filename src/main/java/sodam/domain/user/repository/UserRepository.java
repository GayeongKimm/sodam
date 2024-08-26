package sodam.domain.user.repository;

import sodam.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserId(String memberId);
    boolean existsByUserEmail(String email);
    boolean existsByUserId(String memberId);

}
