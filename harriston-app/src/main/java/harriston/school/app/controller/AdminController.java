package harriston.school.app.controller;


import harriston.school.core.contracts.AdminService;
import harriston.school.core.entities.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/student")
    ResponseEntity<ISave> save(@RequestBody Student student) {
        return ResponseEntity.ok(service.save(student));
    }


    @GetMapping("/student")
    ResponseEntity<List<ISave>> listAllStudent() {
        return ResponseEntity.ok(service.listAll(new Student()));
    }
    @GetMapping("/student/{id}")
    ResponseEntity<List<ISave>> listAllStudent(@PathVariable Long id) {
        var student = new Student();
        student.setId(id);
        return ResponseEntity.ok(service.listAll(student));
    }
    @DeleteMapping("/student/{id}")
    ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        var student = new Student();
        student.setId(id);
        service.delete(student);
        return ResponseEntity.ok("Deleted "+student.getId());
    }

    @PostMapping("/user")
    ResponseEntity<ISave> save(@RequestBody SchoolUser schoolUser) {
        return ResponseEntity.ok(service.save(schoolUser));
    }
    @GetMapping("/user")
    ResponseEntity<List<ISave>> listAllUser() {
        return ResponseEntity.ok(service.listAll(new SchoolUser()));
    }
    @GetMapping("/user/{id}")
    ResponseEntity<List<ISave>> listAllUser(@PathVariable Long id) {
        var schoolUser = new SchoolUser();
        schoolUser.setId(id);
        return ResponseEntity.ok(service.listAll(schoolUser));
    }
    @DeleteMapping("/user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id) {
        var schoolUser = new SchoolUser();
        schoolUser.setId(id);
        service.delete(schoolUser);
        return ResponseEntity.ok("Deleted ".concat(schoolUser.getId().toString()));
    }

    @PostMapping("/staff")
    ResponseEntity<ISave> save(@RequestBody Staff staff) {
        return ResponseEntity.ok(service.save(staff));
    }

    @GetMapping("/staff")
    ResponseEntity<List<ISave>> listAllStaff() {
        return ResponseEntity.ok(service.listAll(new Staff()));
    }
    @GetMapping("/staff/{id}")
    ResponseEntity<List<ISave>> listAllStaff(@PathVariable Long id) {
        var staff = new Staff();
        staff.setId(id);
        return ResponseEntity.ok(service.listAll(staff));
    }
    @DeleteMapping("/staff/{id}")
    ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        var staff = new Staff();
        staff.setId(id);
        service.delete(staff);
        return ResponseEntity.ok("Deleted ".concat(staff.getId().toString()));
    }
    @PostMapping("/occupation")
    ResponseEntity<ISave> save(@RequestBody Occupation occupation) {
        return ResponseEntity.ok(service.save(occupation));
    }
    @GetMapping("/occupation")
    ResponseEntity<List<ISave>> listAllOccupation() {
        return ResponseEntity.ok(service.listAll(new Occupation()));
    }
    @GetMapping("/occupation/{id}")
    ResponseEntity<List<ISave>> listAllOccupation(@PathVariable Long id) {
        var occupation = new Occupation();
        occupation.setId(id);
        return ResponseEntity.ok(service.listAll(occupation));
    }
    @DeleteMapping("/occupation/{id}")
    ResponseEntity<String> deleteOccupation(@PathVariable Long id) {
        var occupation = new Occupation();
        occupation.setId(id);
        service.delete(occupation);
        return ResponseEntity.ok("Deleted ".concat(occupation.getId().toString()));
    }
    @PostMapping("/classroom")
    ResponseEntity<ISave> save(@RequestBody Classroom classroom) {
        return ResponseEntity.ok(service.save(classroom));
    }
    @GetMapping("/classroom")
    ResponseEntity<List<ISave>> listAllClassroom() {
        return ResponseEntity.ok(service.listAll(new Classroom()));
    }

    @GetMapping("/classroom/{id}")
    ResponseEntity<List<ISave>> listAllClassroom(@PathVariable Long id) {
        var classroom = new Classroom();
        classroom.setId(id);
        return ResponseEntity.ok(service.listAll(classroom));
    }

    @DeleteMapping("/classroom/{id}")
    ResponseEntity<String> deleteClassroom(@PathVariable Long id) {
        var classroom = new Classroom();
        classroom.setId(id);
        service.delete(classroom);
        return ResponseEntity.ok("Deleted ".concat(classroom.getId().toString()));
    }

    @GetMapping("/parent")
    ResponseEntity<List<ISave>> listAllParent() {
        return ResponseEntity.ok(service.listAll(new Parent()));
    }
    @GetMapping("/parent/{id}")
    ResponseEntity<List<ISave>> listAllParent(@PathVariable Long id) {
        var parent = new Parent();
        parent.setId(id);
        return ResponseEntity.ok(service.listAll(parent));
    }
    @DeleteMapping("/parent/{id}")
    ResponseEntity<String> deleteParent(@PathVariable Long id) {
        var parent = new Parent();
        parent.setId(id);
        service.delete(parent);
        return ResponseEntity.ok("Delete "+parent.getId());
    }
    @PostMapping("/school-position")
    ResponseEntity<ISave> save(@RequestBody SchoolPosition schoolPosition) {
        return ResponseEntity.ok(service.save(schoolPosition));
    }
    @GetMapping("/school-position")
    ResponseEntity<List<ISave>> listAllSchoolPosition() {
        return ResponseEntity.ok(service.listAll(new SchoolPosition()));
    }

    @GetMapping("/school-position/{id}")
    ResponseEntity<List<ISave>> listAllSchoolPosition(@PathVariable Long id) {
        var parent = new SchoolPosition();
        parent.setId(id);
        return ResponseEntity.ok(service.listAll(parent));
    }
    @DeleteMapping("/school-position/{id}")
    ResponseEntity<String> deleteSchoolPosition(@PathVariable Long id) {
        var parent = new SchoolPosition();
        parent.setId(id);
        service.delete(parent);
        return ResponseEntity.ok("Delete "+parent.getId());
    }
}
