package h8.chikey.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int studentID;

    @Column(name = "FirstName")
    private String studentFirstName;

    @Column(name = "LastName")
    private String studentLastName;

    @Column(name = "MidlName")
    private String studentMidlName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Faculty_ID")
    private Faculty faculty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Special_ID")
    private Special special;

    @Column(name = "Course")
    private int studentCourse;

    @Column(name = "Group")
    private String studentGroup;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    Set<Performance> setPerformance;

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentMidlName='" + studentMidlName + '\'' +
                ", faculty=" + faculty +
                ", special=" + special +
                ", studentCourse=" + studentCourse +
                ", studentGroup='" + studentGroup + '\'' +
                '}';
    }
}
