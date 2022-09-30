package baseball.game;

import baseball.common.input.Input;
import baseball.common.output.Output;
import baseball.computer.Computer;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final Compare compare = new Compare();
    private GameStatus status = GameStatus.READY;
    private Computer computer;
    private Player player;

    public void run(){
        while(status.equals(GameStatus.READY)){
            compare.reset();
            this.computer = new Computer();
            compareNumber(this.computer);
            
            String input = Console.readLine();
            int status = Integer.valueOf(input);
            if(status == 2){
                this.status = GameStatus.END;
                break;
            }
        }
        if(status.equals(GameStatus.END)){
            Output.print("게임 종료");
        }
    }

    private void compareNumber(Computer computer) {
        while(!compare.isFinish()){
            String input = Input.inputNumber();
            this.player = new Player(input);
            Output.print(compare.compare(player.inputNumbers().numbers(), computer.resultNumbers().numbers()));
        }
    }


}
