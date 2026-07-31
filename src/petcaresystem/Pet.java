package petcaresystem;

public class Pet {

    private int id;
    private String nome;
    private String especie;
    private Cliente dono;

    public Pet(int id, String nome, String especie, Cliente dono) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public Cliente getDono() {
        return dono;
    }

    public int getId() {
        return id;
    }

    public String getEspecie() {
        return especie;
    }
}
