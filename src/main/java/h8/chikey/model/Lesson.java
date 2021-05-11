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
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int lessonID;

    @Column(name = "Name")
    private String lessonName;

    @OneToMany(mappedBy = "lesson")
    Set<Performance> setLesson;

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonID=" + lessonID +
                ", lessonName='" + lessonName + '\'' +
                '}';
    }
}
