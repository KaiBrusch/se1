package a10.reservierungskomponente.verwalter;

import a10.reservierungskomponente.Reservierung;
import a10.reservierungskomponente.Zusatzleistung;
import persistenz.IPersistenzService;

public class Reservierungverwalter {

	private IPersistenzService persistenzService;

	public Reservierungverwalter(IPersistenzService persistenzService) {
		this.persistenzService = persistenzService;
	}

	public Zusatzleistung erzeugeZusatzleistung(String name) {
		return null;
	};

	public Reservierung reserviereZimmer(Integer gastNr, Integer zimmerNr) {
		return null;
	};

	public void bucheZusatzleistung(Integer reservierungNr,
			Integer zusatzleistungNr) {
		return;
	};
}
