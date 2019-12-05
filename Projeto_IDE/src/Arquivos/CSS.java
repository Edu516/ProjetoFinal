package Arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CSS extends Arquivo {

    @Override
    public String ler(File Arquivo) {
        String texto="";
        try {
            FileReader arq = new FileReader(Arquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
            texto = texto +linha;
            while (linha != null) {

                linha = lerArq.readLine(); // lê da segunda até a última linha
                texto = texto+linha+"\n";
            }

            arq.close();
        } catch (IOException e) {
            
                    
        }
        return texto;
    }

        @Override
        public void gravar(String cod) throws IOException
        {
            // Conteudo

            // Cria arquivo
            File file = new File("style0.css");

            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }

            // Prepara para escrever no arquivo
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Escreve e fecha arquivo
            bw.write(cod);
            bw.close();
        }

    }
