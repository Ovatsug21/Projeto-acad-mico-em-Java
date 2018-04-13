
package sistemaoo2noite;


public class Agendamento {
    
    private int ID_AGENDAMENTO;
    private Pacientes PRONTUARIO;// COLOQUEI PACIENTES PRA PEGAR O PRONTUÁRIO DELE
    private String DATA_HORA;
    private Medicos CRM;// MESMA COISA AQUI,PORÉM NÃO SEI SE ESTÁ CORRETO.
    private String PROCEDIMENTOS;
    
    
    public Agendamento(){
    
    }
    
    public Agendamento(int ID_AGENDAMENTO , Pacientes PRONTUARIO , String DATA_HORA , Medicos CRM ,String PROCEDIMENTOS){
        
        this.CRM = CRM;
        this.DATA_HORA = DATA_HORA;
        this.ID_AGENDAMENTO = ID_AGENDAMENTO;
        this.PROCEDIMENTOS = PROCEDIMENTOS;
        this.PRONTUARIO = PRONTUARIO;
    }

    public int getID_AGENDAMENTO() {
        return ID_AGENDAMENTO;
    }

    public void setID_AGENDAMENTO(int ID_AGENDAMENTO) {
        this.ID_AGENDAMENTO = ID_AGENDAMENTO;
    }

    public Pacientes getPRONTUARIO() {
        return PRONTUARIO;
    }

    public void setPRONTUARIO(Pacientes PRONTUARIO) {
        this.PRONTUARIO = PRONTUARIO;
    }

    public String getDATA_HORA() {
        return DATA_HORA;
    }

    public void setDATA_HORA(String DATA_HORA) {
        this.DATA_HORA = DATA_HORA;
    }

    public Medicos getCRM() {
        return CRM;
    }

    public void setCRM(Medicos CRM) {
        this.CRM = CRM;
    }

    public String getPROCEDIMENTOS() {
        return PROCEDIMENTOS;
    }

    public void setPROCEDIMENTOS(String PROCEDIMENTOS) {
        this.PROCEDIMENTOS = PROCEDIMENTOS;
    }
}
