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
		PreparedStatement ps = connection.prepareStatement("INSERT INTO notas (id_autor, autor, conteudo) VALUES (?,?,?)");
		int id_autor = nota.getId_autor();
		String autor = nota.getAutor();
		String conteudo = nota.getConteudo();
		ps.setInt(1, id_autor);
		ps.setString(2, autor);
		ps.setString(3, conteudo);
		ps.execute();
		ps.close();
	}
	
	public void apagarNota (Notas nota) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM notas WHERE id_autor=? AND autor=? AND conteudo=?;");
		int id_autor = nota.getId_autor();
		String autor = nota.getAutor();
		String conteudo = nota.getConteudo();
		ps.setInt(1, id_autor);
		ps.setString(2, autor);
		ps.setString(3, conteudo);
		ps.execute();
		ps.close();
	}
	
	public void alterarNota (int id_autor, String autor, String conteudo, String novaNota) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("UPDATE notas SET " + " conteudo=? WHERE id_autor=? AND autor=? AND conteudo=?;");
		ps.setString(1, novaNota);
		ps.setInt(2, id_autor);
		ps.setString(3, autor);
		ps.setString(4, conteudo);
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
			nota.setId_autor(rs.getInt("id_autor"));
			nota.setAutor(rs.getString("autor"));
			nota.setConteudo(rs.getString("conteudo"));
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




