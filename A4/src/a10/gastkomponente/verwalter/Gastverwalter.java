package a10.gastkomponente.verwalter;

import java.sql.ResultSet;

import persistenz.*;
import a10.gastkomponente.Gast;
import a10.gastkomponente.Email;

public class Gastverwalter {

	private IPersistenzService persistenzService;

	public Gastverwalter(IPersistenzService persistenzService) {
		this.persistenzService = persistenzService;
	}

	public Gast sucheGastNachNr(Integer id) {
		// look by the name
		ResultSet rs = persistenzService.read(String.valueOf(id), "gast",
				"name");

		String email = "";
		Integer nr = 0;
		String name_ = "";
		boolean stamm = false;
		try {
			while (rs.next()) {
				email = (rs.getString("Email"));
				name_ = rs.getString("name");
				nr = (rs.getInt(("Nr")));
				stamm = (rs.getBoolean("IstStammkunde"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gast gast = new Gast(nr, name_, emailConvertFromString(email), stamm);
		System.out.println(gast);
		return gast;
	}

	public Gast sucheGastNachName(String name) {
		// look by the name
		ResultSet rs = persistenzService.read(name, "gast", "name");

		String email = "";
		Integer nr = 0;
		String name_ = "";
		boolean stamm = false;
		try {
			while (rs.next()) {
				email = (rs.getString("Email"));
				name_ = rs.getString("name");
				nr = (rs.getInt(("Nr")));
				stamm = (rs.getBoolean("IstStammkunde"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gast gast = new Gast(nr, name_, emailConvertFromString(email), stamm);
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

	public void markiereGastAlsStammkunden(int nr) {

		String searchQuery = "select gast_id, count(distinct q.nr) as reservierung, count(distinct z.r_id) as zusatzreservierung "
				+ "from (select r.gast_id, r.nr from reservierung r "
				+ "where gast_id= "
				+ nr
				+ " "
				+ "group by nr )q "
				+ "inner join z2r z on z.r_id = q.nr";

		String updateQuery = "update gast set IstStammkunde = true where nr = "
				+ nr + ";";

		ResultSet rs = persistenzService.readPlainSql(searchQuery);
		int zusatzreservierung = 0;
		int reservierung = 0;

		try {
			while (rs.next()) {
				zusatzreservierung = (rs.getInt("zusatzreservierung"));
				reservierung = rs.getInt("reservierung");
				System.out.println(rs.getInt("reservierung"));
				System.out.println(rs.getInt("zusatzreservierung"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (zusatzreservierung > 2 || reservierung > 4) {
			persistenzService.writePlainSql(updateQuery);
			System.out.println("That dude with id " + nr + " is eligible!");
		} else {
			System.out.println("That dude with id " + nr + " is not eligibe!");
		}
	}

}
