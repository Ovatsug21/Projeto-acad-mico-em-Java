
package sistemaoo2noite;

public class Usuarios {
   
    private String NOME_USUARIO; 
    private String SENHA_USUARIO;
    
    public Usuarios(){
    
    }
    
    public Usuarios (String NOME_USUARIO , String SENHA_USUARIO){
        this.NOME_USUARIO = NOME_USUARIO;
        this.SENHA_USUARIO = SENHA_USUARIO;
    
    }

    public String getNOME_USUARIO() {
        return NOME_USUARIO;
    }

    public void setNOME_USUARIO(String NOME_USUARIO) {
        this.NOME_USUARIO = NOME_USUARIO;
    }

    public String getSENHA_USUARIO() {
        return SENHA_USUARIO;
    }

    public void setSENHA_USUARIO(String SENHA_USUARIO) {
        this.SENHA_USUARIO = SENHA_USUARIO;
    }
}
