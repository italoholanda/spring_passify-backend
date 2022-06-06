package passify.app.controller;

import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import passify.app.domain.Event;
import passify.app.request.EventPostRequestBody;
import passify.app.request.EventPutRequestBody;
import passify.app.service.EventService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    // TODO: define rules
    @GetMapping(path = "/featured")
    public ResponseEntity<Page<Event>> list(Pageable pageable) {
        return ResponseEntity.ok(eventService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Event>> listAll() {
        return ResponseEntity.ok(eventService.listAllNonPageable());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Event> findById(@RequestParam UUID id) {
        return ResponseEntity.ok(eventService.findByIdOrThrowBadRequest(id));
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Event> save(@RequestBody @Valid EventPostRequestBody eventPostRequestBody) {
        return new ResponseEntity<>(eventService.save(eventPostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<Event> delete(@RequestBody @Valid @RequestParam UUID id) {
        eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Void> update(@RequestBody EventPutRequestBody eventPutRequestBody) {
        eventService.replace(eventPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
