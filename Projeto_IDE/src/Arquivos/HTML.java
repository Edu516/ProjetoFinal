package Arquivos;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class HTML extends Arquivo{

    
    public static String cabecalho() {
	  StringBuilder html = new StringBuilder(); 
	  html.append("<!DOCTYPE html>\n");
	  html.append("<html>\n");
	  html.append("<head><title>Projeto</title>\n");
	  html.append("<meta charset=\"UTF-8\">\n");
          //para fazer a utilização de aspas no java "/"eu estou entre aspas\""
          html.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"style0.css\">");
          html.append("\n<script type=\"text/javascript\" src=\"Script0.js\"></script>");
          html.append("</head>\n");
          html.append("<body>\n");
	  return html.toString();
    }
    
    public static String rodape() {
	  StringBuilder html = new StringBuilder(); 
	  html.append("</body>\n");
	  html.append("</html>\n");
	  return html.toString();
  }    


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
        int in =texto.indexOf("<body>");
        int fim =texto.indexOf("</body>");        
        texto =texto.substring(in+6, fim);
        return texto;
    }

    @Override
    public void gravar(String cod) throws IOException {
        // Cria arquivo
            File file = new File("Inicio0.html");

            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }

            // Prepara para escrever no arquivo
            FileWriter arquivo = new FileWriter(file.getAbsoluteFile());
            PrintWriter gravar_arquivo = new PrintWriter(arquivo);
            
            // formar padrão HTML
            StringBuilder html = new StringBuilder(); 
            html.append(cabecalho());
            html.append(getCod());
            html.append(rodape());
            html.toString();
            // Escreve e fecha arquivo
            gravar_arquivo.printf("%s\n",html);
            arquivo.close();
    }
}
