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
	public Zusatzleistung erzeugeZusatzleistung(String name) {
		return this.reservierungverwalter.erzeugeZusatzleistung(name);
	}

	@Override
	public Reservierung reserviereZimmer(Integer gastNr, Integer zimmerNr) {
		return this.reservierungverwalter.reserviereZimmer(gastNr, zimmerNr);
	}

	@Override
	public void bucheZusatzleistung(Integer reservierungNr,
			Integer zusatzleistungNr) {
		this.reservierungverwalter.bucheZusatzleistung(reservierungNr,
				zusatzleistungNr);
	}

}
