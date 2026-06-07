package com.example.calender_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity // skapa databastabellen från denna klass
public class Event { // Representerar ett event i systemet

    @Id @GeneratedValue //ID primärnyckel + generera värdet automatiskt.
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private LocalDate date;
    @NotBlank
    private String location;
    public Event(Long id, String title, String description, LocalDate date, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
    }
    public Event() { //konstruktor overloading, därför tom.

    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    public void setId(Long id) {
        this.id=id;
    }
    public void setTitle( String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setLocation(String location) {
        this.location = location;
    }

}
