
package sistemaoo2noite;


public class Medicos {
    
    private int CODIGO;
    private String NOME_MEDICO;
    private String CRM;
    private String ESPECIALIDADE;
    private String CPF_MEDICO;
    private Clinica Clin;
    
public Medicos (){

}

public Medicos (int CODIGO, String NOME_MEDICO ,String CRM, String ESPECIALIDADE , String CPF){

        this.CODIGO = CODIGO;
        this.NOME_MEDICO = NOME_MEDICO;
        this.CRM = CRM;
        this.CPF_MEDICO = CPF_MEDICO;
    }

    public int getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(int CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getNOME_MEDICO() {
        return NOME_MEDICO;
    }

    public void setNOME_MEDICO(String NOME_MEDICO) {
        this.NOME_MEDICO = NOME_MEDICO;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getESPECIALIDADE() {
        return ESPECIALIDADE;
    }

    public void setESPECIALIDADE(String ESPECILIDADE) {
        this.ESPECIALIDADE = ESPECILIDADE;
    }

    public String getCPF_MEDICO() {
        return CPF_MEDICO;
    }

    public void setCPF_MEDICO(String CPF_MEDICO) {
        this.CPF_MEDICO = CPF_MEDICO;
    }

    public Clinica getClin() {
        return Clin;
    }

    public void setClin(Clinica Clin) {
        this.Clin = Clin;
    }
    
}
