package main.java.com.bancosimulador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    public void inserirUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (cpf, nascimento, agencia, conta, senha) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getCpf());
            stmt.setString(2, usuario.getNascimento());
            stmt.setString(3, usuario.getAgencia());
            stmt.setString(4, usuario.getConta());
            stmt.setString(5, usuario.getSenha());
            stmt.executeUpdate();
        }
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("cpf"),
                        rs.getString("nascimento"),
                        rs.getString("agencia"),
                        rs.getString("conta"),
                        rs.getString("senha")
                );
                usuario.setId(rs.getLong("id"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public void atualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nascimento = ?, agencia = ?, conta = ?, senha = ? WHERE cpf = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNascimento());
            stmt.setString(2, usuario.getAgencia());
            stmt.setString(3, usuario.getConta());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getCpf());
            stmt.executeUpdate();
        }
    }

    public void deletarUsuario(String cpf) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE cpf = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        }
    }
}
