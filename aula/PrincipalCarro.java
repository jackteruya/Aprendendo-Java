package aula;

public class PrincipalCarro {
    public static void main(String args[]) {

        Carro obj = new Carro();

        obj.setMarca("FIAT");
        obj.setModelo("Uno Mille");
        obj.setPlaca("MQK 1235");

        Carro obj2 = new Carro();

        obj2.setMarca("BMW");
        obj2.setModelo("X1");
        obj2.setPlaca("PLD 1235");


        System.out.println(obj.getInformacoes());
        System.out.println(obj2.getInformacoes());
    }
}
