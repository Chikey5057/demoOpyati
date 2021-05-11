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
@Table(name = "special")
public class Special {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int specialID;

    @Column(name = "Name")
    private String specialName;

    @OneToMany(mappedBy = "special")
    Set<Student> setSpecial;


    @Override
    public String toString() {
        return "Special{" +
                "lessonID=" + specialID +
                ", lessonName='" + specialName + '\'' +
                '}';
    }
}
