package a10.gastkomponente;

import a10.util.*;

public interface IGastServices {

	Gast ErzeugeGast(Integer nr, String name, Email email);
	
	Gast SucheGastNachName(String name);
}
