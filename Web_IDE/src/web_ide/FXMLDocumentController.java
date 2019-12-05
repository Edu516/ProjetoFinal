/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_ide;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author eduardo
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private WebView Navegador;

    @FXML
    private TextArea HTML;

    @FXML
    private TextArea CSS;

    @FXML
    private TextArea JScript;

    @FXML
    private Button Importar;

    @FXML
    private Button Exportar;

    @FXML
    private Button Sair;

    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        WebEngine engine = Navegador.getEngine();
        engine.load("https://www.google.com.br/");
    }
}
