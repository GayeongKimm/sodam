package hackers.ground.sodam.domain.thing.repository;

import hackers.ground.sodam.domain.thing.entity.ThingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThingRepository extends JpaRepository<ThingEntity, Long> {
}
