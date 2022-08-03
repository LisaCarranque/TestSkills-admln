package candidate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import candidate.model.Candidate;
import candidate.repository.CandidateRepository;

import java.util.List;

@Slf4j
@Service
public class CandidateService implements ICandidateService {

    boolean testMode = true;

    @Autowired
    CandidateRepository candidateRepository;

    /**
     * This method is responsible for getting all candidate
     * @return the list of all candidates
     */
    @Override
    public List<Candidate> findAll() {
        log.info("candidate service : listing all candidates");
        return candidateRepository.findAll();
    }

    /**
     * This method is responsible getting a candidate by id
     * @param id the id of the targeted candidate
     * @return the targeted candidate
     */
    @Override
    public Candidate getCandidateById(Integer id) {
        log.info("candidate service : get candidate by id: " + id);
        return candidateRepository.findById(id).orElse(null);
    }

    /**
     * This method is responsible for adding a candidate
     * @param candidate the candidate to be added
     * @return the added candidate
     */
    @Override
    public Candidate addCandidateInformation(Candidate candidate) {
        log.info("candidate service : adding candidate with uuid:" + candidate.getUuid());
        return candidateRepository.save(candidate);
    }

    /**
     * This method is responsible for removing candidate information
     * @param candidate the candidate to be removed
     */
    @Override
    public void removeCandidateInformation(Candidate candidate) {
        log.info("candidate service : removing candidate with uuid:" + candidate.getUuid());
        candidateRepository.delete(candidate);
    }

    /**
     * This method is responsible for updating candidate information
     * @param candidate the candidate to update
     * @return the updated candidate
     */
    @Override
    public Candidate updateCandidateInformation(Candidate candidate) {
        log.info("candidate service : updating candidate with uuid:" + candidate.getUuid());
        return candidateRepository.save(candidate);
    }

    /**
     * This method is responsible for getting candidate information by lastname
     * @param email the email of the targeted candidate
     * @return the list of candidates with this lastname
     */
    @Override
    public List<Candidate> getCandidateByEmail(String email) {
        log.info("candidate service : getting candidate by lastname:" + email);
        return candidateRepository.findByLastname(email);
    }



}
