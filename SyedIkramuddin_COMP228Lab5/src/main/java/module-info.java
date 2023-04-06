module com.exercise1.syedikramuddin_comp228lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires ojdbc6;
    requires java.sql;


    opens com.exercise1 to javafx.fxml;
    exports com.exercise1;
}