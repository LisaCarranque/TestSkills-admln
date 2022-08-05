package candidate.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import candidate.exception.CandidateNotFoundException;
import candidate.model.Candidate;
import candidate.service.ICandidateService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * This controller is responsible for managing candidate data
 */
@Slf4j
@RestController
@Api("Controller for candidate microservice")
public class CandidateController {

    @Autowired
    ICandidateService candidateService;

    /**
     * This method is responsible for getting all candidates
     * @return the list of all candidate
     */
    @GetMapping("/candidate/list")
    public List<Candidate> list() {
        log.info("candidate controller : listing all candidates");
        List<Candidate> candidates = candidateService.findAll();
        return candidates;
    }

    /**
     * This method is responsible for adding a candidate
     * @param candidate the candidate to add
     * @return the added candidate
     */
    @PostMapping("/candidate/add")
    public ResponseEntity<Candidate> addCandidateInformation(@RequestBody @Valid Candidate candidate) {
        if (candidate.getUuid() == null) {
            candidate.setUuid(UUID.randomUUID());
        }
        log.info("candidate controller : adding new candidate with uuid: " + candidate.getUuid());
        Candidate candidateAdded =  candidateService.addCandidateInformation(candidate);
        if (Objects.isNull(candidateAdded)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(candidateAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * This method is responsible for getting candidate information for further update
     * @param id the id of the targeted inforamtion
     * @return the candidate to update
     */
    @GetMapping("/candidate/update/{id}")
    public Candidate updateCandidateInformation(@PathVariable String id) {
        log.info("candidate controller : finding candidate with id: " + id);
        return candidateService.getCandidateById(Integer.valueOf(id));
    }

    /**
     * This method is responsible for updating a candidate
     * @param candidate the candidate to update
     * @return the updated candidate
     */
    @PostMapping("/candidate/update")
    public Candidate validateUpdate(@RequestBody @Valid Candidate candidate) {
        log.info("candidate controller : updating candidate with uuid: " + candidate.getUuid()
                + "and id:" + candidate.getId());
        return candidateService.updateCandidateInformation(candidate);
    }

    /**
     * This method is responsible for get a candidate by id
     * @param id the id of the targeted candidate
     * @return the targeted candidate
     */
    @GetMapping("/candidate/get/{id}")
    public Candidate getCandidateById(@PathVariable String id) {
        log.info("candidate controller : getting candidate with id: " + id);
        Candidate candidate = candidateService.getCandidateById(Integer.valueOf(id));
        if (candidate == null) throw new CandidateNotFoundException("No candidate found in database for id: " + id);
        return candidate;
    }

    /**
     * This method is responsible for get all candidates
     * @return the list of all candidates
     */
    @GetMapping("/candidate/getAll")
    public List<Candidate> getAll() {
        log.info("candidate controller : finding all candidates");
        List<Candidate> candidates = candidateService.findAll();
        return candidates;
    }

    /**
     * This method is responsible for getting a candidate by email
     * @param email the email of the targeted candidate
     * @return the targeted candidate
     */
    @GetMapping("/candidate/getByLastname/{email}")
    public List<Candidate> getCandidateByEmail(@PathVariable String email) {
        log.info("candidate controller : getting candidate with email: " + email);
        List<Candidate> candidates = candidateService.getCandidateByEmail(email);
        if (candidates.isEmpty()) throw new CandidateNotFoundException("No candidate found in database for lastname: " + email);
        return candidates;
    }


}
