/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoPetshop;
import javax.swing.JOptionPane;
import modelo.Petshop;
import tela.manutencao.ManutencaoPetshop;
import tela.manutencao.ManutencaoPetshop;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class ControladorPetshop {

    public static void inserir(ManutencaoPetshop man){
        Petshop objeto = new Petshop();
        objeto.setAvaliacao(Integer.parseInt(man.jtfavaliacao.getText()));
        objeto.setNumero(Integer.parseInt(man.jtfnumero.getText()));
        objeto.setEndereco(man.jtfendereco.getText());
        objeto.setNome(man.jtfnome.getText());
        objeto.setCodigo(Integer.parseInt(man.jtfcodigo.getText()));
        
        boolean resultado = DaoPetshop.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

   public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Avaliação");
        modelo.addColumn("Número");
        modelo.addColumn("Endereço");
        modelo.addColumn("Nome");
        modelo.addColumn("Código");
        List<Petshop> resultados = DaoPetshop.consultar();
        for (Petshop objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getAvaliacao());
            linha.add(objeto.getNumero());
            linha.add(objeto.getEndereco());
            linha.add(objeto.getNome());
            linha.add(objeto.getCodigo());
            

            
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }

   public static void alterar(ManutencaoPetshop man){
        Petshop objeto = new Petshop();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfcodigo.getText()));
        objeto.setNome(man.jtfnome.getText());
        objeto.setEndereco(man.jtfendereco.getText());
        objeto.setAvaliacao(Integer.parseInt(man.jtfavaliacao.getText()));
        objeto.setNumero(Integer.parseInt(man.jtfnumero.getText()));
        
        boolean resultado = DaoPetshop.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

   public static void excluir(ManutencaoPetshop man){
        Petshop objeto = new Petshop();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        boolean resultado = DaoProduto.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    }
    }
    
    
    

