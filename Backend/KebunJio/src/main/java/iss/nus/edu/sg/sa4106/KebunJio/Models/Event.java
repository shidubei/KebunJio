package iss.nus.edu.sg.sa4106.KebunJio.Models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Document(collection = "events")
public class Event {

	@Id
	private String id;  // MongoDB的标准ID类型
	private int eventId;
	private String name;
	private String location;
	private LocalDateTime StartDateTime;
	private LocalDateTime EndDateTime;
	private String description;
	private String Picture;
	private String eventType;
	private String status;
	private String organizer;
	private int maxParticipants;


	public Event() {}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getStartDateTime() {
		return StartDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		StartDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return EndDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		EndDateTime = endDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}

	// 新增字段的 getters 和 setters
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
}