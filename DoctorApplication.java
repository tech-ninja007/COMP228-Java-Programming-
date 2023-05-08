package com.exercise1;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;


import java.io.IOException;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;

public class DoctorApplication extends Application{

    private final String dbUrl = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    //private final String dbUrl = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
    private final String dbUser = "COMP228_W23_sy_139";
    private final String dbPass = "password";

    @Override
    public void start(Stage primaryStage) throws IOException {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(20);
        pane.setVgap(10);

        //TextFields and Texts
        Text title = new Text("Doctor's Database Application");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        pane.add(title, 0, 0);

        Text docId = new Text("Doctor's ID");
        TextField docIdTextField = new TextField();
        pane.add(docId, 0,1);
        pane.add(docIdTextField,1,1);

        Text docName = new Text("Doctor's Name");
        TextField docNameTextField = new TextField();
        pane.add(docName,0,2);
        pane.add(docNameTextField,1,2);
        docNameTextField.setEditable(false);

        Text docGrossSalary = new Text("Doctor's Gross Salary");
        TextField docGrossSalaryTextField = new TextField();
        pane.add(docGrossSalary,0,3);
        pane.add(docGrossSalaryTextField,1,3);

        Text docNetSalary = new Text("Doctor's Net Salary");
        TextField docNetSalaryTextField = new TextField();
        pane.add(docNetSalary,0,4);
        pane.add(docNetSalaryTextField,1,4);
        docNetSalaryTextField.setEditable(false);

        //Buttons
        Button btConnect = new Button("Connect");
        pane.add(btConnect,0,5);
        btConnect.setPrefWidth(110);

        Button btUpdate = new Button("Update");
        pane.add(btUpdate,0,6);
        btUpdate.setPrefWidth(110);

        Button btDelete = new Button("Delete");
        pane.add(btDelete,0,7);
        btDelete.setPrefWidth(110);

        Button btDisplay = new Button("Display");
        pane.add(btDisplay,1,5);
        btDisplay.setPrefWidth(110);

        Button btReset = new Button("Reset");
        pane.add(btReset,1,6);
        btReset.setPrefWidth(110);

        Button btQuit = new Button("Quit");
        pane.add(btQuit,1,7);
        btQuit.setPrefWidth(110);

        //Connect Button Action Event
        btConnect.setOnAction(event ->{
            try{
                Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPass);
                Alert alertSuccess = new Alert(Alert.AlertType.INFORMATION);
                alertSuccess.setHeaderText(null);
                alertSuccess.setContentText("Connection successful!");
                alertSuccess.showAndWait();

            } catch (SQLException e) {
                Alert alertFailed = new Alert(Alert.AlertType.WARNING);
                alertFailed.setHeaderText(null);
                alertFailed.setContentText("Connection failed!");
                alertFailed.showAndWait();
                e.printStackTrace();}
        });

        //Display Button Action Event
        btDisplay.setOnAction(event -> {
            try {
                Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPass);
                String query = "SELECT DocName, DocGrSal FROM Doctor WHERE DocId = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1,docIdTextField.getText());

                var result = ps.executeQuery();

                if (result.next()) {
                    docNameTextField.setText(result.getString("DocName"));
                    docGrossSalaryTextField.setText(result.getString("DocGrSal"));
                    double grossSalary = Double.parseDouble(result.getString("DocGrSal"));
                    double netSalary = grossSalary - (grossSalary * 0.3);
                    NumberFormat nf = NumberFormat.getInstance(Locale.US);
                    docGrossSalaryTextField.setText(nf.format(grossSalary));
                    docNetSalaryTextField.setText(nf.format(netSalary));

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setContentText("Doctor not found!");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });

        //Update Button Action Event
        btUpdate.setOnAction(event ->{
            try{
                Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPass);

                int docId1 = Integer.parseInt(docIdTextField.getText());
                int grossSalary = Integer.parseInt(docGrossSalaryTextField.getText());
                String query = "UPDATE Doctor SET DocGrSal = ? WHERE DocId = ?";

                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, grossSalary);
                ps.setInt(2, docId1);

                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Gross salary updated successfully!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setContentText("Doctor not found!");
                    alert.showAndWait();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        //Reset Button Action Event
        btReset.setOnAction(event ->{
            docIdTextField.clear();
            docNameTextField.clear();
            docGrossSalaryTextField.clear();
            docNetSalaryTextField.clear();
        });

        //Delete Button Action Event
        btDelete.setOnAction(event ->{
            try{
                Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPass);
                String query = "DELETE FROM Doctor WHERE DocId = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, docIdTextField.getText());

                int rowsDeleted = ps.executeUpdate();

                if (rowsDeleted == 0) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setContentText("Doctor not found!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Record successfully deleted!");
                    alert.showAndWait();
                    docIdTextField.clear();
                    docNameTextField.clear();
                    docGrossSalaryTextField.clear();
                    docNetSalaryTextField.clear();
                }

            }catch (SQLException e){
                throw new RuntimeException(e);
            }

        });

        //Quit Button Action Event
        btQuit.setOnAction(event ->{
            try {
                Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPass);
                if(connection != null) {
                    connection.close();
                    System.out.println("You decided to close the Database Connection and quit the application...");
                }
                Platform.exit();
            } catch (SQLException e) {
                System.out.println("Error occurred while closing database connection: " + e.getMessage());
            }
            Platform.exit();
        });

        //BorderPane
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setCenter(pane);

        //Create a scene  and place it in the stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Doctor's Database Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}



