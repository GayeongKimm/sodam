package hackers.ground.sodam.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hackers.ground.sodam.domain.user.entity.BuyerEntity;

@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity, Long> {

}
