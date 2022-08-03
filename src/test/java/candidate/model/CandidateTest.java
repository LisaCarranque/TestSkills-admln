package candidate.model;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is responsible for testing Patient model
 */
@ExtendWith(MockitoExtension.class)
public class CandidateTest {

    @InjectMocks
    Candidate candidate;

    @Test
    public void testGetAndSetPatient() {
        Candidate candidate = Candidate.builder().lastname("lastname")
                .firstname("firstname").email("johnsmith@gmail.com")
                .password("234567@567$$").uuid(UUID.randomUUID()).build();
        candidate.setEmail("jacksmith@gmail.com");
        candidate.setFirstname("firstname");
        candidate.setId(1);
        candidate.setLastname("lastname");
        candidate.setPassword("123456789");
        assertNotNull(candidate);
        assertEquals("johnsmith@gmail.com", candidate.getEmail());
        assertEquals("234567@567$$", candidate.getPassword());
        assertEquals("lastname", candidate.getLastname());
        assertEquals(Integer.valueOf(1), candidate.getId());
    }

    @Test
    public void testBuildPatient() {
        Candidate candidate1 = Candidate.builder().email("johnsmith@gmail.com").password("23567@5678$5678$")
                .id(1).lastname("lastname").firstname("firstname").build();
        assertNotNull(candidate1);
        assertEquals("johnsmith@gmail.com", candidate1.getEmail());
        assertEquals("23567@5678$5678$", candidate1.getPassword());
        assertEquals("lastname", candidate1.getLastname());
        assertEquals(Integer.valueOf(1), candidate1.getId());
    }


}
