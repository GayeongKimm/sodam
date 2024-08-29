package hackers.ground.sodam.domain.user.repository;

import hackers.ground.sodam.domain.user.entity.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<BuyerEntity, Long> {
}
