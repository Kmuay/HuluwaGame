package HuLuWaGame.controller;

import java.util.concurrent.TimeUnit;
import HuLuWaGame.model.Game;

public class BattleController implements Runnable{



    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Test for BattleController run");
        try {
            Game game = new Game();
            while(game.get_gamestate()==1) {
                if(game.get_end()) {
                    int num_self_alive = 0;
                    int num_enemy_alive = 0;
                    for(int i=0; i<8; i++) {
                        if(game.get_list_self().get(i).get_alive()) {
                            num_self_alive++;
                        }
                        if(game.get_list_enemy().get(i).get_alive()) {
                            num_enemy_alive++;
                        }
                    }
                    if(num_self_alive!=0&&num_enemy_alive==0) {
                        game.set_gamestate(2);;
                    }
                    else {
                        if(num_self_alive==0&&num_enemy_alive!=0) {
                            game.set_gamestate(3);
                        }
                    }
                }
                game.set_end(false);
                TimeUnit.MILLISECONDS.sleep(200);
            }
            if(game.get_gamestate()==2) {
                System.out.println("YOU WIN");
            }
            if(game.get_gamestate()==3) {
                System.out.println("YOU LOSE");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
