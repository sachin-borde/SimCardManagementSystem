package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Model.SimCard;
import org.springframework.stereotype.Repository;

@Repository
public interface SimCardRepository extends JpaRepository<SimCard, Integer> {
    List<SimCard> findByName(String name);

}
