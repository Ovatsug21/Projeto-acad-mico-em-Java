
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;//comunicação(driver) entre java e o banco de dados
import java.sql.SQLException;//pra não parar a programação em caso de qualquer erro
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banco {//classe apenas para conectar o banco,não precisa instanciar(classe abstrata)
    
    private static final String url = "jdbc:mysql://127.0.0.1/clinica_medica";//static é pra compartilhar um atributo com todas as outras classes
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    public static Connection conn;// conn é o objeto de conaxão
    
    public static Connection conexao() throws SQLException {
        try{//para tratamento de erro(faça isso,se der qualquer erro,vai para o catch)
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();// imprime a lista de erro
            System.out.println("Não foi possível encontrar o DRIVE");
            //Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
       return conn; 
    }
    
    
}
