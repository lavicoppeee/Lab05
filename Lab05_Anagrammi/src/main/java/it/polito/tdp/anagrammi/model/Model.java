package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	private List<String> soluzione;
	private AnagrammaDAO aDAO;
	/**
	 * Genera tutti gli anagrammi della parola in ingresso
	 * @param parola
	 * @return tutti gli anagrammi della parola data
	 * 
	 */
	public List<String> anagrammi(String parola){
		
		this.soluzione=new ArrayList<>();
		
		parola= parola.toLowerCase();
		
		List<Character> disponibili=new ArrayList<>();
		
		for(int i=0; i<parola.length();i++) {
			disponibili.add(parola.charAt(i));
		}
		
		//avvia la ricorsione
		cerca("",0,disponibili);
		
		//lista di anagrammi 
		return this.soluzione;
	}
	
	/**
	 * Procedura ricorsiva per calcolare l'anagramma
	 * 
	 * @param parziale --> parte che ho fino ad ora costruito
	 * @param level--> levello della ricorsione a cui sono arrivata che è sempre uguale a parziale.lenght()
	 * @param disponibili--->insieme delle lettere non ancora utilizzate 
	 */
	
	private void cerca(String parziale, int level, List<Character> disponibili) {
		if(disponibili.size()==0) {
			this.soluzione.add(parziale);
		}
		
		for(Character c: disponibili) {
			String tentativo= parziale+c;
			
			List<Character> rimanenti=new ArrayList<>(disponibili);
			rimanenti.remove(c);
			
			cerca(tentativo,level+1,rimanenti);
			
		}
		
	}
	
	public boolean anagrammaEsiste(String p) {
		aDAO=new AnagrammaDAO();
		return aDAO.anagrammaEsiste(p);
		
	}
	
}
