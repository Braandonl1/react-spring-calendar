package com.example.calender_api.Service;

import com.example.calender_api.exception.EventNotFoundException;
import com.example.calender_api.model.Event;
import com.example.calender_api.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Innehåller affärslogik och hantering av events i minnet, controller fokuserar på HTTP svar
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();   //findAll frågar databasen efter alla events
    }

    public Event postEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event ex = getEventOrThrow(id);
        eventRepository.delete(ex);
    }

    public  Event updateEvent(Event event, Long id) {
        Event existing = getEventOrThrow(id);
        existing.setTitle(event.getTitle());
        existing.setLocation(event.getLocation());
        existing.setDate(event.getDate());
        existing.setDescription(event.getDescription());

        return eventRepository.save(existing);

    }

    public Event getEventOrThrow(Long id ) {
        return eventRepository.findById(id).orElseThrow(()-> new EventNotFoundException("Event with id " + id + " not found"));
        }
}