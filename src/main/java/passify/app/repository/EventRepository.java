package passify.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import passify.app.domain.Event;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByName(String name);
}
