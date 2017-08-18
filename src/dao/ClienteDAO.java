/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.DBConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Cliente;

public class ClienteDAO {

    private DBConnection connection;

    public ClienteDAO() {
        this.connection = new DBConnection();
    }

    public boolean saveCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO clientes (nome,endereco,complemento, cep, cidade, telefone, nascimento) VALUES (?,?,?,?,?,?, STR_TO_DATE(?, '%d/%m/%Y'));";

            this.connection.openConnection();
            this.connection.setPstmt(this.connection.getCon().prepareStatement(sql));
            this.connection.getPstmt().setString(1, cliente.getNome());
            this.connection.getPstmt().setString(2, cliente.getEndereco());
            this.connection.getPstmt().setString(3, cliente.getComplemento());
            this.connection.getPstmt().setString(4, cliente.getCep());
            this.connection.getPstmt().setString(5, cliente.getCidade());
            this.connection.getPstmt().setString(6, cliente.getTelefone());
            this.connection.getPstmt().setString(7, cliente.getNascimento());

            if (this.connection.getPstmt().executeUpdate() > 0) {
                System.out.println("CLIENTE CADASTRADO!");
                this.connection.closeConnection();
                return true;
                
            }
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }
        return false;
    }
}
