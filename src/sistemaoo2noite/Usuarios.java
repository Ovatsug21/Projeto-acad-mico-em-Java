
package sistemaoo2noite;

public class Usuarios {
   
    private String NOME_USUARIO; 
    private int SENHA_USUARIO;
    private Clinica Clin;
    
    public Usuarios (){
    
    }

    public String getNOME_USUARIO() {
        return NOME_USUARIO;
    }

    public void setNOME_USUARIO(String NOME_USUARIO) {
        this.NOME_USUARIO = NOME_USUARIO;
    }

    public int getSENHA_USUARIO() {
        return SENHA_USUARIO;
    }

    public void setSENHA_USUARIO(int SENHA_USUARIO) {
        this.SENHA_USUARIO = SENHA_USUARIO;
    }

    public Clinica getClin() {
        return Clin;
    }

    public void setClin(Clinica Clin) {
        this.Clin = Clin;
    }
    
    public Usuarios(String NOME_USUARIO , int SENHA_USUARIO){
    
            this.NOME_USUARIO = NOME_USUARIO;
            this.SENHA_USUARIO = SENHA_USUARIO;
    }
    
}
