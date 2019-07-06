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
import javafx.stage.Stage;

/**
 *
 * @author VARUN SINGH
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primary){
        TextField tf1 = new TextField("Enter your name");
        TextField tf2 = new TextField("Enter your age");
        Label name = new Label("name");
        Label age = new Label("age");
        Button b = new Button("View");
        b.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                System.out.println(tf1.getText());
                System.out.println(tf2.getText());
            }
        });
        GridPane root = new GridPane();
        root.setHgap(30);
        root.setVgap(30);
        root.addRow(1,name,tf1);
        root.addRow(2,age,tf2);
        root.addRow(3,b);
        Scene scene = new Scene(root,300,200);
        primary.setScene(scene);
        primary.setTitle("Details");
        primary.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
