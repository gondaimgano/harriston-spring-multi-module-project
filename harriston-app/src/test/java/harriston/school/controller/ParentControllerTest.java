package harriston.school.controller;

import harriston.school.app.controller.ParentController;
import harriston.school.core.contracts.ParentService;
import harriston.school.core.entities.SchoolReport;
import harriston.school.core.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ParentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ParentService parentService;

    @InjectMocks
    private ParentController parentController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(parentController).build();
    }

    @Test
    public void testViewAllReports() throws Exception {
        Long parentId = 1L;
        List<SchoolReport> reports = Collections.singletonList(new SchoolReport());
        when(parentService.viewAllReports(parentId)).thenReturn(reports);

        mockMvc.perform(get("/parent/view/student/report/{parentId}", parentId))
                .andExpect(status().isOk());
    }

    @Test
    public void testViewYourChildrenProfile() throws Exception {
        Long parentId = 1L;
        List<Student> students = Collections.singletonList(new Student());
        when(parentService.viewYourChildrenProfile(parentId)).thenReturn(students);

        mockMvc.perform(get("/parent/view/child/all/{parentId}", parentId))
                .andExpect(status().isOk());
    }
}

