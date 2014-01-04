package tests;

import persistenz.IPersistenzService;
import persistenz.SqlConnecter;
import a10.gastkomponente.Gast;
import a10.gastkomponente.IGastServices;
import a10.gastkomponente.verwalter.GastverwaltungKomponente;
import a10.reservierungskomponente.IReservierungServices;
import a10.reservierungskomponente.Reservierung;
import a10.reservierungskomponente.Zusatzleistung;
import a10.reservierungskomponente.verwalter.ReservierungverwaltungKomponente;

public class WorkflowIntegrationTest {

//	// Gast erstellen
//	IPersistenzService persistenceService = new SqlConnecter();
//	IGastServices gastService = new GastverwaltungKomponente(
//			persistenceService);
//
//	gastService.erzeugeGast(nr, name, email);
//	gastService.erzeugeGast(nr2, name2, email2);
//	gastService.erzeugeGast(nr3, name3, email3);
//
//	Gast matze = gastService.sucheGastNachName("matthias");
//	Gast kai = gastService.sucheGastNachName("kai");
//	Gast tree = gastService.sucheGastNachName("Tree");
//
//	// Zusatzleistung Sauna, Vollpension, WLAN erzeugen
//	IReservierungServices reservierungService = new ReservierungverwaltungKomponente(
//			persistenceService);
//	Zusatzleistung sauna = reservierungService
//			.erzeugeZusatzleistung("Sauna");
//	Zusatzleistung vollpension = reservierungService
//			.erzeugeZusatzleistung("Vollpension");
//	Zusatzleistung wlan = reservierungService.erzeugeZusatzleistung("WLAN");
//
//	// Reservierung erstellen
//	for (int i = 0; i < 10; i++) {
//
//		Reservierung res = reservierungService.reserviereZimmer(
//				matze.getNr(), i);
//		reservierungService.bucheZusatzleistung(res.getNr(), sauna.getNr());
//		reservierungService.bucheZusatzleistung(res.getNr(),
//				vollpension.getNr());
//		reservierungService.bucheZusatzleistung(res.getNr(), wlan.getNr());
//
//	}
//
//	for (int i = 11; i < 15; i++) {
//		Reservierung res = reservierungService.reserviereZimmer(
//				kai.getNr(), i);
//		reservierungService.bucheZusatzleistung(res.getNr(), sauna.getNr());
//	}
}
