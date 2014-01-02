package a10.gastkomponente.verwalter;

import java.util.ArrayList;

import persistenz.*;

public class Gastverwalter {

  public static void main(String[] args) throws Exception {
    // 
    // connection.readDataBase("select * from test.gast");
    // getGast("kai");
    //createGast("dritter", "klein@grol.de", true);
    SqlConnecter connection = new SqlConnecter();
    Gastverwalter gw = new Gastverwalter(connection);
    
    
    ArrayList<String> l = new ArrayList<>();
    l.add("eins");
    l.add("zwei");
    l.add("drei");
    l.add("");
    
    System.out.println(l.get(3));
    //gw.sucheGastNachName("test");
    //gw.erzeugeGast("peterPan", "elec@tek.de", true);
    gw.updateGast("test", "kacke@test");
  }

  
  private IPersistenzService sqlc;
  public Gastverwalter(IPersistenzService sqlc){
    this.sqlc = sqlc;

  }
  
  
  public void sucheGastNachName(String name) throws Exception {
    //look by the name
    String lookUpByParameter = "name";
    
    sqlc.readFromDB(name,"gast",lookUpByParameter);
  }

  

  public  void deleteGast(String name) throws Exception {
    
    sqlc.removeFromDB(name, "gast");
  }
  
  
  public  void erzeugeGast(String name, String email, boolean stammkunde)
      throws Exception {
    
    //generate list with sql parameters
    ArrayList<String> parameterList = new ArrayList<String>();
    parameterList.add(name);
    parameterList.add(email);
    // you cant set to stammkunde by default
    
    // insert into table gast with given parameters
    sqlc.insertIntoDB("gast", parameterList);
  }

  public void updateGast(String name, String email) throws Exception{
    
    //String lookUpByParameter = "name";
    ArrayList<String> parameterList = new ArrayList<String>();
    parameterList.add(name);
    parameterList.add(email);
    sqlc.updateEntryFromDB("gast", name, parameterList);
  }

}
