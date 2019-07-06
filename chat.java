/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

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
public class chat extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        Label person1 = new Label("person 1");
        Label person2 = new Label("person 2");
        Text t = new Text();
        Button p1 = new Button("Enter 1");
        Button p2 = new Button("Enter 2");
        p1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                t.setText(tf1.getText() + " : Person 2 enter your message");
                System.out.println(tf1.getText() + " : Person 2 enter your message");
                tf1.setText("");
            }
        });
        p2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                t.setText(tf2.getText() + "   Person 1 enter your message");
                System.out.println(tf2.getText() + " : Person 1 enter your message");
                tf2.setText("");
            }
        });
        
        GridPane root  =new GridPane();
        Scene scene = new Scene(root, 500, 450);
        root.setHgap(30);
        root.setVgap(30);
        root.addRow(1,person1,tf1,p1);
        root.addRow(2,person2,tf2,p2);
        primaryStage.setTitle("Chat Box");
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
