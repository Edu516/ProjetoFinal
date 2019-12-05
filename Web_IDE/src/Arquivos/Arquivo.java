/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class Arquivo {
    public char[] lerDados(File arquivo) throws IOException {
        char[] texto = new char[500];
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            br.read(texto);
            return texto;

        } catch (FileNotFoundException ex) {
            
        } 
        return texto;
    }

    
}
