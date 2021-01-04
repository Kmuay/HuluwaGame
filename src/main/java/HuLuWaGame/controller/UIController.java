package HuLuWaGame.controller;

import HuLuWaGame.model.Game;
import HuLuWaGame.view.BattleView;
import java.util.concurrent.TimeUnit;

//负责刷新view
public class UIController implements Runnable{

    private Thread t;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            //根据game里面的list_self & list_enemy更新battleview上的chessboard
            while(Game.gamestate==1) {
                BattleView new_battleView = new BattleView(1,Game.list_self);
                new_battleView.renew_chessboard(Game.list_self, Game.list_enemy);
                TimeUnit.MILLISECONDS.sleep(500);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if(t == null) {
            t = new Thread(this,"UIController");
            t.start ();
        }
    }
    
}
