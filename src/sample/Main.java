package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;

public class Main extends Application {

    public Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("Views/login.fxml"));
        primaryStage.setTitle("Financial App");
        Scene sc = new Scene(root, 800, 600);
        sc.getStylesheets().add("sample/Styles/DarkTheme.css");
        primaryStage.setScene(sc);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {

        I18N.getInstance().setLocale(Locale.getDefault());
        launch(args);
    }
}
