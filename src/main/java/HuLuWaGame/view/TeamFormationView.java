package HuLuWaGame.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import HuLuWaGame.controller.UIController;
import HuLuWaGame.model.Creature;
import HuLuWaGame.model.Game;
import HuLuWaGame.network.NetClient;
import HuLuWaGame.network.NetServer;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class TeamFormationView extends Application {

    public ArrayList<Creature> list = new ArrayList<Creature>(8);

    //1-葫芦娃阵营；2-妖怪阵营
    private int FACTION;

    private Stage stage = new Stage();
    private ImageView chessboard = new ImageView();
    private ImageView chessmen_1 = new ImageView();
    private TextField text_1 = new TextField("(1,B)");
    private ImageView chessmen_2 = new ImageView();
    private TextField text_2 = new TextField("(1,C)");
    private ImageView chessmen_3 = new ImageView();
    private TextField text_3 = new TextField("(1,D)");
    private ImageView chessmen_4 = new ImageView();
    private TextField text_4 = new TextField("(1,E)");
    private ImageView chessmen_5 = new ImageView();
    private TextField text_5 = new TextField("(1,F)");
    private ImageView chessmen_6 = new ImageView();
    private TextField text_6 = new TextField("(1,G)");
    private ImageView chessmen_7 = new ImageView();
    private TextField text_7 = new TextField("(1,H)");
    private ImageView chessmen_8 = new ImageView();
    private TextField text_8 = new TextField("(1,I)");
    private Button button = new Button("OK");

    public TeamFormationView(int i) {
        FACTION=i;
        if(FACTION==1) {
            Creature grandpa = new Creature("Grandpa");
            Creature firsthuluwa = new Creature("FirstHuluwa");
            Creature secondhuluwa = new Creature("SecondHuluwa");
            Creature thirdhuluwa = new Creature("ThirdHuluwa");
            Creature fourthhuluwa = new Creature("FourthHuluwa");
            Creature fifthhuluwa = new Creature("FifthHuluwa");
            Creature sixthhuluwa = new Creature("SixthHuluwa");
            Creature seventhhuluwa = new Creature("SeventhHuluwa");
            list.add(grandpa);list.add(firsthuluwa);list.add(secondhuluwa);list.add(thirdhuluwa);
            list.add(fourthhuluwa);list.add(fifthhuluwa);list.add(sixthhuluwa);list.add(seventhhuluwa);
        }
        else {
            Creature tornedron = new Creature("Tornedron");
            Creature serpent = new Creature("Serpent");
            Creature centipede = new Creature("Centipede");
            Creature toad = new Creature("Toad");
            Creature bat = new Creature("Bat");
            Creature spider = new Creature("Spider");
            Creature jia = new Creature("Jia");
            Creature yi = new Creature("Yi");
            list.add(tornedron);list.add(serpent);list.add(centipede);list.add(toad);
            list.add(bat);list.add(spider);list.add(jia);list.add(yi);
        }
        try {
            init();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void init() throws Exception{
        super.init();

        //1 - init Height & Width
        //1-1 stage
        stage.setHeight(600);
        stage.setWidth(1000);
        //1-2 imageviews
        chessboard.setFitHeight(300);
        chessboard.setFitWidth(550);
        chessmen_1.setFitHeight(50);
        chessmen_1.setFitWidth(50);
        chessmen_2.setFitHeight(50);
        chessmen_2.setFitWidth(50);
        chessmen_3.setFitHeight(50);
        chessmen_3.setFitWidth(50);
        chessmen_4.setFitHeight(50);
        chessmen_4.setFitWidth(50);
        chessmen_5.setFitHeight(50);
        chessmen_5.setFitWidth(50);
        chessmen_6.setFitHeight(50);
        chessmen_6.setFitWidth(50);
        chessmen_7.setFitHeight(50);
        chessmen_7.setFitWidth(50);
        chessmen_8.setFitHeight(50);
        chessmen_8.setFitWidth(50);
        //1-3 textfields
        text_1.setPrefHeight(40);
        text_1.setPrefWidth(50);
        text_2.setPrefHeight(40);
        text_2.setMaxWidth(50);
        text_3.setPrefHeight(40);
        text_3.setPrefWidth(50);
        text_4.setPrefHeight(40);
        text_4.setMaxWidth(50);
        text_5.setPrefHeight(40);
        text_5.setPrefWidth(50);
        text_6.setPrefHeight(40);
        text_6.setMaxWidth(50);
        text_7.setPrefHeight(40);
        text_7.setPrefWidth(50);
        text_8.setPrefHeight(40);
        text_8.setMaxWidth(50);
        //1-4 button
        button.setPrefHeight(20);
        button.setPrefWidth(50);

        //2 - init content
        //2-1 init stage
        stage.setTitle("调整你的布局站位");
        //2-2 init images
        if(FACTION==1) {
            URL url = getClass().getClassLoader().getResource("ChessBoard.png");
            chessboard.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Grandpa.png");
            chessmen_1.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("FirstHuluwa.png");
            chessmen_2.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("SecondHuluwa.png");
            chessmen_3.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("ThirdHuluwa.png");
            chessmen_4.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("FourthHuluwa.png");
            chessmen_5.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("FifthHuluwa.png");
            chessmen_6.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("SixthHuluwa.png");
            chessmen_7.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("SeventhHuluwa.png");
            chessmen_8.setImage(new Image(url.toString()));
        }
        else {
            URL url = getClass().getClassLoader().getResource("ChessBoard.png");
            chessboard.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Tornedron.png");
            chessmen_1.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Serpent.png");
            chessmen_2.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Centipede.png");
            chessmen_3.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Toad.png");
            chessmen_4.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Bat.png");
            chessmen_5.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Spider.png");
            chessmen_6.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Jia.png");
            chessmen_7.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Yi.png");
            chessmen_8.setImage(new Image(url.toString()));
        }
        //3 - init layout
        //3-1 imageviews
        chessboard.setLayoutX(225);
        chessboard.setLayoutY(10);
        chessmen_1.setLayoutX(65);
        chessmen_1.setLayoutY(350);
        chessmen_2.setLayoutX(180);
        chessmen_2.setLayoutY(350);
        chessmen_3.setLayoutX(295);
        chessmen_3.setLayoutY(350);
        chessmen_4.setLayoutX(410);
        chessmen_4.setLayoutY(350);
        chessmen_5.setLayoutX(525);
        chessmen_5.setLayoutY(350);
        chessmen_6.setLayoutX(640);
        chessmen_6.setLayoutY(350);
        chessmen_7.setLayoutX(755);
        chessmen_7.setLayoutY(350);
        chessmen_8.setLayoutX(870);
        chessmen_8.setLayoutY(350);
        //3-2 textfield
        text_1.setLayoutX(65);
        text_1.setLayoutY(410);
        text_2.setLayoutX(180);
        text_2.setLayoutY(410);
        text_3.setLayoutX(295);
        text_3.setLayoutY(410);
        text_4.setLayoutX(410);
        text_4.setLayoutY(410);
        text_5.setLayoutX(525);
        text_5.setLayoutY(410);
        text_6.setLayoutX(640);
        text_6.setLayoutY(410);
        text_7.setLayoutX(755);
        text_7.setLayoutY(410);
        text_8.setLayoutX(870);
        text_8.setLayoutY(410);
        //3-3 button
        button.setLayoutX(475);
        button.setLayoutY(500);

        //4 - init action
        //4-1 button
        button.setOnMouseClicked((MouseEvent e) -> {show_battleview();});
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }
    
    public void show() throws Exception {
        Pane pane = new Pane();
        pane.getChildren().addAll(chessboard,chessmen_1,chessmen_2,chessmen_3,chessmen_4,chessmen_5,chessmen_6,chessmen_7,chessmen_8,text_1,text_2,text_3,text_4,text_5,text_6,text_7,text_8,button);
        Scene scene = new Scene(pane,1000,600);
        stage.setScene(scene);
        start(stage);
    }

    public void get_data() {
        String text1 = this.text_1.getText();
        String text2 = this.text_2.getText();
        String text3 = this.text_3.getText();
        String text4 = this.text_4.getText();
        String text5 = this.text_5.getText();
        String text6 = this.text_6.getText();
        String text7 = this.text_7.getText();
        String text8 = this.text_8.getText();
        if(FACTION==1) {
            this.list.get(0).set_position_x('5'-text1.charAt(1));
            this.list.get(0).set_position_y(text1.charAt(3)-'A');
            this.list.get(1).set_position_x('5'-text2.charAt(1));
            this.list.get(1).set_position_y(text2.charAt(3)-'A');
            this.list.get(2).set_position_x('5'-text3.charAt(1));
            this.list.get(2).set_position_y(text3.charAt(3)-'A');
            this.list.get(3).set_position_x('5'-text4.charAt(1));
            this.list.get(3).set_position_y(text4.charAt(3)-'A');
            this.list.get(4).set_position_x('5'-text5.charAt(1));
            this.list.get(4).set_position_y(text5.charAt(3)-'A');
            this.list.get(5).set_position_x('5'-text6.charAt(1));
            this.list.get(5).set_position_y(text6.charAt(3)-'A');
            this.list.get(6).set_position_x('5'-text7.charAt(1));
            this.list.get(6).set_position_y(text7.charAt(3)-'A');
            this.list.get(7).set_position_x('5'-text8.charAt(1));
            this.list.get(7).set_position_y(text8.charAt(3)-'A');
        }
        else {
            this.list.get(0).set_position_x(text1.charAt(1)-'0'+4);
            this.list.get(0).set_position_y(text1.charAt(3)-'A');
            this.list.get(1).set_position_x(text2.charAt(1)-'0'+4);
            this.list.get(1).set_position_y(text2.charAt(3)-'A');
            this.list.get(2).set_position_x(text3.charAt(1)-'0'+4);
            this.list.get(2).set_position_y(text3.charAt(3)-'A');
            this.list.get(3).set_position_x(text4.charAt(1)-'0'+4);
            this.list.get(3).set_position_y(text4.charAt(3)-'A');
            this.list.get(4).set_position_x(text5.charAt(1)-'0'+4);
            this.list.get(4).set_position_y(text5.charAt(3)-'A');
            this.list.get(5).set_position_x(text6.charAt(1)-'0'+4);
            this.list.get(5).set_position_y(text6.charAt(3)-'A');
            this.list.get(6).set_position_x(text7.charAt(1)-'0'+4);
            this.list.get(6).set_position_y(text7.charAt(3)-'A');
            this.list.get(7).set_position_x(text8.charAt(1)-'0'+4);
            this.list.get(7).set_position_y(text8.charAt(3)-'A');
        }
    }

    public void show_battleview() {
        get_data();
        BattleView battleview = new BattleView(this.FACTION,this.list);
        Game new_game = new Game(0,this.list);
        if(this.FACTION==1) {
            NetServer server = new NetServer();
            server.start();
        }
        else {
            NetClient client = new NetClient();
            client.start();
        }
        try {
            while(Game.list_enemy.size()==0){
                TimeUnit.SECONDS.sleep(2);
            }
            Game.set_state(1);
            battleview.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        stage.close();
    }
}
