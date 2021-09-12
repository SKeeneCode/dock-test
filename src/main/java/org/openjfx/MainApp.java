package org.openjfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainApp extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        DetachableTabPane tabPane = new DetachableTabPane();

        VBox left = new VBox();
        SplitPane right = new SplitPane(tabPane);

        HBox root = new HBox(left, right);
        Scene scene = new Scene(root);
        root.setPrefWidth(600);
        root.setPrefHeight(400);
        stage.setTitle("JavaFX and Gradle");
        stage.setScene(scene);
        stage.show();


        tabPane.getTabs().add(createTab());
        tabPane.setPrefWidth(500);

        Button addTabsQuicklyButton = new Button("add tabs quickly (works)");
        addTabsQuicklyButton.setOnAction(event -> {
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
        });

        Button addTabsQuicklyButton2 = new Button("add tabs quickly (errors out)");
        addTabsQuicklyButton2.setOnAction(event -> {
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
            tabPane.placeTab(createTab(), Pos.TOP_CENTER);
            tabPane.placeTab(createTab(), Pos.CENTER_RIGHT);
        });

        left.getChildren().add(addTabsQuicklyButton);
        left.getChildren().add(addTabsQuicklyButton2);

    }

    private Tab createTab() {
        Tab tab = new Tab();
        StackPane center = new StackPane();
        center.setAlignment(Pos.CENTER);
        Button addLeft = new Button("add left");
        Button addRight = new Button("add right");
        Button addAbove = new Button("add above");
        Button addBelow = new Button("add below");
        Button addCenter = new Button("add center");
        center.getChildren().addAll(addLeft, addRight, addAbove, addBelow, addCenter);
        addLeft.setTranslateX(-70);
        addRight.setTranslateX(70);
        addAbove.setTranslateY(-50);
        addBelow.setTranslateY(50);

        addLeft.setOnAction(event -> {((DetachableTabPane) tab.getTabPane()).placeTab(createTab(), Pos.CENTER_LEFT);});
        addRight.setOnAction(event -> {((DetachableTabPane) tab.getTabPane()).placeTab(createTab(), Pos.CENTER_RIGHT);});
        addAbove.setOnAction(event -> {((DetachableTabPane) tab.getTabPane()).placeTab(createTab(), Pos.TOP_CENTER);});
        addBelow.setOnAction(event -> {((DetachableTabPane) tab.getTabPane()).placeTab(createTab(), Pos.BOTTOM_CENTER);});
        addCenter.setOnAction(event -> {tab.getTabPane().getTabs().add(createTab());});

        tab.setContent(center);
        tab.setText("Tab");
        return tab;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
