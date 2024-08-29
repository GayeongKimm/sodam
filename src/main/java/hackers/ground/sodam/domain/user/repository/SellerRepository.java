package hackers.ground.sodam.domain.user.repository;

import hackers.ground.sodam.domain.user.entity.SellerEntity;
import hackers.ground.sodam.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Long> {
    SellerEntity findByUserEntity(UserEntity userEntity);
}
