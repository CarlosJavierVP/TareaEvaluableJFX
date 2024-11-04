package org.example.ejercicioevaluablejfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage ventana;

    @Override
    public void start(Stage stage) throws IOException {
        ventana = stage;

        loadFXML("views/main-view.fxml","Ejericio Evaluable JFX");
        stage.show();
    }

    public static void loadFXML(String view, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(view  ));
        Scene scene = null;
        try{
            scene = new Scene(fxmlLoader.load(),1000, 400);
        }catch (IOException e){
            throw new IOException(e.getMessage());
        }

        ventana.setTitle("Hello!");
        ventana.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}