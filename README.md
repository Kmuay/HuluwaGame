# 葫芦娃GAME开发手册

171860697  陈佳欢        
171860697@smail.nju.edu.cn

## 游戏介绍
### 人物阵营
#### 葫芦娃方
+ 爷爷 + 大娃 + 二娃 + 三娃 + 四娃 + 五娃 + 六娃 + 七娃
#### 妖怪方
+ 蝎子精 + 蛇精 + 蜈蚣精 + 赖蛤蟆精 + 蝙蝠精 + 蜘蛛精 + 小喽啰-甲 + 小喽啰-乙

### 战斗模式
#### 开局界面
选择作为服务器还是作为客户端，作为服务器直接绑定为葫芦娃方；作为客户端，绑定为妖怪方。
![openpage](/readme_resources/OpenPage.png)

#### 对局准备（以葫芦娃阵营为例）
双方各自为自己的棋子分配点数
![preparepage](/readme_resources/Points_Huluwa.png)

#### 对局准备（以葫芦娃阵营为例）
双方在各自半区自由布阵，默认葫芦娃在最终游戏棋局的左半区，妖怪在最终棋局的右半区
![preparepage](/readme_resources/Team_Huluwa.png)

#### 对局中（以葫芦娃阵营为例）
采用回合制，玩家两者间自定先手顺序，轮流每人每次只可操纵一个棋子的移动/攻击。   
游戏操控：
> 右上角TextField：想要操纵的棋子号（从左向右数1-8号）   
> 上下左右移动Button：结合操纵的棋子号，在左边侧的chessboard内实时更新   
> 技能Button：该功能最终未能实现    
> 选择攻击敌方对象Button：结合操纵的棋子号，视为操纵的棋子对对方敌人发动了一次攻击   
>最下方显示自己操纵的棋子的游戏状态，棋子阵亡，图像换成骷髅头

![battlepage](/readme_resources/Battle_Huluwa.png)

#### 对局结束
一方没有棋子存活

------------------------------------------------------
## 游戏实际开发
### 开发环境
Apache Maven: 3.6.3
Build-Jdk: 14.0.2
JavaFx: 13

### 整体框架

本次开发框架模型采用MVC结构，将view，model和controller之间分离。在vscode中文件结构体现如下。Main类作为整个project的入口。 
<center>
<img src="/readme_resources/FramWork.png">
</center>

#### model
本次项目一共有两大model，Creature类和Game类。   
Creature类就是最基础的棋子类，包含HP，ALIVE在内的多个属性
Game类是整个游戏需要维护的资源类，里面包含对游戏运行状态判断的gamestate，己方棋子的队列self_list，敌方棋子的队列enemy_list

#### view
因为开局界面直接设置在了Main中，所以在view中一共有三个游戏界面设计。
PrepareSPLView：分配点数界面，这个界面中由8个自定义的javafx控件CustomControl，一个Label和一个OK_Button。
TeamFormationView：调整站位界面，
BattleView：详细界面如上面的对局中界面所示

#### controller
两个线程相关文件
UIController：负责界面刷新
BattleController：负责战斗逻辑

### 网络编程
本次Project的网络通信模块由一个NetServer和NetClient，两点之间通过Scoket通信，NetClient内置的ip为127.0.0.1。
### 多线程编程
在本次Project，连同JavaFx主线程一共有5个线程
> JavaFx主线程——负责几个游戏界面的显示，鼠标键盘的事件响应;   
> SendMessage网络通信线程——负责对自身Game信息(维护的self_list和enemy_list)的打包，发送；
> ReceviceMessage线程——负责接受包，解析并对自身Game信息进行更新
> UIController线程——负责刷新对局界面
> BattleController线程——负责进行游戏逻辑的部分，对游戏是否结束进行判断

#### 线程同步
因为之前没有完整的开发过多线程的项目，对于线程同步等问题的解决能力不足，在本次项目中深受其困扰。   
对Game类的临界区资源self_list,enemy_list访问都依靠synchronized关键字。   

#### 线程通信
这几个线程之间，严格意义上并不是并行同时发生。
一个有效的线程协作流程是，JavaFx主线程响应鼠标事件，改变了Game内维护的两个list,此时SendMessage和ReceviceMessage两个网络通信线程，将更新之后的list同步到两台机器上，最后UIContrller线程将此次更新体现在视图View上，并且BattleController根据战斗逻辑判断游戏状态，更新Game内的gamestate。
所以大致分成了三块，在主线程和网络通信线程之间，通过Game中的change标志来进行控制，在网络通信和UI，Battle之间通过Game中的end标志进行控制。

------------------------------------------------------
## 游戏运行指令
在根目录下执行`mvn clean javafx:run`
![RUN](/readme_resources/cmdrun.png)

------------------------------------------------------
## 开发体会
1. 在最开始，游戏的策划时间花费太多导致，游戏的细节想的很多，最终实现的远远达不到最初的计划
2. 对于游戏的框架，一定要仔细理解，这样会节省很多时间，在代码编写中期，由于对线程和控制器理解不够深，导致在写完view和model之后，一时之间不知道从何下手
3. 线程编程永远是难点，还有很多需要学习
4. 还有很多bug需要修改