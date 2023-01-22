package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Model.SimCard;
import com.example.Repository.SimCardRepository;
import com.example.Service.SimCardService;

public class SimCardServiceImpl implements SimCardService {
    @Autowired
    private SimCardRepository simcardRepository;

    @Override
    public SimCard saveSimCard(SimCard simcard) {
        return simcardRepository.save(simcard);
    }

    @Override
    public SimCard findById(int id) {
        return simcardRepository.findById(id).get();
    }

    @Override
    public List<SimCard> getAllSimCards() {
        return simcardRepository.findAll();
    }

    @Override
    public void deleteSimCard(int id) {
        simcardRepository.deleteById(id);
    }

    @Override
    public SimCard updateSimCard(SimCard simcard) {
        SimCard sim = simcardRepository.findById(simcard.getId()).get();
        sim.setId(sim.getId());
        sim.setName(sim.getName());
        sim.setCustomer_care_no(sim.getCustomer_care_no());
        sim.setEmail(sim.getEmail());
        sim.setTotal_customer(sim.getTotal_customer());

        return simcardRepository.save(sim);
    }

    @Override
    public List<SimCard> findByName(String sc_name) {
        return simcardRepository.findByName(sc_name);
    }
}
