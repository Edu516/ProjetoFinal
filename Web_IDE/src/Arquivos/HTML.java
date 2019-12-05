package Arquivos;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class HTML {
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
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
     public void gerarHTML() throws IOException{
        // Conteudo
            

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
            html.append(this.codigo);
            html.append(rodape());
            html.toString();
            // Escreve e fecha arquivo
            gravar_arquivo.printf("%s\n",html);
            arquivo.close();
    }
}
