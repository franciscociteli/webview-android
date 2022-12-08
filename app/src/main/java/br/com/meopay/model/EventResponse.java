package br.com.meopay.model;

public class EventResponse {

    public EventResponse() {}

    private EventData event;

    public EventData getEvent() {
        return event;
    }

    public void setEvent(EventData event) {
        this.event = event;
    }
}
