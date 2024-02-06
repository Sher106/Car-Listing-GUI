import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.effect.ImageInput;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.io.IOException;


public class Listing extends Application {

    //Declaring variables so they can be used throughout the method
    private static DealershipInventory Dealership;

    private Stage Stage;
    private Scene scene;
    private ComboBox<String> options;
    private ImageView carImageView;
    private Label Heading, Count, CarText, fast;
    Button Vroom;
    Car Beep;
    Image carImage, carImg;

    //Starting the method and organizing String that should be initialized
    public void start(Stage primaryStage) throws IOException {
        Dealership = new DealershipInventory();
        Dealership.list(2012, "Acura ", "Sport Utility", "2HNYB1H64CH500622", "68698", "$21,990", Boolean.parseBoolean("\f"), "2012 Acura.gif");
        Dealership.list(2017, "Hyundai Tuscan", "Sport Utility", "KM8J3CA46HU533369", "33837", "$19,590", Boolean.parseBoolean("\f"), "2017 Hyundai.gif");
        Dealership.list(2018, "BMW", "i3", "WBY7Z8C58JVB86743", "28025", "$31,990", Boolean.parseBoolean("\t"), "2018 BMW i3.gif");
        Dealership.list(2018, "Tesla", "Sedan", "5YJSA1E43JF246163", "9746", "$78,590", Boolean.parseBoolean("\t"), "2018 Tesla.gif");
        Dealership.list(2020, "Dodge Challenger", "GT Coupe", "2C3CDZJG8LH165235", "13458", "$29,590", Boolean.parseBoolean("\t"), "2020 Dodge Challenger.gif");


        //Creating Heading of Dealership page
        Heading = new Label("Welcome to the Saving Grace Dealership");
        Heading.setTextFill(Paint.valueOf("pink")); //Font color
        Heading.setAlignment(Pos.CENTER);  //Text positioning
        Heading.setTranslateX(0);
        Heading.setFont(new Font("BOLD+Helvetica", 20));  //Font style and size

        Count = new Label(Dealership.toString());   //String associated with number of cars

        String[] carNames = {"2012 Acura", "2017 Hyundai", "2018 BMW i3", "2018 Tesla", "2020 Dodge Challenger"};  //Names in Combobox

        //Creating ComboBox
        options = new ComboBox<>();   //Used to create area for options to be selected
        options.getItems().addAll(carNames);  //To display car names
        options.getItems().addAll();
        options.setPromptText("Is This Your New Whip?");
        options.setOnAction(this::handleOptionsSelection);   //Action handler

        CarText = new Label("What Are You Looking For?");  //Additioal heading
        CarText.setFont(new Font("Calibre", 14));
        CarText.setTextFill(Paint.valueOf("WHITE"));   //Color of text
        CarText.setAlignment(Pos.CENTER_LEFT);   //Position of text

        fast = new Label();                                  //Another label, but this one displays car details
        fast.setTextFill(Paint.valueOf("ORANGE"));          //Report color
        fast.setFont(new Font("BOLD+Calibre", 14));    //Font style and size
        fast.setTranslateX(10);

        //Creating Button
        Vroom = new Button("Lets See");      //Button to gives instructions based on what's put in
        Vroom.setAlignment(Pos.CENTER);        //Positioning button
        Vroom.setOnAction(this::processButtonPush);  //Action Handler

        //Image Display
        ImageView carImageView = new ImageView(carImage);
        carImageView.setViewport(new Rectangle2D(60, 60, 400, 500));
        carImageView.setTranslateY(40);
        carImageView.setTranslateX(40);
        carImageView.setFitWidth(100);
        carImageView.setPreserveRatio(true);

        //Creating HBox
        HBox layout = new HBox(Heading);         //Aligns text horizontally
        layout.setPadding(new Insets(20, 20, 20, 40));    //set spacing between things displayed
        layout.setSpacing(10);
        layout.setStyle("-fx-background-color: teal");      //HBox color

        //Creating VBox
        VBox layout2 = new VBox( layout, CarText, Count, options, Vroom, fast, carImageView);   //Aligns text and objects horizontally
        layout2.setSpacing(10);
        layout2.setAlignment(Pos.TOP_CENTER);
        layout2.setStyle("-fx-background-color: teal");      //VBox color
        layout2.setPrefSize(450, 700);


        scene = new Scene(layout2, 450, 700);     //Where each part is placed
        primaryStage.setTitle("Car Listing");        //Title
        primaryStage.setScene(scene);   //Where everything will be displayed
        primaryStage.show();
    }

    private void handleOptionsSelection(ActionEvent event) {         //Action handler for ComboBox and its instructions
        Beep = Dealership.Inventory[options.getSelectionModel().getSelectedIndex()];
    }

    private void processButtonPush(ActionEvent event) {             //Action handler for Button and its instructions
        fast.setText(Beep.toString());

        carImage = new Image(Beep.carImage);

    }
}


