package aula;

public class PrincipalCarro {
    public static void main(String args[]) {

        Carro obj = new Carro();

        obj.setModelo("Uno Mille");
        obj.setPlaca("NRC 1234");
        obj.setQntPorta(4);

        Carro obj2 = new Carro();

        obj2.setModelo("Uno Way");
        obj2.setPlaca("NRC 1254");
        obj2.setQntPorta(4);

        if(obj == obj2) {
            System.out.println("O objeto é igual");
        } else {
            System.out.println("Objento é diferente");
        }
    }
}
