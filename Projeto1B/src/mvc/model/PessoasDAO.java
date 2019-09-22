package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoasDAO {
	private Connection connection = null;

	public PessoasDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/projeto1", "root", "gioiaGGR1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void register(Pessoas pessoa) throws SQLException {
		String nome = pessoa.getUsuario();
		String senha = pessoa.getSenha();
		PreparedStatement ps = connection.prepareStatement("INSERT INTO pessoa (nome, senha) VALUES (?,?)");
		ps.setString(1, nome);
		ps.setString(2, senha);
		ps.execute();
		ps.close();
	}
	
	

	public int getID(Pessoas pessoa) throws SQLException {
		int id = 0;
		PreparedStatement ps = connection.prepareStatement("SELECT id FROM pessoa WHERE nome = ? AND senha = ?");
		ps.setString(1, pessoa.getUsuario());
		ps.setString(2, pessoa.getSenha());
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		   id = rs.getInt("id");
		System.out.println(id);
		return id;
		
		
	}

	public void login(Pessoas pessoa) throws SQLException {
		String usuario = pessoa.getUsuario();
		String senha = pessoa.getSenha();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM pessoa WHERE nome = ? AND senha = ?");
		ps.setString(1, usuario);
		ps.setString(2, senha);
		ps.execute();
		ps.close();
		
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
