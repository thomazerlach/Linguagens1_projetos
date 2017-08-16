/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroaluno;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author thomazerlach
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private ImageView imgPerfil;
    
    @FXML private TextField txtNome;
    @FXML private TextField txtIdade;
    @FXML private TextField txtEnd;
    @FXML private TextField txtRg;
    @FXML private TextField txtCpf;
    @FXML private TextField txtPesquisa;
    
    @FXML
    private Label fileSelected;
    
    private Person aluno;
    private Stage dialogStage;
    private String imageFile;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnEscolher;
    @FXML
    private Button btnPesquisar;
    @FXML
    private MenuItem btnSaveAll;

    @FXML
    private void escolherButtonAction(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif")); // limit fileChooser options to image files
        File selectedFile = fileChooser.showOpenDialog(fileSelected.getScene().getWindow());

        if (selectedFile != null) {

            imageFile = selectedFile.toURI().toURL().toString();

            Image image = new Image(imageFile);
            imgPerfil.setImage(image);
        } else {
            fileSelected.setText("Image file selection cancelled.");
        }

    }
    
    @FXML
    private void SalvarNoArquivo(ActionEvent event) {
        String fileName = System.getProperty("user.home")+"/alunos.csv";
        CsvFileWriter.writeCsvFile(fileName);
    }
    
    @FXML
    private void salvarButtonAction(ActionEvent event) {
        if(isInputValid()) {
            aluno.setNome(txtNome.getText());
            aluno.setIdade(txtIdade.getText());
            aluno.setEndereco(txtEnd.getText());
            aluno.setRg(txtRg.getText());
            aluno.setCpf(txtCpf.getText());
            
            CsvFileWriter.addToList(aluno);
        }
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (txtNome.getText() == null || txtNome.getText().length() == 0) {
            errorMessage += "Nome não é válido!\n"; 
        }
        if (txtIdade.getText() == null || txtIdade.getText().length() == 0) {
            errorMessage += "Idade não é válido!\n"; 
        }
        if (txtEnd.getText() == null || txtEnd.getText().length() == 0) {
            errorMessage += "Endereço não é válido!\n"; 
        }

        if (txtRg.getText() == null || txtRg.getText().length() == 0) {
            errorMessage += "RG não é válido!\n"; 
        } 

        if (txtCpf.getText() == null || txtCpf.getText().length() == 0) {
            errorMessage += "CPF não é válido!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
