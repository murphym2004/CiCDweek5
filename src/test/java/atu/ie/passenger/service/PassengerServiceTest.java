package atu.ie.passenger.service;

import atu.ie.passenger.model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerServiceTest {
    private PassengerService service;
    @BeforeEach
    public void setup() {
        service = new PassengerService();
    }
    @Test
    void createThenFindById() {
        Passenger p = Passenger .builder()
                .PassengerId("p1")
                .Name("paul")
                .Email("paul@atu.ie")
                .build();

        service.create(p);

        Optional<Passenger> found = service.findById("p1");
        assertTrue(found.isPresent());
        assertEquals("paul", found.get().getName());
    }
    @Test
    void duplicateIdThrows(){
        service.create(Passenger.builder()
                .PassengerId("p2")
                .Name("bob")
                .Email("b@atu.ie")
                .build());

        assertThrows(IllegalStateException.class, () ->
            service.create(Passenger.builder()
                    .PassengerId("p2")
                    .Name("bob")
                    .Email("b@atu.ie")
                    .build()));

    }

}
