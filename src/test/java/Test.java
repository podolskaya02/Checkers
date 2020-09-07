import org.junit.jupiter.api.Test;
import sample.controller.AddSelectionCells;
import sample.controller.ImpactCheck;
import sample.controller.PlayerTurn;
import sample.model.ListConstant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class Tests {

    private int x, y;
    private int i, j, player;

    @Test
    void SimpleMove(){ // делаем ход обычной шашкой
       PlayerTurn playerTurn = new PlayerTurn();
       playerTurn.coordY = 2; playerTurn.coordX = 6; ListConstant.firstPlayerMove = true;
       ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] = 1;
       assertEquals(1, ListConstant.checkers[ListConstant.coordY][ListConstant.coordX]); // проверяем, что на поле стоит наша обычная шашка
       playerTurn.simpleMove();
       assertEquals(0, ListConstant.checkers[ListConstant.coordY][ListConstant.coordX]); // проверяем, что клетка уже пуста, тк был сделан ход

    }

    @Test
    void ProofCheck(){ // становимся дамкой
        PlayerTurn pt = new PlayerTurn();
        pt.coordY = 0; pt.coordX = 1; ListConstant.firstPlayerMove = true;
        ListConstant.coordY = 0; ListConstant.coordX = 1;
        ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = -1;
        pt.proofCheck();
        assertEquals(3, ListConstant.checkers[ListConstant.coordY][ListConstant.coordX]);
        ListConstant.saveY = 3; ListConstant.saveX = 3;
    }

    @Test
    void CheckSimpleCheckers(){ // можем побить просто шашкой шашку противника
        ImpactCheck impactCheck = new ImpactCheck();
        i = 0; j = 7; player = -1;
        ListConstant.checkers[i+1][j-1] = 1;
        ListConstant.checkers[i+2][j-2] = 0;
        impactCheck.checkSimpleCheckers(0, 7, -1);
        assertTrue(ListConstant.impactCheck);
    }

    @Test
    void AddCellsSimpleFirstPlayer() { // добавление варинтов ходов для первой шашки
        AddSelectionCells cell = new AddSelectionCells();
        x = 0; y = 2;
        cell.x = 0; cell.y = 2; ListConstant.impactCheck = false;
        ListConstant.checkers[y-1][x+1] = 0;
        cell.addCellsSimpleFirstPlayer();
        assertEquals(2, ListConstant.checkers[y-1][x+1]);
    }

    @Test
    void AddCellsSimpleSecondPlayer(){ // добавление варинтов ходов для второй шашки
        AddSelectionCells cell = new AddSelectionCells();
        x = 0; y = 5;
        cell.x = 0; cell.y = 5; ListConstant.impactCheck = false;
        ListConstant.checkers[y+1][x+1] = 0;
        cell.addCellsSimpleSecondPlayer();
        assertEquals(2, ListConstant.checkers[y+1][x+1]);
    }
}