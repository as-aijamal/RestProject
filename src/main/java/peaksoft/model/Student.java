package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import peaksoft.enumPackage.StudyFormat;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "study_format")
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH}, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "group_id")
    private Group groups;

    @OneToOne(cascade = ALL,fetch = FetchType.EAGER)
    private AuthInfo authInfo;

}
