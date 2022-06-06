package passify.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import passify.app.domain.Event;
import passify.app.repository.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public Page<Event> listAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    public List<Event> listAllNonPageable() {
        return eventRepository.findAll();
    }
}
