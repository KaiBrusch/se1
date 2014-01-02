package a10.gastkomponente.verwalter;

import java.nio.channels.GatheringByteChannel;
import java.sql.ResultSet;
import java.util.ArrayList;

import persistenz.*;
import tests.EmailTest;
import a10.gastkomponente.Gast;
import a10.gastkomponente.Email;


public class Gastverwalter {

	public static void main(String[] args) throws Exception {
		//
		// connection.readDataBase("select * from test.gast");
		// getGast("kai");
		// createGast("dritter", "klein@grol.de", true);
		SqlConnecter connection = new SqlConnecter();
		Gastverwalter gw = new Gastverwalter(connection);

		ArrayList<String> l = new ArrayList<>();
		l.add("eins");
		l.add("zwei");
		l.add("drei");
		l.add("");

		// System.out.println(l.get(3));
		// gw.sucheGastNachName("test");
		// gw.erzeugeGast("peterPan", "elec@tek.de", true);
		// gw.updateGast("test","lol@lol.de");
		gw.sucheGastNachName("test");
	}

	private IPersistenzService persistenzService;

	public Gastverwalter(IPersistenzService persistenzService) {
		this.persistenzService = persistenzService;

	}

	public Gast sucheGastNachName(String name) throws Exception {
		// look by the name
		ResultSet rs = persistenzService.read(name, "gast");
		
		String email = "";
		Integer nr = 0;
		String name_ = "";
		while(rs.next()){
			email = (rs.getString("Email"));
			name_ = rs.getString("name");
			nr = (rs.getInt(("Nr")));
			
		}
		
		Gast gast = new Gast(nr,name_,emailConvertFromString(email));
		System.out.println(gast);
		return gast;
	}

	
	 public Email emailConvertFromString(String plain){
		  String [] s = plain.split("(@|\\.)");
		  String name = s[0];
		  String server = s[1];
		  String domain = s[2];
		  return Email.email(name, server, domain);
	  }

	public void erzeugeGast(String name, String email, boolean stammkunde)
			throws Exception {

		// generate list with sql parameters
		ArrayList<String> parameterList = new ArrayList<String>();
		parameterList.add(name);
		parameterList.add(email);
		
		String query = "";
//		"gast", parameterList
		// insert into table gast with given parameters
		persistenzService.create(query);
	}


}
