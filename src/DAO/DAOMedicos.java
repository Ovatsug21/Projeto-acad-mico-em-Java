package DAO;

import sistemaoo2noite.Medicos;
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

public class DAOMedicos {//DAO DATA ACCESS OBJECT - pesquisar

    private static Connection conn;//serve de acesso ao banco
    private static Statement comando;// serve para aplicar instruções sql na concxão
    //private static Banco banco;
    
    public static void conectar() {

        try {
            conn = Banco.conexao();
            comando = conn.createStatement();
          
        } catch (SQLException ex) {
            Logger.getLogger(DAOMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void desconectar() {

        try {
            conn.close();
            comando.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(DAOMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void incluir(Medicos m1) {
        conectar();
        String sql = "insert into medicos values("
                + m1.getCODIGO()+ ",'" //QUANDO FOR TEXTO COLOCA(STRING,VARCHAR) APÓSTROFO''
                + m1.getNOME_MEDICO() +"','"
                + m1.getCPF_MEDICO() +"','"
                + m1.getESPECIALIDADE() +"','"
                + m1.getCRM() + "');";
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

    public static void excluir(int CODIGO) {
        conectar();
        //int num_pessoa = codigo;// = CodigoCorrentista
        String sql = "delete from medicos where CODIGO =" + CODIGO + " ;";

        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro na exclusão");
        }

        desconectar();

    }

    public static Medicos pesquisar(int CODIGO) {//retornou Pessoa(após o public) pq o pesquisar vai buscar Pessoa
        conectar();
        Medicos m1 = new Medicos(); // talvez não precise pesquisar médicos
        //int num_pessoa = codigo;
        String sql = "select* from medicos where CODIGO ='" + CODIGO + " ;";
        
        ResultSet rs;
        //System.out.println(sql);

        try {
            //ResultSet rs = comando.executeQuery(sql);//rs = recebe
            rs = comando.executeQuery(sql);
            if (rs.last())
            {
                rs.first();//posiciona o cursor no primeiro da lista(pesquisar)
                m1.setCODIGO(rs.getInt("CODIGO"));
                m1.setCRM(rs.getString("CRM"));
                m1.setESPECIALIDADE(rs.getString("ESPECIALIDADE"));
                m1.setNOME_MEDICO(rs.getString("NOME_MEDICO"));
                m1.setCPF_MEDICO(rs.getString("CPF_MEDICO"));
                
            }
            else{
                JOptionPane.showMessageDialog(null,"não encontrado");
                //P = null;
                m1 = null;
            }
            
            
        } catch (SQLException ex) {
            m1 = null;
           JOptionPane.showMessageDialog(null,"erro buscando o registro!");
        }

        desconectar();

        return m1;

    }

    public static boolean alterar(Medicos m1) {
        conectar();
        String sql = "update dmedicos set NOME = '" + m1.getNOME_MEDICO()
                +"',CRM ='"+ m1.getCRM()
                +"',CRM ='"+ m1.getCPF_MEDICO()
                +"',CRM ='"+ m1.getESPECIALIDADE()
                +"' where CODIGO ="+m1.getCODIGO()
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
