package iss.nus.edu.sg.sa4106.KebunJio.Controllers;

import iss.nus.edu.sg.sa4106.KebunJio.Models.Event;
import iss.nus.edu.sg.sa4106.KebunJio.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Events")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }
    
    //Change the id to String
    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable String eventId) {
        try {
            Event event = eventService.findByEventId(eventId);
            return ResponseEntity.ok(event);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Have some little question
    // Which data we need to transfer?
    // do we need return event info?
    
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.save(event);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable String eventId, @RequestBody Event event) {
        try {
            Event existingEvent = eventService.findByEventId(eventId);
            event.setId(existingEvent.getId());
//            event.setEventId(eventId);
            return ResponseEntity.ok(eventService.save(event));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable String eventId) {
        try {
//            eventService.findByEventId(eventId);
//            eventService.deleteByEventId(eventId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
