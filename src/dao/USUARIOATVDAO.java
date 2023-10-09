package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import entity.USUARIO_ATV;

public class USUARIOATVDAO {

    private static PreparedStatement preparar;
    private static Connection conectar;

    public USUARIOATVDAO() {
        CONEXAO novaConexao = new CONEXAO();
        conectar = novaConexao.getConexao();
        preparar = null;
    }

    public void cadastrarUsuario(USUARIO_ATV usuario_ATV){

        String query = "INSERT INTO usuario (cpf, nome, sobrenome, idade, email, ano) VALUES (?, ?, ?, ?, ?, ?)";

        try{
            preparar = conectar.prepareStatement(query);
            preparar.setString(1, usuario_ATV.getCpf());
            preparar.setString(2, usuario_ATV.getNome());
            preparar.setString(3, usuario_ATV.getSobrenome());
            preparar.setInt(4, usuario_ATV.getIdade());
            preparar.setString(5, usuario_ATV.getEmail());
            preparar.setInt(6, usuario_ATV.getAno());
            preparar.execute();
            JOptionPane.showMessageDialog(null,"Usuario Cadastrado!");
        } catch (SQLException erro_cadastrar_usuario) {
            System.out.println("Erro ao cadastrar o Usuario\n" + erro_cadastrar_usuario.getMessage());
        }
        }

    
    public void buscarUsuario(USUARIO_ATV usuario_ATV){

        String query = "SELECT nome, sobrenome, idade, email, ano FROM usuario WHERE cpf = '" + usuario_ATV.getCpf() + "'";

        try {
            java.sql.Statement stmt = conectar.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            JOptionPane.showMessageDialog(null,"Busca Feita!");

            while (resultado.next()) {
                usuario_ATV.setNome(resultado.getString("nome"));
                usuario_ATV.setSobrenome(resultado.getString("sobrenome"));
                usuario_ATV.setIdade(resultado.getInt("idade"));
                usuario_ATV.setEmail(resultado.getString("email"));
                usuario_ATV.setAno(resultado.getInt("ano"));
                }
            } catch (SQLException erro_buscar_usuario) {
                JOptionPane.showMessageDialog(null,"Erro ao buscar usuario!\n" + erro_buscar_usuario.getMessage());
            }



    }


    public static void atualizarUsuario(USUARIO_ATV usuario_ATV){
        

        String query = "UPDATE usuario SET nome=?, sobrenome=?, idade=?, email=?, ano=? WHERE cpf= '" + usuario_ATV.getCpf() + "'";

        try {
            preparar = conectar.prepareStatement(query);
            preparar.setString(1, usuario_ATV.getNome());
            preparar.setString(2, usuario_ATV.getSobrenome());
            preparar.setInt(3, usuario_ATV.getIdade());
            preparar.setString(4, usuario_ATV.getEmail());
            preparar.setInt(5, usuario_ATV.getAno());

            preparar.execute();
            JOptionPane.showMessageDialog(null,"Usuario Atualizado!");
        } catch (SQLException erro_atualizar_usuario) {
            System.out.println("Erro ao atualizar usuario\n" + erro_atualizar_usuario.getMessage());
        }
    



    }


    public static void excluirUsuario(USUARIO_ATV usuario_ATV){

        String query = "DELETE FROM usuario WHERE cpf= '" + usuario_ATV.getCpf() + "'";
        
        try {
            preparar = conectar.prepareStatement(query);
            preparar.execute();
            JOptionPane.showMessageDialog(null,"Usuario Excluido!");


        }catch (SQLException erro_excluir_usuario) {
            System.out.println("Erro ao atualizar usuario\n" + erro_excluir_usuario.getMessage());
        }

    }
}





    

