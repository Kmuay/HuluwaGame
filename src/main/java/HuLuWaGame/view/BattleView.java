package HuLuWaGame.view;

import java.util.ArrayList;

import HuLuWaGame.model.Creature;
import HuLuWaGame.model.Game;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.net.URL;
import javafx.scene.input.MouseEvent;

public class BattleView extends Application {

    //1-葫芦娃阵营；2-妖怪阵营
    private int FACTION;

    //己方棋子状态队列
    private ArrayList<Creature> list = new ArrayList<Creature>(8);

    private Stage stage = new Stage();
    //战场，纯展示，无任何Action接口
    private static ChessBoardView chessboard = new ChessBoardView();

    //移动按钮，选择一个方向按钮
    private Button button_up = new Button();
    private Button button_down = new Button();
    private Button button_left = new Button();
    private Button button_right = new Button();

    //攻击目标按钮，选择一个敌方英雄
    private Button firstenemy = new Button();
    private Button secondenemy = new Button();
    private Button thirdenemy = new Button();
    private Button fourthenemy = new Button();
    private Button fifthenemy = new Button();
    private Button sixthenemy = new Button();
    private Button seventhenemy = new Button();
    private Button eighthenemy = new Button();

    //技能释放按钮
    private Button skill = new Button();

    //己方英雄状态栏，图片+HP+MP
    private ImageView firstsoldier = new ImageView();
    private Label hp_firstsoldier = new Label("HP:0");
    private Label mp_firstsoldier = new Label("MP:0");
    private ImageView secondsoldier = new ImageView();
    private Label hp_secondsoldier = new Label("HP:0");
    private Label mp_secondsoldier = new Label("MP:0");
    private ImageView thirdsoldier = new ImageView();
    private Label hp_thirdsoldier = new Label("HP:0");
    private Label mp_thirdsoldier = new Label("MP:0");
    private ImageView fourthsoldier = new ImageView();
    private Label hp_fourthsoldier = new Label("HP:0");
    private Label mp_fourthsoldier = new Label("MP:0");
    private ImageView fifthsoldier = new ImageView();
    private Label hp_fifthsoldier = new Label("HP:0");
    private Label mp_fifthsoldier = new Label("MP:0");
    private ImageView sixthsoldier = new ImageView();
    private Label hp_sixthsoldier = new Label("HP:0");
    private Label mp_sixthsoldier = new Label("MP:0");
    private ImageView seventhsoldier = new ImageView();
    private Label hp_seventhsoldier = new Label("HP:0");
    private Label mp_seventhsoldier = new Label("MP:0");
    private ImageView eighthsoldier = new ImageView();
    private Label hp_eighthsoldier = new Label("HP:0");
    private Label mp_eighthsoldier = new Label("MP:0");

