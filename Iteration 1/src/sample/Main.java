package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import org.w3c.dom.Text;

public class Main extends Application {
    // We declare the "Text field/area" here in order to be able to use them in the clearFields method;
    TextField textCprNumber = new TextField();  // a TextField is a single lined field
    TextField textName = new TextField();       // Laver et nyt tekstfelt til patientnavnet
    TextArea resultField = new TextArea();      // a TextArea is a multiline text field - more advanced than TextField

    @Override
    public void start(Stage primaryStage) {     // a Stage is the main window for a JavaFX application
        primaryStage.setTitle("CoronaNet sundhedspersonale");   // set the title shown int th title bar
        GridPane grid = new GridPane();         // create a GridPane for a nice even flexible screen layout
        grid.setAlignment(Pos.CENTER);          // Align the grid to the center of the application window
        Label overskrift = new Label("Patientoplsag");  //Laver nyt label
        grid.add(overskrift, 1, 0);         // Skriver overskriften over felterne
        Label CPR = new Label("Søg på patientens CPR: ");      // create a text label displaying "CPR"
        grid.add(CPR, 0, 1);              // put the newly created label in the top left corner of the grid (0,0)
        grid.setHgap(10);                       // set the horizontal gap between the fields to 10 pixels
        grid.setVgap(10);                       // set the vertical gap between the fields to 10 pixels
        //grid.setGridLinesVisible(true);       // nice if you want to check the grid layout
        textCprNumber.setPromptText("CPR-nummer");   // display some useful text to the user
        textCprNumber.setFocusTraversable(false);   // needed to be able to display the initial PromptText
        textCprNumber.setMaxWidth(300);         // Make sure the CPR field doesn't get too wide
        textCprNumber.setTooltip(new Tooltip("CPR-nummer skal have formatet ######-####")); // mouseover tooltip

        Label Name = new Label("Søg på patientens navn: ");     // Nyt label der giver mulighed for at søge på patientnavn
        grid.add(Name, 0, 2);       //Placering af label
        textName.setPromptText("Patientens navn");
        textName.setFocusTraversable(false);
        textName.setMaxWidth(300);
        textName.setTooltip(new Tooltip("Patientnavn skal have formatet 'Efternavn, Fornavn': "));

        resultField.setPromptText("Søg efter patient via CPR-nummer eller patientens navn i et af ovenstående felter.");
        resultField.setPrefHeight(50);         // set the preferable height of the result field
        resultField.setPrefWidth(300);          // set the preferable width of the result field
        resultField.setEditable(false);         // make sure the user can't edit the result field
        resultField.setWrapText(true);          // ensure the text can be wrapped in the result field

        Button buttonSearch = new Button("Søg");          // create a clickable button
        Button buttonSearch2 = new Button ("Søg");        // create a clickable button
        Button buttonAnnuller = new Button("Annuller");    // create another clickable button

        buttonAnnuller.setOnMouseClicked(event -> {
            clearFields();  // call the method which clears all fields (see below)
        });

        // Now place the remaining fields in the grid

        grid.add(textCprNumber, 1, 1);  // second column, first row
        grid.add(buttonSearch, 2, 1);    // third column, first row
        grid.add(textName, 1, 2);
        grid.add(buttonSearch2, 2, 2);
        grid.add(resultField, 1, 3);    // first column, second row
        grid.add(buttonAnnuller, 2, 5); // third column, fifth row

        Scene scene = new Scene(grid, 600, 400); // create an scene window 600 x 400 pixels
        primaryStage.setScene(scene);                   // add the scene to the stage / application window
        primaryStage.show();                 // display the stage - important! otherwise nothing happens :-)
    }

    public void clearFields() { // method to clear text fields
        textCprNumber.clear();
        textName.clear();
        resultField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}