package org.example.repository;

import org.example.model.Audi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudiRepository extends JpaRepository<Audi,Integer> {
}
