package atv1;

import atv1.PessoaBusiness;


public class Principal {
    
    public static void main(String[] args) {

        Pessoa p = new Pessoa("Paulo", 30);

        PessoaBusiness pb = new PessoaBusiness();
        pb.aprovarPessoa(p);
    }
}
