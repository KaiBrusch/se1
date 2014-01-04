package a10;

import persistenz.IPersistenzService;
import persistenz.SqlConnecter;
import a10.gastkomponente.Email;
import a10.gastkomponente.Gast;
import a10.gastkomponente.IGastServices;
import a10.gastkomponente.IGastServicesFuerReservierung;
import a10.gastkomponente.verwalter.GastverwaltungKomponente;
import a10.reservierungskomponente.IReservierungServices;
import a10.reservierungskomponente.Reservierung;
import a10.reservierungskomponente.Zusatzleistung;
import a10.reservierungskomponente.verwalter.ReservierungverwaltungKomponente;

public class Main {

	public static void main(String[] args) {

		// Gast 1
		Integer nr = 1;
		String name = "matthias";
		Email email = Email.email(name, "gmail", "de");
		// Gast 2
		Integer nr2 = 2;
		String name2 = "kai";
		Email email2 = Email.email(name2, "gmail", "org");
		// Gast 3
		Integer nr3 = 3;
		String name3 = "Tree";
		Email email3 = Email.email(name3, "gmail", "org");
		// Gast erstellen
		IPersistenzService persistenceService = new SqlConnecter();
		IGastServices gastService = new GastverwaltungKomponente(
				persistenceService);

		gastService.erzeugeGast(nr, name, email);
		gastService.erzeugeGast(nr2, name2, email2);
		gastService.erzeugeGast(nr3, name3, email3);

		Gast matze = gastService.sucheGastNachName("matthias");
		Gast kai = gastService.sucheGastNachName("kai");
		Gast tree = gastService.sucheGastNachName("Tree");

		// Zusatzleistung Sauna, Vollpension, WLAN erzeugen
		IReservierungServices reservierungService = new ReservierungverwaltungKomponente(
				persistenceService);
		Zusatzleistung sauna = reservierungService
				.erzeugeZusatzleistung("Sauna");
		Zusatzleistung vollpension = reservierungService
				.erzeugeZusatzleistung("Vollpension");
		Zusatzleistung wlan = reservierungService.erzeugeZusatzleistung("WLAN");

		// Reservierung erstellen
		for (int i = 0; i < 10; i++) {

			Reservierung res = reservierungService.reserviereZimmer(
					matze.getNr(), i);
			reservierungService.bucheZusatzleistung(res.getNr(), sauna.getNr());
			reservierungService.bucheZusatzleistung(res.getNr(),
					vollpension.getNr());
			reservierungService.bucheZusatzleistung(res.getNr(), wlan.getNr());

		}

		for (int i = 11; i < 15; i++) {
			Reservierung res = reservierungService.reserviereZimmer(
					kai.getNr(), i);
			reservierungService.bucheZusatzleistung(res.getNr(), sauna.getNr());
		}

		// BucheZusatzleistung (Assertion 5 Reservierungen || 3 reservierungen +
		// zusatzleistung
		IGastServicesFuerReservierung stammkunde = new GastverwaltungKomponente(
				persistenceService);
		stammkunde.markiereGastAlsStammkunden(matze.getNr());
		stammkunde.markiereGastAlsStammkunden(kai.getNr());
		stammkunde.markiereGastAlsStammkunden(tree.getNr());
	}
}
