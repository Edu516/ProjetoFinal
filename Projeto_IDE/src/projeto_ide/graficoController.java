/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_ide;

import Arquivos.CSS;
import Arquivos.HTML;
import Arquivos.javaScript;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 *
 * @author eduardo
 */
public class graficoController implements Initializable {
    private String uri;

    @FXML
    private WebView Navegador;

    @FXML
    private TextArea HTML;

    @FXML
    private TextArea CSS;

    @FXML
    private TextArea Jscript;

    @FXML
    private Button Salvar;

    @FXML
    private Button e_css;

    @FXML
    private Button e_html;

    @FXML
    private Button e_js;

    @FXML
    private Button Pesquisa;

    @FXML
    private Button BD;

    @FXML
    private Button Executa;

    @FXML
    void Banco(ActionEvent event) {
        WebEngine navegador = Navegador.getEngine();
        navegador.load("http://localhost/phpmyadmin");
    }

    @FXML
    void Pesquisa(ActionEvent event) {
        WebEngine navegador = Navegador.getEngine();
        navegador.load("https://www.google.com.br/");
    }

    @FXML
    void Salvar(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Exportar");
        Window Stage = null;
        CSS cs = new CSS();
        HTML ht = new HTML();
        javaScript js = new javaScript();
        cs.setCod(CSS.getText());
        cs.gravar(CSS.getText());
        ht.setCod(HTML.getText());
        ht.gravar(HTML.getText());
        js.setCod(Jscript.getText());
        js.gravar(Jscript.getText());
        
        //fileChooser.showSaveDialog(Stage);
    }

    @FXML
    void executar(ActionEvent event) {
         
        WebEngine navegador = Navegador.getEngine();
        navegador.setJavaScriptEnabled(true);
        navegador.load(uri);
        navegador.reload();
    }

    @FXML
    void getCss(ActionEvent event) {
        CSS cod =new CSS();
        FileChooser importar = new FileChooser();
        importar.setTitle("Importar CSS");
        Window Stage = null;
        
        File arquivo =importar.showOpenDialog(Stage);
        String texto = cod.ler(arquivo);
        CSS.setText(texto);
    }

    @FXML
    void getHtml(ActionEvent event) {
        HTML htl = new HTML();
        FileChooser importar = new FileChooser();
        importar.setTitle("Importar HTML");
        Window Stage = null;
        
        File arquivo =importar.showOpenDialog(Stage);
        String texto = htl.ler(arquivo);
        HTML.setText(texto);
    }

    @FXML
    void getJscript(ActionEvent event) {
        javaScript js =new javaScript();
        FileChooser importar = new FileChooser();
        importar.setTitle("Importar CSS");
        Window Stage = null;
        
        File arquivo =importar.showOpenDialog(Stage);
        String texto = js.ler(arquivo);
        Jscript.setText(texto);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Bem-Vindo IDEWeb");
        dialogoInfo.setHeaderText("Localize ou crie uma pagina html inicial");
        dialogoInfo.showAndWait();
        FileChooser importar = new FileChooser();
        importar.setTitle("Importar");
        Window Stage = null;
        WebEngine navegador = Navegador.getEngine();
        uri ="file://"+importar.showOpenDialog(Stage);
        navegador.load(uri);
        navegador.setJavaScriptEnabled(true);

    }
       
    
}
