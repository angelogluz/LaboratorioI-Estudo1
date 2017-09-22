package local.livraria;

import java.time.LocalDate;
import local.utilidade.Util;

/**
 * Classe Livraria
 *
 * @author Angelo da Luz
 */
public class Livraria {

    private Livro[] livros; // lista de livros

    /**
     * Construtor aloca espaço para 100 livros e chama o menu
     *
     * @throws InterruptedException
     */
    public Livraria() throws InterruptedException {
        livros = new Livro[100];
        menu();
    }

    /**
     * menu interação com o usuário
     *
     * @throws InterruptedException
     */
    private void menu() throws InterruptedException {
        int escolha = 0; // escolha do usuário no menu
        do {
            // menu de opções
            System.out.println("+===================================================================+");
            System.out.println("|           Livraria Jalee                                          |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("| 1. Cadastrar novo livro                                           |");
            System.out.println("| 2. Remover livro do acervo                                        |");
            System.out.println("| 3. Listar acervo                                                  |");
            System.out.println("| 4. Resetar livraria                                               |");
            System.out.println("| 5. Modificar Livro do Acervo                                      |");
            System.out.println("| 6. Listar capítulos de livro                                      |");
            System.out.println("| 9. Sair                                                           |");
            System.out.println("+-------------------------------------------------------------------+");
            try {
                escolha = Util.leInteiro("Escolha uma opção: "); // lê um inteiro
                switch (escolha) {
                    case 1:
                        cadastrarLivro(); // chama o cadastro de livro
                        break;
                    case 2:
                        removerLivro(); // chama a remoção de livro
                        break;
                    case 3:
                        listarAcervo(); // chama a listagem de acervo
                        break;
                    case 4:
                        resetarLivraria(); // chama 
                        break;
                    case 5:
                        modificarLivroDoAcervo(); // chama a modificação de livro do acervo
                        break;
                    case 6:
                        listarCapitulos(); // chama a listagem de capítulos
                        break;
                    case 9: // fim do programa
                        break;
                    default: // outras digitações
                        System.err.println("Opção inválida!");
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage()); // mensagem de erro de digitação inválida
                Thread.sleep(1000);
            }
        } while (escolha != 9); // enquanto não sair do programa
    }

    /**
     * cadastrarLivro cadastra novo livro
     *
     *
     * @return a posição do livro cadastrado, ou -1 se não houve o cadastramento
     * @throws Exception
     */
    private int cadastrarLivro() throws Exception {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                String titulo = Util.leString("Digite o Título do livro: ");
                String isbn = Util.leString("Digite o ISBN: ");
                Livro livro = new Livro(titulo, isbn);
                System.out.println("+-------------------------------------------------------------------+");
                int numeroDeAutores = Util.leInteiro("Digite o número de autores a cadastrar: ");
                cadastraAutores(livro, numeroDeAutores);
                int numeroDeCapitulos = Util.leInteiro("Digite o número de capítulos a cadastrar: ");
                cadastraCapitulos(livro, numeroDeCapitulos);
                livros[i] = livro;
                return i;
            }
        }
        return -1;
    }

    /**
     * cadastraAutores cadastra novos autores em um livro
     *
     * @param livro Livro livro a inserir os capítulos
     * @param numeroDeAutores int número de autores a inserir
     * @throws Exception
     */
    private void cadastraAutores(Livro livro, int numeroDeAutores) throws Exception {
        for (int j = 0; j < numeroDeAutores; j++) {
            System.out.println("Cadastro de Autor (" + (j + 1) + "/" + (numeroDeAutores) + ")");
            String nome = Util.leString("Digite o nome do autor: ");
            Autor autor = new Autor(nome);
            LocalDate data = Util.leLocalDate("Digite a data de nascimento do autor: ");
            autor.setDataDeNascimento(data);
            livro.adicionarAutor(autor);
        }
        System.out.println("+-------------------------------------------------------------------+");
    }

    /**
     * cadastraCapitulos cadastra novos capítulos em um livro
     *
     * @param livro Livro livro a inserir os capítulos
     * @param numeroDeCapitulos int número de capítulos a inserir
     * @throws Exception
     */
    private void cadastraCapitulos(Livro livro, int numeroDeCapitulos) throws Exception {
        for (int j = 0; j < numeroDeCapitulos; j++) {
            System.out.println("Cadastro de Capitulos (" + (j + 1) + "/" + (numeroDeCapitulos) + ")");
            String titulo = Util.leString("Digite o titulo do capítulo: ");
            String texto = Util.leString("Digite o texto do capítulo: ");
            livro.adicionarCapitulo(titulo, texto);
        }
        System.out.println("+-------------------------------------------------------------------+");
    }

    /**
     * adicionarAutorLivro adiciona um autor para o livro
     *
     * @param livro Livro livro a adicionar o autor
     * @throws Exception
     */
    private void adicionarAutorLivro(Livro livro) throws Exception {
        Autor autor = new Autor(Util.leString("Digite o nome do autor: "));
        autor.setDataDeNascimento(Util.leLocalDate("Digite a data de nascimento (dd/MM/YYYY): "));
        livro.adicionarAutor(autor);
    }

    /**
     * adicionarCapituloLivro adiciona um capítulo para o livro
     *
     * @param livro Livro livro a adicionar o capítulo
     * @throws Exception
     */
    private void adicionarCapituloLivro(Livro livro) {
        livro.adicionarCapitulo(Util.leString("Digite o capítulo do Livro: "),
                Util.leString("Digite o texto do capítulo: "));
    }

    /**
     * removerLivro remove livro do id digitado
     *
     * @throws Exception
     */
    private void removerLivro() throws Exception {
        listarAcervo();
        int id = Util.leInteiro("Digite o id do livro: ");
        try {
            livros[id] = null;
        } catch (Exception ex) {
            throw new Exception("Não foi possível remover este livro");
        }
    }

    /**
     * listarCapitulos lista todos os capítulos do livro
     *
     * @param livro Livro livro a serem listados os capítulos
     */
    private void listarCapitulos(Livro livro) {
        Capitulo[] capitulos = livro.getCapitulos();
        for (int i = 0; i < capitulos.length; i++) {
            if (capitulos[i] != null) {
                System.out.printf("Capítulo %d - %s\n", i + 1, capitulos[i]);
            }
        }
    }

    /**
     * listarAcervo lista todos os livros
     */
    private void listarAcervo() {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null) {
                System.out.printf("[%d] %s", i, livros[i] + "\n");
            }
        }
    }

    /**
     * resetarLivraria apaga todos os livros
     */
    private void resetarLivraria() {
        for (int i = 0; i < livros.length; i++) {
            livros[i] = null;
        }
    }

    /**
     * modificarLivroDoAcervo insere novo capítulo ou novo autor ao livro
     *
     * @throws Exception
     */
    private void modificarLivroDoAcervo() throws Exception {
        listarAcervo();
        int id = Util.leInteiro("Digite o id do livro: ");
        System.out.println("+===================================================================+");
        System.out.println("|                       Livraria Jalee                              |");
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("| 1. Inserir novo capítulo                                          |");
        System.out.println("| 2. Inserir novo autor                                             |");
        System.out.println("+-------------------------------------------------------------------+");
        int escolha = Util.leInteiro("Escolha uma opção:");

        switch (escolha) {
            case 1:
                adicionarCapituloLivro(livros[id]);
                break;
            case 2:
                adicionarAutorLivro(livros[id]);
                break;
            default:
                System.err.println("Opção inválida! Operação cancelada.");
        }

    }

    /**
     * listarCapitulos lista todos os capítulos de um livro
     *
     * @throws Exception
     */
    private void listarCapitulos() throws Exception {
        listarAcervo();
        int idDoLivro = Util.leInteiro("Digite id do livro que deseja ver os capítulos: ");
        listarCapitulos(livros[idDoLivro]);
    }
}
