package a10.gastkomponente.verwalter;
import persistenz.*;

public class Gastverwalter {
	
		  public static void main(String[] args) throws Exception {
		    SqlConnecter connection = new SqlConnecter();
		    connection.readDataBase();
		    
		  }


}
