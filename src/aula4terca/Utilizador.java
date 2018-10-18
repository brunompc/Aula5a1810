
package aula4terca;

public class Utilizador {
    
    String username;
    String password;
    
    int nrTentativasFalhadas = 0;
    long horaDesbloqueio = -1;
    
    boolean verificarCredenciais(String username, String password) {
        
        // verificar se passou o tempo de bloqueio
        if(System.currentTimeMillis() > horaDesbloqueio) {
            nrTentativasFalhadas = 0;
            horaDesbloqueio = -1;
        }
        
        // verificar se continua bloqueado
        if(horaDesbloqueio > 0) {
            return false;
        }
        
        if(this.username.equals(username) && this.password.equals(password)) {
            return true;
        }
        else {
            nrTentativasFalhadas++;
            if(nrTentativasFalhadas == 3) {
                // bloquear
                int quatroHoras = 4 * 60 * 60 * 1000;
                horaDesbloqueio = System.currentTimeMillis() + quatroHoras;
            }
            return false;
        }
    }
}
