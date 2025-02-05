package iss.nus.edu.sg.sa4106.KebunJio.DAO;

import lombok.Data;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.validation.constraints.Size;

@Data
public class EventDTO {
    @NotBlank(message = "Event name is required")
    private String name;
    
    @NotBlank(message = "Location is required")
    private String location;
    
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    
    @Size(max = 200, message = "Description must not exceed 200 characters")
    private String description;
    
    private String picture;
} 