package HuLuWaGame.view;

import java.net.URL;
import java.util.ArrayList;

import HuLuWaGame.model.Creature;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class PrepareSPLView extends Application{
    
    //1-葫芦娃阵营；2-妖怪阵营
    private int FACTION;

    private Stage stage = new Stage();
    private CustomControl firstcontrol = new CustomControl();
    private CustomControl secondcontrol = new CustomControl();
    private CustomControl thirdcontrol = new CustomControl();
    private CustomControl fourthcontrol = new CustomControl();
    private CustomControl fifthcontrol = new CustomControl();
    private CustomControl sixthcontrol = new CustomControl();
    private CustomControl seventhcontrol = new CustomControl();
    private CustomControl eighthcontrol = new CustomControl();
    private Label label = new Label("Tips : 你拥有的总技能点数为960.");
    private Button button = new Button("OK");

    public PrepareSPLView(int i) {
        FACTION = i;
        try{
            init();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void show() throws Exception {
        HBox hbox = new HBox();
        hbox.getChildren().addAll(firstcontrol.getCustomControl(),secondcontrol.getCustomControl(),thirdcontrol.getCustomControl(),fourthcontrol.getCustomControl(),fifthcontrol.getCustomControl(),sixthcontrol.getCustomControl(),seventhcontrol.getCustomControl(),eighthcontrol.getCustomControl());
        Pane pane = new Pane();
        pane.getChildren().add(hbox);
        pane.getChildren().add(label);
        pane.getChildren().add(button);
        Scene scene = new Scene(pane,1000,600);
        stage.setScene(scene);
        start(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();

        //init stage
        stage.setTitle("分配你的点数");
        stage.setHeight(600);
        stage.setWidth(1000);

        //init images
        if(FACTION==1) {
            URL url = getClass().getClassLoader().getResource("Grandpa.png");
            firstcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("FirstHuluwa.png");
            secondcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("SecondHuluwa.png");
            thirdcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("ThirdHuluwa.png");
            fourthcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("FourthHuluwa.png");
            fifthcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("FifthHuluwa.png");
            sixthcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("SixthHuluwa.png");
            seventhcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("SeventhHuluwa.png");
            eighthcontrol.setImage(new Image(url.toString()));
        }
        else {
            URL url = getClass().getClassLoader().getResource("Tornedron.png");
            firstcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Serpent.png");
            secondcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Centipede.png");
            thirdcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Toad.png");
            fourthcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Bat.png");
            fifthcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Spider.png");
            sixthcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Jia.png");
            seventhcontrol.setImage(new Image(url.toString()));
            url = getClass().getClassLoader().getResource("Yi.png");
            eighthcontrol.setImage(new Image(url.toString()));
        }
        //init label
        label.setPrefHeight(20);
        label.setPrefWidth(300);
        label.setLayoutX(430);
        label.setLayoutY(440);

        //init button
        button.setPrefHeight(20);
        button.setPrefWidth(50);
        button.setLayoutX(490);
        button.setLayoutY(480);
        button.setOnMouseClicked((MouseEvent e) -> {show_teamformationview();});
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }

    public void get_data(ArrayList<Creature> list) {
        list.get(0).set_hp(this.firstcontrol.get_life());
        list.get(0).set_attack(this.firstcontrol.get_attack());
        list.get(0).set_range(this.firstcontrol.get_range());

        list.get(1).set_hp(this.secondcontrol.get_life());
        list.get(1).set_attack(this.secondcontrol.get_attack());
        list.get(1).set_range(this.secondcontrol.get_range());

        list.get(2).set_hp(this.thirdcontrol.get_life());
        list.get(2).set_attack(this.thirdcontrol.get_attack());
        list.get(2).set_range(this.thirdcontrol.get_range());

        list.get(3).set_hp(this.fourthcontrol.get_life());
        list.get(3).set_attack(this.fourthcontrol.get_attack());
        list.get(3).set_range(this.fourthcontrol.get_range());

        list.get(4).set_hp(this.fifthcontrol.get_life());
        list.get(4).set_attack(this.fifthcontrol.get_attack());
        list.get(4).set_range(this.fifthcontrol.get_range());

        list.get(5).set_hp(this.sixthcontrol.get_life());
        list.get(5).set_attack(this.sixthcontrol.get_attack());
        list.get(5).set_range(this.sixthcontrol.get_range());

        list.get(6).set_hp(this.seventhcontrol.get_life());
        list.get(6).set_attack(this.seventhcontrol.get_attack());
        list.get(6).set_range(this.seventhcontrol.get_range());

        list.get(7).set_hp(this.eighthcontrol.get_life());
        list.get(7).set_attack(this.eighthcontrol.get_attack());
        list.get(7).set_range(this.eighthcontrol.get_range());
    }

    public void show_teamformationview() {
        TeamFormationView teamformationview = new TeamFormationView(this.FACTION);
        get_data(teamformationview.list);
        try {
            teamformationview.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        stage.close();
    }
}
