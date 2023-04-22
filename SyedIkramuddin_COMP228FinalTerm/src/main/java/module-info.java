module com.exercise1.syedikramuddin_comp228finalterm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires ojdbc6;


    opens com.exercise1 to javafx.fxml;
    exports com.exercise1;
}