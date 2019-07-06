/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.ArrayList;
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
public class practice2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label user = new Label("user");
        Label password = new Label("password");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        Text tf3 = new Text();
        
        Button b1 = new Button();
        Button b2 = new Button();
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        b1.setText("Submit");
        b2.setText("View");
        b1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                tf3.setText("Welcome" + tf1.getText());
                a.add(tf1.getText());
                tf1.setText("");
                tf2.setText("");
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println(a);
                System.out.println(b);
            }
        });
        
        GridPane g= new GridPane();
        g.setHgap(10);
        g.setVgap(5);
        g.addRow(0,user,tf1);
        g.addRow(1,password,tf2);
        g.addRow(2,b1);
        g.addRow(3,b2);
        g.addRow(4,tf3);
        Scene scene = new Scene(g,300,400);
        primaryStage.setTitle("Login");
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
