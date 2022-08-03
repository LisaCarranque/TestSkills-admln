package candidate.service;

import org.springframework.web.bind.annotation.RequestParam;
import candidate.model.Candidate;

import java.util.List;

/**
 * This interface is responsible for managing candidate information
 */
public interface ICandidateService {


    /**
     * This method is responsible for getting all candidate
     * @return the list of all candidates
     */
    List<Candidate> findAll();

    /**
     * This method is responsible getting a candidate by id
     * @param id the id of the targeted candidate
     * @return the targeted candidate
     */
    Candidate getCandidateById(@RequestParam Integer id);

    /**
     * This method is responsible for adding a candidate
     * @param candidate the candidate to be added
     * @return the added candidate
     */
    Candidate addCandidateInformation(Candidate candidate);

    /**
     * This method is responsible for removing candidate information
     * @param candidate the candidate to be removed
     */
    void removeCandidateInformation(Candidate candidate);

    /**
     * This method is responsible for updating candidate information
     * @param candidate the candidate to update
     * @return the updated candidate
     */
    Candidate updateCandidateInformation(Candidate candidate);

    /**
     * This method is responsible for getting candidate information by email
     * @param email the email of the targeted candidate
     * @return the list of candidates with this lastname
     */
    List<Candidate> getCandidateByEmail(String email);

}
