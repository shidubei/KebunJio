package iss.nus.edu.sg.sa4106.KebunJio.Models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reminders")
public class Reminder {
    private int reminderId;
    private User user;
    private Plant plant;
    private String reminderType;
    private LocalDateTime reminderDateTime;
    private Boolean isRecurring;
    private String recurrenceInterval;
    private String status;
    private LocalDateTime createdDateTime;
    
    public Reminder() {}

	public int getReminderId() {
		return reminderId;
	}

	public void setReminderId(int reminderId) {
		this.reminderId = reminderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public String getReminderType() {
		return reminderType;
	}

	public void setReminderType(String reminderType) {
		this.reminderType = reminderType;
	}

	public LocalDateTime getReminderDateTime() {
		return reminderDateTime;
	}

	public void setReminderDateTime(LocalDateTime reminderDateTime) {
		this.reminderDateTime = reminderDateTime;
	}

	public Boolean getIsRecurring() {
		return isRecurring;
	}

	public void setIsRecurring(Boolean isRecurring) {
		this.isRecurring = isRecurring;
	}

	public String getRecurrenceInterval() {
		return recurrenceInterval;
	}

	public void setRecurrenceInterval(String recurrenceInterval) {
		this.recurrenceInterval = recurrenceInterval;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
    
    

}
