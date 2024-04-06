module org.example.exams {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.exams to javafx.fxml;
    exports org.example.exams;
}