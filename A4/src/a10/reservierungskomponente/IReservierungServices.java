package a10.reservierungskomponente;

public interface IReservierungServices {

	Zusatzleistung ErzeugeZusatzleistung(String name);

	Reservierung ReserviereZimmer(Integer gastNr, Integer zimmerNr);

	void BucheZusatzleistung(Integer reservierungNr, Integer zusatzleistungNr);
}
