package aula;

public class Carro {
    private String modelo;
    private int qntPorta;
    private String placa;
    private String motor;
    private static String marca;

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getInformacoes() {
        return "Marca: "+marca + " modelo: "+modelo + " placa: "+placa;
    }

    public Carro(String placa) {
        this.setPlaca(placa);
    }

    public Carro(String motor, String modelo) {
        this.setMotor(motor);
        this.setModelo(modelo);
    }

    public Carro(){
        this.setPlaca("A definir");
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQntPorta() {
        return qntPorta;
    }

    public void setQntPorta(int qntPorta) {
        this.qntPorta = qntPorta;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMotor() {
        return this.motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    private boolean estaAcelerando = false;

    public void acelerar() {
        estaAcelerando = true;
        if(motor == null) {
            this.setMotor("Motor 1.0");
        }
        System.out.println("Acelerando com motor: " +motor);
    }

    public void para() {
        this.ligarLuzFreio();
        this.desacelerar();
        System.out.println("Carro parado");
    }

    private void desacelerar() {
        if(estaAcelerando == true) {
            System.out.println("Desacelerando...");
        }
        estaAcelerando = false;
    }

    private void ligarLuzFreio() {
        System.out.println("Ligando Luz de freio");
    }
}
