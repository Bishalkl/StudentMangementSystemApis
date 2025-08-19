package com.studentProject.studentProject.health;

import org.hibernate.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHealthIndicator implements HealthIndicator{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Health health() {
        try {
            //Execute a simple query to check the DB Connectivity
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return Health.up().withDetail("Database", "Available").build();
        } catch(Exception e) {
            return Health.down().withDetail("Database", "Not reachable").withDetail("Error", e.getMessage()).build();
        }
    }



}
