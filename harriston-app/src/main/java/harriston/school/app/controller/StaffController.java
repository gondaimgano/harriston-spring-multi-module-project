package harriston.school.app.controller;

import harriston.school.core.contracts.ParentService;
import harriston.school.core.contracts.StaffService;
import harriston.school.core.entities.SchoolReport;
import harriston.school.core.entities.Staff;
import harriston.school.core.entities.SchoolUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController extends ParentController{
    private final StaffService staffService;

    public StaffController(
            @Qualifier("staffService")
            StaffService staffService,
                           @Qualifier("parentService") ParentService parentService) {
        super(parentService);
        this.staffService = staffService;
    }

    @PostMapping("/user")
    public ResponseEntity<SchoolUser> manageCredentials(@RequestBody SchoolUser schoolUser) {
        return ResponseEntity.ok(staffService.manageCredentials(schoolUser));
    }

    @GetMapping("/view/profile")
    public ResponseEntity<Staff> viewMyProfile() {
        return ResponseEntity.ok(staffService.viewMyProfile(1L));
    }

    @PostMapping("/report")
    public ResponseEntity<SchoolReport> create(SchoolReport report) {
        return ResponseEntity.ok(staffService.create(report));
    }

    @GetMapping("/report")
    public ResponseEntity<List<SchoolReport>> listReports() {
        return ResponseEntity.ok(staffService.listReports(12345L));
    }


}
