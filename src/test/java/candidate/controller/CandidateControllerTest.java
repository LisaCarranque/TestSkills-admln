package candidate.controller;

import candidate.exception.CandidateNotFoundException;
import candidate.model.Candidate;
import candidate.service.CandidateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model; 

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This class is responsible for testing CandidateController
 */
@ExtendWith(MockitoExtension.class)
public class CandidateControllerTest {

    @InjectMocks
    CandidateController CandidateController;

    @Mock
    CandidateService CandidateService;

    @Mock
    Model model;

    @Test
    public void loadController() {
        assertNotNull(CandidateController);
    }


    @Test
    public void updateCandidateInformatCionTest() {
        CandidateController.updateCandidateInformation("1");
        verify(CandidateService).getCandidateById(1);
    }

    @Test
    public void addCandidateInformationTest() {
        UUID uuid = UUID.randomUUID();
        Candidate candidate = Candidate.builder().id(1).firstname("John")
                .lastname("Smith").email("johnsmith@gmail.com").password("000@13450000").uuid(uuid).build();
        CandidateController.addCandidateInformation(candidate);
        verify(CandidateService).addCandidateInformation(candidate);
    }

    @Test
    public void validateCandidateInformationTest() {
        UUID uuid = UUID.randomUUID();
        Candidate candidate = Candidate.builder().id(1).firstname("John")
                .lastname("Smith").email("johnsmith@gmail.com").password("13450000").uuid(uuid).build();
        CandidateController.validateUpdate(candidate);
        verify(CandidateService).updateCandidateInformation(candidate);
    }

    @Test
    public void getAllTest() {
        CandidateController.getAll();
        verify(CandidateService).findAll();
    }

    @Test
    public void getCandidateByEmailTest() {
        when(CandidateService.getCandidateByEmail("johnsmith@gmail.com")).thenReturn(Collections.singletonList(Candidate
                .builder().firstname("firstname").lastname("lastname").email("johnsmith@gmail.com")
                .password("23456789@Fu$4589").uuid(UUID.randomUUID()).id(1).build()));
        CandidateController.getCandidateByEmail("johnsmith@gmail.com");
        verify(CandidateService).getCandidateByEmail("johnsmith@gmail.com");
    }

    @Test
    public void getCandidateByIdTest() {
        when(CandidateService.getCandidateById(1)).thenReturn(Candidate
                .builder().firstname("firstname").lastname("lastname").email("johnsmith@gmail.com").password("234567@ù345678")
                .uuid(UUID.randomUUID()).id(1).build());
        CandidateController.getCandidateById("1");
        verify(CandidateService).getCandidateById(1);
    }

    @Test
    public void getCandidateByEmailThrowsExceptionTest() {
        assertThrows(CandidateNotFoundException.class , () -> CandidateController.getCandidateByEmail("johndoe@gmail.com"));
    }

    @Test
    public void getCandidateByIdThrowsExceptionTest() {
        assertThrows(CandidateNotFoundException.class , () -> CandidateController.getCandidateById("1"));
    }
}
