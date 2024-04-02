import java.sql.Connection;

public class Conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	Conexao(){
		url="jdbc:postgresql://localhost:5432/postgres";
		usuario = "postgres";
		senha = "postgres";
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
