package local.livraria;

import java.time.LocalDate;

/**
 * Classe Autor
 *
 * @author Angelo da Luz
 */
public class Autor {

    private String nome; // nome do autor
    private LocalDate dataDeNascimento; // data de nascimento do autor

    /**
     * Construtor constrói o autor com dado recebido
     *
     * @param nome String nome do autor
     */
    public Autor(String nome) {
        this.nome = nome;
    }

    /**
     * getNome
     *
     * @return nome String nome do autor
     */
    public String getNome() {
        return nome;
    }

    /**
     * setNome
     *
     * @param nome String novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * getDataDeNascimento
     *
     * @return dataDeNascimento data de nascimento do autor
     */
    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    /**
     * setDataDeNascimento
     *
     * @param dataDeNascimento LocalDate nova data de nascimento
     */
    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     * toString
     *
     * @return String objeto com nome do autor
     */
    @Override
    public String toString() {
        return "Autor{" + "nome=" + nome + '}';
    }

}
