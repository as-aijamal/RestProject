package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = {PERSIST, REFRESH, DETACH, MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;

    @ManyToOne(cascade = {PERSIST, REFRESH, DETACH, MERGE}, fetch = FetchType.LAZY)
    private Company company;

    @OneToOne(cascade = ALL,fetch = FetchType.EAGER)
    private AuthInfo authInfo;
}
