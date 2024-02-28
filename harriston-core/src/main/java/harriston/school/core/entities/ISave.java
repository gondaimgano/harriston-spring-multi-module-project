package harriston.school.core.entities;

public sealed interface ISave permits Parent, Staff, SchoolReport, Student, Subject,Occupation,Classroom, SchoolUser, SchoolPosition,Comment {
}
