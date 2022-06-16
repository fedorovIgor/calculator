package com.fedorovigor.calculator.config;

import com.fedorovigor.calculator.view.calculator.CalculatorController;
import com.fedorovigor.calculator.view.history.HistoryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;

public class FxmlFilesLoader {


    private final ViewModelFactory viewModelFactory;

    public enum FileToLoad {
        HISTORY("/com/fedorovigor/calculator/history_view.fxml"),
        SOME("/com/fedorovigor/calculator/some.fxml"),
        CALCULATOR("/com/fedorovigor/calculator/calculator_view.fxml");

        private String path;

        FileToLoad(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }

    public FxmlFilesLoader(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    private void initializeNode(FXMLLoader loader, FileToLoad loadFile) {
        if (FileToLoad.CALCULATOR.equals(loadFile)) {
            var calculator = (CalculatorController)loader.getController();
            calculator.init(viewModelFactory.getCalculatorViewModel(),
                    load(FileToLoad.HISTORY));
        }
        else if (FileToLoad.HISTORY.equals(loadFile)) {
            var calculator = (HistoryController)loader.getController();
            calculator.init(viewModelFactory.getHistoryViewModel());
        }
    }

    public Node load(FileToLoad loadFile) {

        Node loadedNode = null;
        FXMLLoader loader = new FXMLLoader();

        try {
            String path = loadFile.getPath();
            URL location = getClass().getResource(path);
            loader.setLocation(location);
            loadedNode = loader.load();

            initializeNode(loader, loadFile);
        }
        catch (IOException e) {
            throw new FileSystemNotFoundException(" can`t load file " + loadFile.getPath() + "\n" + e);
        }

        return loadedNode;
    }
}

