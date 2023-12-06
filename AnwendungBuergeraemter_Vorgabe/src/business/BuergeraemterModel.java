package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import fabrikMethode.ConcreteCreator;
import fabrikMethode.ConcreteCreatorTxt;
import fabrikMethode.Creator;
import fabrikMethode.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class BuergeraemterModel implements Observable {
	
	private Buergeramt buergeramt;

	//hier
	public static BuergeraemterModel instanz=null;
	LinkedList<Observer> list=new LinkedList<Observer>();
	//
	public BuergeraemterModel() {
		
	}
	
	//
	public static BuergeraemterModel getInstanz() {
		
		if(instanz==null) {
			instanz=new BuergeraemterModel();
		}
		return instanz;
	}
	
	public Buergeramt getBuergeramt() {
		return this.buergeramt;
	}
	
	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
		notifyObservers();
	}
 		
	public void schreibeBuergeraemterInCsvDatei()
	    throws IOException{
		Creator creator =new ConcreteCreator();
		Product writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(buergeramt);
		writer.schliessDatei();

 	}
	public void schreibeBuergeraemterInTxtDatei()    throws IOException{
		
		Creator creator =new ConcreteCreatorTxt();
		Product writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(buergeramt);
		writer.schliessDatei();
	}

	@Override
	public void addObserver(Observer obs) {
		list.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		list.remove(obs);
		
	}

	@Override
	public void notifyObservers() {
		for(Observer o : list) {
			
			o.update();
		}
		
	}

	

}
