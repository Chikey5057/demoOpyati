package h8.chikey.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "performance")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int performanceID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Lesson_ID")
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Student_ID")
    private Student student;

    @Column(name = "Semester")
    private String performanceSemester;

    @Column(name = "Evaluation")
    private int performanceEvaluation;

    @Column(name = "DateExam")
    private Date performanceDateExam;

    @Column(name = "Teacher")
    private String performanceTeacher;

    @Override
    public String toString() {
        return "Performance{" +
                "performanceID=" + performanceID +
                ", lesson=" + lesson +
                ", student=" + student +
                ", performanceSemester='" + performanceSemester + '\'' +
                ", performanceEvaluation=" + performanceEvaluation +
                ", performanceDateExam=" + performanceDateExam +
                ", performanceTeacher='" + performanceTeacher + '\'' +
                '}';
    }
}
