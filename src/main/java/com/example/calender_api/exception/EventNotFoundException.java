package com.example.calender_api.exception;


import com.example.calender_api.model.Event;

import java.util.Optional;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException( String message) {
        super(message);
    }



}
