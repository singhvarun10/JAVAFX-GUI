/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.sql.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author VARUN SINGH
 */
public class practice4 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        Text t1 = new Text();
        Label user = new Label("user");
        Label pass = new Label("pass");
        Label age = new Label("age");
        Button btn = new Button();
        Button b1 = new Button("add");
        Button b2 = new Button("view");
        btn.setText("Say 'Hello World'");
        b1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/practice","root","root");
                    String sql= "insert into details values (?,?,?)";
                    PreparedStatement stm = conn.prepareStatement(sql);
                    stm.setString(1, tf1.getText());
                    stm.setString(2, tf2.getText());
                    stm.setString(3, tf3.getText());
                    stm.executeUpdate();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Done");
            }
        });
        
        GridPane root = new GridPane();
        root.addRow(1,user,tf1);
        root.addRow(2,pass,tf2);
        root.addRow(3,age,tf3);
        root.addRow(4,b1);
        root.addRow(5,b2);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Say Hi to my app");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
