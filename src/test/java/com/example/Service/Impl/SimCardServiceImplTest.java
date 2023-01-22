package com.example.Service.Impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.example.Model.SimCard;
import com.example.Repository.SimCardRepository;
import com.example.Service.SimCardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SimCardServiceImplTest {

    @Mock
    private SimCardRepository simCardRepository;

    @InjectMocks
    private SimCardService simCardService = new SimCardServiceImpl();

    private SimCard simCard;

    @Before
    public void setUp() {
        simCard = new SimCard();
        simCard.setName("Airtel");
        simCard.setEmail("airtel@example.com");
        simCard.setCustomer_care_no(123-456-7890);
        simCard.setTotal_customer(100);
    }

    @Test
    public void testSaveSimCard() {
        Mockito.when(simCardRepository.save(simCard)).thenReturn(simCard);
        SimCard savedSimCard = simCardService.saveSimCard(simCard);
        assertNotNull(savedSimCard);
        assertNotNull(savedSimCard.getId());
    }

    @Test
    public void testFindById() {
        simCard.setId(1);
        Mockito.when(simCardRepository.findById(1)).thenReturn(java.util.Optional.of(simCard));
        SimCard foundSimCard = simCardService.findById(1);
        assertNotNull(foundSimCard);
        assertEquals(1, foundSimCard.getId());
    }

    @Test
    public void testGetAllSimCards() {
        List<SimCard> simCards = new ArrayList<>();
        Mockito.when(simCardRepository.findAll()).thenReturn(simCards);
        List<SimCard> returnedSimCards = simCardService.getAllSimCards();
        assertNotNull(returnedSimCards);
        assertTrue(returnedSimCards.size() == 2);
    }

    @Test
    public void testDeleteSimCard() {
        Mockito.doNothing().when(simCardRepository).deleteById(1);
        simCardService.deleteSimCard(1);
        Mockito.verify(simCardRepository, Mockito.times(1)).deleteById(1);
    }


}
