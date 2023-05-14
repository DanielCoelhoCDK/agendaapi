package com.aula.agendaapi.contatos.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectionFactory {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/agenda";
        String usuario = "postgres";
        String senha = "q1w2e3r4";
        
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida.");
            
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM public.contatos c;");
            while (rs.next()) {
                // Processa os resultados da consulta aqui
            }
            
            rs.close();
            stmt.close();
            conexao.close();
            System.out.println("Conexão fechada.");
        } catch (SQLException e) {
            System.out.println("Não foi possível estabelecer a conexão.");
            e.printStackTrace();
        }
		
	}

}
