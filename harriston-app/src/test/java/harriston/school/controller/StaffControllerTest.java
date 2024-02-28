package harriston.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import harriston.school.app.controller.StaffController;
import harriston.school.core.contracts.StaffService;
import harriston.school.core.entities.SchoolReport;
import harriston.school.core.entities.SchoolUser;
import harriston.school.core.entities.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class StaffControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StaffService staffService;

    @InjectMocks
    private StaffController staffController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(staffController).build();
    }

    @Test
    public void testManageCredentials() throws Exception {
        SchoolUser schoolUser = new SchoolUser();
        when(staffService.manageCredentials(any(SchoolUser.class))).thenReturn(schoolUser);

        mockMvc.perform(post("/staff/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(schoolUser)))
                .andExpect(status().isOk());
    }

    @Test
    public void testViewMyProfile() throws Exception {
        Staff staff = new Staff();
        when(staffService.viewMyProfile(1L)).thenReturn(staff);

        mockMvc.perform(get("/staff/view/profile"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreate() throws Exception {
        SchoolReport report = new SchoolReport();
        when(staffService.create(any(SchoolReport.class))).thenReturn(report);

        mockMvc.perform(post("/staff/report")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(report)))
                .andExpect(status().isOk());
    }

    @Test
    public void testListReports() throws Exception {
        Long teacherId = 1L;
        SchoolReport report = new SchoolReport();
        when(staffService.listReports(teacherId)).thenReturn(Collections.singletonList(report));

        mockMvc.perform(get("/staff/report/{teacherId}", teacherId))
                .andExpect(status().isOk());
    }
}

