package local.utilidade;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe Util
 *
 * @author Angelo da Luz
 */
public class Util {

    /**
     * leInteiro lê um valor inteiro
     *
     * @param mensagem String mensagem de solicitação do valor inteiro
     * @return int o número inteiro lido
     * @throws Exception caso não seja número inteiro
     */
    public static int leInteiro(String mensagem) throws Exception {
        int x = 0;
        try {
            Scanner in = new Scanner(System.in);
            System.out.print(mensagem);
            x = in.nextInt();
        } catch (InputMismatchException ex) {
            throw new IOException("entrada inválida");
        }
        return x;
    }

    /**
     * leString lê uma string
     *
     * @param mensagem String mensagem de solicitação da string
     * @return String a string lida
     */
    public static String leString(String mensagem) {
        String x;

        Scanner in = new Scanner(System.in);
        System.out.print(mensagem);
        x = in.nextLine();

        return x;
    }

    /**
     * leLocalDate lê uma data
     *
     * @param mensagem String data com barras
     * @return a data em formato LocalDate
     * @throws java.lang.Exception caso a data não respeite o formato
     */
    public static LocalDate leLocalDate(String mensagem) throws Exception {
        try {
            String[] partesData = leString(mensagem).split("/");
            return LocalDate.of(Integer.parseInt(partesData[2]), Integer.parseInt(partesData[1]), Integer.parseInt(partesData[0]));
        } catch (Exception ex) {
            throw new Exception("Formato inválido para data. Favor usar DD/MM/YYYY");
        }
    }
}
