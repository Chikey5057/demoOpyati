package h8.chikey.controller;


import h8.chikey.dao.DAO;
import h8.chikey.daoimpl.PerformanceDAOIMPL;
import h8.chikey.daoimpl.StudentDAOIMPL;
import h8.chikey.model.Performance;
import h8.chikey.model.Student;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class MainController {

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> columnID;

    @FXML
    private TableColumn<Student, String> columnLastName;

    @FXML
    private TableColumn<Student, String> columnSpecial;

    @FXML
    private TableColumn<Student, Double> columnBall;





    @FXML
    void initialize(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        ObservableList<Student> list = FXCollections.observableArrayList();
        DAO<Student,Integer> dao = new StudentDAOIMPL(factory);
        list.addAll(dao.readAll());




        columnID.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getStudentID()));
        columnLastName.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getStudentLastName()));
        columnSpecial.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getSpecial().getSpecialName()));
        columnBall.setCellValueFactory(c-> {
            Set<Performance> list1 = c.getValue().getSetPerformance();
            int sum = 0;

            for (Performance performance:list1) {
                if(performance.getStudent() == c.getValue()){
                    sum += performance.getPerformanceEvaluation();
                }
            }
            return new SimpleObjectProperty<>((double)sum / list1.size());
        });
        tableView.setItems(list);


    }







}
