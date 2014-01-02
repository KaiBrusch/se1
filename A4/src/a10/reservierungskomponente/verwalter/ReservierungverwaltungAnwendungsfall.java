package a10.reservierungskomponente.verwalter;

import a10.reservierungskomponente.IReservierungServices;
import a10.reservierungskomponente.Reservierung;
import a10.reservierungskomponente.Zusatzleistung;

public class ReservierungverwaltungAnwendungsfall implements
		IReservierungServices {

	private Reservierungverwalter reservierungverwalter = null;

	public ReservierungverwaltungAnwendungsfall(
			Reservierungverwalter reservierungverwalter) {
		this.reservierungverwalter = reservierungverwalter;
	}

	@Override
	public Zusatzleistung ErzeugeZusatzleistung(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservierung ReserviereZimmer(Integer gastNr, Integer zimmerNr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void BucheZusatzleistung(Integer reservierungNr,
			Integer zusatzleistungNr) {
		// TODO Auto-generated method stub

	}

}
