package com.plant.repository;

import com.plant.entity.EventAdmin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<EventAdmin, String> {
    List<EventAdmin> findAllByOrderByStartDateTimeDesc();
} 