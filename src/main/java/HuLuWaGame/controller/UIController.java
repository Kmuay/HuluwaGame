package HuLuWaGame.controller;

import HuLuWaGame.model.Creature;
import HuLuWaGame.model.Game;
import HuLuWaGame.view.BattleView;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//负责刷新view
public class UIController implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Test for UIController run");
        try {
            //根据game里面的list_self & list_enemy更新battleview上的chessboard
            Game game = new Game();
            while(game.get_gamestate()==1) {
                ArrayList<Creature> selflist = game.get_list_self();
                ArrayList<Creature> enemylist = game.get_list_enemy();
                ArrayList<Integer> list = new ArrayList<Integer>();

                //刷新chessboard
                for(int i=0; i<8; i++) {
                    int position_x = selflist.get(i).get_position_x();
                    int position_y = selflist.get(i).get_position_y();
                    list.add(position_x + position_y * 10);
                }
                for(int i=0; i<8; i++) {
                    int position_x = enemylist.get(i).get_position_x();
                    int position_y = enemylist.get(i).get_position_y();
                    list.add(position_x + position_y * 10);
                }
                for(int i=0; i<100; i++) {
                    URL url_white = getClass().getClassLoader().getResource("White.png");
                    URL url_black = getClass().getClassLoader().getResource("Black.png");
                    if(!list.contains(i)) {
                        int x = i/10;
                        int y = i%10;
                        if((x+y)%2==0) {
                            BattleView.chessboard.get(i).setImage(new Image(url_black.toString()));
                        }
                        else {
                            BattleView.chessboard.get(i).setImage(new Image(url_white.toString()));
                        }
                    }
                }
                for(int i=0; i<8; i++) {
                    int position_x = selflist.get(i).get_position_x();
                    int position_y = selflist.get(i).get_position_y();
                    if(selflist.get(i).get_alive()) {
                        String name = selflist.get(i).get_name();
                        URL url = getClass().getClassLoader().getResource(name+".png");
                        BattleView.chessboard.get(position_x + position_y * 10).setImage(new Image(url.toString()));
                    }
                    else {
                        URL url = getClass().getClassLoader().getResource("DeadMen.png");
                        BattleView.chessboard.get(position_x + position_y * 10).setImage(new Image(url.toString()));
                    }
                }
                for(int i=0; i<8; i++) {
                    int position_x = enemylist.get(i).get_position_x();
                    int position_y = enemylist.get(i).get_position_y();
                    if(enemylist.get(i).get_alive()) {
                        String name = enemylist.get(i).get_name();
                        URL url = getClass().getClassLoader().getResource(name+".png");
                        BattleView.chessboard.get(position_x + position_y * 10).setImage(new Image(url.toString()));
                    }
                    else {
                        URL url = getClass().getClassLoader().getResource("DeadMen.png");
                        BattleView.chessboard.get(position_x + position_y * 10).setImage(new Image(url.toString()));
                    }
                }
                
                /*
                String hp = Integer.toString(selflist.get(0).get_hp());
                String mp = Integer.toString(selflist.get(0).get_mp());
                BattleView.hp_firstsoldier.setText(hp);
                BattleView.mp_firstsoldier.setText(mp);

                hp = Integer.toString(selflist.get(1).get_hp());
                mp = Integer.toString(selflist.get(1).get_mp());
                BattleView.hp_secondsoldier.setText(hp);
                BattleView.mp_secondsoldier.setText(mp);

                hp = Integer.toString(selflist.get(2).get_hp());
                mp = Integer.toString(selflist.get(2).get_mp());
                BattleView.hp_thirdsoldier.setText(hp);
                BattleView.mp_thirdsoldier.setText(mp);

                hp = Integer.toString(selflist.get(3).get_hp());
                mp = Integer.toString(selflist.get(3).get_mp());
                BattleView.hp_fourthsoldier.setText(hp);
                BattleView.mp_fourthsoldier.setText(mp);

                hp = Integer.toString(selflist.get(4).get_hp());
                mp = Integer.toString(selflist.get(4).get_mp());
                BattleView.hp_fifthsoldier.setText(hp);
                BattleView.mp_fifthsoldier.setText(mp);

                hp = Integer.toString(selflist.get(5).get_hp());
                mp = Integer.toString(selflist.get(5).get_mp());
                BattleView.hp_sixthsoldier.setText(hp);
                BattleView.mp_sixthsoldier.setText(mp);

                hp = Integer.toString(selflist.get(6).get_hp());
                mp = Integer.toString(selflist.get(6).get_mp());
                BattleView.hp_seventhsoldier.setText(hp);
                BattleView.mp_seventhsoldier.setText(mp);

                hp = Integer.toString(selflist.get(7).get_hp());
                mp = Integer.toString(selflist.get(7).get_mp());
                BattleView.hp_eighthsoldier.setText(hp);
                BattleView.mp_eighthsoldier.setText(mp);
                */

                /*
                boolean alive = enemylist.get(0).get_alive();
                String name = enemylist.get(0).get_name();
                ImageView imageview1 = new ImageView();
                imageview1.setFitHeight(40);
                imageview1.setFitWidth(40);
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    imageview1.setImage(new Image(url.toString()));
                    BattleView.firstenemy.setGraphic(imageview1);
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    imageview1.setImage(new Image(url.toString()));
                    BattleView.firstenemy.setGraphic(imageview1);
                }

                alive = enemylist.get(1).get_alive();
                name = enemylist.get(1).get_name();
                ImageView imageview2 = new ImageView();
                imageview2.setFitHeight(40);
                imageview2.setFitWidth(40);
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    imageview2.setImage(new Image(url.toString()));
                    BattleView.secondenemy.setGraphic(imageview2);
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    imageview2.setImage(new Image(url.toString()));
                    BattleView.secondenemy.setGraphic(imageview2);
                }

                alive = enemylist.get(2).get_alive();
                name = enemylist.get(2).get_name();
                ImageView imageview3 = new ImageView();
                imageview3.setFitHeight(40);
                imageview3.setFitWidth(40);
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    imageview3.setImage(new Image(url.toString()));
                    BattleView.thirdenemy.setGraphic(imageview3);
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    imageview3.setImage(new Image(url.toString()));
                    BattleView.thirdenemy.setGraphic(imageview3);
                }

                alive = enemylist.get(3).get_alive();
                name = enemylist.get(3).get_name();
                ImageView imageview4 = new ImageView();
                imageview4.setFitHeight(40);
                imageview4.setFitWidth(40);
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    imageview4.setImage(new Image(url.toString()));
                    BattleView.fourthenemy.setGraphic(imageview4);
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    imageview4.setImage(new Image(url.toString()));
                    BattleView.fourthenemy.setGraphic(imageview4);
                }

                alive = enemylist.get(4).get_alive();
                name = enemylist.get(4).get_name();
                ImageView imageview5 = new ImageView();
                imageview5.setFitHeight(40);
                imageview5.setFitWidth(40);
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    imageview5.setImage(new Image(url.toString()));
                    BattleView.fifthenemy.setGraphic(imageview5);
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    imageview5.setImage(new Image(url.toString()));
                    BattleView.fifthenemy.setGraphic(imageview5);
                }

                alive = enemylist.get(5).get_alive();
                name = enemylist.get(5).get_name();
                ImageView imageview6 = new ImageView();
                imageview6.setFitHeight(40);
                imageview6.setFitWidth(40);
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    imageview6.setImage(new Image(url.toString()));
                    BattleView.sixthenemy.setGraphic(imageview6);
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    imageview6.setImage(new Image(url.toString()));
                    BattleView.sixthenemy.setGraphic(imageview6);
                }

                alive = enemylist.get(6).get_alive();
                name = enemylist.get(6).get_name();
                ImageView imageview7 = new ImageView();
                imageview7.setFitHeight(40);
                imageview7.setFitWidth(40);
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    imageview7.setImage(new Image(url.toString()));
                    BattleView.seventhenemy.setGraphic(imageview7);
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    imageview7.setImage(new Image(url.toString()));
                    BattleView.seventhenemy.setGraphic(imageview7);
                }

                alive = enemylist.get(7).get_alive();
                name = enemylist.get(7).get_name();
                ImageView imageview8 = new ImageView();
                imageview8.setFitHeight(40);
                imageview8.setFitWidth(40);
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    imageview8.setImage(new Image(url.toString()));
                    BattleView.eighthenemy.setGraphic(imageview8);
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    imageview8.setImage(new Image(url.toString()));
                    BattleView.eighthenemy.setGraphic(imageview8);
                }
                */

                boolean alive = selflist.get(0).get_alive();
                String name = selflist.get(0).get_name();
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    BattleView.firstsoldier.setImage(new Image(url.toString()));
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    BattleView.firstsoldier.setImage(new Image(url.toString()));
                }

                alive = selflist.get(1).get_alive();
                name = selflist.get(1).get_name();
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    BattleView.secondsoldier.setImage(new Image(url.toString()));
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    BattleView.secondsoldier.setImage(new Image(url.toString()));
                }

                alive = selflist.get(2).get_alive();
                name = selflist.get(2).get_name();
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    BattleView.thirdsoldier.setImage(new Image(url.toString()));
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    BattleView.thirdsoldier.setImage(new Image(url.toString()));
                }

                alive = selflist.get(3).get_alive();
                name = selflist.get(3).get_name();
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    BattleView.fourthsoldier.setImage(new Image(url.toString()));
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    BattleView.fourthsoldier.setImage(new Image(url.toString()));
                }

                alive = selflist.get(4).get_alive();
                name = selflist.get(4).get_name();
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    BattleView.fifthsoldier.setImage(new Image(url.toString()));
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    BattleView.fifthsoldier.setImage(new Image(url.toString()));
                }

                alive = selflist.get(5).get_alive();
                name = selflist.get(5).get_name();
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    BattleView.sixthsoldier.setImage(new Image(url.toString()));
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    BattleView.sixthsoldier.setImage(new Image(url.toString()));
                }

                alive = selflist.get(6).get_alive();
                name = selflist.get(6).get_name();
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    BattleView.seventhsoldier.setImage(new Image(url.toString()));
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    BattleView.seventhsoldier.setImage(new Image(url.toString()));
                }

                alive = selflist.get(7).get_alive();
                name = selflist.get(7).get_name();
                if(alive) {
                    URL url = getClass().getClassLoader().getResource(name+".png");
                    BattleView.eighthsoldier.setImage(new Image(url.toString()));
                }
                else {
                    URL url = getClass().getClassLoader().getResource("DeadMen.png");
                    BattleView.eighthsoldier.setImage(new Image(url.toString()));
                }

                TimeUnit.MILLISECONDS.sleep(500);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
