package passify.app.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import passify.app.domain.Event;
import passify.app.exception.BadRequestException;
import passify.app.mapper.EventMapper;
import passify.app.repository.EventRepository;
import passify.app.request.EventPostRequestBody;
import passify.app.request.EventPutRequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public List<Event> findByName(String name) {
        return eventRepository.findByName(name);
    }

    public Event findByIdOrThrowBadRequest(UUID id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Event not found"));
    }

    @Transactional
    public Event save(EventPostRequestBody eventPostRequestBody) {
        Event event = EventMapper.INSTANCE.toEvent(eventPostRequestBody);
        return eventRepository.save(event);
    }

    public void delete(UUID id) {
        eventRepository.delete(findByIdOrThrowBadRequest(id));
    }

    public void replace(EventPutRequestBody eventPutRequestBody) {
        Event savedEvent = findByIdOrThrowBadRequest(eventPutRequestBody.getId());
        Event event = EventMapper.INSTANCE.toEvent(eventPutRequestBody);
        event.setId(savedEvent.getId());
        eventRepository.save(event);
    }
}
