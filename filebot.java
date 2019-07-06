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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.sql.*;
import javafx.scene.layout.GridPane;
/**
 *
 * @author VARUN SINGH
 */
public class filebot extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField tf1 = new TextField("Enter the name");
        TextField tf2 = new TextField("Enter the age");
        Text t= new Text();
        Label name = new Label("name");
        Label age = new Label("age");
        Button submit = new Button("submit");
        Button view = new Button("view");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try{
                    t.setText("Resgistration Done!!!");
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/practice","root","root");
                    PreparedStatement stmt = conn.prepareStatement("insert into details values(?,?)");
                    stmt.setString(1, tf1.getText());
                    stmt.setString(2, tf2.getText());
                    stmt.executeUpdate();
                    stmt.close();
                    conn.close();
                    FileOutputStream f = new FileOutputStream("D:\\new.txt");
                    byte[] b = tf1.getText().getBytes();
                    byte[] c = tf2.getText().getBytes();
                    f.write(b);
                    f.write(c);
                    f.close();
                    tf1.setText("");
                    tf2.setText("");
                    
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });
        view.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/practice","root","root");
                    Statement stmt  = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from details");
                    while(rs.next()){
                        System.out.println(rs.getString("name") + " " + rs.getString("age"));
                    }
                    conn.close();
                    stmt.close();
                    FileInputStream fi = new FileInputStream("D:\\new.txt");
                    int i=0;
                    while((i=fi.read())!=-1){
                        System.out.print((char)i);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });
        GridPane root  = new GridPane();
        root.setHgap(30);
        root.setVgap(30);
        root.addRow(1,name,tf1);
        root.addRow(2,age,tf2);
        root.addRow(3,submit,view);
        Scene scene = new Scene(root, 500, 350);
        
        primaryStage.setTitle("Hello World!");
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
