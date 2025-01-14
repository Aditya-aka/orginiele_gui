module org.guardiansofthewasteland.orginiele_gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javax.servlet.api;
    requires jbcrypt;


    opens org.guardiansofthewasteland.orginiele_gui to javafx.fxml;
    exports org.guardiansofthewasteland.orginiele_gui;
}