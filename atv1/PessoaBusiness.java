package atv1;

import atv1.Pessoa;

public class PessoaBusiness {
    
    public boolean aprovado;

    void aprovarPessoa(Pessoa pessoa) {
        aprovado = pessoa.idade > 18;
    }
}
