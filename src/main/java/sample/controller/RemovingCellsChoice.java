package sample.controller;

import sample.model.ListConstant;

public class RemovingCellsChoice {
    // класс, удаляющий все клетки с выбором хода.
    public RemovingCellsChoice(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ListConstant.checkers[i][j] == 2) {
                    ListConstant.checkers[i][j] = 0;
                }
            }
        }
    }
}

