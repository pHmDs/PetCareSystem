package petcaresystem;

public class Consulta {

    private int id;
    private String data;
    private double valor;
    private Pet pet;

    public Consulta(int id, String data, double valor, Pet pet) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.pet = pet;
    }

    public void exibirResumo() {
        System.out.println("=== COMPROVANTE DE CONSULTA ===");
        // ... resto do método ...
        System.out.println("===============================");
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public Pet getPet() {
        return pet;
    }
}
