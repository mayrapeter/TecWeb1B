package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NotasDAO {
	
	private Connection connection = null;

	public NotasDAO() {
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
	
	public void addNota(Notas nota) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO notas (id, nome, nota) VALUES (?,?,?)");
		int id = nota.getIdAutor();
		String nome = nota.getAutor();
		String conteudo = nota.getNota();
		ps.setInt(1, id);
		ps.setString(2, nome);
		ps.setString(3, conteudo);
		ps.execute();
		ps.close();
	}
	
	public void apagarNota (Notas nota) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM notas WHERE id=? AND nome=? AND nota=?;");
		int id = nota.getIdAutor();
		String nome = nota.getAutor();
		String conteudo = nota.getNota();
		ps.setInt(1, id);
		ps.setString(2, nome);
		ps.setString(3, conteudo);
		ps.execute();
		ps.close();
	}
	
	public void alterarNota (int id, String nome, String nota, String novaNota) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("UPDATE notas SET " + " nota=? WHERE id=? AND nome=? AND nota=?;");
		ps.setString(1, novaNota);
		ps.setInt(2, id);
		ps.setString(3, nome);
		ps.setString(4, nota);
		ps.execute();
		ps.close();
	}
	public List<Notas> getLista() throws SQLException {
		List<Notas> notas = new ArrayList<Notas>();
		 PreparedStatement stmt = connection.
				prepareStatement("SELECT * FROM notas");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Notas nota = new Notas();
			nota.setIdAutor(rs.getInt("id"));
			nota.setAutor(rs.getString("nome"));
			nota.setNota(rs.getString("nota"));
			notas.add(nota);
		}
		rs.close();
		stmt.close();
		return notas;
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




