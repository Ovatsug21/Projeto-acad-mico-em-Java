package DAO;

import sistemaoo2noite.Agendamento;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
//import java.sql.* paga todos os imports sql de cima
//IPC - para acessar o banco de dados é preciso add biblioteca do Mysql clicando com  botão direito
//do mouse no projeto,propriedades,biblioteca,JDBC do MySQL

public class DAOagendamento {//DAO DATA ACCESS OBJECT - pesquisar

    private static Connection conn;//serve de acesso ao banco
    private static Statement comando;// serve para aplicar instruções sql na concxão
    //private static Banco banco;
    
    public static void conectar() {

        try {
            conn = Banco.conexao();
            comando = conn.createStatement();
          
        } catch (SQLException ex) {
            Logger.getLogger(DAOagendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void desconectar() {

        try {
            conn.close();
            comando.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(DAOagendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void incluir(Agendamento a1) {
        conectar();
        String sql = "insert into agendamento values("
                + a1.getID_AGENDAMENTO()+ ",'" //QUANDO FOR TEXTO COLOCA(STRING,VARCHAR) APÓSTROFO''
                + a1.getPRONTUARIO() +"','"
                + a1.getDATA_HORA() +"','"
                + a1.getPROCEDIMENTOS()+ "');";
        JOptionPane.showMessageDialog(null,sql);//caixa de mensagem
        //System.out.println(sql);

        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro na inserção!");
        }

        desconectar();

    }

    public static void excluir(int codigoDep) {
        conectar();
        //int num_pessoa = codigo;// = CodigoCorrentista
        String sql = "delete from departamento where codigo =" + codigoDep+ " ;";

        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro na exclusão");
        }

        desconectar();

    }

    public static Agendamento pesquisar(int ID_AGENDAMENTO) {//retornou Pessoa(após o public) pq o pesquisar vai buscar Pessoa
        conectar();
        Agendamento a1 = new Agendamento();
        //int num_pessoa = codigo;
        String sql = "select* from agendamento where ID_AGENDAMENTO ='" + ID_AGENDAMENTO + " ;";
        
        ResultSet rs;
        //System.out.println(sql);

        try {
            //ResultSet rs = comando.executeQuery(sql);//rs = recebe
            rs = comando.executeQuery(sql);
            if (rs.last())
            {
                rs.first();//posiciona o cursor no primeiro da lista(pesquisar)
                a1.setID_AGENDAMENTO(rs.getInt("ID_AGENDAMENTO"));
                //a1.setPRONTUARIO(PRONTUARIO);PRONTUARIO(rs.getInt("PRONTUARIO")); dando erro
                a1.setDATA_HORA(rs.getString("local"));
                a1.setPROCEDIMENTOS(rs.getString("PRONTUARIO"));
                //a1.setCODIGO(rs.getInt("CODIGO_MEDICO")); incluir CODIGO NA CLASSE Agendamento
                
            }
            else{
                JOptionPane.showMessageDialog(null,"não encontrado");
                //P = null;
                a1 = null;
            }
            
            
        } catch (SQLException ex) {
            a1 = null;
           JOptionPane.showMessageDialog(null,"erro buscando o registro!");
        }

        desconectar();

        return a1;

    }

    public static boolean alterar(Agendamento a1) {
        conectar();
        String sql = "update agendamento set PRONTUARIO = '" + a1.getPRONTUARIO()
                +"',PROCEDIMENTOS ='"+ a1.getPROCEDIMENTOS()
                +"',DATA_HORA ='"+ a1.getDATA_HORA()
                //+"',CODIGO ='"+ a1.getCODIGO()
                +"' where ID_AGENDAMENTO ="+a1.getID_AGENDAMENTO()
                +";";
       
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro na alteração!");
        }

        desconectar();
        return true;

    }

    //public static List<Pessoa> lerLista() {
        //conectar();

        //desconectar();
       // List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
       // return listaPessoa;

    //}

    //public static boolean salvarLista(List<Pessoa> listaPessoa) {
        //conectar();

        //desconectar();
        //return true;

    //}

}
