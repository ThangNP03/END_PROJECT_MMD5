package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.entity.Channel;
@Repository
public interface IChanelRepository extends JpaRepository<Channel, Long> {
}
