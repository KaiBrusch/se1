package persistenz;

import java.sql.ResultSet;

public interface IPersistenzService {

	void create(String query);

	ResultSet read(String name, String table);
}
