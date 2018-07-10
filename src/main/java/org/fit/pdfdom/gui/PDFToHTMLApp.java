package org.fit.pdfdom.gui;


import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
 
//@SuppressWarnings("restriction")
public class PDFToHTMLApp extends Application {
	File inputFile = null;
	File outputFile = null;

    private Button pdfOpenBtn = new Button("Choose PDF file");
	private Label pdfSelectedLabel = new Label(" No file chosen");
    private Button htmlOpenBtn = new Button("Choose output file location");
	private Label htmlSelectedLabel = new Label();
	
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PDF to HTML (Pdf2Dom)");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 0));

        //PDF input file chooser
 		pdfOpenBtn = new Button("Choose PDF file");
 		grid.add(pdfOpenBtn, 1, 0);
 		pdfOpenBtn.setOnAction(e -> {
 			
 			FileChooser fileChooser = new FileChooser();
 			fileChooser.setTitle("Select PDF file");
 			fileChooser.getExtensionFilters().addAll(
 				new ExtensionFilter("PDF Files", "*.pdf"));
 			File selectedFile = fileChooser.showOpenDialog(null);
 			
 			if(selectedFile != null) {
 				inputFile = selectedFile;
 				String fileAbsPath = inputFile.getAbsolutePath();
 				pdfSelectedLabel.setText(" Selected file: '" + fileAbsPath + "'");
 				htmlSelectedLabel.setText(" Default output: '" + fileAbsPath.substring(0, fileAbsPath.length() - 4) + ".html'");
 				htmlOpenBtn.setDisable(false);
 				primaryStage.sizeToScene();
 			}
 		});

 		grid.add(pdfSelectedLabel, 2, 0);
     	
     	//HTML output file chooser
 		htmlOpenBtn.setDisable(true);
 		grid.add(htmlOpenBtn, 1, 1);
 		htmlOpenBtn.setOnAction(e -> {
 			
 			FileChooser fileChooser = new FileChooser();
 			fileChooser.setTitle("Select HTML file");
 			fileChooser.getExtensionFilters().addAll(
 				new ExtensionFilter("HTML Files", "*.html"));
 			File selectedFile = fileChooser.showOpenDialog(null);
 			
 			if(selectedFile != null) {
 				outputFile = selectedFile;
 				htmlSelectedLabel.setText(" Selected file: '" + outputFile.getAbsolutePath() + "'");
 				primaryStage.sizeToScene();
 			}
 		});
 		
 		grid.add(htmlSelectedLabel, 2, 1);
 		
 		
        primaryStage.setScene(new Scene(grid));
        primaryStage.show();
    }
}
