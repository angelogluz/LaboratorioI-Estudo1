package local.livraria;

import java.util.Arrays;

/**
 * Classe Livro
 *
 * @author Angelo da Luz
 */
public class Livro {

    private String titulo; // título do livro
    private Capitulo[] capitulos; // lista de capítulos do livro
    private Autor[] autores; // lista de autores do livro
    private String ISBN; // ISBN do livro

    /**
     * Construtor constrói livro com dados recebidos e aloca espaço para vetores
     *
     * @param titulo String título do livro
     * @param ISBN String ISBN do livro
     */
    public Livro(String titulo, String ISBN) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        capitulos = new Capitulo[30];
        autores = new Autor[5];
    }

    /**
     * getCapitulos
     *
     * @return capitulos Capitulo[] lista de capítulos
     */
    public Capitulo[] getCapitulos() {
        return capitulos;
    }

    /**
     * setCapitulos
     *
     * @param capitulos Capitulo[] nova lista de capítulos
     */
    public void setCapitulos(Capitulo[] capitulos) {
        this.capitulos = capitulos;
    }

    /**
     * getAutores
     *
     * @return autores Autor[] lista de autores do livro
     */
    public Autor[] getAutores() {
        return autores;
    }

    /**
     * setAutores
     *
     * @param autores Autor[] nova lista de autores do livro
     */
    public void setAutores(Autor[] autores) {
        this.autores = autores;
    }

    /**
     * getISBN
     *
     * @return ISBN String ISBN do livro
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * setISBN
     *
     * @param ISBN String nova ISBN do livro
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * adicionarCapitulo adiciona capítulo do livro
     *
     * @param titulo String título do capítulo
     * @param texto String texto do capítulo
     * @return a posição em que o capítulo foi inserido, ou -1 caso não tenha
     * sido inserido.
     */
    public int adicionarCapitulo(String titulo, String texto) {
        Capitulo cap = new Capitulo(titulo, texto);
        for (int i = 0; i < capitulos.length; i++) {
            if (capitulos[i] == null) {
                capitulos[i] = cap;
                return i;
            }
        }
        return -1;
    }

    /**
     * removerCapitulo remove capítulo do livro
     *
     * @param cap Capitulo capítulo a ser removido
     * @return a posição do capítulo que foi removido, ou -1 caso não tenha sido
     * removido
     */
    public int removerCapitulo(Capitulo cap) {
        for (int i = 0; i < capitulos.length; i++) {
            if (capitulos[i].equals(cap)) {
                capitulos[i] = null;
                return i;
            }
        }
        return -1;
    }

    /**
     * removerAutor remove autor do livro
     *
     * @param autor Autor autor a ser removido
     * @return a posição do autor que foi removido, ou -1 caso não tenha sido
     * removido
     */
    public int removerAutor(Autor autor) {
        for (int i = 0; i < autores.length; i++) {
            if (autores[i].equals(autor)) {
                autores[i] = null;
                return i;
            }
        }
        return -1;
    }

    /**
     * adicionarAutor adiciona autor do livro
     *
     * @param autor Autor autor do capítulo
     * @return a posição em que o autor foi inserido, ou -1 caso não tenha sido
     * inserido.
     */
    public int adicionarAutor(Autor autor) {
        for (int i = 0; i < autores.length; i++) {
            if (autores[i] == null) {
                autores[i] = autor;
                return i;
            }
        }
        return -1;
    }

    /**
     * toString
     *
     * @return String objeto com título, autores e ISBN
     */
    @Override
    public String toString() {
        return "Livro{" + "Título = " + titulo + ", autores=" + Arrays.toString(autores) + ", ISBN=" + ISBN + '}';
    }

    /**
     * getTitulo
     *
     * @return titulo String título do livro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * setTitulo
     *
     * @param titulo String novo título
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
