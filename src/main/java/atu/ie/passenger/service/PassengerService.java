package atu.ie.passenger.service;
import atu.ie.passenger.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
@Service
public class PassengerService {
    private final List<Passenger> store = new ArrayList<>();

    public List<Passenger> findAll() {
        return new ArrayList<>(store);
    }

    public Optional<Passenger> findById(String id) {
        for (Passenger p : store) {
            if (p.getPassengerId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Passenger create(Passenger p) {
        if (findById(p.getPassengerId()).isPresent()) {
            throw new IllegalStateException("Passenger with id " + p.getPassengerId() + " already exists");

        }
        store.add(p);
        return p;
    }
   public Optional<Passenger> update(Passenger p) {
        if (findById(p.getPassengerId()).isPresent()) {
            throw new IllegalStateException("Passenger with id " + p.getPassengerId() + " already exists");
        }
        store.add(p);
        return Optional.of(p);
   }
}
