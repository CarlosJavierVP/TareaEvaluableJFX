module org.example.ejercicioevaluablejfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jfr;
    requires java.desktop;
    requires static lombok;


    opens org.example.ejercicioevaluablejfx to javafx.fxml;
    exports org.example.ejercicioevaluablejfx;
}