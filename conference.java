/*Design a JFX form to collect the details of the conference event. Have various controls like regno/empid, name, age, college name, area of interest, subject expertise, dateofbirth....etc
Print the details collected as string in same window. 
*/

import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Conference_Details extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Form JavaFX Application");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> b = new ArrayList<String>();
        ArrayList<String> c = new ArrayList<String>();
        ArrayList<String> d = new ArrayList<String>();
        ArrayList<String> e = new ArrayList<String>();
        ArrayList<String> f = new ArrayList<String>();
        ArrayList<String> g = new ArrayList<String>();
        ArrayList<String> h = new ArrayList<String>();
        // Add Header
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(20);
        gridPane.add(nameField, 1,1);


        // Add Email Label
        Label emailLabel = new Label("Email ID : ");
        gridPane.add(emailLabel, 0, 2);

        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(20);
        gridPane.add(emailField, 1, 2);
        
        // Add Registration number Label
        Label regNo = new Label("Reg NO : ");
        gridPane.add(regNo, 0, 3);

        // Add Reg No Text Field
        TextField regno = new TextField();
        regno.setPrefHeight(20);
        gridPane.add(regno, 1, 3);
        
        // Add Age Label
        Label Age = new Label("Age : ");
        gridPane.add(Age, 0, 4);

        // Add Age Text Field
        TextField age = new TextField();
        age.setPrefHeight(20);
        gridPane.add(age, 1, 4);
        
        // Add College name Label
        Label collegeName = new Label("College Name : ");
        gridPane.add(collegeName, 0, 5);

        // Add College name Text Field
        TextField cname = new TextField();
        cname.setPrefHeight(20);
        gridPane.add(cname, 1, 5);
        
        // Add Area of interest Label
        Label areahob = new Label("Area of Interest : ");
        gridPane.add(areahob, 0, 6);

        // Add Area of interest Text Field
        TextField aHob = new TextField();
        aHob.setPrefHeight(20);
        gridPane.add(aHob, 1, 6);
        
        // Add Subject expertise Label
        Label subExp = new Label("Subject Expertise : ");
        gridPane.add(subExp, 0, 7);

        // Add subject expertise Text Field
        TextField subexp = new TextField();
        subexp.setPrefHeight(20);
        gridPane.add(subexp, 1, 7);
        
        // Add DOB Label
        Label Dob = new Label("Date of birth : ");
        gridPane.add(Dob, 0, 8);

        // Add DOB Text Field
        TextField dob = new TextField();
        dob.setPrefHeight(20);
        gridPane.add(dob, 1, 8);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(20);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 9, 2, 1);
        GridPane.setHalignment(submitButton, HPos.LEFT);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
        
        // Add View Button
        Button viewButton = new Button("View");
        viewButton.setPrefHeight(20);
        viewButton.setDefaultButton(true);
        viewButton.setPrefWidth(100);
        gridPane.add(viewButton, 0, 9, 2, 1);
        GridPane.setHalignment(viewButton, HPos.RIGHT);
        GridPane.setMargin(viewButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
                    return;
                }
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText() + " : " + regno.getText());
                a.add(nameField.getText());
                b.add(emailField.getText());
                c.add(regno.getText());
                d.add(age.getText());
                e.add(cname.getText());
                f.add(aHob.getText());
                g.add(subexp.getText());
                h.add(dob.getText());
                nameField.setText("");
                emailField.setText("");
                regno.setText("");
                age.setText("");
                cname.setText("");
                aHob.setText("");
                subexp.setText("");
                dob.setText("");
            }
        });
        viewButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                System.out.println("Name || Email || RegNO || Age || College Name || Area of Interest || Subject Expertise || DOB");
                for(int i=0;i<a.size();i++){
                    System.out.println(a.get(i) + " || " + b.get(i) + " || " + c.get(i) + " || " + d.get(i) + " || " + e.get(i) + " || " + f.get(i) + " || " + g.get(i) + " || " + h.get(i));
                }
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
