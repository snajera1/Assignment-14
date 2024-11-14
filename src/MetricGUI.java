import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class MetricGUI extends Application {
    public static void main(String[] args) {
        launch(args); //Launches the JavaFX GUI
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        Button btn = new Button("Convert!"); //Creates the button the user will press to preform the conversion

        ToggleGroup group = new ToggleGroup(); //Creates a togglegroup to store all the radio buttons
        RadioButton rb1 = new RadioButton("Feet to Meters"); //Creates the radio buttons and adds them to the togglegroup
        rb1.setToggleGroup(group);
        RadioButton rb2 = new RadioButton("Inches to CM");
        rb2.setToggleGroup(group);
        RadioButton rb3 = new RadioButton("Miles to KM");
        rb3.setToggleGroup(group);
        RadioButton rb4 = new RadioButton("MM to Inches");
        rb4.setToggleGroup(group);

        Label label1 = new Label("Enter your value:"); //Creates the text labels and textfield for the user input
        TextField textField = new TextField ();
        Label label2 = new Label("Converted value:");
        Label result = new Label();

        btn.setOnAction(new EventHandler<ActionEvent>() { //Creates an anonymous innerclass EventHandler to handle user input
 
            @Override //Overrides the handle method from the handler interface
            public void handle(ActionEvent event) {
                if(group.getSelectedToggle() == null){ //Checks if the user has selected any radio buttons
                    result.setText("Please select a button");
                }else if(group.getSelectedToggle() == rb1){ //Checks which radio button has been selected and calls the method for the associated conversion and displayting the result
                    result.setText(MetricConverter.feetToMeter(Double.parseDouble(textField.getText())));
                }else if(group.getSelectedToggle() == rb2){
                    result.setText(MetricConverter.inchToCM(Double.parseDouble(textField.getText())));
                }else if(group.getSelectedToggle() == rb3){
                    result.setText(MetricConverter.milesToKM(Double.parseDouble(textField.getText())));
                }else if(group.getSelectedToggle() == rb4){
                    result.setText(MetricConverter.mmToInches(Double.parseDouble(textField.getText())));
                }
            }

        });
        
        

        VBox root = new VBox(10); //Establishes a VBox as the root node to hold all the other nodes
        
        root.getChildren().add(rb1); //Adds the rest of the nodes in the order they will appear
        root.getChildren().add(rb2);
        root.getChildren().add(rb3);
        root.getChildren().add(rb4);
        root.getChildren().addAll(label1, textField);
        root.getChildren().add(btn);
        root.getChildren().addAll(label2, result);
        primaryStage.setScene(new Scene(root, 200, 260)); //Creates the scene with the root node and shows it
        primaryStage.show();
    }
}
