package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import persistenz.SqlConnecter;
import a10.reservierungskomponente.Reservierung;
import a10.reservierungskomponente.Zusatzleistung;
import a10.reservierungskomponente.verwalter.*;

public class ZusatzleistungTest {

	@Test
	public void testZusatzleistung() {
		SqlConnecter connection = new SqlConnecter();
		Reservierungverwalter rv = new Reservierungverwalter(connection);

		

		//assertEquals(true,x.equals(rv.sucheReservierung(1, 11)));
		//assertEquals(true,x.equals(rv.sucheReservierung(1,6)));
		rv.markiereGastAlsStammkunde("2");
	}

}