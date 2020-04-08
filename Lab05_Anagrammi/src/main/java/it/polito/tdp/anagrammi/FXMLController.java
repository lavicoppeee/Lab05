package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolo;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void CalcoloAnagrammi(ActionEvent event) {

    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	
    	txtAnagrammiCorretti.setDisable(false);
    	txtAnagrammiErrati.setDisable(false);
    
    	String parola=txtParola.getText().toLowerCase();
    	
    	if(parola.isEmpty()) {
    		
    		txtAnagrammiCorretti.setText("Devi inserire una parola!");
    		return;	
    	}
    	
    	if (!parola.matches("[a-zA-Z]*")) {
			txtAnagrammiCorretti.setText("Inserire solo caratteri alfabetici.");
			return;
		}
    	
    	List<String> anagrammi=this.model.anagrammi(parola);
    	
    	for(String a: anagrammi) {
    		if(!this.model.anagrammaEsiste(a)) {
    		txtAnagrammiErrati.appendText(a.toString()+"\n");
    		}else {
    		txtAnagrammiCorretti.appendText(a.toString()+"\n");
    		}
    	}
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtParola.clear();
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolo != null : "fx:id=\"btnCalcolo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model=model;
		
	}
}
