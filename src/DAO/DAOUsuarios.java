package DAO;

import sistemaoo2noite.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class DAOUsuarios {//DAO DATA ACCESS OBJECT - pesquisar

    private static Connection conn;//serve de acesso ao banco
    private static Statement comando;// serve para aplicar instruções sql na concxão
    //private static Banco banco;
    
    public static void conectar() {

        try {
            conn = Banco.conexao();
            comando = conn.createStatement();
          
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void desconectar() {

        try {
            conn.close();
            comando.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checkLogin(String login, String senha){
        
       conectar();
       PreparedStatement stmt = null;
       ResultSet rs =  null;
       boolean check = false;
       
       try {
          stmt = conn.prepareStatement("SELECT *FROM usuarios where NOME_USUARIO = ? and SENHA_USUARIO = ?");
          stmt.setString(1, login);
          stmt.setString(2, senha);
          rs = stmt.executeQuery();
          
          if (rs.next()){
              check = true;
              
          }
          
       } catch (SQLException ex){
           Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
       } finally{
           desconectar();
       }
      return check;
    }
    
    public static Usuarios pesquisar(int ID ,String NOME_USUARIO, String SENHA_USUARIO) throws SQLException{
        
        
        conectar();
        Usuarios u1 = new Usuarios();
        String sql = ("select *from usuarios where NOME_USUARIO = " + NOME_USUARIO + ";");
        ResultSet rs;
        try{
                            rs = comando.executeQuery(sql);

                       if (rs.last()) {

                               rs.first();//posiciona o cursor no primeiro da lista(pesquisar)
                               u1.setNOME_USUARIO(rs.getString("NOME_USUARIO"));
                               u1.setSENHA_USUARIO(rs.getString("SENHA_USUARIO"));

                       }else{
                               JOptionPane.showMessageDialog(null,"não encontrado");
                               //P = null;
                               u1 = null;
                           }
        }catch (SQLException ex) {
            u1 = null;
           JOptionPane.showMessageDialog(null,"erro buscando o registro!");
           System.out.println(ex);
        }
        desconectar();
        return u1;
        
        
        
        
    }
    public static void incluir(Usuarios u1){
        conectar();
        //String sql ="insert into usuarios  values (null,"+ u1.getNOME_USUARIO()+ ","  + u1.getSENHA_USUARIO() + ");";
       String sql = ("insert into usuarios (nome, senha_usuario) values ('"+u1.getNOME_USUARIO()+"' , '"+u1.getSENHA_USUARIO()+"') " );
       
        
        JOptionPane.showMessageDialog(null,sql);//caixa de mensagem
        //System.out.println(sql);
        
        try {
            
            comando.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null,"inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro na inserção!");
            System.out.println(ex);
        }

        desconectar();

    }

    public static void excluir(String NOME_USUARIO) {
        conectar();
        //int num_pessoa = codigo;// = CodigoCorrentista
        String sql = "delete from usuarios where NOME_USUARIO =" + NOME_USUARIO + " ;";

        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro na exclusão");
        }

        desconectar();

    }

   // public static Departamento pesquisar(int codigoDep) {//retornou Pessoa(após o public) pq o pesquisar vai buscar Pessoa
        //conectar();
        //Departamento d1 = new Departamento();
        //int num_pessoa = codigo;
        //String sql = "select* from departamento where codigoDep ='" + codigoDep + " ;";
        
        //ResultSet rs;
        //System.out.println(sql);

        //try {
            //ResultSet rs = comando.executeQuery(sql);//rs = recebe
          //  rs = comando.executeQuery(sql);
            //if (rs.last())
            //{
              //  rs.first();//posiciona o cursor no primeiro da lista(pesquisar)
                //d1.setCodDep(rs.getInt("codigo"));
                //d1.setNomeDep(rs.getString("nome"));
                //d1.setLocal(rs.getString("local"));
                
            //}
           // else{
                //JOptionPane.showMessageDialog(null,"não encontrado");
                //P = null;
                //d1 = null;
           // }
            
            
       // } catch (SQLException ex) {
         //   d1 = null;
         //  JOptionPane.showMessageDialog(null,"erro buscando o registro!");
        //}

       // desconectar();

       // return d1;

    //}

    public static boolean alterar(Usuarios u1) {// talvez não precise
        conectar();
        String sql = "update usuarios set NOME_USUARIO = '" + u1.getNOME_USUARIO()
                +"',SENHA_USUARIO ='"+ u1.getSENHA_USUARIO()
                +"' where codigo ="+u1.getNOME_USUARIO()
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
