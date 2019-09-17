/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Petshop; 
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrador
 */
public class DaoPetshop {
    public static boolean inserir(Petshop objeto) {
        String sql = "INSERT INTO petshop (avaliacao, numero, endereco, nome, codigo) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getAvaliacao());
            ps.setInt(2, objeto.getNumero());
            ps.setString(3, objeto.getEndereco());
            ps.setString(4, objeto.getNome());
            ps.setInt(5, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
    }
    public static void main(String[] args) {
        Petshop objeto = new Petshop();
        objeto.setAvaliacao(234);
        objeto.setNumero(034);
        objeto.setEndereco("Quinze de Novembro");
        objeto.setNome("Lauany");
        objeto.setCodigo(1234);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static List<Petshop> consultar() {
        List<Petshop> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT avaliacao, nome, numero, endereco, codigo FROM petshop";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Petshop objeto = new Petshop();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("Nome"));
                objeto.setEndereco(rs.getString("Endereço"));
                objeto.setNumero(rs.getInt("Número"));
                objeto.setAvaliacao(rs.getInt("Avaliação"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
      public static boolean alterar(Petshop objeto) {
        String sql = "UPDATE petshop SET avaliacao = ?, numero = ?, endereco = ?, nome = ?, codigo = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getAvaliacao()); 
            ps.setInt(2, objeto.getNumero());
            ps.setString(3, objeto.getEndereco());
            ps.setString(4, objeto.getNome());
            ps.setInt(5, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       public static boolean excluir(Petshop objeto) {
        String sql = "DELETE FROM petshop WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
