package a10.gastkomponente;

import a10.gastkomponente.Gast;

public interface IGastServices {

	Gast erzeugeGast(Integer nr, String name, Email email);
	
	Gast sucheGastNachName(String name);
	
	void updateGast(Gast gast);
	
	void deleteGast(Gast gast);
}