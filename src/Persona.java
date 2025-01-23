public class Persona {
    private String nome;
    private String cognome;
    private String codice;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public boolean isOmonimo(Persona p){
        return p.getNome().equals(this.nome);
    }

    private boolean validitaCodiceFiscale(String codice) {
        String cod = codice.toUpperCase();
        if (cod.length() != 16) {
            return false;
        }
        if (cod.contains(" ")) {
            return false;
        }
        String vocali = "AEIOU";
        for (int i = 0; i < 6; i++) {
            char c = cod.charAt(i);
            if (vocali.indexOf(c) != -1) {
                return false;
            }
        }
        if (!Character.isDigit(cod.charAt(6)) || !Character.isDigit(cod.charAt(7))) {
            return false;
        }
        return true;
    }

    public Persona(String nome, String cognome, String codice) {
        this.nome = nome.toUpperCase();
        this.cognome = cognome.toUpperCase();
        if (!validitaCodiceFiscale(codice)) {
            throw new IllegalArgumentException("Codice fiscale non valido");
        }else{
            this.codice = codice.toUpperCase();
        }
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "NOME: " + nome + " COGNOME: " + cognome + " CF: " + codice;
    }
    
}
