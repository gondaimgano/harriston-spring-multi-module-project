package harriston.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import harriston.school.app.controller.AdminController;
import harriston.school.core.contracts.AdminService;
import harriston.school.core.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void testSaveStudent() throws Exception {
        Student student = new Student(/* Initialize your Student object */);
        when(adminService.save(any(Student.class))).thenReturn(student);

        mockMvc.perform(post("/admin/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllStudent() throws Exception {
        List<ISave> students = Collections.singletonList(new Student(/* Initialize your Student object */));
        when(adminService.listAll(any(Student.class))).thenReturn(students);

        mockMvc.perform(get("/admin/student"))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllStudentById() throws Exception {
        Long id = 1L;
        List<ISave> students = Collections.singletonList(new Student(/* Initialize your Student object */));
        when(adminService.listAll(any(Student.class))).thenReturn(students);

        mockMvc.perform(get("/admin/student/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Long id = 1L;
        Student student = new Student();
        student.setId(id);

        mockMvc.perform(delete("/admin/student/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveSubject() throws Exception {
        Subject subject = new Subject(/* Initialize your Subject object */);
        when(adminService.save(any(Subject.class))).thenReturn(subject);

        mockMvc.perform(post("/admin/subject")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(subject)))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllSubject() throws Exception {
        List<ISave> subjects = Collections.singletonList(new Subject(/* Initialize your Subject object */));
        when(adminService.listAll(any(Subject.class))).thenReturn(subjects);

        mockMvc.perform(get("/admin/subject"))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllSubjectById() throws Exception {
        Long id = 1L;
        List<ISave> subjects = Collections.singletonList(new Subject(/* Initialize your Subject object */));
        when(adminService.listAll(any(Subject.class))).thenReturn(subjects);

        mockMvc.perform(get("/admin/subject/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteSubject() throws Exception {
        Long id = 1L;
        Subject subject = new Subject();
        subject.setId(id);

        mockMvc.perform(delete("/admin/subject/{id}", id))
                .andExpect(status().isOk());
    }

    // Add tests for other methods such as saveUser, listAllUser, etc.
    @Test
    public void testSaveUser() throws Exception {
        SchoolUser schoolUser = new SchoolUser(/* Initialize your SchoolUser object */);
        when(adminService.save(any(SchoolUser.class))).thenReturn(schoolUser);

        mockMvc.perform(post("/admin/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(schoolUser)))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllUser() throws Exception {
        List<ISave> users = Collections.singletonList(new SchoolUser(/* Initialize your SchoolUser object */));
        when(adminService.listAll(any(SchoolUser.class))).thenReturn(users);

        mockMvc.perform(get("/admin/user"))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllUserById() throws Exception {
        Long id = 1L;
        List<ISave> users = Collections.singletonList(new SchoolUser(/* Initialize your SchoolUser object */));
        when(adminService.listAll(any(SchoolUser.class))).thenReturn(users);

        mockMvc.perform(get("/admin/user/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUser() throws Exception {
        Long id = 1L;
        SchoolUser schoolUser = new SchoolUser();
        schoolUser.setId(id);

        mockMvc.perform(delete("/admin/user/{id}", id))
                .andExpect(status().isOk());
    }

// Add tests for other methods such as saveStaff, listAllStaff, etc.
/*@Test
public void testSaveStaff() throws Exception {
    Staff staff = new Staff();
    when(adminService.save(staff)).thenReturn(staff);

    mockMvc.perform(post("/admin/staff")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(staff)))
            .andExpect(status().isOk());
}*/

    @Test
    public void testListAllStaff() throws Exception {
        List<ISave> staffList = Collections.singletonList(new Staff(/* Initialize your Staff object */));
        when(adminService.listAll(any(Staff.class))).thenReturn(staffList);

        mockMvc.perform(get("/admin/staff"))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllStaffById() throws Exception {
        Long id = 1L;
        List<ISave> staffList = Collections.singletonList(new Staff(/* Initialize your Staff object */));
        when(adminService.listAll(any(Staff.class))).thenReturn(staffList);

        mockMvc.perform(get("/admin/staff/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteStaff() throws Exception {
        Long id = 1L;
        Staff staff = new Staff();
        staff.setId(id);

        mockMvc.perform(delete("/admin/staff/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveOccupation() throws Exception {
        Occupation occupation = new Occupation(/* Initialize your Occupation object */);
        when(adminService.save(any(Occupation.class))).thenReturn(occupation);

        mockMvc.perform(post("/admin/occupation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(occupation)))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllOccupation() throws Exception {
        List<ISave> occupations = Collections.singletonList(new Occupation(/* Initialize your Occupation object */));
        when(adminService.listAll(any(Occupation.class))).thenReturn(occupations);

        mockMvc.perform(get("/admin/occupation"))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllOccupationById() throws Exception {
        Long id = 1L;
        List<ISave> occupations = Collections.singletonList(new Occupation(/* Initialize your Occupation object */));
        when(adminService.listAll(any(Occupation.class))).thenReturn(occupations);

        mockMvc.perform(get("/admin/occupation/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteOccupation() throws Exception {
        Long id = 1L;
        Occupation occupation = new Occupation();
        occupation.setId(id);

        mockMvc.perform(delete("/admin/occupation/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveClassroom() throws Exception {
        Classroom classroom = new Classroom(/* Initialize your Classroom object */);
        when(adminService.save(any(Classroom.class))).thenReturn(classroom);

        mockMvc.perform(post("/admin/classroom")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(classroom)))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllClassroom() throws Exception {
        List<ISave> classrooms = Collections.singletonList(new Classroom(/* Initialize your Classroom object */));
        when(adminService.listAll(any(Classroom.class))).thenReturn(classrooms);

        mockMvc.perform(get("/admin/classroom"))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllClassroomById() throws Exception {
        Long id = 1L;
        List<ISave> classrooms = Collections.singletonList(new Classroom(/* Initialize your Classroom object */));
        when(adminService.listAll(any(Classroom.class))).thenReturn(classrooms);

        mockMvc.perform(get("/admin/classroom/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteClassroom() throws Exception {
        Long id = 1L;
        Classroom classroom = new Classroom();
        classroom.setId(id);

        mockMvc.perform(delete("/admin/classroom/{id}", id))
                .andExpect(status().isOk());
    }

  /*  @Test
    public void testLinkUserAndParent() throws Exception {
        ISave parent = new Parent(*//* Initialize your Parent object *//*);
        when(adminService.save(any(Parent.class))).thenReturn(parent);

        mockMvc.perform(post("/admin/parent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(parent)))
                .andExpect(status().isOk());
    }*/

    @Test
    public void testListAllParent() throws Exception {
        List<ISave> parents = Collections.singletonList(new Parent(/* Initialize your Parent object */));
        when(adminService.listAll(any(Parent.class))).thenReturn(parents);

        mockMvc.perform(get("/admin/parent"))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllParentById() throws Exception {
        Long id = 1L;
        List<ISave> parents = Collections.singletonList(new Parent(/* Initialize your Parent object */));
        when(adminService.listAll(any(Parent.class))).thenReturn(parents);

        mockMvc.perform(get("/admin/parent/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteParent() throws Exception {
        Long id = 1L;
        Parent parent = new Parent();
        parent.setId(id);

        mockMvc.perform(delete("/admin/parent/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveSchoolPosition() throws Exception {
        SchoolPosition schoolPosition = new SchoolPosition(/* Initialize your SchoolPosition object */);
        when(adminService.save(any(SchoolPosition.class))).thenReturn(schoolPosition);

        mockMvc.perform(post("/admin/school-position")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(schoolPosition)))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllSchoolPosition() throws Exception {
        List<ISave> schoolPositions = Collections.singletonList(new SchoolPosition(/* Initialize your SchoolPosition object */));
        when(adminService.listAll(any(SchoolPosition.class))).thenReturn(schoolPositions);

        mockMvc.perform(get("/admin/school-position"))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllSchoolPositionById() throws Exception {
        Long id = 1L;
        List<ISave> schoolPositions = Collections.singletonList(new SchoolPosition(/* Initialize your SchoolPosition object */));
        when(adminService.listAll(any(SchoolPosition.class))).thenReturn(schoolPositions);

        mockMvc.perform(get("/admin/school-position/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteSchoolPosition() throws Exception {
        Long id = 1L;
        SchoolPosition schoolPosition = new SchoolPosition();
        schoolPosition.setId(id);

        mockMvc.perform(delete("/admin/school-position/{id}", id))
                .andExpect(status().isOk());
    }


}

