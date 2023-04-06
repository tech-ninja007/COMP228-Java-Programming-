package com.exercise1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import oracle.jdbc.*;
import oracle.sql.*;
import java.sql.*;
import java.time.LocalDate;

public class PlayerGameApplication extends Application {
    Label playerInformation;
    Label gameInformation;
    TextField firstNameField;
    TextField lastNameField;
    TextField addressField;
    TextField provinceField;
    TextField postalCodeField;
    TextField phoneNumberField;
    TextField updatePlayerIdField;
    TextField gameTitleField;
    TextField gameScoreField;
    TextField datePlayedField;
    DatePicker datePicker;

    Button updatePlayerButton;
    Button createPlayerButton;
    Button displayAllPlayerButton;

    TableView<PlayerAndGame> playerAndGameTable;

    ObservableList<PlayerAndGame> data;
    public Connection getDatabaseConnection(){
        Connection connection;
        try {
            System.out.println("> Start Program ...");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("> Driver Loaded successfully.");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@199.212.26.208:1521:SQLD"," COMP228_W23_sy_139", "password");
            System.out.println("Database connected successfully.");
            Statement statement = connection.createStatement();
            return connection;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void start(Stage stage) throws Exception {
        Connection connection = getDatabaseConnection();
        if(connection == null){
            System.out.println("Database not connected");
        }

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        playerInformation= new Label("Player Information:");
        gridPane.add(playerInformation,0,0,2,1);
        playerInformation.setFont(Font.font("Verdana", FontWeight.BOLD,10));

        gridPane.add(new Label("First Name:"),0,1);
        firstNameField = new TextField();
        gridPane.add(firstNameField,1,1);

        gridPane.add(new Label("Last Name:"),0,2);
        lastNameField = new TextField();
        gridPane.add(lastNameField,1,2);

        gridPane.add(new Label("Address:"),0,3);
        addressField = new TextField();
        gridPane.add(addressField,1,3);

        gridPane.add(new Label("Province:"),0,4);
        provinceField = new TextField();
        gridPane.add(provinceField,1,4);

        gridPane.add(new Label("Postal Code:"),0,5);
        postalCodeField = new TextField();
        gridPane.add(postalCodeField,1,5);

        gridPane.add(new Label("Phone Number:"),0,6);
        phoneNumberField = new TextField();
        gridPane.add(phoneNumberField,1,6);

        gridPane.add(new Label("Update Player by Id"),3,0);
        updatePlayerIdField = new TextField();
        gridPane.add(updatePlayerIdField,4,0);
        updatePlayerButton = new Button("Update");
        gridPane.add(updatePlayerButton,5,0);

        gameInformation= new Label("Game Information:");
        gridPane.add(gameInformation,3,3,2,1);
        gameInformation.setFont(Font.font("Verdana", FontWeight.BOLD,10));

        gridPane.add(new Label("Game Title:"),3,4);
        gameTitleField = new TextField();
        gridPane.add(gameTitleField,4,4);

        gridPane.add(new Label("Game Score:"),3,5);
        gameScoreField = new TextField();
        gridPane.add(gameScoreField,4,5);

        gridPane.add(new Label("Date Played:"),3,6);
        gridPane.add(new Label("Date format is DD-MM-YY"),3,7,2,1);
        datePlayedField = new TextField();
        gridPane.add(datePlayedField,4,6);

        createPlayerButton = new Button("Create Player");
        displayAllPlayerButton = new Button("Display All Players");
        createPlayerButton.setPrefWidth(150);
        gridPane.add(createPlayerButton, 4,11);
        gridPane.add(displayAllPlayerButton, 5,11);

        createPlayerButton.setOnAction( actionEvent -> {
            try {
                PreparedStatement selectPlayerId = connection.prepareStatement("SELECT player_id from Player where first_name = ? and last_name = ?");
                selectPlayerId.setString(1,firstNameField.getText());
                selectPlayerId.setString(2,lastNameField.getText());
                ResultSet rs1 = selectPlayerId.executeQuery();
                if(rs1.next() == false){
                    PreparedStatement preparedStatement = connection.prepareStatement("Insert INTO Player (first_name,last_name,address,postal_code,province,phone_number)" +
                            "VALUES(?,?,?,?,?,?)");
                    preparedStatement.setString(1,firstNameField.getText());
                    preparedStatement.setString(2,lastNameField.getText());
                    preparedStatement.setString(3,addressField.getText());
                    preparedStatement.setString(4,postalCodeField.getText());
                    preparedStatement.setString(5,phoneNumberField.getText());
                    preparedStatement.setString(6,phoneNumberField.getText());
                    int count = preparedStatement.executeUpdate();
                    if(count == 1){
                        System.out.println("inserted a player");
                    }
                }
                ResultSet rs3 = selectPlayerId.executeQuery();
                PreparedStatement selectGameId = connection.prepareStatement("SELECT game_id from GAME where game_title = ?");
                selectGameId.setString(1,gameTitleField.getText());
                ResultSet rs2 = selectGameId.executeQuery();
                if(rs2.next() == false){
                    PreparedStatement preparedStatement = connection.prepareStatement("Insert INTO Game (game_title) VALUES (?)");
                    preparedStatement.setString(1,gameTitleField.getText());
                    int count = preparedStatement.executeUpdate();
                    if(count == 1){
                        System.out.println("inserted a game");
                    }
                }
                ResultSet rs4 = selectGameId.executeQuery();
                PreparedStatement preparedStatement = connection.prepareStatement("Insert INTO PlayerAndGame (player_id,game_id,playing_date,score)" +
                        "VALUES(?,?,?,?)");
                if(rs3.next() == true){
                    preparedStatement.setInt(1,rs3.getInt("player_id"));
                }
                if(rs4.next() == true){
                    preparedStatement.setInt(2,rs4.getInt("game_id"));
                }
                preparedStatement.setString(3,datePlayedField.getText());
                preparedStatement.setInt(4, Integer.parseInt(gameScoreField.getText()));
                int count = preparedStatement.executeUpdate();
                if(count == 1){
                    System.out.println("inserted a playerAndGame row");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        updatePlayerButton.setOnAction(actionEvent -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from player where player_id = ?");
                preparedStatement.setInt(1,Integer.parseInt(updatePlayerIdField.getText()));
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next() == false){
                    System.out.println("player Id not found");
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(!firstNameField.getText().isEmpty()){
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("Update Player set first_name = ? where player_id = ?");
                    preparedStatement.setString(1,firstNameField.getText());
                    preparedStatement.setInt(2,Integer.parseInt(updatePlayerIdField.getText()));
                    int count = preparedStatement.executeUpdate();
                    System.out.println("first_name updated "+count);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(!lastNameField.getText().isEmpty()){
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("Update Player set last_name = ? where player_id = ?");
                    preparedStatement.setString(1,lastNameField.getText());
                    preparedStatement.setInt(2,Integer.parseInt(updatePlayerIdField.getText()));
                    int count = preparedStatement.executeUpdate();
                    System.out.println("last_name updated "+count);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(!addressField.getText().isEmpty()){
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("Update Player set address = ? where player_id = ?");
                    preparedStatement.setString(1,addressField.getText());
                    preparedStatement.setInt(2,Integer.parseInt(updatePlayerIdField.getText()));
                    int count = preparedStatement.executeUpdate();
                    System.out.println("address updated "+count);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(!postalCodeField.getText().isEmpty()){
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("Update Player set postal_code = ? where player_id = ?");
                    preparedStatement.setString(1,postalCodeField.getText());
                    preparedStatement.setInt(2,Integer.parseInt(updatePlayerIdField.getText()));
                    int count = preparedStatement.executeUpdate();
                    System.out.println("postal code updated "+count);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(!provinceField.getText().isEmpty()){
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("Update Player set province = ? where player_id = ?");
                    preparedStatement.setString(1,provinceField.getText());
                    preparedStatement.setInt(2,Integer.parseInt(updatePlayerIdField.getText()));
                    int count = preparedStatement.executeUpdate();
                    System.out.println("province updated "+count);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(!phoneNumberField.getText().isEmpty()){
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("Update Player set phone_number = ? where player_id = ?");
                    preparedStatement.setString(1,phoneNumberField.getText());
                    preparedStatement.setInt(2,Integer.parseInt(updatePlayerIdField.getText()));
                    int count = preparedStatement.executeUpdate();
                    System.out.println("phone number updated "+count);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });

        displayAllPlayerButton.setOnAction(actionEvent -> {
            playerAndGameTable = new TableView<>();
            Statement statement;
            ResultSet rs;
            data = FXCollections.observableArrayList();
            try {
                statement = connection.createStatement();
                String selectListofPlayers = "select p.player_id, p.first_name,p.last_name, p.address,p.postal_code,p.province,p.phone_number,\n" +
                        "g.game_title, pg.playing_date, pg.score\n" +
                        "from playerandgame pg join player p on pg.player_id = p.player_id\n" +
                        "join game g on pg.game_id= g.game_id";
                rs = statement.executeQuery(selectListofPlayers);
                while(rs.next()){
                    PlayerAndGame player = new PlayerAndGame(rs.getInt("player_id"), rs.getString("first_name")+" "+rs.getString("last_name"),
                            rs.getString("address"), rs.getString("postal_code"), rs.getString("province")
                            , rs.getString("phone_number"), rs.getString("game_title"), rs.getInt("score")
                            , rs.getDate("playing_date").toString());
                    data.add(player);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            TableColumn<PlayerAndGame, Integer> idCol = new TableColumn("Player Id");
            idCol.setCellValueFactory( new PropertyValueFactory<>("id"));
            TableColumn<PlayerAndGame, String>  nameCol = new TableColumn("Name");
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            TableColumn<PlayerAndGame, String> addressCol = new TableColumn("Address");
            addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
            TableColumn<PlayerAndGame, String>  postalCodeCol = new TableColumn("PostalCode");
            postalCodeCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
            TableColumn<PlayerAndGame, String> provinceCol = new TableColumn("Province");
            provinceCol.setCellValueFactory(new PropertyValueFactory<>("province"));
            TableColumn<PlayerAndGame, String>  phoneNumberCol = new TableColumn("Phone Number");
            phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            TableColumn<PlayerAndGame, String> gameTitleCol = new TableColumn<>("Game Title");
            gameTitleCol.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));
            TableColumn<PlayerAndGame, Integer> scoreCol = new TableColumn<>("Score");
            scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
            TableColumn<PlayerAndGame, String> datePlayedCol = new TableColumn<>("Date Played");
            datePlayedCol.setCellValueFactory(new PropertyValueFactory<>("datePlayed"));

            playerAndGameTable.setItems(data);
            playerAndGameTable.getColumns().addAll(idCol,nameCol,addressCol,postalCodeCol,provinceCol,phoneNumberCol,gameTitleCol,scoreCol,datePlayedCol);

            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(playerAndGameTable);

            Scene secondScene = new Scene(secondaryLayout, 760, 300);

            // New window (Stage)
            Stage newWindow = new Stage();
            newWindow.setTitle("List Of All Players");
            newWindow.setScene(secondScene);

            // Set position of second window, related to primary window.
            newWindow.setX(stage.getX() + 200);
            newWindow.setY(stage.getY() + 100);

            newWindow.show();
        });

        StackPane root=new StackPane();
        root.getChildren().add(gridPane);
        Scene scene=new Scene(root,720,350);
        stage.setTitle("Player Game JavaFX Application(Assignment 5)");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
