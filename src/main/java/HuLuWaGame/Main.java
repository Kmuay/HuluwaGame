package HuLuWaGame;

import java.net.URL;
import HuLuWaGame.view.PrepareSPLView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class Main extends Application{

    private Stage stage = new Stage();
    private ImageView imageview = new ImageView();
    private Button button_offline = new Button("作为服务器");
    private Button button_online = new Button("作为客户端");

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("葫芦娃 VS 妖怪");
        primaryStage.setHeight(600);
        primaryStage.setWidth(1000);
        primaryStage.setResizable(false);
        Pane pane = new Pane();

        //添加半屏图片
        pane.getChildren().add(imageview);

        //添加服务器按钮
        //TODO : 等待有客户端的连接
        button_offline.setOnMouseClicked((MouseEvent e) -> {show_preparesplview(1);});
        pane.getChildren().add(button_offline);

        //添加客户端按钮
        //TODO ：输入服务器IP，连接，
        button_online.setOnMouseClicked((MouseEvent e) -> {show_preparesplview(2);});
        pane.getChildren().add(button_online);

        Scene scene = new Scene(pane,1000,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        //init imageview
        URL url = getClass().getClassLoader().getResource("OpenPageImage.png");
        Image image = new Image(url.toString());
        imageview.setImage(image);
        imageview.setFitWidth(1000);
        imageview.setFitHeight(300);

        //init button_offline
        button_offline.setLayoutX(400);
        button_offline.setLayoutY(330);
        button_offline.setStyle("-fx-font: 30 arial;");

        //init button_online
        button_online.setLayoutX(400);
        button_online.setLayoutY(430);
        button_online.setStyle("-fx-font: 30 arial;");
    }
    
    private void show_preparesplview(int i) {
        PrepareSPLView preparesplview = new PrepareSPLView(i);
        try {
            preparesplview.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
