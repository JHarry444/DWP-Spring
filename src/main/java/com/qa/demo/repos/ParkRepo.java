package com.qa.demo.repos;

import com.qa.demo.entities.Park;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepo extends JpaRepository<Park, Integer> {
}
