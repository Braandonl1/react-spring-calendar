package com.example.calender_api.controller;

import com.example.calender_api.model.Event;
import com.example.calender_api.Service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controller som hanterar inkommande HTTP-anrop för kalenderns events.
 * Exponerar CRUD-endpoints som används av React-frontenden.
 */
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EventController {

    private final EventService eventService;

    // Constructor injection används för att koppla in EventService.
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // Hämtar alla events från databasen.
    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    // Skapar ett nytt event.
    @PostMapping("/event")
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) {
        Event saved = eventService.postEvent(event);

        return ResponseEntity
                .status(201)
                .body(saved);
    }

    // Hämtar ett specifikt event baserat på id.
    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event result = eventService.getEventOrThrow(id);
        return ResponseEntity.ok(result);
    }

    // Uppdaterar ett befintligt event.
    @PutMapping("/event/{id}")
    public ResponseEntity<Event> updateEvent(
            @PathVariable Long id,
            @Valid @RequestBody Event event) {

        Event result = eventService.updateEvent(event, id);
        return ResponseEntity.ok(result);
    }

    // Tar bort ett event och returnerar HTTP 204 vid lyckad borttagning.
    @DeleteMapping("/event/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}