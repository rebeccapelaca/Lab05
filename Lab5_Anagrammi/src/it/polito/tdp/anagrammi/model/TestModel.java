package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model m = new Model();
		
		m.add("gatto");
		
		List<String> soluzioni = m.trova_anagrammi();
		
		for(String s : soluzioni)
			System.out.println(s);
		
		System.out.println(m.count);
		/*
		m.controllaAnagramma();
		for(Anagramma a : m.getSoluzioni_complete_anagramma()) {
			if(a.isValida())
				System.out.println("Parola corretta: " + a.getAnagramma());
			else
				System.out.println("Parola sbagliata: " + a.getAnagramma());
				
		}
		*/
	}
}
