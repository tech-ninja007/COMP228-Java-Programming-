module com.example.syedikramuddin_comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.exercise1 to javafx.fxml;
    exports com.exercise1;
}