/**
 * La classe Persona aiuta la sviluppatore a gestire dati di tipo Persona
 * @since JDK1.0
 */

public class Persona {
    private String nome;
    private String cognome;
    private String codice;

    /**
     * Costruisce un oggetto dato il nome, il cognome e 
     * il codice fiscale (trasformato in automatico in maiuscolo).
     * 
     * Se CF non e' valido, viene lanciata un'eccezione.
     * <strong>CONTROLLO sul CODICE FISCALE:</strong>
     * <ul>
     *  <li>Deve contenere 16 caratteri alfanumerici</li>
     *  <li>Non deve contenere spazi</li>
     *  <li>I primi 6 caratteri devono essere delle consonanti</li>
     *  <li>Il settimo e ottavo carattere devono essere numeri</li>
     * </ul>
     * @param nome Il nome della persona
     * @param cognome Il cognome della persona
     * @param codice Il codice fiscale della persona
     * @throws IllegalArgumentException Se il codice fiscale fornito non e' valido
     */

    public Persona(String nome, String cognome, String codice) {
        this.nome = nome.toUpperCase();
        this.cognome = cognome.toUpperCase();
        if (!validitaCodiceFiscale(codice)) {
            throw new IllegalArgumentException("Codice fiscale non valido");
        }else{
            this.codice = codice.toUpperCase();
        }
    }

    /**
     * restituisce una Stringa contenente il nome della persona
     * @return il nome di un oggetto Persona
     */

    public String getNome() {
        return nome;
    }

    /**
     * assegna una Stringa come nome di una persona
     * @param nome Stringa da assegnare come nome
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * restituisce una Stringa contenente il cognome della persona
     * @return il cognome di un oggetto Persona
     */

    public String getCognome() {
        return cognome;
    }

    /**
     * assegna una Stringa come cognome di una persona
     * @param cognome nuova stringa da assegnare come cognome a un oggetto Persona giÃ  esistente
     */

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Il metodo stabilisce se due persone sono omonime; Restituisce un booleano: 
     * VERO se le due persone hanno lo stesso nome (senza distinzione di maiuscole e minuscole) altrimenti FALSO
     * @param p oggetto Persona
     * @return Vero se le due persone confrontate hanno lo stesso nome, altrimenti falso
     */

    public boolean isOmonimo(Persona p){
        return p.getNome().equals(this.nome);
    }

    //Metodo che permette il controllo della validità del codice fiscale inserito

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
            if (vocali.indexOf(c) != -1 || Character.isDigit(c)) {
                return false;
            }
        }
        if (!Character.isDigit(cod.charAt(6)) || !Character.isDigit(cod.charAt(7))) {
            return false;
        }
        return true;
    }

    /**
     * Restituisce una rappresentazione testuale di un oggetto Persona, nel seguente formato "NOME:xx COGNOME:xx CF:xx"
     * @return La rappresentazione testuale di un oggetto Persona
     */
    
    @Override
    public String toString() {
        return "NOME: " + nome + " COGNOME: " + cognome + " CF: " + codice;
    }
    
}
