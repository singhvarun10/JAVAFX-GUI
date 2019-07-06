/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;
import java.util.*;
import javafx.application.Application;  
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.scene.control.Label;  
import javafx.scene.control.TextField;  
import javafx.scene.layout.GridPane;  
import javafx.scene.text.Text;
import javafx.stage.Stage;  
public class Practice extends Application {  
  
      
public static void main(String[] args) {  
launch(args);     
}  
  
@Override  
public void start(Stage primaryStage) throws Exception {  
    // TODO Auto-generated method stub  
    Label user_id=new Label("User ID"); 
    ArrayList<String> a = new ArrayList<>();
    Label password = new Label("Password");
    Text actiontarget = new Text();
    TextField tf1=new TextField();  
    TextField tf2=new TextField();  
    Button b = new Button("Submit");
    Button m = new Button("View");
    b.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent event){
            actiontarget.setText("Suceessfully added : " + tf1.getText());
            a.add(tf1.getText());
            user_id.setText("");
            password.setText("");
        }
    }
    );
    m.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent event){
            actiontarget.setText("hello : " + tf1.getText());
        }
    });
    GridPane root = new GridPane();  
    root.setHgap(10);
    root.setVgap(5);
    root.addRow(0, user_id, tf1);  
    root.addRow(1, password, tf2);  
    root.addRow(2, b); 
    root.addRow(3,m);
    root.addRow(4,actiontarget);
    Scene scene=new Scene(root,300,200);  
    primaryStage.setScene(scene);  
    primaryStage.setTitle("Text Field Example");  
    primaryStage.show();  
}  
}  