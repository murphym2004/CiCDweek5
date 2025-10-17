package atu.ie.passenger.Controller;

import atu.ie.passenger.model.Passenger;
import atu.ie.passenger.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {
    private final PassengerService service;

    public PassengerController(PassengerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Passenger>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getOne(@PathVariable String id) {
        Optional<Passenger> maybe = service.findById(id);
        if (maybe.isPresent()) {
            return ResponseEntity.ok(maybe.get());
        } else {return ResponseEntity.notFound().build();
    }
}
@PostMapping
    public ResponseEntity<Passenger> create(@Valid @RequestBody Passenger p) {
        Passenger created = service.create(p);
        return ResponseEntity
                .created(URI.create("/api/passenger/"+ created.getPassengerId()))
                .body(created);
}
@DeleteMapping("/Delete")
    public ResponseEntity<?> delete(@Valid @RequestBody Passenger p) {
        Optional<Passenger> maybe = service.findById(p.getPassengerId());
        if (maybe.isPresent()) {
            service.delete(p.getPassengerId());
            return ResponseEntity.ok().build();

        }
        else {return ResponseEntity.notFound().build();}
@PutMapping("/updateName")
    public ResponseEntity<Passenger> update(@Valid @RequestBody Passenger p) {
        Optional<Passenger> maybe = service.findById(p.getPassengerId());
        if (maybe.isPresent()) {
            Passenger updated = maybe.get();
            updated.setName(p.getName());
            updated.setEmail(p.getEmail());
            return ResponseEntity.ok(updated);


        }
        return ResponseEntity.notFound().build();
}

}
