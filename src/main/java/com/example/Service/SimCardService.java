package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.Model.SimCard;

@Service
public interface SimCardService {
    SimCard saveSimCard(SimCard simcard);

    SimCard findById(int id);

    List<SimCard> getAllSimCards();

    void deleteSimCard(int id);

    SimCard updateSimCard(SimCard simcard);

    List<SimCard> findByName(String name);

}
