package org.launchcode.codingevents.models;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;
    private EventType type;
    @NotBlank(message = "Name is Required")
    @Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
    private String name;
    @Size(max=500,message="Description too long!")
    private String description;
    @NotBlank
    @Email(message = "Invalid Email. Try Again.")
    private String contactEmail;
    @NotBlank(message = "Location  is Required!")
    private String location;
    @AssertTrue(message = "Must require Registration!")
    private boolean mustRegister;
    public Event(String name, String description,String contactEmail,String location,EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail=contactEmail;
        this.type=type;
        this.location=location;

    }
    public Event(){
        this.id = nextId;
        nextId++;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isMustRegister() {
        return mustRegister;
    }

    public void setMustRegister(boolean mustRegister) {
        this.mustRegister = mustRegister;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}