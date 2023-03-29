module com.exercise1.syedikramuddin_comp228lab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.exercise1.syedikramuddin_comp228lab5 to javafx.fxml;
    exports com.exercise1.syedikramuddin_comp228lab5;
}