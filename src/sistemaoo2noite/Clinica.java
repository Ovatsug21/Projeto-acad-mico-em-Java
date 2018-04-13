package sistemaoo2noite;
public class Clinica {
    
    private int senha;
    private String nomeProfissional;
    
    public Clinica(int senha,String nomeProfissional) {
    
        this.senha = senha;
        this.nomeProfissional = nomeProfissional;
    }    
    public Clinica (){
    }    

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }


   
}
