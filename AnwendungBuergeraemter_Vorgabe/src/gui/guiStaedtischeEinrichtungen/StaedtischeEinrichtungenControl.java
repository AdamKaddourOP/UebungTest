package gui.guiStaedtischeEinrichtungen;

import business.BuergeraemterModel;
import gui.guiBuergeraemter.BuergeraemterView;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StaedtischeEinrichtungenControl implements Observer {

	
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	private BuergeraemterModel buergeraemterModel;

	public StaedtischeEinrichtungenControl(Stage primaryStage){
		this.buergeraemterModel =buergeraemterModel.getInstanz();
		this.staedtischeEinrichtungenView= new StaedtischeEinrichtungenView(this, primaryStage,buergeraemterModel);
		//
		buergeraemterModel.addObserver(this);
		
	}

	@Override
	public void update() {
		staedtischeEinrichtungenView.zeigeBuergeraemterAn();
		
	}
}
