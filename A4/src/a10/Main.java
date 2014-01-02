package a10;

import persistenz.IPersistenzService;
import persistenz.SqlConnecter;
import a10.gastkomponente.Email;
import a10.gastkomponente.Gast;
import a10.gastkomponente.IGastServices;
import a10.gastkomponente.verwalter.GastverwaltungKomponente;
import a10.reservierungskomponente.IReservierungServices;
import a10.reservierungskomponente.Reservierung;
import a10.reservierungskomponente.Zusatzleistung;
import a10.reservierungskomponente.verwalter.ReservierungverwaltungKomponente;

public class Main {

	// - Falls ein Gast mehr als 5 Reservierungen geta��tigt, oder er mindestens
	// 3 Reservierungen mit Zusatzleistungen gebucht hat, wird er in der
	// GastKomponente als Stammgast markiert (der Aufruf erfolgt durch die
	// ReservierungsKomponente im Zuge der Ausfu��hrung der Operation
	// ReserviereZimmer bzw. BucheZusatzleistung)

	private static IPersistenzService persistenceService = null;

	public static void main(String[] args) {
		// Gast
		Integer nr = 1;
		String name = "matthias";
		Email email = Email.email(name, "gmail", "de");
		// Gast erstellen
		IPersistenzService persistenceService = new SqlConnecter();
		IGastServices gastService = new GastverwaltungKomponente(
				persistenceService);
		gastService.erzeugeGast(nr, name, email);
		Gast matze = gastService.sucheGastNachName("matthias");
		// Zusatzleistung Sauna, Vollpension, WLAN erzeugen
		IReservierungServices reservierungService = new ReservierungverwaltungKomponente(
				persistenceService);
		Zusatzleistung sauna = reservierungService
				.erzeugeZusatzleistung("Sauna");
		Zusatzleistung vollpension = reservierungService
				.erzeugeZusatzleistung("Vollpension");
		Zusatzleistung wlan = reservierungService.erzeugeZusatzleistung("WLAN");
		// Reservierung erstellen
		Integer zimmerNr = 20;
		Reservierung res = reservierungService.reserviereZimmer(matze.getNr(),
				zimmerNr);
		reservierungService.bucheZusatzleistung(res.getNr(), sauna.getNr());
		reservierungService.bucheZusatzleistung(res.getNr(),
				vollpension.getNr());
		reservierungService.bucheZusatzleistung(res.getNr(), wlan.getNr());
		// BucheZusatzleistung (Assertion 5 Reservierungen || 3 reservierungen +
		// zusatzleistung

	}
}
