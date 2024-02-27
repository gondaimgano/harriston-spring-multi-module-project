package harriston.school.app.controller;

import harriston.school.core.contracts.ParentService;
import harriston.school.core.entities.SchoolReport;
import harriston.school.core.entities.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentController {
    private final ParentService parentService;

    public ParentController(
            @Qualifier("parentService")
            ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/view/student/report/{parentId}")
    public ResponseEntity<List<SchoolReport>> viewAllReports(@PathVariable Long parentId) {
        return ResponseEntity.ok(parentService.viewAllReports(parentId));
    }

    @GetMapping("/view/child/all/{parent}")
    public List<Student> viewYourChildrenProfile(@PathVariable Long parentId) {
        return parentService.viewYourChildrenProfile(parentId);
    }
}
