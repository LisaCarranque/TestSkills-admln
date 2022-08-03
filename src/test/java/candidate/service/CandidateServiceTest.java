package candidate.service;

import candidate.model.Candidate;
import candidate.repository.CandidateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension; 

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * This class is responsible for testing PatientService
 */
@ExtendWith(MockitoExtension.class)
public class CandidateServiceTest {

    @InjectMocks
    CandidateService candidateService;

    @Mock
    CandidateRepository candidateRepository;

    @Test
    public void loadService() {
        assertNotNull(candidateService);
    }

    @Test
    public void addPatientInformationTest() {
        UUID uuid = UUID.randomUUID();
        Candidate candidate = Candidate.builder().id(1).firstname("John")
                .lastname("Smith").email("johnsmith@gmail.com").password("00@1345670$00").uuid(uuid).build();
        candidateService.addCandidateInformation(candidate);
        verify(candidateRepository).save(candidate);
    }

    @Test
    public void updatePatientInformationTest() {
        UUID uuid = UUID.randomUUID();
        Candidate candidate = Candidate.builder().id(1).firstname("John")
                .lastname("Smith").email("johnsmith@gmail.com").password("00@1345670$00")
                .uuid(uuid).build();
        candidateService.updateCandidateInformation(candidate);
        verify(candidateRepository).save(candidate);
    }

    @Test
    public void removePatientInformationTest() {
        UUID uuid = UUID.randomUUID();
        Candidate candidate = Candidate.builder().id(1).firstname("John")
                .lastname("Smith").email("johnsmith@gmail.com").password("00@1345670$00")
                .uuid(uuid).build();
        candidateService.removeCandidateInformation(candidate);
        verify(candidateRepository).delete(candidate);
    }

    @Test
    public void findAllTest() {
        candidateService.findAll();
        verify(candidateRepository).findAll();
    }

    @Test
    public void getPatientByIdTest() {
        candidateService.getCandidateById(1);
        verify(candidateRepository).findById(1);
    }

    @Test
    public void getPatientByLastnameTest() {
        candidateService.getCandidateByEmail("johnsmith@gmail.com");
        verify(candidateRepository).findByLastname("johnsmith@gmail.com");
    }

}
