package com.plant.service;

import com.plant.dto.EventDTO;
import com.plant.entity.EventAdmin;
import com.plant.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {
    private final EventRepository eventRepository;
    
    public Page<EventAdmin> getAllEvents(int page, int size) {
        try {
            log.info("Fetching events for page {} with size {}", page, size);
            Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "startDateTime"));
            Page<EventAdmin> eventPage = eventRepository.findAll(pageable);
            log.info("Found {} events in total", eventPage.getTotalElements());
            return eventPage;
        } catch (Exception e) {
            log.error("Error fetching events: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to fetch events", e);
        }
    }
    
    public EventAdmin getEventById(String id) {
        try {
            log.info("Fetching event with id: {}", id);
            return eventRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        } catch (Exception e) {
            log.error("Error fetching event with id {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Failed to fetch event", e);
        }
    }
    
    public EventAdmin createEvent(EventDTO eventDTO) {
        try {
            log.info("Creating new event with data: {}", eventDTO);
            EventAdmin event = new EventAdmin();
            event.setName(eventDTO.getName());
            event.setLocation(eventDTO.getLocation());
            event.setStartDateTime(eventDTO.getStartDateTime());
            event.setEndDateTime(eventDTO.getEndDateTime());
            event.setDescription(eventDTO.getDescription());
            event.setPicture(eventDTO.getPicture());
            event.setCreatedAt(LocalDateTime.now());
            event.setUpdatedAt(LocalDateTime.now());
            
            EventAdmin savedEvent = eventRepository.save(event);
            log.info("Event created successfully with id: {}", savedEvent.getId());
            return savedEvent;
        } catch (Exception e) {
            log.error("Error creating event: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to create event", e);
        }
    }
    
    public EventAdmin updateEvent(String id, EventDTO eventDTO) {
        try {
            log.info("Updating event with id: {}", id);
            EventAdmin event = getEventById(id);
            event.setName(eventDTO.getName());
            event.setLocation(eventDTO.getLocation());
            event.setStartDateTime(eventDTO.getStartDateTime());
            event.setEndDateTime(eventDTO.getEndDateTime());
            event.setDescription(eventDTO.getDescription());
            event.setPicture(eventDTO.getPicture());
            event.setUpdatedAt(LocalDateTime.now());
            
            EventAdmin updatedEvent = eventRepository.save(event);
            log.info("Event updated successfully");
            return updatedEvent;
        } catch (Exception e) {
            log.error("Error updating event with id {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Failed to update event", e);
        }
    }
    
    public void deleteEvent(String id) {
        try {
            log.info("Deleting event with id: {}", id);
            eventRepository.deleteById(id);
            log.info("Event deleted successfully");
        } catch (Exception e) {
            log.error("Error deleting event with id {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Failed to delete event", e);
        }
    }
} 