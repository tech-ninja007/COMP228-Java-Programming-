package com.exercise1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.List;


public class StudentInformationApplication extends Application {
    TextField nameField;
    TextField addressField;
    TextField provinceField;
    TextField cityField;
    TextField postalCodeField;
    TextField phoneNumbeField;
    TextField emailField;
    CheckBox studentCouncilCheck;
    CheckBox volunteerWorkCheck;
    RadioButton computerScienceBtn;
    RadioButton businessSchoolBtn;
    ComboBox coursesBox;
    TextArea coursesArea;

    Button displayButton;
    TextArea displayArea;
    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(6,6,6,6));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Name:"),0,0);
        nameField = new TextField();
        gridPane.add(nameField, 1,0);

        gridPane.add(new Label("Address:"),0,1);
        addressField = new TextField();
        gridPane.add(addressField,1,1);

        gridPane.add(new Label("Province:"),0,2);
        provinceField = new TextField();
        gridPane.add(provinceField,1,2);

        gridPane.add(new Label("City:"),0,3);
        cityField = new TextField();
        gridPane.add(cityField,1,3);

        gridPane.add(new Label("Postal Code:"),0,4);
        postalCodeField = new TextField();
        gridPane.add(postalCodeField,1,4);

        gridPane.add(new Label("Phone Number:"),0,5);
        phoneNumbeField = new TextField();
        gridPane.add(phoneNumbeField,1,5);

        gridPane.add(new Label("Email:"),0,6);
        emailField = new TextField();
        gridPane.add(emailField,1,6);

        displayButton = new Button("Display");
        gridPane.add(displayButton,5,8);

        studentCouncilCheck = new CheckBox();
        gridPane.add(studentCouncilCheck,3,2);
        gridPane.add(new Label("Student Council"),4,2);

        volunteerWorkCheck = new CheckBox();
        gridPane.add(volunteerWorkCheck,3,5);
        gridPane.add(new Label("Volunteer Work"),4,5);

        computerScienceBtn = new RadioButton("Computer Science");
        computerScienceBtn.setText("Computer Science");
        gridPane.add(computerScienceBtn,6,0);
        //gridPane.add(new Label("Computer Science"),7,0);

        businessSchoolBtn = new RadioButton("Business Administration");
        businessSchoolBtn.setText("Business Administration");
        gridPane.add(businessSchoolBtn,8,0,1,1);
        //gridPane.add(new Label("Business Administration"),9,0,1,1);
        ToggleGroup subject = new ToggleGroup();
        computerScienceBtn.setToggleGroup(subject);
        businessSchoolBtn.setToggleGroup(subject);


        coursesBox = new ComboBox();
        coursesBox.setPrefWidth(150);
        gridPane.add(coursesBox,6,1,2,1);


        computerScienceBtn.setOnAction(actionEvent -> {
            String[] courses = new String[]{"Java", "Python", "C#","Software Engineering"};
            coursesBox.setItems(FXCollections.observableArrayList(courses));
        });
        businessSchoolBtn.setOnAction(actionEvent -> {
            String[] courses= new String[]{"Business Communication","Marketing","Accounting"};
            coursesBox.setItems(FXCollections.observableArrayList(courses));
        });
        List<String> selectedCourses = new ArrayList<String>();
        final String[] displayCourses = {""};


        coursesArea = new TextArea();
        coursesArea.setPrefWidth(200);
        coursesArea.setPrefHeight(100);
        coursesArea.setEditable(false);
        gridPane.add(coursesArea,6,2,4,4);

        coursesBox.setOnAction(actionEvent -> {
            if(coursesBox.getValue() == null){
                return;
            }
            if(selectedCourses.contains(coursesBox.getValue().toString())){
                return;
            }
            selectedCourses.add(coursesBox.getValue().toString());
            displayCourses[0] += coursesBox.getValue().toString()+"\n";
            coursesArea.setText(displayCourses[0]);
        });


        ScrollPane scrollPane = new ScrollPane();
        displayArea = new TextArea();
        displayArea.setPrefColumnCount(10);
        displayArea.setPrefRowCount(4);
        displayArea.setPrefHeight(150);
        displayArea.setPrefWidth(800);
        displayArea.setEditable(false);
        scrollPane.setContent(displayArea);
        gridPane.add(scrollPane,0,9,11,11);

        displayButton.setOnAction(actionEvent -> {
            String subjectValue = "";
            String subjects= "";
            String checkBoxContent = "";
             if(volunteerWorkCheck.isSelected()){
                 checkBoxContent+= "Part of Volunteer Work"+"\n";
             }
             if(studentCouncilCheck.isSelected()){
                 checkBoxContent += "Part of Student Council"+"\n";
             }
             if(computerScienceBtn.isSelected()){
                 subjectValue+= "Computer Science";
             }
             if(businessSchoolBtn.isSelected()){
                 subjectValue+= "Business Administration";
             }
            for (String value: selectedCourses) {
                subjects += value+"\n";
            }
            String displayText ="Name: "+nameField.getText()+"\n"+
                    "Address: "+addressField.getText()+"\n"+
                    "city: "+cityField.getText()+"\n"+
                    "Postal Code: "+postalCodeField.getText()+"\n"+
                    "Phone number: "+phoneNumbeField.getText()+"\n"+
                    "Email:"+emailField.getText()+"\n"+
                    checkBoxContent+
                    "Program Selected: "+subjectValue+"\n"+
                    "Courses Selected:"+"\n"+subjects;
            displayArea.setText(displayText);
            selectedCourses.clear();
            coursesArea.clear();
            displayCourses[0] = "";

        });

        StackPane root=new StackPane();
        root.getChildren().add(gridPane);
        Scene scene=new Scene(root,800,410);
        stage.setTitle("Student Information JavaFX Application(Assignment 4)");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
