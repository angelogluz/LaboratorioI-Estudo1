package local.livraria;

import java.util.Objects;

/**
 * Classe Capitulo
 *
 * @author Angelo da Luz
 */
public class Capitulo {

    private String titulo; // título do capítulo
    private String texto; // texto do capítulo

    /**
     * Construtor constroi o capítulo
     */
    public Capitulo() {
    }

    /**
     * Construtor constrói o capitulo com dados recebidos
     *
     * @param titulo String titulo do capitulo
     * @param texto String texto do capitulo
     */
    public Capitulo(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    /**
     * hashCode
     *
     * @return hash int hash recalculada
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.titulo);
        hash = 67 * hash + Objects.hashCode(this.texto);
        return hash;
    }

    /**
     * equals
     *
     * @param obj Object objeto
     * @return false se nulo, se objetos diferentes, se dados diferentes
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Capitulo other = (Capitulo) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        return true;
    }

    /**
     * getTitulo
     *
     * @return titulo String título do capítulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * setTitulo
     *
     * @param titulo String novo titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * getTexto
     *
     * @return texto String texto do capítulo
     */
    public String getTexto() {
        return texto;
    }

    /**
     * setTexto
     *
     * @param texto String novo texto
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * toString
     *
     * @return titulo String título do capítulo
     */
    @Override
    public String toString() {
        return titulo;
    }

}
