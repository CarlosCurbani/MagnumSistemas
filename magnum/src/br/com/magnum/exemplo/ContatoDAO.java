package br.com.magnum.exemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class ContatoDAO {

	public static void main(String[] args) throws SQLException {
		ContatoDAO cd = new ContatoDAO();
		cd.adiciona(new Contato());
	}

	public void adiciona(Contato contato) {
		// conectando
		Connection con = null;
		try {
			con = new ConnectionFactory().getConnection();
			// cria um preparedStatement
			String sql = "insert into contatos"
					+ " (nome,email,endereco,dataNascimento)"
					+ " values (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(Calendar.getInstance()
					.getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
			System.out.println("Gravado!");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			
		}
	}

}
