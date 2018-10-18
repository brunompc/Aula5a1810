
package aula4terca;

public class Utilizador {
    
    String username;
    String password;
    
    int nrTentativasFalhadas = 0;
    long horaDesbloqueio = -1;
    
    boolean verificarCredenciais(String username, String password) {
        
        if(System.currentTimeMillis() > horaDesbloqueio) {
            nrTentativasFalhadas = 0;
            horaDesbloqueio = -1;
        }
        
        if(horaDesbloqueio > 0) {
            return false;
        }
        
        if(this.username.equals(username) && this.password.equals(password)) {
            return true;
        }
        else {
            nrTentativasFalhadas++;
            if(nrTentativasFalhadas == 3) {
                horaDesbloqueio = System.currentTimeMillis() + 4 * 60 * 60 * 1000;
            }
            return false;
        }
    }
}