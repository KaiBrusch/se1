package a10.gastkomponente.verwalter;

import a10.gastkomponente.Email;
import a10.gastkomponente.Gast;
import a10.gastkomponente.IGastServices;

public class GastverwaltungAnwendungsfall implements IGastServices {

	private Gastverwalter gastverwalter = null;

	public GastverwaltungAnwendungsfall(Gastverwalter gastverwalter) {
		this.gastverwalter = gastverwalter;
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
