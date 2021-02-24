package application;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.sun.glass.events.MouseEvent;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class ControllerClassName implements Initializable{
	int total;
	String Url;
	 @FXML
	    private ScrollPane ScrollInterface;
	public void Count() {
		
	try {

		Connection conn = travel.getConnexion();
		Statement myStmt;
		myStmt = conn.createStatement();
		ResultSet monResultat = myStmt.executeQuery("select count(*) as compte from voyage");
		while(monResultat.next()) {
		 total= monResultat.getInt("compte");
		System.out.println(monResultat.getInt("compte"));
		
	} 
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public String getUrl() throws SQLException {
	

			Connection conn = travel.getConnexion();
			Statement myStmt;
			myStmt = conn.createStatement();
			ResultSet monResultat = myStmt.executeQuery("select url from voyage");	
			 Url= monResultat.getString("url");
			System.out.println(monResultat.getString("url"));
			
		
	
		return monResultat.getString("url");
		
	}
	void makeeverything() throws FileNotFoundException {
		System.out.println("hello");
		Pane[][] cellAnchorPane = new Pane[5][5];	    
	    ImageView[][] btn = new ImageView[5][5];
	    GridPane gridPane = new GridPane();
	    gridPane.setHgap(25);
	    gridPane.setVgap(25);
	    gridPane.setStyle("-fx-background-color : #ffffff");
	    for(int i=0; i<4; i++){
		    for(int j=0; j<btn.length;j++){
		    	Label locatLabel = new Label("Marrakech");
		    	Label priceLabel = new Label("À partir de "+ "10000 MDH");
		    	priceLabel.setFont(new Font("Consolas", 15));
		    	locatLabel.setFont(new Font("Consolas", 18));
			    btn[i][j] = new ImageView();
			    cellAnchorPane[i][j] = new AnchorPane();
			    cellAnchorPane[i][j].setMinHeight(320);      
			    cellAnchorPane[i][j].setStyle("-fx-border-color: black;-fx-background-color : #ffffff;-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);");
			    InputStream stream = new FileInputStream("C:\\Users\\dell\\OneDrive\\Images\\cities project\\Marrakech.jpg");
			    Image image = new Image(stream,299, 200, false, true);
			    btn[i][j].setImage(image);
 			    cellAnchorPane[i][j].getChildren().add(btn[i][j]);
			    cellAnchorPane[i][j].getChildren().add(priceLabel);
			    cellAnchorPane[i][j].getChildren().add(locatLabel);
			    AnchorPane.setLeftAnchor(btn[i][j],(double) 0);
			    AnchorPane.setTopAnchor(btn[i][j], (double) 0);
			    AnchorPane.setRightAnchor(btn[i][j], (double) 0);
			    
			    AnchorPane.setLeftAnchor(priceLabel,(double) 20);
			    AnchorPane.setBottomAnchor(priceLabel, (double) 24);
			    AnchorPane.setLeftAnchor(locatLabel,(double) 20);
			    AnchorPane.setBottomAnchor(locatLabel, (double) 70);
			    gridPane.add(cellAnchorPane[i][j], i, j);
		    }
	    }
		AnchorPane gridAnchorPane = new AnchorPane();
		gridAnchorPane.getChildren().add(gridPane);
		ScrollInterface.setContent(gridAnchorPane);
	}
	    @FXML
	    void wendy(MouseEvent event) throws SQLException, FileNotFoundException {
	    	System.out.println(" im here");
	    	System.out.println(total);
	    	ImageView [][]bouton =new ImageView[3][3];
	    	GridPane gridpane = new GridPane();
	    	gridpane.setHgap(25);
	    	gridpane.setVgap(25);
	    	int i=0;
			while(i <total) {
				int col=i%3;
				int ligne =i/3;
				bouton[col][ligne]=new ImageView();
				InputStream stream = new FileInputStream("C:\\Users\\dell\\OneDrive\\Images\\cities project\\Marrakech.jpg");
				Image image= new Image(stream , 420 , 300 , false ,true);
				bouton[col][ligne].setImage(image);
				gridpane.add(bouton[col][ligne], col, ligne);
				i++;
	    	}
			AnchorPane gridAnchorPane = new AnchorPane();
			gridAnchorPane.getChildren().add(gridpane);
			ScrollInterface.setContent(gridAnchorPane);
			
	    		
	    	}
	    	
	    
	    public static void main (String [] args) {
	    	ControllerClassName t = new ControllerClassName();
	    	t.Count();
	    	System.out.println(t.total); 
	    }
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			try {
				Count();
				wendy(null);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


