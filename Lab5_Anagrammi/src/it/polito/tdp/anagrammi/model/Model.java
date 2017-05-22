package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;

public class Model {
	
	AnagrammiDAO anagrammiDAO;
	
	private List<String> soluzioni_complete;
	private List<Anagramma> soluzioni_complete_anagramma;
	private Character[] lettere_input;
	private int dim_parola_input;	
	public int count=0;	
	
	public List<String> trova_anagrammi() {
		
		this.soluzioni_complete =  new ArrayList<String>();
		
		int livello = 0;
		String parziale = "";
		recursive(parziale, livello);
		
		return soluzioni_complete;	
	}

	public void add(String parola_input) {
		
		dim_parola_input = parola_input.length();
		this.lettere_input = new Character[dim_parola_input];
		
		for(int i=0; i<parola_input.length(); i++)
			lettere_input[i] = parola_input.charAt(i);		
	}
	
	public void recursive(String parziale, int livello) {
		
		count++;
		
		int lettera_ripetuta_parziale;
		int lettera_ripetuta_generale;
		
		if(parziale.length()==dim_parola_input) {
			if(!soluzioni_complete.contains(parziale))
			soluzioni_complete.add(parziale);
			return; 
		}
		
		for(Character c : lettere_input) {
			
			lettera_ripetuta_parziale=0;
			lettera_ripetuta_generale=0;
			
			for(int i=0; i<parziale.length(); i++) 
				if(parziale.charAt(i)==c)
					lettera_ripetuta_parziale++;
			
			for(int j=0; j<lettere_input.length; j++)
				if(c==lettere_input[j])
					lettera_ripetuta_generale++;
			
			if(lettera_ripetuta_parziale<lettera_ripetuta_generale) {
				parziale += c;
				recursive(parziale, livello+1);
				parziale = parziale.substring(0, parziale.length()-1); 
				}
			}
		}
	
	public void controllaAnagramma() {
		
		this.soluzioni_complete_anagramma = new ArrayList<Anagramma>();
		this.anagrammiDAO = new AnagrammiDAO();
		
		for(String anagramma : soluzioni_complete) {
			Anagramma a = new Anagramma(anagramma);
			soluzioni_complete_anagramma.add(a);
			if(anagrammiDAO.controllaAnagramma(a.getAnagramma()))
				a.setValida(true);
		}		
	}

	public List<Anagramma> getSoluzioni_complete_anagramma() {
		return soluzioni_complete_anagramma;
	}
}