    public BattleView(int j, ArrayList<Creature> Alist) {
        FACTION=j;
        this.list = Alist;
        try {
            init();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }

    @Override
    public void init() throws Exception{
        super.init();

        //1 - init height & width
        stage.setHeight(750);
        stage.setWidth(1000);
        //1-1 移动 & 技能 button
        button_up.setPrefHeight(40);
        button_up.setPrefWidth(40);
        button_down.setPrefHeight(40);
        button_down.setPrefWidth(40);
        button_left.setPrefHeight(40);
        button_left.setPrefWidth(40);
        button_right.setPrefHeight(40);
        button_right.setPrefWidth(40);
        skill.setPrefHeight(40);
        skill.setPrefWidth(40);
        //1-2 敌方 button
        firstenemy.setPrefHeight(40);
        firstenemy.setPrefWidth(40);
        secondenemy.setPrefHeight(40);
        secondenemy.setPrefWidth(40);
        thirdenemy.setPrefHeight(40);
        thirdenemy.setPrefWidth(40);
        fourthenemy.setPrefHeight(40);
        fourthenemy.setPrefWidth(40);
        fifthenemy.setPrefHeight(40);
        fifthenemy.setPrefWidth(40);
        sixthenemy.setPrefHeight(40);
        sixthenemy.setPrefWidth(40);
        seventhenemy.setPrefHeight(40);
        seventhenemy.setPrefWidth(40);
        eighthenemy.setPrefHeight(40);
        eighthenemy.setPrefWidth(40);
        //1-3 己方 imageview+hp_label+mp_label
        firstsoldier.setFitHeight(80);
        firstsoldier.setFitWidth(80);
        hp_firstsoldier.setPrefHeight(30);
        hp_firstsoldier.setPrefWidth(80);
        mp_firstsoldier.setPrefHeight(30);
        mp_firstsoldier.setPrefWidth(80);

        secondsoldier.setFitHeight(80);
        secondsoldier.setFitWidth(80);
        hp_secondsoldier.setPrefHeight(30);
        hp_secondsoldier.setPrefWidth(80);
        mp_secondsoldier.setPrefHeight(30);
        mp_secondsoldier.setPrefWidth(80);

        thirdsoldier.setFitHeight(80);
        thirdsoldier.setFitWidth(80);
        hp_thirdsoldier.setPrefHeight(30);
        hp_thirdsoldier.setPrefWidth(80);
        mp_thirdsoldier.setPrefHeight(30);
        mp_thirdsoldier.setPrefWidth(80);

        fourthsoldier.setFitHeight(80);
        fourthsoldier.setFitWidth(80);
        hp_fourthsoldier.setPrefHeight(30);
        hp_fourthsoldier.setPrefWidth(80);
        mp_fourthsoldier.setPrefHeight(30);
        mp_fourthsoldier.setPrefWidth(80);

        fifthsoldier.setFitHeight(80);
        fifthsoldier.setFitWidth(80);
        hp_fifthsoldier.setPrefHeight(30);
        hp_fifthsoldier.setPrefWidth(80);
        mp_fifthsoldier.setPrefHeight(30);
        mp_fifthsoldier.setPrefWidth(80);

        sixthsoldier.setFitHeight(80);
        sixthsoldier.setFitWidth(80);
        hp_sixthsoldier.setPrefHeight(30);
        hp_sixthsoldier.setPrefWidth(80);
        mp_sixthsoldier.setPrefHeight(30);
        mp_sixthsoldier.setPrefWidth(80);

        seventhsoldier.setFitHeight(80);
        seventhsoldier.setFitWidth(80);
        hp_seventhsoldier.setPrefHeight(30);
        hp_seventhsoldier.setPrefWidth(80);
        mp_seventhsoldier.setPrefHeight(30);
        mp_seventhsoldier.setPrefWidth(80);

        eighthsoldier.setFitHeight(80);
        eighthsoldier.setFitWidth(80);
        hp_eighthsoldier.setPrefHeight(30);
        hp_eighthsoldier.setPrefWidth(80);
        mp_eighthsoldier.setPrefHeight(30);
        mp_eighthsoldier.setPrefWidth(80);

        //2 - init content
        stage.setTitle("葫芦娃 VS 妖精");
        //2-1 移动 & 技能 button
        ImageView imageview1 = new ImageView();
        imageview1.setFitHeight(40);
        imageview1.setFitWidth(40);
        URL url = getClass().getClassLoader().getResource("Up.png");
        imageview1.setImage(new Image(url.toString()));
        button_up.setGraphic(imageview1);

        ImageView imageview2 = new ImageView();
        imageview2.setFitHeight(40);
        imageview2.setFitWidth(40);
        url = getClass().getClassLoader().getResource("Down.png");
        imageview2.setImage(new Image(url.toString()));
        button_down.setGraphic(imageview2);

        ImageView imageview3 = new ImageView();
        imageview3.setFitHeight(40);
        imageview3.setFitWidth(40);
        url = getClass().getClassLoader().getResource("Left.png");
        imageview3.setImage(new Image(url.toString()));
        button_left.setGraphic(imageview3);

        ImageView imageview4 = new ImageView();
        imageview4.setFitHeight(40);
        imageview4.setFitWidth(40);
        url = getClass().getClassLoader().getResource("Right.png");
        imageview4.setImage(new Image(url.toString()));
        button_right.setGraphic(imageview4);

        ImageView imageview5 = new ImageView();
        imageview5.setFitHeight(40);
        imageview5.setFitWidth(40);
        url = getClass().getClassLoader().getResource("Skill.png");
        imageview5.setImage(new Image(url.toString()));
        skill.setGraphic(imageview5);
        //2-2 敌方 button
        if(FACTION==1) {
            ImageView imageview6 = new ImageView();
            imageview6.setFitHeight(40);
            imageview6.setFitWidth(40);
            url = getClass().getClassLoader().getResource("Tornedron.png");
            imageview6.setImage(new Image(url.toString()));
            firstenemy.setGraphic(imageview6);

            ImageView imageview7 = new ImageView();
            imageview7.setFitHeight(40);
            imageview7.setFitWidth(40);
            url = getClass().getClassLoader().getResource("Serpent.png");
            imageview7.setImage(new Image(url.toString()));
            secondenemy.setGraphic(imageview7);

            ImageView imageview8 = new ImageView();
            imageview8.setFitHeight(40);
            imageview8.setFitWidth(40);
            url = getClass().getClassLoader().getResource("Centipede.png");
            imageview8.setImage(new Image(url.toString()));
            thirdenemy.setGraphic(imageview8);

            ImageView imageview9 = new ImageView();
            imageview9.setFitHeight(40);
            imageview9.setFitWidth(40);
            url = getClass().getClassLoader().getResource("Toad.png");
            imageview9.setImage(new Image(url.toString()));
            fourthenemy.setGraphic(imageview9);

            ImageView imageviewa = new ImageView();
            imageviewa.setFitHeight(40);
            imageviewa.setFitWidth(40);
            url = getClass().getClassLoader().getResource("Bat.png");
            imageviewa.setImage(new Image(url.toString()));
            fifthenemy.setGraphic(imageviewa);

            ImageView imageviewb = new ImageView();
            imageviewb.setFitHeight(40);
            imageviewb.setFitWidth(40);
            url = getClass().getClassLoader().getResource("Spider.png");
            imageviewb.setImage(new Image(url.toString()));
            sixthenemy.setGraphic(imageviewb);

            ImageView imageviewc = new ImageView();
            imageviewc.setFitHeight(40);
            imageviewc.setFitWidth(40);
            url = getClass().getClassLoader().getResource("Jia.png");
            imageviewc.setImage(new Image(url.toString()));
            seventhenemy.setGraphic(imageviewc);

            ImageView imageviewd = new ImageView();
            imageviewd.setFitHeight(40);
            imageviewd.setFitWidth(40);
            url = getClass().getClassLoader().getResource("Yi.png");
            imageviewd.setImage(new Image(url.toString()));
            eighthenemy.setGraphic(imageviewd);
        }
        else {
            ImageView imageview6 = new ImageView();
            imageview6.setFitHeight(40);
            imageview6.setFitWidth(40);
            url = getClass().getClassLoader().getResource("Grandpa.png");
            imageview6.setImage(new Image(url.toString()));
            firstenemy.setGraphic(imageview6);

            ImageView imageview7 = new ImageView();
            imageview7.setFitHeight(40);
            imageview7.setFitWidth(40);
            url = getClass().getClassLoader().getResource("FirstHuluwa.png");
            imageview7.setImage(new Image(url.toString()));
            secondenemy.setGraphic(imageview7);

            ImageView imageview8 = new ImageView();
            imageview8.setFitHeight(40);
            imageview8.setFitWidth(40);
            url = getClass().getClassLoader().getResource("SecondHuluwa.png");
            imageview8.setImage(new Image(url.toString()));
            thirdenemy.setGraphic(imageview8);

            ImageView imageview9 = new ImageView();
            imageview9.setFitHeight(40);
            imageview9.setFitWidth(40);
            url = getClass().getClassLoader().getResource("ThirdHuluwa.png");
            imageview9.setImage(new Image(url.toString()));
            fourthenemy.setGraphic(imageview9);

            ImageView imageviewa = new ImageView();
            imageviewa.setFitHeight(40);
            imageviewa.setFitWidth(40);
            url = getClass().getClassLoader().getResource("FourthHuluwa.png");
            imageviewa.setImage(new Image(url.toString()));
            fifthenemy.setGraphic(imageviewa);

            ImageView imageviewb = new ImageView();
            imageviewb.setFitHeight(40);
            imageviewb.setFitWidth(40);
            url = getClass().getClassLoader().getResource("FifthHuluwa.png");
            imageviewb.setImage(new Image(url.toString()));
            sixthenemy.setGraphic(imageviewb);

            ImageView imageviewc = new ImageView();
            imageviewc.setFitHeight(40);
            imageviewc.setFitWidth(40);
            url = getClass().getClassLoader().getResource("SixthHuluwa.png");
            imageviewc.setImage(new Image(url.toString()));
            seventhenemy.setGraphic(imageviewc);

            ImageView imageviewd = new ImageView();
            imageviewd.setFitHeight(40);
            imageviewd.setFitWidth(40);
            url = getClass().getClassLoader().getResource("SeventhHuluwa.png");
            imageviewd.setImage(new Image(url.toString()));
            eighthenemy.setGraphic(imageviewd);
        }
        //2-3 己方 imageview+hp_label
        if(FACTION==1) {
            url = getClass().getClassLoader().getResource("Grandpa.png");
            firstsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("FirstHuluwa.png");
            secondsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("SecondHuluwa.png");
            thirdsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("ThirdHuluwa.png");
            fourthsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("FourthHuluwa.png");
            fifthsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("FifthHuluwa.png");
            sixthsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("SixthHuluwa.png");
            seventhsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("SeventhHuluwa.png");
            eighthsoldier.setImage(new Image(url.toString()));
        }
        else {
            url = getClass().getClassLoader().getResource("Tornedron.png");
            firstsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Serpent.png");
            secondsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Centipede.png");
            thirdsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Toad.png");
            fourthsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Bat.png");
            fifthsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Spider.png");
            sixthsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Jia.png");
            seventhsoldier.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Yi.png");
            eighthsoldier.setImage(new Image(url.toString()));
        } 
        hp_firstsoldier.setText("HP:"+list.get(0).get_hp());
        hp_secondsoldier.setText("HP:"+list.get(1).get_hp());
        hp_thirdsoldier.setText("HP:"+list.get(2).get_hp());
        hp_fourthsoldier.setText("HP:"+list.get(3).get_hp());
        hp_fifthsoldier.setText("HP:"+list.get(4).get_hp());
        hp_sixthsoldier.setText("HP:"+list.get(5).get_hp());
        hp_seventhsoldier.setText("HP:"+list.get(6).get_hp());
        hp_eighthsoldier.setText("HP:"+list.get(7).get_hp());

        renew_chessboard(Game.list_self, Game.list_enemy);

        //3 - init layout
        //3-1 移动 & 技能 button
        button_up.setLayoutX(555);
        button_up.setLayoutY(105);
        button_down.setLayoutX(620);
        button_down.setLayoutY(105);
        button_left.setLayoutX(685);
        button_left.setLayoutY(105);
        button_right.setLayoutX(750);
        button_right.setLayoutY(105);
        skill.setLayoutX(815);
        skill.setLayoutY(105);
        //3-2 敌方 button
        firstenemy.setLayoutX(583);
        firstenemy.setLayoutY(240);
        secondenemy.setLayoutX(651);
        secondenemy.setLayoutY(240);
        thirdenemy.setLayoutX(719);
        thirdenemy.setLayoutY(240);
        fourthenemy.setLayoutX(787);
        fourthenemy.setLayoutY(240);
        fifthenemy.setLayoutX(583);
        fifthenemy.setLayoutY(375);
        sixthenemy.setLayoutX(651);
        sixthenemy.setLayoutY(375);
        seventhenemy.setLayoutX(719);
        seventhenemy.setLayoutY(375);
        eighthenemy.setLayoutX(787);
        eighthenemy.setLayoutY(375);
        //3-3 己方 imageview+hp_label+mp_label
        firstsoldier.setLayoutX(25);
        firstsoldier.setLayoutY(550);
        secondsoldier.setLayoutX(135);
        secondsoldier.setLayoutY(550);
        thirdsoldier.setLayoutX(245);
        thirdsoldier.setLayoutY(550);
        fourthsoldier.setLayoutX(355);
        fourthsoldier.setLayoutY(550);
        fifthsoldier.setLayoutX(465);
        fifthsoldier.setLayoutY(550);
        sixthsoldier.setLayoutX(575);
        sixthsoldier.setLayoutY(550);
        seventhsoldier.setLayoutX(685);
        seventhsoldier.setLayoutY(550);
        eighthsoldier.setLayoutX(795);
        eighthsoldier.setLayoutY(550);
        hp_firstsoldier.setLayoutX(25);
        hp_firstsoldier.setLayoutY(640);
        hp_secondsoldier.setLayoutX(135);
        hp_secondsoldier.setLayoutY(640);
        hp_thirdsoldier.setLayoutX(245);
        hp_thirdsoldier.setLayoutY(640);
        hp_fourthsoldier.setLayoutX(355);
        hp_fourthsoldier.setLayoutY(640);
        hp_fifthsoldier.setLayoutX(465);
        hp_fifthsoldier.setLayoutY(640);
        hp_sixthsoldier.setLayoutX(575);
        hp_sixthsoldier.setLayoutY(640);
        hp_seventhsoldier.setLayoutX(685);
        hp_seventhsoldier.setLayoutY(640);
        hp_eighthsoldier.setLayoutX(795);
        hp_eighthsoldier.setLayoutY(640);
        mp_firstsoldier.setLayoutX(25);
        mp_firstsoldier.setLayoutY(680);
        mp_secondsoldier.setLayoutX(135);
        mp_secondsoldier.setLayoutY(680);
        mp_thirdsoldier.setLayoutX(245);
        mp_thirdsoldier.setLayoutY(680);
        mp_fourthsoldier.setLayoutX(355);
        mp_fourthsoldier.setLayoutY(680);
        mp_fifthsoldier.setLayoutX(465);
        mp_fifthsoldier.setLayoutY(680);
        mp_sixthsoldier.setLayoutX(575);
        mp_sixthsoldier.setLayoutY(680);
        mp_seventhsoldier.setLayoutX(685);
        mp_seventhsoldier.setLayoutY(680);
        mp_eighthsoldier.setLayoutX(795);
        mp_eighthsoldier.setLayoutY(680);
        
        //4 - init action
        //TODO : 上下左右攻击键，技能键
        button_up.setOnMouseClicked((MouseEvent e) -> {System.out.println("up");});
    }

    public void show() throws Exception {
        Pane pane = new Pane();
        //chessboard
        for(int i=0; i<100; i++) {
            pane.getChildren().add(chessboard.get(i));
        }
        //移动 & 技能 button
        pane.getChildren().addAll(button_up,button_down,button_left,button_right,skill);
        //敌方 button
        pane.getChildren().addAll(firstenemy,secondenemy,thirdenemy,fourthenemy,fifthenemy,sixthenemy,seventhenemy,eighthenemy);
        //己方 imageview+hp_label+mp_label
        pane.getChildren().addAll(firstsoldier,secondsoldier,thirdsoldier,fourthsoldier,fifthsoldier,sixthsoldier,seventhsoldier,eighthsoldier);
        pane.getChildren().addAll(hp_firstsoldier,hp_secondsoldier,hp_thirdsoldier,hp_fourthsoldier,hp_fifthsoldier,hp_sixthsoldier,hp_seventhsoldier,hp_eighthsoldier);
        pane.getChildren().addAll(mp_firstsoldier,mp_secondsoldier,mp_thirdsoldier,mp_fourthsoldier,mp_fifthsoldier,mp_sixthsoldier,mp_seventhsoldier,mp_eighthsoldier);

        Scene scene = new Scene(pane,1000,750);
        stage.setScene(scene);
        start(stage);
    }

    public void renew_chessboard(ArrayList<Creature> list_self,ArrayList<Creature> list_enemy) {
        for(int i=0; i<list_self.size(); i++) {
            int position_x = list_self.get(i).get_position_x();
            int position_y = list_self.get(i).get_position_y();
            String name = list_self.get(i).get_name();
            System.out.println(name+".png");
            URL url = getClass().getClassLoader().getResource(name+".png");
            BattleView.chessboard.get(position_x + position_y * 10).setImage(new Image(url.toString()));
        }
        for(int i=0; i<list_enemy.size(); i++) {
            int position_x = list_enemy.get(i).get_position_x();
            int position_y = list_enemy.get(i).get_position_y();
            String name = list_enemy.get(i).get_name();
            System.out.println(name+".png");
            URL url = getClass().getClassLoader().getResource(name+".png");
            BattleView.chessboard.get(position_x + position_y * 10).setImage(new Image(url.toString()));
        }
    }
}
