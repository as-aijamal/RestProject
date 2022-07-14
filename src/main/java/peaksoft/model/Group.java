package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;


    @ManyToMany(cascade = {REFRESH,MERGE,PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "course_group", joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnore
    private List<Course> courses;

    public void setCourses(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
    }
    @OneToMany(cascade = ALL, fetch = FetchType.LAZY, mappedBy = "groups")
    private List<Student> students;

}
