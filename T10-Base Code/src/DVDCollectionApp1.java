import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DVDCollectionApp1  extends Application {
    private DVDCollection model;

    public DVDCollectionApp1() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();

        // Create the view
        DVDCollectionAppView1  view = new DVDCollectionAppView1();
        //DVDCollectionAppView2  view = new DVDCollectionAppView2(); //used for view2

        aPane.getChildren().add(view);
        view.update(model, 0);

        view.getButtonPane().getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String s = javax.swing.JOptionPane.showInputDialog("Title: ");
                int y;
                int l;

                try {
                    y =  Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Year: "));
                }
                catch (NumberFormatException e){
                    y = 0;
                }

                try {
                    l = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Duration: "));
                }
                catch (NumberFormatException e){
                    l = 0;
                }

                if (s == null){// handles null
                    s = "";
                }

                DVD d = new DVD(s, y, l);
                model.add(d);
                view.update(model, 0);

            }
        });

        view.getButtonPane().getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String selected = view.getTitleList().getSelectionModel().getSelectedItem();

                model.remove(selected);

                view.update(model, 0);

            }
        });

        view.getTitleList().setOnMousePressed(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent mouseEvent) {
                int id = view.getTitleList().getSelectionModel().getSelectedIndex();
                view.update(model, id);

            }
        });

        view.getYearList().setOnMousePressed(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent mouseEvent) {
                int id = view.getYearList().getSelectionModel().getSelectedIndex();
                view.update(model, id);

            }
        });

        view.getLengthList().setOnMousePressed(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent mouseEvent) {
                int id = view.getLengthList().getSelectionModel().getSelectedIndex();
                view.update(model, id);

            }
        });


        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}