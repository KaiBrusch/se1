package a10.gastkomponente.verwalter;

import java.sql.ResultSet;

import persistenz.*;
import a10.gastkomponente.Gast;
import a10.gastkomponente.Email;

public class Gastverwalter {

	public static void main(String[] args) throws Exception {

		SqlConnecter connection = new SqlConnecter();
		Gastverwalter gw = new Gastverwalter(connection);

		// System.out.println(l.get(3));
		// gw.sucheGastNachName("test");
		// gw.erzeugeGast("peterPan", "elec@tek.de", true);
		// gw.updateGast("test","lol@lol.de");
		Email em = Email.email("kai", "asd", "domain");
		gw.erzeugeGast(2, "iak", em);
	}

	private IPersistenzService persistenzService;

	public Gastverwalter(IPersistenzService persistenzService) {
		this.persistenzService = persistenzService;

	}

	public Gast sucheGastNachName(String name) {
		// look by the name
		ResultSet rs = persistenzService.read(name, "gast");

		String email = "";
		Integer nr = 0;
		boolean stamm = false;
		try {
			while (rs.next()) {
				email = (rs.getString("Email"));
				nr = (rs.getInt(("Nr")));
				stamm = (rs.getBoolean("IstStammkunde"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gast gast = new Gast(nr, name, emailConvertFromString(email));
		System.out.println(gast);
		return gast;
	}

	public Gast erzeugeGast(Integer nr, String name, Email email) {

		try {
			String query = "insert into gast values(" + nr + ", '" + name
					+ "', '" + email.toString() + "', false)";
			System.out.println(query);

			persistenzService.create(query);
			Gast gast = sucheGastNachName(name);
			return gast;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Email emailConvertFromString(String plain) {
		String[] s = plain.split("(@|\\.)");
		String name = s[0];
		String server = s[1];
		String domain = s[2];
		return Email.email(name, server, domain);
	}

}
