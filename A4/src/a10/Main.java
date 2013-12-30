package a10;

import a10.gastkomponente.*;

public class Main {

	public static void main(String[] args) {
		Integer nr = 1;
		String name = "matthias";
		Boolean stammkunde = true;
		Email email = Email.email(name, "gmail", "de");
		Gast g = new Gast(nr, name, email, stammkunde);
		System.out.println(g);
		// Gast g = ErzeugeGast(nr, name, email);
		// Gast SucheGastNachName(String name);
		// ReserviereZimmer();
		// BucheZusatzleistung();

	}
}
