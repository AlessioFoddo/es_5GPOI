public class App {
    public static void main(String[] args) throws Exception {
        try {
            Persona persona = new Persona("Mario", "Rossi", "BCDFGH12ABCD3456");
            System.out.println(persona.toString());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            Persona personaInvalida = new Persona("Luca", "Verdi", "ABCD1234INVALIDCF");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); // Stampa "Codice fiscale non valido"
        }
    }
}
