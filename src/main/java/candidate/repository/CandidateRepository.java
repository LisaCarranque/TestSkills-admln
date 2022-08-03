package candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import candidate.model.Candidate;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    List<Candidate> findByLastname(String lastname);

}
