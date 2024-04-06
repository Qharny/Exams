package org.example.exams;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button editBtn;

    @FXML
    private MenuItem exitWindow;

    @FXML
    private Label labelArea;

    @FXML
    private Button lockBtn;

    @FXML
    private MenuItem openFile;

    @FXML
    private MenuItem saveFile;

    @FXML
    private TextArea txtArea;

    @FXML
    void onEdit(ActionEvent event) {
        txtArea.setEditable(true);

    }

    @FXML
    void onExit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void onLock(ActionEvent event) {
        txtArea.setEditable(false);

    }

    @FXML
    void onOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            String path = ((File) selectedFile).getAbsolutePath();
            TextArea textArea = new TextArea();

            try {
                String content = new String(Files.readAllBytes(Paths.get(path)));
                txtArea.setText(content);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            txtArea.setText("No File Selected");
        }


    }

    @FXML
    void onSave(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        fileChooser.showOpenDialog(null).getAbsolutePath();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // get the total number of characters in the file
        txtArea.textProperty().addListener((observable, oldValue, newValue) -> {
            labelArea.setText("Characters Types: " + newValue.length());
        });


    }
}

