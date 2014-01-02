package a10;

import persistenz.IPersistenzService;
import a10.gastkomponente.*;
import a10.gastkomponente.verwalter.GastverwaltungKomponente;

public class Main {

	// - Zunächst werden Stammdaten angelegt (ErzeugeGast und
	// ErzeugeZusatzleistung). Zusatzleistungen sind bspw. „Sauna“,
	// „Vollpension“, „WLAN“.
	// - Eine neue Reservierung kann mittels ReserviereZimmer erzeugt werden. Es
	// wird ein Reservierungsobjekt mit eindeutiger Nr zurückgegeben.
	// - Auf vorhandenen Reservierungen können mittels BucheZusatzleistung
	// Zusatzleistungen gebucht werden.
	// - Falls ein Gast mehr als 5 Reservierungen getätigt, oder er mindestens
	// 3 Reservierungen mit Zusatzleistungen gebucht hat, wird er in der
	// GastKomponente als Stammgast markiert (der Aufruf erfolgt durch die
	// ReservierungsKomponente im Zuge der Ausführung der Operation
	// ReserviereZimmer bzw. BucheZusatzleistung)


	private static IGastServices gastService = null;

	private static IPersistenzService persistenceService = null;

	public static void main(String[] args) {
		gastService = new GastverwaltungKomponente();
		
		
		
		Integer nr = 1;
		String name = "matthias";
		Boolean stammkunde = true;
		Email email = Email.email(name, "gmail", "de");
		Gast g = new Gast(nr, name, email, stammkunde);
		System.out.println(g);
		// Gast g = ErzeugeGast(nr, name, email);
		// Gast SucheGastNachName(String name);
		// ReserviereZimmer();
		// BucheZusatzleistung();

	}
}
