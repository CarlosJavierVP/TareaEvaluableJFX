package org.example.ejercicioevaluablejfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.ejercicioevaluablejfx.models.User;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class MainController implements Initializable {

    @FXML
    private CheckBox checkBoxAdmin;
    @FXML
    private ChoiceBox<String> choiceBoxPlatform;
    @FXML
    private Button btnAdd;
    @FXML
    private TableColumn<User,String> columnPLataforma;
    @FXML
    private TableColumn<User, String> columnFecha;
    @FXML
    private TableView<User> tablaUsuarios;
    @FXML
    private TableColumn<User, String> columnCorreo;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TableColumn<User, String> columnAdmin;
    @FXML
    private Spinner<Integer> txtVersionSoftware;
    @FXML
    private Button btnLimpiar;


    @FXML
    public void addUser(ActionEvent actionEvent) {
        if (txtCorreo.getText() == null || txtCorreo.getText().isEmpty() || choiceBoxPlatform.getValue() == null
                || txtVersionSoftware.getValue() == null ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");

        }else{
            User newUser = new User();
            newUser.setCorreo(txtCorreo.getText());
            newUser.setPlataforma(choiceBoxPlatform.getValue());
            txtVersionSoftware.getValueFactory().setValue(txtVersionSoftware.getValue());
            newUser.setVersionSoftware(txtVersionSoftware.getValueFactory().getValue());
            newUser.setAdministrador(checkBoxAdmin.getText());
            newUser.setFechaRegistro(LocalDate.parse(LocalDate.now().toString()));

            tablaUsuarios.getItems().clear();

            tablaUsuarios.getItems().add(newUser);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtVersionSoftware.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,5,1,1));
        choiceBoxPlatform.getItems().addAll("Windows","Linux","MacOs");

        columnCorreo.setCellValueFactory((fila)-> {
            return new SimpleStringProperty(fila.getValue().getCorreo());
        });
        columnPLataforma.setCellValueFactory((fila)->{
          return new SimpleStringProperty(fila.getValue().getPlataforma()+" "+fila.getValue().getVersionSoftware());
        });
        columnFecha.setCellValueFactory((fila)->{
            return new SimpleStringProperty(fila.getValue().getFechaRegistro().toString() );
        });
        columnAdmin.setCellValueFactory((fila)->{
         return new SimpleStringProperty(fila.getValue().getAdministrador());
        });


    }

    @FXML
    public void borrar(ActionEvent actionEvent) {

    }
}