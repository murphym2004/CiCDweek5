package atu.ie.passenger.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data @NoArgsConstructor @AllArgsConstructor@Builder
public class Passenger {
    @NotBlank @Size( max = 40)
    private String PassengerId;
    @NotBlank @Size( max = 60)
    private String Name;
    @Email @NotBlank
    private String Email;
}
