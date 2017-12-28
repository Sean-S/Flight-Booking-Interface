package application;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.*;
import javafx.util.Callback;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.*;
import java.awt.Checkbox;
import java.time.LocalDate;
import javafx.geometry.*;
import javafx.scene.image.*;




	public class Interface extends Application   	 
	{    
		
	public static void main(String[] args) 
	{
		Locale.setDefault(Locale.UK);
		launch(args);    
	}
	
	
	
	
	//Scenes
	Scene scene1;
	Scene scene2;
	Scene scene3;
	Scene scene4;
	
	//Button
	Button finish;
	
	//Label
	Label labelTo;
	Label labelFrom;
	Label travelling;
	Label heading;
	Label departure;
	Label returnBack;
	Label adultLabel;
	Label childLabel;
	Label infantLabel;
	Label personsTravelling;
	
	
	//Layout Panes
	BorderPane pane;
	VBox vbox;
	HBox hbox1;
	HBox hbox2;
	HBox hbox3;
	HBox hbox4;
	 
		
	//ComboBoxes
	private ComboBox<Airport> travelingFrom;
	private ComboBox<Airport> travelingTo;
	private ComboBox<String> adults;
	private ComboBox<String> children;
	private ComboBox<String> infants;
	
	//Radio Buttons
	RadioButton eachWay;
	RadioButton oneWay;
	
	//ToggleGroup
	ToggleGroup radioButtons;
    
    DatePicker checkInDatePicker;
    DatePicker checkOutDatePicker;

    //Image
    Image img;
    ImageView iview1;

    
    //Multi-dimensional Array
    String[][] arrayFlightTimes;

    
    
    
    //Scene2
    //Labels
    Label heading2;
    
    //Table
  	TableView<Flight> table;
  	TableView<Flight2> table2;
  	TableView<FlightDetails> table3;
  	
  	//String
  	String outboundFlightString;
  	String inboundFlightString;
  	
    //Button
  	Button continueScene2;
    Button back;
    
    //Layout Panes
    BorderPane pane2;
    VBox vbox2;
    HBox hbox5;
    HBox hbox6;
    HBox hbox7;
    HBox hbox8;
    
    
    
    
    //Scene3
    //Labels
    Label heading3;
    
    //Arrays
    TextField[] firstName;
    TextField[] secondName;
    DatePicker[] datePicker;
    TextField[] bag;
    TextField[] dni;
    CheckBox[] spanishResident;
    CheckBox[] bagCheckbox;
    
    
    //ArrayList
    ArrayList<Passenger> adultsList;
    ArrayList<Passenger> childrenList;
    ArrayList<Passenger> infantsList;
    
  	
  	//Button 
  	Button backToScene2;
  	Button continueScene4;
  	
    //Layout Panes
    BorderPane pane3;
    VBox vbox3;
    HBox hbox10;
    HBox hbox11;
    HBox hbox12;
    GridPane grid;
    
    
    
    
    //Scene4
    //Labels
    Label heading4;
    Label totalCost;
    Label creditCardLabel;
    
    //TextField
    TextField creditCardField;
    
    //Buttons 
  	Button backToScene3;
  	Button continueScene5;
  	Button pay;
    
    //Layout Panes
    BorderPane pane4;
    VBox vbox4;
    HBox hbox15;
    HBox hbox16;
    HBox hbox17;
    HBox hbox18;
  	
    		
    @Override 
    public void start(Stage primaryStage)    
    {   
    	//Schedules schedules = new Schedules();
    	
    	//Create ComboBoxes
    	travelingFrom = new ComboBox <Airport>(); 
    	//Create Airports
    	Airports airports = new Airports();    
    	travelingFrom.setPromptText("From:");
    	travelingFrom.getItems().addAll(airports.getAirports());
    	//travelingFrom.setValue(airport1);
    	
    	travelingTo = new ComboBox <Airport>();    	
    	travelingTo.setPromptText("To");
    	travelingTo.getItems().addAll(airports.getAirports());
    	//travelingTo.setValue(airport2);
    	
    	
    	adults = new ComboBox <String>();    	
    	adults.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8");
    	adults.setValue("1");
    	//adults.setOnAction(e -> createGridPane());
    	
    	children = new ComboBox <String>();
    	children.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8");
    	children.setValue("0");
    	
    	infants = new ComboBox <String>();
    	infants.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8");
    	infants.setValue("0");
    	
    	//Create Radio Buttons
    	eachWay = new RadioButton("Return");
    	eachWay.setSelected(true);
    	oneWay = new RadioButton("One Way");
    	
    	
    	//Create ToggleGroup
    	radioButtons = new ToggleGroup();
    	eachWay.setToggleGroup(radioButtons);
    	oneWay.setToggleGroup(radioButtons);
    	
    	//Create Labels
    	heading = new Label();
 		heading.setText("Book Flights");
 		heading.getStyleClass().add("label-header");
 		//heading.setStyle("-fx-font: 35 arial;");
 		travelling = new Label();
 		travelling.setText("Travelling:");
 		labelTo = new Label();
 		labelTo.setText("To:");
 		labelFrom = new Label();
 		labelFrom.setText("From:");
 		departure = new Label();
 		departure.setText("Departure");
 		returnBack = new Label();
 		returnBack.setText("Return");
 		adultLabel = new Label();
 		adultLabel.setText("Adults (6+)");
 		childLabel = new Label();
 		childLabel.setText("Children (2-5 years)");
 		infantLabel = new Label();
 		infantLabel.setText("Infants (<2 years)");
 		personsTravelling = new Label();
 		personsTravelling.setText("Persons Travelling:");
 		
 		
 		
 		//DatePicker
 		checkInDatePicker = new DatePicker();
        checkOutDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());
        final ObservableList<DisabledRange> rangesToDisable = 
        	    FXCollections.observableArrayList(
        	        new DisabledRange(LocalDate.of(2017,3,1), LocalDate.of(2017,4,30)));
        final ObservableList<DisabledRange> rangesToDisable2 = 
        	    FXCollections.observableArrayList(
        	        new DisabledRange(LocalDate.of(2017,4,1), LocalDate.of(2017,4,30)));
        final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                            
                            if (item.isAfter(
                            		LocalDate.now().plusMonths(6))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }
                           
                            if (item.isBefore(
                                    LocalDate.now().plusDays(0))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                             }
                            
                            if(travelingFrom.getValue().getAirportName().equals("St.Brieuc")
                            		&& travelingTo.getValue().getAirportName().equals("Stansted"))
                            {
	                            boolean disable = rangesToDisable.stream()
	                                    .filter(r->r.initialDate.minusDays(1).isBefore(item))
	                                    .filter(r->r.endDate.plusDays(1).isAfter(item))
	                                    .findAny()
	                                    .isPresent();
	
	                            if (item.isBefore(checkInDatePicker.getValue().plusDays(1)) || 
	                                    disable) 
	                            {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: #ffc0cb;");
	                            }  
                            }
                            
                            if(travelingFrom.getValue().getAirportName().equals("Stansted")
                            		&& travelingTo.getValue().getAirportName().equals("St.Brieuc"))
                            {
	                            boolean disable = rangesToDisable.stream()
	                                    .filter(r->r.initialDate.minusDays(1).isBefore(item))
	                                    .filter(r->r.endDate.plusDays(1).isAfter(item))
	                                    .findAny()
	                                    .isPresent();
	
	                            if (item.isBefore(checkInDatePicker.getValue().plusDays(1)) || 
	                                    disable) 
	                            {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: #ffc0cb;");
	                            }  
                            }
                            
                            if(travelingFrom.getValue().getAirportName().equals("Paris")
                            		&& travelingTo.getValue().getAirportName().equals("Stansted"))
                            {
	                            boolean disable = rangesToDisable2.stream()
	                                    .filter(r->r.initialDate.minusDays(1).isBefore(item))
	                                    .filter(r->r.endDate.plusDays(1).isAfter(item))
	                                    .findAny()
	                                    .isPresent();
	
	                            if (item.isBefore(checkInDatePicker.getValue().plusDays(1)) || 
	                                    disable) 
	                            {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: #ffc0cb;");
	                            }  
                            }
                            
                            if(travelingFrom.getValue().getAirportName().equals("Stansted")
                            		&& travelingTo.getValue().getAirportName().equals("Paris"))
                            {
	                            boolean disable = rangesToDisable2.stream()
	                                    .filter(r->r.initialDate.minusDays(1).isBefore(item))
	                                    .filter(r->r.endDate.plusDays(1).isAfter(item))
	                                    .findAny()
	                                    .isPresent();
	
	                            if (item.isBefore(checkInDatePicker.getValue().plusDays(1)) || 
	                                    disable) 
	                            {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: #ffc0cb;");
	                            }  
                            }
                              
                            }                                                                                   
                    
                };
            }
        };
        
        final Callback<DatePicker, DateCell> dayCellFactory2 = 
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item.isAfter(
                                        checkInDatePicker.getValue().plusMonths(6))
                                    ) {
                                        setDisable(true);
                                        setStyle("-fx-background-color: #ffc0cb;");
                                }
                               
                                if (item.isBefore(
                                        checkInDatePicker.getValue().plusDays(1))
                                    ) {
                                        setDisable(true);
                                        setStyle("-fx-background-color: #ffc0cb;");
                                }
                                
                                if(travelingFrom.getValue().getAirportName().equals("St.Brieuc")
                                		&& travelingTo.getValue().getAirportName().equals("Stansted"))
                                {
    	                            boolean disable = rangesToDisable.stream()
    	                                    .filter(r->r.initialDate.minusDays(1).isBefore(item))
    	                                    .filter(r->r.endDate.plusDays(1).isAfter(item))
    	                                    .findAny()
    	                                    .isPresent();
    	
    	                            if (item.isBefore(checkInDatePicker.getValue().plusDays(1)) || 
    	                                    disable) 
    	                            {
    	                                    setDisable(true);
    	                                    setStyle("-fx-background-color: #ffc0cb;");
    	                            }  
                                }
                                
                                if(travelingFrom.getValue().getAirportName().equals("Stansted")
                                		&& travelingTo.getValue().getAirportName().equals("St.Brieuc"))
                                {
    	                            boolean disable = rangesToDisable.stream()
    	                                    .filter(r->r.initialDate.minusDays(1).isBefore(item))
    	                                    .filter(r->r.endDate.plusDays(1).isAfter(item))
    	                                    .findAny()
    	                                    .isPresent();
    	
    	                            if (item.isBefore(checkInDatePicker.getValue().plusDays(1)) || 
    	                                    disable) 
    	                            {
    	                                    setDisable(true);
    	                                    setStyle("-fx-background-color: #ffc0cb;");
    	                            }  
                                }
                                
                                if(travelingFrom.getValue().getAirportName().equals("Paris")
                                		&& travelingTo.getValue().getAirportName().equals("Stansted"))
                                {
    	                            boolean disable = rangesToDisable2.stream()
    	                                    .filter(r->r.initialDate.minusDays(1).isBefore(item))
    	                                    .filter(r->r.endDate.plusDays(1).isAfter(item))
    	                                    .findAny()
    	                                    .isPresent();
    	
    	                            if (item.isBefore(checkInDatePicker.getValue().plusDays(1)) || 
    	                                    disable) 
    	                            {
    	                                    setDisable(true);
    	                                    setStyle("-fx-background-color: #ffc0cb;");
    	                            }  
                                }
                                
                                if(travelingFrom.getValue().getAirportName().equals("Stansted")
                                		&& travelingTo.getValue().getAirportName().equals("Paris"))
                                {
    	                            boolean disable = rangesToDisable2.stream()
    	                                    .filter(r->r.initialDate.minusDays(1).isBefore(item))
    	                                    .filter(r->r.endDate.plusDays(1).isAfter(item))
    	                                    .findAny()
    	                                    .isPresent();
    	
    	                            if (item.isBefore(checkInDatePicker.getValue().plusDays(1)) || 
    	                                    disable) 
    	                            {
    	                                    setDisable(true);
    	                                    setStyle("-fx-background-color: #ffc0cb;");
    	                            }  
                                }
                                
                        }
                    };
                }
            };
            
        checkInDatePicker.setDayCellFactory(dayCellFactory);
        checkOutDatePicker.setDayCellFactory(dayCellFactory2);
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1)); 

        
 		
 		//Create Image
 		img = new Image("file:C:\\AUI Code\\Airline.jpg");
 		iview1 = new ImageView(img);
 		
 	    // Create button     
    	finish = new Button();
    	finish.setText("Continue");
    	finish.setOnAction(e ->{
    	if(numberOfPassengers())
    		{
    	vbox3.getChildren().addAll(createGridPane());
    	table.setItems(loadData());
    	table2.setItems(loadData2());
        primaryStage.setScene(scene2);}
        });
    	
    	
    	//Create Multi-dimensional Array
    	arrayFlightTimes = new String[7][7];
    	
    	   
    	// Create layout panes
 		pane = new BorderPane();
 		vbox = new VBox();
 		
 		pane.setTop(heading);
 		pane.setCenter(vbox);
 		pane.setBottom(finish);
 		//pane.setLeft(iview1);
 		pane.setMargin(finish, new Insets(20,20,100,650));
 		pane.setMargin(heading, new Insets(20,20,100,600));
 		//pane.autoResize
 		
 		
 		hbox1 = new HBox(); 
 		hbox1.setSpacing(25);
 		hbox1.setPadding(new Insets(20,20,20,525));
 		hbox1.getChildren().addAll(travelling, travelingFrom, travelingTo);
 		
 		
 		hbox2 = new HBox(); 
 		hbox2.setSpacing(50);
 		hbox2.setPadding(new Insets(20,20,20,600));
 		hbox2.getChildren().addAll(eachWay, oneWay);
 		
 		hbox3 = new HBox(); 
 		hbox3.setSpacing(25);
 		hbox3.setPadding(new Insets(20,20,20,400));
 		hbox3.getChildren().addAll(departure, checkInDatePicker, returnBack, checkOutDatePicker);
 		
 		hbox4 = new HBox(); 
 		hbox4.setSpacing(25);
 		hbox4.setPadding(new Insets(20,20,20,400));
 		hbox4.getChildren().addAll(personsTravelling, adultLabel, adults,
 				childLabel, children, infantLabel, infants);
 		
 		vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);
 		
 		 
 		// Add the layout pane to a scene
 		scene1 = new Scene(pane, 1350, 670);
 		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 		
 		
 		
 		
 		
 		
 		
 		//Scene2
 		//Create heading
 		heading2 = new Label();
 		heading2.setText("Flight Details");
 		heading2.getStyleClass().add("label-header");
 		//heading2.setStyle("-fx-font: 35 arial;");
 		
 		// Create buttons
 		continueScene2 = new Button();
 		continueScene2.setText("Continue");
 		continueScene2.setOnAction(e -> primaryStage.setScene(scene3));
 		
    	back = new Button();
    	back.setText("Back");
    	back.setOnAction(e -> {
    	vbox3.getChildren().clear(); //Clear Arrays
    	clearArrays();
    	primaryStage.setScene(scene1);
    	});
    	
    	//Create Table
    	table = new TableView<Flight>(); 	//Load data from continue button from scene1

    	TableColumn<Flight, String> colOutBoundFlight = new TableColumn("OutBound Flight");
    	colOutBoundFlight.setMinWidth(50);      
    	colOutBoundFlight.setCellValueFactory
    	(new PropertyValueFactory<Flight, String>("outBoundFlight"));
    	
    	TableColumn<Flight, LocalDate> colOutBoundDate = new TableColumn("OutBound Date");
    	colOutBoundDate.setMinWidth(50);      
    	colOutBoundDate.setCellValueFactory
    	(new PropertyValueFactory<Flight, LocalDate>("outBoundDate"));
    	
    	TableColumn<Flight, String> colDepartureTime = new TableColumn("Departure Time");
    	colDepartureTime.setMinWidth(50);      
    	colDepartureTime.setCellValueFactory
    	(new PropertyValueFactory<Flight, String>("departureTime"));
    	
    	TableColumn<Flight, String> colArrivalTime = new TableColumn("Arrival Time");
    	colArrivalTime.setMinWidth(50);      
    	colArrivalTime.setCellValueFactory
    	(new PropertyValueFactory<Flight, String>("arrivalTime"));
    	
    	TableColumn<Flight, String> colPrice = new TableColumn("Price");
    	colPrice.setMinWidth(50);      
    	colPrice.setCellValueFactory
    	(new PropertyValueFactory<Flight, String>("price"));
    	 
    	table.getColumns().addAll(colOutBoundFlight, colOutBoundDate,
    			colDepartureTime, colArrivalTime, colPrice);
    	
    	table.setMinWidth(450);
    	table.setMaxHeight(200);
    	
    	
    	//Create Table2
    	table2 = new TableView<Flight2>();
    	
    	TableColumn<Flight2, String> colInBoundFlight2 = new TableColumn("InBound Flight");
    	colInBoundFlight2.setMinWidth(50);      
    	colInBoundFlight2.setCellValueFactory
    	(new PropertyValueFactory<Flight2, String>("inBoundFlight2"));
    	
    	TableColumn<Flight2, LocalDate> colInBoundDate2 = new TableColumn("InBound Date");
    	colInBoundDate2.setMinWidth(50);      
    	colInBoundDate2.setCellValueFactory
    	(new PropertyValueFactory<Flight2, LocalDate>("inBoundDate2"));
    	
    	TableColumn<Flight2, String> colDepartureTime2 = new TableColumn("Departure Time");
    	colDepartureTime2.setMinWidth(50);      
    	colDepartureTime2.setCellValueFactory
    	(new PropertyValueFactory<Flight2, String>("departureTime2"));
    	
    	TableColumn<Flight2, String> colArrivalTime2 = new TableColumn("Arrival Time");
    	colArrivalTime2.setMinWidth(50);      
    	colArrivalTime2.setCellValueFactory
    	(new PropertyValueFactory<Flight2, String>("arrivalTime2"));
    	
    	TableColumn<Flight2, String> colPrice2 = new TableColumn("Price");
    	colPrice2.setMinWidth(50);      
    	colPrice2.setCellValueFactory
    	(new PropertyValueFactory<Flight2, String>("price2"));
    	table2.getColumns().addAll(colInBoundFlight2, colInBoundDate2,
    			colDepartureTime2, colArrivalTime2, colPrice2);
    	
    	table2.setMinWidth(450);
    	table2.setMaxHeight(200);
    	
    	
    	
    	
        // Create layout panes
      	pane2 = new BorderPane();
      	vbox2 = new VBox();
      	hbox5 = new HBox();
      		
      	pane2.setTop(heading2);
      	pane2.setCenter(vbox2);
      	pane2.setBottom(hbox5);
      	//pane.setLeft(iview1);
      	pane2.setMargin(back, new Insets(20,20,100,600));
      	pane2.setMargin(heading2, new Insets(20,20,100,600));
      	//pane.autoResize
      		
      	 
      	hbox5.setSpacing(25);
      	hbox5.setPadding(new Insets(20,20,100,650));
      	hbox5.getChildren().addAll(back, continueScene2);
      	
      	hbox7 = new HBox(); 
      	hbox7.setSpacing(25);
      	hbox7.setPadding(new Insets(20,20,20,475));
      	hbox7.getChildren().addAll(table);
      	
      	hbox8 = new HBox(); 
      	hbox8.setSpacing(25);
      	hbox8.setPadding(new Insets(20,20,20,475));
      	hbox8.getChildren().addAll(table2);

      	vbox2.getChildren().addAll(hbox7, hbox8);
      	
 		//Create Scene
        scene2 = new Scene(pane2, 1350, 670);
        scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        
        
        
        
        //Scene3
 		//Create heading
 		heading3 = new Label();
 		heading3.setText("Passengers");
 		heading3.getStyleClass().add("label-header");
 		//heading3.setStyle("-fx-font: 35 arial;");

 		
 		
 		// Create buttons     
    	backToScene2 = new Button();
    	backToScene2.setText("Back");
    	backToScene2.setOnAction(e -> primaryStage.setScene(scene2));
    	//backToScene2.setOnAction(e -> alertMessage());
    	//primaryStage.setScene(scene2)
    	
    	// Create buttons
    	continueScene4 = new Button();
    	continueScene4.setText("Continue");
    	continueScene4.setOnAction(e -> {
    	//validateDNI();
    	if(validateDNI() == true)
    	{
	    	if(updateArrays() == true)
	    	{
	    	//vbox3.getChildren().addAll(createGridPane());
	    	
	    	table3.setItems(loadData3());
	    	totalCost.setText("Total Cost:" + " €" + calculateTotalCost());
	    	primaryStage.setScene(scene4);
	    	}
	    }
    	});
    	
    	// Create layout panes
      	pane3 = new BorderPane();
      	vbox3 = new VBox();
      	hbox12 = new HBox();
      		
      	pane3.setTop(heading3);
      	pane3.setCenter(vbox3);
      	pane3.setBottom(hbox12);
      	pane3.setMargin(backToScene2, new Insets(20,20,100,600));
      	pane3.setMargin(heading3, new Insets(20,20,100,600));
 
      	hbox12.setSpacing(25);
      	hbox12.setPadding(new Insets(20,20,100,650));
      	hbox12.getChildren().addAll(backToScene2, continueScene4);

      	
 		//Create Scene
        scene3 = new Scene(pane3, 1350, 670);
        scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
 		
        
        
        //Scene4
        //Create heading
 		heading4 = new Label();
 		heading4.setText("Payment");
 		heading4.getStyleClass().add("label-header");
 		//heading4.setStyle("-fx-font: 35 arial;");
 		
 		totalCost = new Label();
 		totalCost.setStyle("-fx-font: 15 arial;");
 		
 		
 		creditCardLabel = new Label();
 		creditCardLabel.setText("Enter Credit Card Number:");
 		
 		//Create TextField
 		creditCardField = new TextField();		
        
        //Create Buttons
 		pay = new Button();
 		pay.setText("Pay");
 		pay.setOnAction(e -> validateCCNum());
 		
        backToScene3 = new Button();
        backToScene3.setText("Back");
        backToScene3.setOnAction(e -> primaryStage.setScene(scene3));
        
      	//continueScene5 = new Button();
      	//continueScene5.setText("Continue");
      	
        //Create Table
    	table3 = new TableView<FlightDetails>();     	
    	//table.setItems(loadData());

    	TableColumn<FlightDetails, String> colOutBoundFlightRoute = new TableColumn("OutBound Flight Route");
    	colOutBoundFlightRoute.setMinWidth(50);      
    	colOutBoundFlightRoute.setCellValueFactory
    	(new PropertyValueFactory<FlightDetails, String>("outBoundFlightRoute"));
    	
    	TableColumn<FlightDetails, String> colInBoundFlightRoute = new TableColumn("InBound Flight Route");
    	colInBoundFlightRoute.setMinWidth(50);      
    	colInBoundFlightRoute.setCellValueFactory
    	(new PropertyValueFactory<FlightDetails, String>("inBoundFlightRoute"));
    	
    	TableColumn<FlightDetails, LocalDate> colDateOut = new TableColumn("Date Out");
    	colDateOut.setMinWidth(50);      
    	colDateOut.setCellValueFactory
    	(new PropertyValueFactory<FlightDetails, LocalDate>("dateOut"));
    	
    	TableColumn<FlightDetails, LocalDate> colDateReturn = new TableColumn("Date Return");
    	colDateReturn.setMinWidth(50);      
    	colDateReturn.setCellValueFactory
    	(new PropertyValueFactory<FlightDetails, LocalDate>("dateReturn"));
    	
    	TableColumn<FlightDetails, String> colPassengerName = new TableColumn("Passenger Name");
    	colPassengerName.setMinWidth(50);      
    	colPassengerName.setCellValueFactory
    	(new PropertyValueFactory<FlightDetails, String>("passengerName"));
    	
    	TableColumn<FlightDetails, LocalDate> colPassengerDOB = new TableColumn("Passenger DOB");
    	colPassengerDOB.setMinWidth(50);      
    	colPassengerDOB.setCellValueFactory
    	(new PropertyValueFactory<FlightDetails, LocalDate>("passengerDOB"));
    	
    	TableColumn<FlightDetails, Integer> colBaggage = new TableColumn("Baggage");
    	colBaggage.setMinWidth(50);      
    	colBaggage.setCellValueFactory
    	(new PropertyValueFactory<FlightDetails, Integer>("baggage"));

    	 
    	table3.getColumns().addAll(colOutBoundFlightRoute, colInBoundFlightRoute,
    			colDateOut, colDateReturn, colPassengerName, colPassengerDOB,
    			colBaggage);
    	
    	table3.setMaxWidth(1000);
    	table3.setMinWidth(750);
    	table3.setMaxHeight(300);
    	table3.setMinHeight(150);
    	
        
        
        // Create layout panes
      	pane4 = new BorderPane();
      	vbox4 = new VBox();
      	hbox15 = new HBox();
      	hbox16 = new HBox();
      	hbox17 = new HBox();
      	hbox18 = new HBox();
      	
      	pane4.setTop(heading4);
      	pane4.setCenter(vbox4);
      	pane4.setBottom(hbox15);
      	//pane.setLeft(iview1);
      	pane4.setMargin(vbox4, new Insets(20,20,20,200));
      	pane4.setMargin(heading4, new Insets(20,20,100,600));
      	//pane4.setMargin(hbox15, new Insets(20,20,100,200));
      	//System.out.println(javafx.scene.text.Font.getFamilies());
      	
      	hbox15.setSpacing(25);
      	hbox15.setPadding(new Insets(20,20,100,650));
      	hbox15.getChildren().addAll(backToScene3);
      	
      	hbox16.setSpacing(25);
      	hbox16.setPadding(new Insets(20,20,20,200));
      	hbox16.getChildren().addAll(creditCardLabel, creditCardField, pay);
      	
      	hbox17.setSpacing(25);
      	hbox17.setPadding(new Insets(20,20,20,200));
      	hbox17.getChildren().addAll(totalCost);
      	
      	hbox18.setSpacing(25);
      	hbox18.setPadding(new Insets(20,20,20,200));
      	hbox18.getChildren().addAll(table3);
      	
      	
      	
      	
      	
      	vbox4.getChildren().addAll(hbox18, hbox17, hbox16);
      	
        //Create Scene
        scene4 = new Scene(pane4, 1350, 670);
        scene4.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
 				 
 		// Finalize and show the stage
 		primaryStage.setScene(scene1);
 		primaryStage.setTitle("JavaAir");
 		// Set the application icon.
 	    primaryStage.getIcons().add(new Image("file:resources/images/icon_takeoff.png"));
 		primaryStage.show();
    }
    
    public Boolean numberOfPassengers()
    {
    	Boolean valid = true;
    	double numberOfAdults;
    	double numberOfChildren;
    	double numberOfInfants;
    	double totalNumberOfPassengers;
    	
    	String adultsString;
	  	adultsString = adults.getValue();	//From Adults ComboBox
		int adultsInt = Integer.parseInt(adultsString);
		
		String childrenString;
	  	childrenString = children.getValue();	//From Children ComboBox
		int childrenInt = Integer.parseInt(childrenString);
		
		String infantsString;
	  	infantsString = infants.getValue();	//From Infants ComboBox
		int infantsInt = Integer.parseInt(infantsString);
    	
    	numberOfAdults = adultsInt;
    	numberOfChildren = childrenInt;
    	numberOfInfants = infantsInt;
    	
    	totalNumberOfPassengers = numberOfAdults + numberOfChildren + numberOfInfants;
    	
    	if(totalNumberOfPassengers > 8)
    	{
    		valid = false;
    	}
    	
    	if(numberOfAdults < (numberOfChildren + numberOfInfants) / 2)
    	{
    		System.out.println("Only allowed 2 children/infants per adult");
    		valid = false;
    	}
    	
    	if (valid == false)
   		{
	   		Alert alert = new Alert(AlertType.ERROR);
	   		alert.setTitle("Error Dialog");
	   		alert.setHeaderText("Maximum number of passengers allowed is 8");
	   		alert.setContentText("2 children/infants per adult");
	
	   		alert.showAndWait();
   		}
		return valid;
    }
    
    public void alertMessage()
    {
    	Alert alert = new Alert(AlertType.ERROR);
   		alert.setTitle("Error Dialog");
   		alert.setHeaderText("Sorry, cannot go back to previous page.");
   		alert.setContentText("To go back, please resart application");
   		

   		alert.showAndWait();
    }
    
    public boolean validateDNI()
    {
    	Boolean valid = new Boolean(true);
    	//Loop through list of adults
    	for(int i = 0; i < adultsList.size(); i++)
    	{  		
	    	//If checkbox is selected, validate
	    	if(spanishResident[i].isSelected())
		    	{   	
		    	String dniString = dni[i].getText();
		    	//var dnicopy = dni;
	    	
	
		    	//it must be 9 or 10 chars long
		    	if (!((dniString.length()==10) || (dniString.length()==9))) 
			    	{
			    	 valid = false;
			    	}
		
		
		    	// if 10 long then check for - and strip it out
		    	if (dniString.length()==10)
			    	{
			    		if (dniString.charAt(8) == '-')
			    		{
			    			dniString = dniString.substring(0,8) + dniString.substring(9,10);
			    		}
			    		else
			    		{
			    		valid = false;
			    		}
			    	}
		    	
		
		    	// extract numeric part
		    	int dninum = 0;
		
		    	try{
		    	dninum = Integer.parseInt(dniString.substring(0,8), 10);
		
		    	// extract letter
		    	String dniletter = dniString.substring(8,9);
		
		    	// make letter upper case
		    	dniletter = dniletter.toUpperCase();
		
		    	// get mod 23
		    	int dnimod = dninum % 23;
		
		    	// map mod to letter
		    	String madstring ="TRWAGMYFPDXBNJZSQVHLCKE";
		    	String dniletter2 = Character.toString(madstring.charAt(dnimod));
		
		    	// do the input letter and the calculated letter match?
		    	if (!(dniletter.equals(dniletter2)))  	//.equals()
			    	{
			    		valid=false;
			    	}
		    	} catch (StringIndexOutOfBoundsException e)
			    	{
			    	
			    	//if (valid == false || dni[i].getText().isEmpty())
				   		//{
				   		Alert alert = new Alert(AlertType.ERROR);
				   		alert.setTitle("Error Dialog");
				   		alert.setHeaderText("Error!");
				   		alert.setContentText("Invalid DNI Number");
				
				   		alert.showAndWait();
				   		//}
			    	}
		   		}
	    	} 	
		return valid;
    }
    
    public void validateCCNum()
    {
    	   //Credit card checksum
    	   Boolean valid = new Boolean (true);
    	   String input = creditCardField.getText();
    	   //Check if empty
    	   if(input.equals(""))
    	   {
    		   valid = false;
    	   }
    	   int sum = 0;
    	   //Assign length of number to numDigits
    	   int numDigits = input.length();
    	   int evenNum = numDigits % 2;
    	   //Loop through each number
    	   for(int i=0; i < numDigits; i++)
    	   {
    	     //Convert each character to a number
    		   int digit = Character.getNumericValue(input.charAt(i));
    		 //If the number is even, multiply by 2
    		 if (i % 2 == evenNum)
    			{	 
    			   digit = digit * 2;
    			}
    		 
    		 //If the number is greater than 9, subtract 9 from it. This is the same as adding the 2 digits together
    		 if (digit > 9)
    			{
    			   digit = digit - 9;
    			}
    	     sum = sum + digit;
    	   }

    	   //Check to see if sum is divisible by 10
    	   if (!((sum%10) == 0))
    	   {
    	       valid = false;
    	   }
    	   
    	   if (valid == false)
       		{
       		Alert alert = new Alert(AlertType.ERROR);
       		alert.setTitle("Error Dialog");
       		alert.setHeaderText("Error!");
       		alert.setContentText("Invalid Number");

       		alert.showAndWait();
       		}
    	   
    	   if (valid == true)
    	   {
    	   Alert alert = new Alert(AlertType.INFORMATION);
    	   alert.setTitle("Information Dialog");
    	   alert.setHeaderText("We've made it!");
    	   alert.setContentText("Booking Complete!");  	   

    	   alert.showAndWait();
    	   }
    	   
    	   
    	}

	
    
    
    	public GridPane createGridPane()
    	{
    			adultsList = new ArrayList<Passenger>();
    			childrenList = new ArrayList<Passenger>();
    			infantsList = new ArrayList<Passenger>();
			    //GridPane with 10px padding around edge
			    grid = new GridPane();
			    grid.setPadding(new Insets(10, 10, 10, 10));
			    grid.setVgap(8);
			    grid.setHgap(10);
			    
			    
			    //Adult textfields
			    //Convert String to Int
			    String adultsString;
			  	adultsString = adults.getValue();
				int adultsInt = Integer.parseInt(adultsString);
				
				
			
				//Create Arrays
			    firstName = new TextField[20];
			    secondName = new TextField[20];
			    bag = new TextField[20];
			    spanishResident = new CheckBox[20];
			    bagCheckbox = new CheckBox[20];
			    dni = new TextField[20];
			    datePicker = new DatePicker[20];
				for (int i = 0; i < adultsInt; i++) {
				   firstName[i] = new TextField();
				   firstName[i].setPromptText("Adult's First Name");
				   secondName[i] = new TextField();
				   secondName[i].setPromptText("Adult's Second Name");
				   datePicker[i] = new DatePicker();
				   datePicker[i].setPromptText("Date of Birth");
				   bag[i] = new TextField();
				   bag[i].setPromptText("Bag: Enter 1 or 0");
				   bagCheckbox[i] = new CheckBox();
				   bagCheckbox[i].setText("Bag(Only 1 bag per passenger(€15 each leg))");
				   spanishResident[i] = new CheckBox();
				   spanishResident[i].setText("Spanish Resident(€5 rebate, travel to/from Spain)");
				   dni[i] = new TextField();
				   dni[i].setPromptText("If Spanish Res, Enter DNI");
				   GridPane.setConstraints(firstName[i], 5, i); //Column = 5, row = i
				   GridPane.setConstraints(secondName[i], 6, i);
				   GridPane.setConstraints(datePicker[i], 7, i);
				   GridPane.setConstraints(bagCheckbox[i], 8, i);
				   GridPane.setConstraints(spanishResident[i], 9, i);
				   GridPane.setConstraints(dni[i], 10, i);
				   grid.getChildren().addAll(firstName[i], secondName[i],
						   datePicker[i], bagCheckbox[i], spanishResident[i], dni[i]);
				   adultsList.add(new Passenger(firstName[i].getText(), secondName[i].getText(),
						  datePicker[i], bagCheckbox[i].isSelected(),  dni[i].getText()));
				}
				
				final Callback<DatePicker, DateCell> dayCellFactory3 = 
			            new Callback<DatePicker, DateCell>() {
			                @Override
			                public DateCell call(final DatePicker datePicker) {
			                    return new DateCell() {
			                        @Override
			                        public void updateItem(LocalDate item, boolean empty) {
			                            super.updateItem(item, empty);
			                           
			                            if (item.isBefore(
			                                    checkInDatePicker.getValue().minusYears(6).plusDays(1))
			                                ) {
			                                    setDisable(true);
			                                    setStyle("-fx-background-color: #ffc0cb;");
			                            }   
			                            
			                            if (item.isAfter(
			                            		checkInDatePicker.getValue())
			                            		) {
			                            	setDisable(true);
		                                    setStyle("-fx-background-color: #ffc0cb;");
			                            }
			                    }
			                };
			            }
			        };
			        
				
				//Child Textfields
				//Convert String to Int
				String childrenString;
			  	childrenString = children.getValue();	//From Children ComboBox
				int childrenInt = Integer.parseInt(childrenString);
				for (int i = 0; i < childrenInt; i++) {
					   firstName[i+4] = new TextField();
					   firstName[i+4].setPromptText("Child's First Name");
					   secondName[i+4] = new TextField();
					   secondName[i+4].setPromptText("Child's Second Name");
					   datePicker[i+4] = new DatePicker();
					   datePicker[i+4].setPromptText("Date of Birth");
					   datePicker[i+4].setDayCellFactory(dayCellFactory3);
					   bag[i+4] = new TextField();
					   bag[i+4].setPromptText("Bag: Enter 1 or 0");
					   bagCheckbox[i+4] = new CheckBox();
					   bagCheckbox[i+4].setText("Bag(Only 1 bag per passenger(€15 each leg))");
					   //spanishResident[i+4] = new CheckBox();
					   //spanishResident[i+4].setText("Spanish Resident(€5 rebate, travel to/from Spain)");
					   //dni[i+4] = new TextField();
					   //dni[i+4].setPromptText("If Spanish Res, Enter DNI");
					   GridPane.setConstraints(firstName[i+4], 5, i+8);
					   GridPane.setConstraints(secondName[i+4], 6, i+8);
					   GridPane.setConstraints(datePicker[i+4], 7, i+8);
					   GridPane.setConstraints(bagCheckbox[i+4], 8, i+8);
					   //GridPane.setConstraints(spanishResident[i+4], 9, i+8);
					   //GridPane.setConstraints(dni[i+4], 10, i+8);
					   grid.getChildren().addAll(firstName[i+4], secondName[i+4],
							   datePicker[i+4], bagCheckbox[i+4]);
					   childrenList.add(new Passenger(firstName[i+4].getText(), secondName[i+4].getText(),
							   datePicker[i+4], bagCheckbox[i+4].isSelected(), null));
					}
				
				final Callback<DatePicker, DateCell> dayCellFactory4 = 
			            new Callback<DatePicker, DateCell>() {
			                @Override
			                public DateCell call(final DatePicker datePicker) {
			                    return new DateCell() {
			                        @Override
			                        public void updateItem(LocalDate item, boolean empty) {
			                            super.updateItem(item, empty);
			                           
			                            if (item.isBefore(
			                                    checkInDatePicker.getValue().minusYears(2).plusDays(1))
			                                ) {
			                                    setDisable(true);
			                                    setStyle("-fx-background-color: #ffc0cb;");
			                            }   
			                            
			                            if (item.isAfter(
			                            		checkInDatePicker.getValue())
			                            		) {
			                            	setDisable(true);
		                                    setStyle("-fx-background-color: #ffc0cb;");
			                            }
			                    }
			                };
			            }
			        };
				
				//Infant textfields
				String infantString;
				infantString = infants.getValue();	//From Infants ComboBox
				int infantInt = Integer.parseInt(infantString);
				for (int i = 0; i < infantInt; i++) {
					   firstName[i+8] = new TextField();
					   firstName[i+8].setPromptText("Infant's First Name");
					   secondName[i+8] = new TextField();
					   secondName[i+8].setPromptText("Infants's Second Name");
					   datePicker[i+8] = new DatePicker();
					   datePicker[i+8].setPromptText("Date of Birth");
					   datePicker[i+8].setDayCellFactory(dayCellFactory4);
					   //spanishResident[i+8] = new CheckBox();
					   //spanishResident[i+8].setText("Spanish Resident(€5 rebate, travel to/from Spain)");
					   //dni[i+8] = new TextField();
					   //dni[i+8].setPromptText("If Spanish Res, Enter DNI");
					   GridPane.setConstraints(firstName[i+8], 5, i+16);
					   GridPane.setConstraints(secondName[i+8], 6, i+16);
					   GridPane.setConstraints(datePicker[i+8], 7, i+16);
					   //GridPane.setConstraints(spanishResident[i+8], 8, i+16);
					   //GridPane.setConstraints(dni[i+8], 9, i+16);
					   grid.getChildren().addAll(firstName[i+8], secondName[i+8],
							   datePicker[i+8]);
					   infantsList.add(new Passenger(firstName[i+8].getText(), secondName[i+8].getText(),
							   datePicker[i+8], null, null));
					}
				
				return grid;
    	}
    	
    	
    	public void clearArrays()
    	{
    		for (int i = 0; i < adultsList.size(); i++) {
    			adultsList.remove(i);
        	}
    		
    		for (int i = 0; i < childrenList.size(); i++) {
        		childrenList.remove(i);
        	}
    		
    		for (int i = 0; i < infantsList.size(); i++) {
    			infantsList.remove(i);
        	}
    	}
    
    	
    public Boolean updateArrays()
    {
    	Boolean valid = true;
    	//Remove everything from ArrayList childrenList
    	childrenList.clear();
    	//for (int i = 0; i < childrenList.size(); i++) {
    	//	childrenList.remove(i);			//Remove null values
    	//}
    	
    	//Add textfield values to ArrayList childrenList
    	String childrenString;
	  	childrenString = children.getValue();	//From Children ComboBox
	  	int childrenInt = Integer.parseInt(childrenString);
    	for (int i = 0; i < childrenInt; i++) {
    		childrenList.add(new Passenger(firstName[i+4].getText(), secondName[i+4].getText(),
					   datePicker[i+4], bagCheckbox[i+4].isSelected(), null));
    		if(firstName[i+4].getText().equals("") || secondName[i+4].getText().equals("") || 
    				datePicker[i+4].getValue() == null)
    		{
    			valid = false;
    		}
    	}
    	
    	//Remove everything from ArrayList infantsList
    	infantsList.clear();
    	//for (int i = 0; i < infantsList.size(); i++) {
    	//	infantsList.remove(i);
    	//}
    	
    	//Add textfield values to ArrayList childrenList
    	String infantString;
    	infantString = infants.getValue();	//From Children ComboBox
	  	int infantInt = Integer.parseInt(infantString);
	  	try{
    	for (int i = 0; i < infantInt; i++) {
    		infantsList.add(new Passenger(firstName[i+8].getText(), secondName[i+8].getText(),
					   datePicker[i+8], false, null));
    	}
    	}catch(NullPointerException e){   	
    		System.out.println("NullPointerException " + "Infants");    	
    	}
	  	
	  	if (valid == false)
   		{
	   		Alert alert = new Alert(AlertType.ERROR);
	   		alert.setTitle("Error Dialog");
	   		alert.setHeaderText("Error!");
	   		alert.setContentText("Please enter passenger's names and date of birth.");
	
	   		alert.showAndWait();
   		}
		return valid;    	
    }
    
    public ObservableList<Flight> loadData()
    {     
    	ObservableList<Flight> data = FXCollections.observableArrayList();
    	if (travelingFrom.getSelectionModel().isEmpty() ||
    			travelingTo.getSelectionModel().isEmpty())
    	{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error Dialog");
    		alert.setHeaderText("Error!");
    		alert.setContentText("Please enter flights");

    		alert.showAndWait();
    	}
    	else{
    	outboundFlightString = travelingFrom.getValue().getAirportName() 
    			+ " - " + travelingTo.getValue().getAirportName();
    	
    	//Get Fare
    	String val;
    	val = travelingFrom.getValue().getFare(travelingTo.getValue().getAirportCode());
    	int fare = Integer.parseInt(val);
 
    	//Departure Time
    	String departureTime;
    	departureTime = travelingFrom.getValue().getDepartureTime(travelingTo.getValue().getAirportCode());
    	
    	//Arrival Time
    	String arriavlTime;
    	arriavlTime = travelingFrom.getValue().getArrivalTime(travelingTo.getValue().getAirportCode());
    	
    	//Check Date of flight
    	LocalDate outboundDate = checkInDatePicker.getValue();
	    data.add(new Flight(outboundFlightString, outboundDate,
	    		departureTime, arriavlTime, fare)); 
	    
	    return data;
    	}
    	return null;
	}
    
    public ObservableList<Flight2> loadData2()
    {     
    	if (eachWay.isSelected())
    	{
    		
    	ObservableList<Flight2> data = FXCollections.observableArrayList();
    	

    	inboundFlightString = travelingTo.getValue().getAirportName() 
    			+ " - " + travelingFrom.getValue().getAirportName();
    	String val;
    	val = travelingFrom.getValue().getFare(travelingTo.getValue().getAirportCode());
    	int fare = Integer.parseInt(val);
    	//readValues();
    	
    	//Departure Time
    	String departureTime;
    	departureTime = travelingTo.getValue().getDepartureTime(travelingFrom.getValue().getAirportCode());
    	
    	//Arrival Time
    	String arriavlTime;
    	arriavlTime = travelingTo.getValue().getArrivalTime(travelingFrom.getValue().getAirportCode());
    		
    	
    	//Check Date of flight
    	LocalDate inboundDate = checkOutDatePicker.getValue();
	    data.add(new Flight2(inboundFlightString, inboundDate,
	    		departureTime, arriavlTime, fare)); 
	    
	    return data;
    	}
    	
    	return null;
	}
    
    public ObservableList<FlightDetails> loadData3()
    {     
    	ObservableList<FlightDetails> data3 = FXCollections.observableArrayList();
    	
    	//Outbound Route
    	outboundFlightString = travelingFrom.getValue().getAirportName() 
    			+ " - " + travelingTo.getValue().getAirportName();
    	
    	//Inbound Route
    	inboundFlightString = travelingTo.getValue().getAirportName() 
    			+ " - " + travelingFrom.getValue().getAirportName();
    	String val;
    	val = travelingFrom.getValue().getFare(travelingTo.getValue().getAirportCode());
    	int fare = Integer.parseInt(val);
    	//readValues();
    	
    	//Date Out
    	LocalDate dateOut = checkInDatePicker.getValue();
    	
    	//Date Return
    	LocalDate dateReturn = checkOutDatePicker.getValue();
    	
    	
    	String name;
    	LocalDate localDateOfBirth;
    	String bagString;
    	int bagInt;
    	
    	for(int i = 0; i < adultsList.size(); i++)
    	{
    		name = firstName[i].getText() + " " + secondName[i].getText();
    		localDateOfBirth = datePicker[i].getValue();
    		//bagString = bag[i].getText();
    		int bagCounter = 0;
    		if(bagCheckbox[i].isSelected())
    		{
    			bagCounter = 1;
    		}
    		data3.add(new FlightDetails(outboundFlightString, inboundFlightString,
	    		dateOut, dateReturn, name, localDateOfBirth,
	    		bagCounter)); 
    	}
    	
    	for(int i = 0; i < childrenList.size(); i++)
    	{
    		name = childrenList.get(i).getFirstName() + " "+ childrenList.get(i).getSecondName();
    		localDateOfBirth = childrenList.get(i).getDatePicker().getValue();
    		//bagString = childrenList.get(i).getBag();
    		//bagInt = Integer.parseInt(bagString);
    		int bagCounter = 0;
    		//if(childrenList.get(i).getBag())
    		if(childrenList.get(i).getBag())
    		{
    			bagCounter = 1;
    		}
    		data3.add(new FlightDetails(outboundFlightString, inboundFlightString,
	    		dateOut, dateReturn, name, localDateOfBirth,
	    		bagCounter));    		
    	}
    	
    	for(int i = 0; i < infantsList.size(); i++)
    	{
    		name = infantsList.get(i).getFirstName() + " "+ infantsList.get(i).getSecondName();
    		localDateOfBirth = infantsList.get(i).getDatePicker().getValue();
    		//bagString = infantsList.get(i).getBag();
    		//bagInt = Integer.parseInt(bagString);
    		data3.add(new FlightDetails(outboundFlightString, inboundFlightString,
	    		dateOut, dateReturn, name, localDateOfBirth,
	    		0));    		
    	}
	    
	    return data3;
	}
    
    
    public int calculateTotalCost()
    {
    	//Initialize price
    	int adultPrice = 0;
    	int childrenPrice = 0;
    	int totalPrice = 0;
    	
    	//Get Fare
    	String val;
    	val = travelingFrom.getValue().getFare(travelingTo.getValue().getAirportCode());
    	int fare = Integer.parseInt(val);
    	
    	
    	//Check number of adults AND add fare
    	for(int i = 0; i < adultsList.size(); i++)
    	{
    		adultPrice = adultPrice + fare;
    	}
    	
    	//Check number of children AND add fare
    	for(int i = 0; i < childrenList.size(); i++)
    	{
    		childrenPrice = childrenPrice + 60;
    	}
    	
    	//Check Date of flight
    	LocalDate outboundDate = checkInDatePicker.getValue();
    	LocalDate inboundDate = checkOutDatePicker.getValue();
    	if (outboundDate.getDayOfWeek().getValue() == 5)	//Check if day of week is Friday
    	{
    		adultPrice = adultPrice / 100 * 120;	//Add 20%
    	}
    	else if(outboundDate.getDayOfWeek().getValue() == 6)	//Check if day of week is Saturday
    	{
    		adultPrice = adultPrice / 100 * 120;	//Add 20%
    	}
    	else if(outboundDate.getDayOfWeek().getValue() == 7)	//Check if day of week is Sunday
    	{
    		adultPrice = adultPrice / 100 * 120;	//Add 20%
    	}
    	
    	if(eachWay.isSelected()){
	    	if (inboundDate.getDayOfWeek().getValue() == 5)	//Check if day of week is Friday
	    	{
	    		adultPrice = adultPrice / 100 * 120;	//Add 20%
	    	}
	    	else if(inboundDate.getDayOfWeek().getValue() == 6)	//Check if day of week is Saturday
	    	{
	    		adultPrice = adultPrice / 100 * 120;	//Add 20%
	    	}
	    	else if(inboundDate.getDayOfWeek().getValue() == 7)	//Check if day of week is Sunday
	    	{
	    		adultPrice = adultPrice / 100 * 120;	//Add 20%
	    	}
    	}
    	
    	//Check if Spanish resident AND traveling from/to Spanish airport
    	for(int i = 0; i < adultsList.size(); i++)
    	{
    		if(spanishResident[i].isSelected() && 
    				((travelingFrom.getValue().getAirportName().equals("Madrid") ||
    		travelingFrom.getValue().getAirportName().equals("Malaga"))
    				|| (travelingTo.getValue().getAirportName().equals("Madrid") ||
    			    		travelingTo.getValue().getAirportName().equals("Malaga")))
    				)
    		{
    			adultPrice = adultPrice - 5;
    		}
    		else if(spanishResident[i].isSelected() && 
    				(travelingFrom.getValue().getAirportName().equals("Malaga") &&
    		travelingTo.getValue().getAirportName().equals("Madrid")))
    		{
    			adultPrice = adultPrice - 10;
    		}
    	}   	
    	
    	//Check if taking bag
    	for(int i = 0; i < adultsList.size(); i++)
    	{
    		if(bagCheckbox[i].isSelected())
    		{
    			adultPrice = adultPrice + 15;
    		}
    	}
    	
    	for(int i = 0; i < childrenList.size(); i++)
    	{
    		if(childrenList.get(i).getBag())
    		{
    			childrenPrice = childrenPrice + 15;
    		}
    	}
    	
    	totalPrice = adultPrice + childrenPrice;
    	   	
    	//Double price if it is a return flight
		if (eachWay.isSelected())
		{
			totalPrice = totalPrice * 2;
		}		
		return totalPrice;   	
    }
}