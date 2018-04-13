
package sistemaoo2noite;


public class Pacientes {
    
    private int PRONTUARIO;
    private String NOME_PACIENTE;
    private String NOME_MAE;
    private String DATA_NASCIMENTO;
    private String ENDERECO_PACIENTE;
    private String RG_PACIENTE;
    private String CPF_PACIENTE;
    private String EMAIL_PACIENTE;
    private String CONTATO_PACIENTE;
    private Clinica clin;
    
    public Pacientes(){
    
    }
    
    public Pacientes(int PRONTUARIO,String NOME_PACIENTE, String NOME_MAE,String DATA_NASCIMENTO ,
                     String ENDERECO_PACIENTE ,String RG_PACIENTE ,String CPF_PACIENTE ,String EMAIL_PACIENTE ,String CONTATO_PACIENTE){
    
    }

    public int getPRONTUARIO() {
        return PRONTUARIO;
    }

    public void setPRONTUARIO(int PRONTUARIO) {
        this.PRONTUARIO = PRONTUARIO;
    }

    public String getNOME_PACIENTE() {
        return NOME_PACIENTE;
    }

    public void setNOME_PACIENTE(String NOME_PACIENTE) {
        this.NOME_PACIENTE = NOME_PACIENTE;
    }

    public String getNOME_MAE() {
        return NOME_MAE;
    }

    public void setNOME_MAE(String NOME_MAE) {
        this.NOME_MAE = NOME_MAE;
    }

    public String getDATA_NASCIMENTO() {
        return DATA_NASCIMENTO;
    }

    public void setDATA_NASCIMENTO(String DATA_NASCIMENTO) {
        this.DATA_NASCIMENTO = DATA_NASCIMENTO;
    }

    public String getENDERECO_PACIENTE() {
        return ENDERECO_PACIENTE;
    }

    public void setENDERECO_PACIENTE(String ENDERECO_PACIENTE) {
        this.ENDERECO_PACIENTE = ENDERECO_PACIENTE;
    }

    public String getRG_PACIENTE() {
        return RG_PACIENTE;
    }

    public void setRG_PACIENTE(String RG_PACIENTE) {
        this.RG_PACIENTE = RG_PACIENTE;
    }

    public String getCPF_PACIENTE() {
        return CPF_PACIENTE;
    }

    public void setCPF_PACIENTE(String CPF_PACIENTE) {
        this.CPF_PACIENTE = CPF_PACIENTE;
    }

    public String getEMAIL_PACIENTE() {
        return EMAIL_PACIENTE;
    }

    public void setEMAIL_PACIENTE(String EMAIL_PACIENTE) {
        this.EMAIL_PACIENTE = EMAIL_PACIENTE;
    }

    public String getCONTATO_PACIENTE() {
        return CONTATO_PACIENTE;
    }

    public void setCONTATO_PACIENTE(String CONTATO_PACIENTE) {
        this.CONTATO_PACIENTE = CONTATO_PACIENTE;
    }

    public Clinica getClin() {
        return clin;
    }

    public void setClin(Clinica clin) {
        this.clin = clin;
    }


}


