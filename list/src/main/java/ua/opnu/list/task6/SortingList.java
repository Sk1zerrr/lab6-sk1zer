package ua.opnu.list.task6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SortingList extends Application {

    public static class Student {
        private String name, surname; private double average;
        public Student(String n,String s,double a){name=n;surname=s;average=a;}
        public String getName(){return name;}
        public String getSurname(){return surname;}
        public double getAverage(){return average;}
        @Override public String toString(){return name+" "+surname+" ("+average+")";}
    }

    public static class NameSorter implements java.util.Comparator<Student> {
        private boolean asc; public NameSorter(boolean asc){this.asc=asc;}
        public int compare(Student s1, Student s2){ return asc ? s1.getName().compareTo(s2.getName()) : s2.getName().compareTo(s1.getName()); }
    }
    public static class SurnameSorter implements java.util.Comparator<Student> {
        private boolean asc; public SurnameSorter(boolean asc){this.asc=asc;}
        public int compare(Student s1, Student s2){ return asc ? s1.getSurname().compareTo(s2.getSurname()) : s2.getSurname().compareTo(s1.getSurname()); }
    }
    public static class MarkSorter implements java.util.Comparator<Student> {
        private boolean asc; public MarkSorter(boolean asc){this.asc=asc;}
        public int compare(Student s1, Student s2){ return asc ? Double.compare(s1.getAverage(), s2.getAverage()) : Double.compare(s2.getAverage(), s1.getAverage()); }
    }

    private ObservableList<Student> students;
    private boolean nameAsc=true, surnameAsc=true, markAsc=true;

    @Override
    public void start(Stage stage){
        stage.setTitle("Список студентів");
        students = FXCollections.observableArrayList(
                new Student("Борис", "Іванов", 75),
                new Student("Петро", "Петренко", 92),
                new Student("Сергій", "Сергієнко", 61),
                new Student("Григорій", "Сковорода", 88)
        );

        ListView<Student> listView = new ListView<>(students);
        listView.setPrefSize(400, 240);

        Button byName = new Button("Сортувати за ім'ям");
        Button bySurname = new Button("Сортувати за прізвищем");
        Button byMark = new Button("Сортувати за балом");
        HBox.setHgrow(byName, Priority.ALWAYS);
        HBox.setHgrow(bySurname, Priority.ALWAYS);
        HBox.setHgrow(byMark, Priority.ALWAYS);
        byName.setMaxWidth(Double.MAX_VALUE); bySurname.setMaxWidth(Double.MAX_VALUE); byMark.setMaxWidth(Double.MAX_VALUE);

        byName.setOnAction(e -> { students.sort(new NameSorter(nameAsc)); nameAsc = !nameAsc; });
        bySurname.setOnAction(e -> { students.sort(new SurnameSorter(surnameAsc)); surnameAsc = !surnameAsc; });
        byMark.setOnAction(e -> { students.sort(new MarkSorter(markAsc)); markAsc = !markAsc; });

        HBox buttons = new HBox(5, byName, bySurname, byMark);
        buttons.setAlignment(Pos.CENTER);
        VBox root = new VBox(5, listView, buttons);
        root.setPadding(new Insets(5));
        root.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args){ launch(args); }
}
