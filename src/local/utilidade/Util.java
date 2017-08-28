/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.utilidade;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author angelodaluz
 */
public class Util {
    
    /** 
     * Método para leitura de número inteiros
     * @param mensagem
     * @return mensagem de resultado da operação
     * @throws Exception 
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
     * Método para leitura de Strings
     * @param mensagem
     * @return mensagem de resultado da operação
     */
    
    public static String leString(String mensagem) {
        String x;
        
        Scanner in = new Scanner(System.in);
        System.out.print(mensagem);
        x = in.nextLine();
        
        return x;
    }

    /**
     * Método de Leitura de Datas
     * @param mensagem
     * @return a data em formato LocalDate
     * @throws java.lang.Exception caso a data não respeite o formato
     */
    public static LocalDate leLocalDate(String mensagem) throws Exception {
        
        try {
            
            String[] partesData = leString(mensagem).split("/");
            return LocalDate.of(Integer.parseInt(partesData[2]), Integer.parseInt(partesData[1]), Integer.parseInt(partesData[0]));
        } catch (Exception ex) {
            throw new Exception("Formato inválido para Data. Favor usar dd/MM/YYYY");
        }
    }
}
