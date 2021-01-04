package HuLuWaGame.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CustomControl {

    //general controls
    private ImageView imageview = new ImageView();
    private Label life = new Label("生命值:");
    private Label attack = new Label("攻击力:");
    private Label speed = new Label("攻击速度:");
    private Label range = new Label("攻击距离:");
    private TextField textlife = new TextField("100");
    private TextField textattack = new TextField("10");
    private TextField textspeed = new TextField("16");
    private TextField textrange = new TextField("8");

    //monolithic control
    private VBox vbox = new VBox();

    public CustomControl() {
        //set imageview
        imageview.setFitHeight(125);
        imageview.setFitWidth(125);

        //set labels & textfield
        life.setPrefHeight(40);
        life.setPrefWidth(55);
        textlife.setPrefHeight(40);
        textlife.setPrefWidth(50);
        attack.setPrefHeight(40);
        attack.setPrefWidth(55);
        textattack.setPrefHeight(40);
        textattack.setPrefWidth(50);
        speed.setPrefHeight(40);
        speed.setPrefWidth(55);
        textspeed.setPrefHeight(40);
        textspeed.setPrefWidth(50);
        range.setPrefHeight(40);
        range.setPrefWidth(55);
        textrange.setPrefHeight(40);
        textrange.setPrefWidth(50);
        
        //set hboxs , each Hbox contains one label & one textfield
        HBox lifebox = new HBox();
        lifebox.setPrefHeight(75);
        lifebox.setPrefWidth(105);
        lifebox.getChildren().addAll(life,textlife);
        HBox attackbox = new HBox();
        attackbox.setPrefHeight(75);
        attackbox.setPrefWidth(105);
        attackbox.getChildren().addAll(attack,textattack);
        HBox speedbox = new HBox();
        speedbox.setPrefHeight(75);
        speedbox.setPrefWidth(105);
        speedbox.getChildren().addAll(speed,textspeed);
        HBox rangebox = new HBox();
        rangebox.setPrefHeight(75);
        rangebox.setPrefWidth(105);
        rangebox.getChildren().addAll(range,textrange);

        //set vbox which contains all hboxs & imageview
        vbox.setPrefHeight(500);
        vbox.setPrefWidth(125);
        vbox.getChildren().addAll(imageview,lifebox,attackbox,speedbox,rangebox);
    }

    public VBox getCustomControl() {
        return this.vbox;
    }

    public void setImage(Image image) {
        this.imageview.setImage(image);
    }

    public int get_life() {
        return Integer.parseInt(this.textlife.getText());
    }

    public int get_attack() {
        return Integer.parseInt(this.textattack.getText());
    }

    public int get_speed() {
        return Integer.parseInt(this.textspeed.getText());
    }

    public int get_range() {
        return Integer.parseInt(this.textrange.getText());
    }
}
