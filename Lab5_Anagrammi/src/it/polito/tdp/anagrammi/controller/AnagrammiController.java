package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParolaInput;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	
    	boolean parolaValida = true;
    	
    	for(int i=0; i<txtParolaInput.getText().length(); i++) 
    		if(Character.isDigit(txtParolaInput.getText().charAt(i))==true) 
    			parolaValida = false;
    	
    	if(parolaValida==true) {
    		
    		model.add(txtParolaInput.getText());
    	    model.trova_anagrammi();
    	    model.controllaAnagramma();
    	    
    	    for(int j=0; j<model.getSoluzioni_complete_anagramma().size(); j++){
    	    	
    	    	if(model.getSoluzioni_complete_anagramma().get(j).isValida())
    	    		txtAnagrammiCorretti.appendText(model.getSoluzioni_complete_anagramma().get(j).getAnagramma() + "\n");
    	    	else
    	    		txtAnagrammiErrati.appendText(model.getSoluzioni_complete_anagramma().get(j).getAnagramma() + "\n");
    	    	}	
    		}		
    	}

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtParolaInput.clear();
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParolaInput != null : "fx:id=\"txtParolaInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
}
