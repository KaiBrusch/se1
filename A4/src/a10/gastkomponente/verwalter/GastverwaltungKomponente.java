package a10.gastkomponente.verwalter;

import persistenz.IPersistenzService;
import a10.gastkomponente.Email;
import a10.gastkomponente.Gast;
import a10.gastkomponente.IGastServices;

public class GastverwaltungKomponente implements IGastServices {

	private Gastverwalter gastVerwalter = null;
	private GastverwaltungAnwendungsfall gastVerwaltungAnwendungsfall = null;
	
	public GastverwaltungKomponente(IPersistenzService persistenceManager)
    {
		gastVerwalter = new Gastverwalter(persistenceManager);
		gastVerwaltungAnwendungsfall = new GastverwaltungAnwendungsfall(gastVerwalter);
    }
	
	@Override
	public Gast erzeugeGast(Integer nr, String name, Email email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gast sucheGastNachName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGast(Gast gast) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGast(Gast gast) {
		// TODO Auto-generated method stub
		
	}

}
