package com.bancosimulador;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        port(4567);
        Gson gson = new Gson();

        // Criar usuário
        post("/usuarios", (req, res) -> {
            Usuario usuario = gson.fromJson(req.body(), Usuario.class);
            try {
                UsuarioDAO.inserir(usuario);
                res.status(201);
                return "Usuário criado com sucesso!";
            } catch (SQLException e) {
                res.status(500);
                return "Erro ao criar usuário: " + e.getMessage();
            }
        });

        // Listar usuários
        get("/usuarios", (req, res) -> {
            try {
                List<Usuario> usuarios = UsuarioDAO.listar();
                res.type("application/json");
                return gson.toJson(usuarios);
            } catch (SQLException e) {
                res.status(500);
                return "Erro ao buscar usuários: " + e.getMessage();
            }
        });

        // Atualizar usuário
        put("/usuarios/:id", (req, res) -> {
            Long id = Long.parseLong(req.params(":id"));
            Usuario usuario = gson.fromJson(req.body(), Usuario.class);
            usuario.setId(id);
            try {
                UsuarioDAO.atualizar(usuario);
                return "Usuário atualizado com sucesso!";
            } catch (SQLException e) {
                res.status(500);
                return "Erro ao atualizar usuário: " + e.getMessage();
            }
        });

        // Deletar usuário
        delete("/usuarios/:id", (req, res) -> {
            Long id = Long.parseLong(req.params(":id"));
            try {
                UsuarioDAO.deletar(id);
                return "Usuário deletado com sucesso!";
            } catch (SQLException e) {
                res.status(500);
                return "Erro ao deletar usuário: " + e.getMessage();
            }
        });
    }
}
