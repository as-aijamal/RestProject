package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;

    @ManyToOne(cascade = {PERSIST, REFRESH, DETACH, MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @ManyToMany(cascade = {PERSIST, MERGE, REFRESH, DETACH, REMOVE}, fetch = FetchType.LAZY, mappedBy = "courses")
    private List<Group> groups;

    @OneToOne(cascade = ALL,mappedBy = "course")
    private Teacher teacher;
}
