package com.adamhard.restapi.refractoring.repository;

import com.adamhard.restapi.refractoring.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
