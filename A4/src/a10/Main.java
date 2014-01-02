package a10;

import persistenz.IPersistenzService;
import persistenz.SqlConnecter;
import a10.gastkomponente.*;
import a10.gastkomponente.verwalter.GastverwaltungKomponente;

public class Main {

	// - Zuna��chst werden Stammdaten angelegt (ErzeugeGast und
	// ErzeugeZusatzleistung). Zusatzleistungen sind bspw. ���Sauna���,
	// ���Vollpension���, ���WLAN���.
	// - Eine neue Reservierung kann mittels ReserviereZimmer erzeugt werden. Es
	// wird ein Reservierungsobjekt mit eindeutiger Nr zuru��ckgegeben.
	// - Auf vorhandenen Reservierungen ko��nnen mittels BucheZusatzleistung
	// Zusatzleistungen gebucht werden.
	// - Falls ein Gast mehr als 5 Reservierungen geta��tigt, oder er mindestens
	// 3 Reservierungen mit Zusatzleistungen gebucht hat, wird er in der
	// GastKomponente als Stammgast markiert (der Aufruf erfolgt durch die
	// ReservierungsKomponente im Zuge der Ausfu��hrung der Operation
	// ReserviereZimmer bzw. BucheZusatzleistung)

	private static IGastServices gastService = null;

	private static IPersistenzService persistenceService = null;

	public static void main(String[] args) {
		Integer nr = 1;
		String name = "matthias";
		Email email = Email.email(name, "gmail", "de");
		// Gast
		IPersistenzService persistenceService = new SqlConnecter();
		IGastServices gastService = new GastverwaltungKomponente(
				persistenceService);
		gastService.erzeugeGast(nr, name, email);
		Gast matze = gastService.sucheGastNachName("matthias");
		// Zusatzleistung Sauna, Vollpension, WLAN
		// Reservierung
		// BucheZusatzleistung (Assertion 5 Reservierungen || 3 reservierungen +
		// zusatzleistung

	}
}
