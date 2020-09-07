package sample.controller;

import sample.model.ListConstant;

public class MouseClickProcessing {
    // класс предназначенный для выбора действий
    public MouseClickProcessing(){
        if (ListConstant.checkers[ListConstant.coordY][ListConstant.coordX]==2) { //если координаты нажатия уже на клетке с выбором хода
            new RemovingCellsChoice();
            new PlayerTurn(); // делаем ход
        }else { //
            new RemovingCellsChoice();
            new AddSelectionCells(); //иначе добавляем варианты ходов
        }
    }
}