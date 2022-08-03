package candidate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * The model for candidates gathering their personal information
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Generated
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "firstname")
    @NotEmpty
    @NonNull
    @Size(min=1, max=40)
    String firstname;
    @Column(name = "lastname")
    @NotEmpty
    @NonNull
    @Size(min=1, max=40)
    String lastname;
    @Column(name = "email")
    @NotEmpty
    @NonNull
    @Size(min=1, max=40)
    String email;
    @Column(name = "password")
    @NotEmpty
    @NonNull
    @Size(min=1, max=40)
    String password;
    @Column(name = "uuid")
    UUID uuid;

}
