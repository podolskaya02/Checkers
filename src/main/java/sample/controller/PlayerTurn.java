package sample.controller;

import sample.model.ListConstant;

public class PlayerTurn {
    // класс выполнения хода шашки или дамки
    public int differenceX, differenceY, coordX, coordY, dopX, dopY;
    public PlayerTurn(){
        this.coordX = ListConstant.coordX ;
        this.coordY = ListConstant.coordY;
        this.differenceX = ListConstant.coordX - ListConstant.saveX;
        this.differenceY = ListConstant.coordY - ListConstant.saveY;
        if (Math.abs(differenceX) == 2 || ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] == 3 || ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] == -3) {
            takingMove(); // если нужно сделать ход дамкой или съесть другую шашку,
            // он стирает все между первоначальным положением шашки и новым, а затем вызывает метод ProofCheck
        }else if(Math.abs(differenceX) != 2) {
            simpleMove(); // если нужно сделать обычный ход простой шашки
        }
    }

    public void simpleMove() {
        if (ListConstant.firstPlayerMove) {
            ListConstant.firstPlayerMove = false;
            if (ListConstant.coordY == 0) {
                ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = 3; // становимся дамкой
            }else {
                if(ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] == 3) {
                    ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = 3;
                }else if (ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] == 1) {
                    ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = 1;
                }
            }
        }else {
            ListConstant.firstPlayerMove = true;
            if (ListConstant.coordY == 7) {
                ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = -3;
            }else {
                if(ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] == -3) {
                    ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = -3;
                }else if (ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] == -1) {
                    ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = -1;
                }
            }
        }
        ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] = 0; // клетка, где стояла шашка на предыдущем ходу становится свободной
    }

    private void takingMove() {
        dopX = coordX;
        dopY = coordY;
        if (differenceX * differenceY > 0) {
            if (differenceX > 0) {
                while(dopX != ListConstant.saveX+1) {
                    ListConstant.checkers[dopY -1][dopX -1] = 0;
                    dopX--;
                    dopY--;
                }
                proofCheck();
            }else {
                while(dopX != ListConstant.saveX-1) {
                    ListConstant.checkers[dopY +1][dopX +1] = 0;
                    dopX++;
                    dopY++;
                }
                proofCheck();
            }
        }else {
            if (differenceX > 0) {
                while(dopX != ListConstant.saveX+1) {
                    ListConstant.checkers[dopY +1][dopX -1] = 0;
                    dopX--;
                    dopY++;
                }
                proofCheck();
            }else {
                while(dopX != ListConstant.saveX-1) {
                    ListConstant.checkers[dopY -1][dopX +1] = 0;
                    dopX++;
                    dopY--;
                }
                proofCheck();
            }
        }
    }

    public void proofCheck() {// метод позволяет узнать, была ли побита шашка/дамка врага
        //если да, то возвращает ход игроку, если нет, то передает ход сопернику
        new RemovingCellsChoice();
        if (ListConstant.firstPlayerMove) {
            if (ListConstant.coordY == 0) {
                ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = 3;
            }else {
                if(ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] == 3) {
                    ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = 3;
                }else if (ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] == 1) {
                    ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = 1;
                }
            }
        }else {
            if (ListConstant.coordY == 7) {
                ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = -3;
            }else {
                if(ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] == -3) {
                    ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = -3;
                }else if (ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] == -1) {
                    ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] = -1;
                }
            }
        }
        ListConstant.checkers[ListConstant.saveY][ListConstant.saveX] = 0; //клетку, где стояла предыдущая шашка делаем свободной
        new AddSelectionCells();
        if (ListConstant.firstPlayerMove) {
            ListConstant.firstPlayerMove = false;
        }else {
            ListConstant.firstPlayerMove = true;
        }
        if (!ListConstant.firstPlayerMove && ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] == 1) {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (ListConstant.checkers[i][j]==2 && Math.abs(j - ListConstant.saveX) == 2) {
                        ListConstant.firstPlayerMove = true;
                    }
                    if (ListConstant.checkers[i][j]==2 && Math.abs(j - ListConstant.saveX) == 1) {
                        ListConstant.checkers[i][j] = 0;
                    }
                }
            }
        }else if(ListConstant.firstPlayerMove && ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] == -1){

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (ListConstant.checkers[i][j]==2 && Math.abs(j - ListConstant.saveX) == 2) {
                        ListConstant.firstPlayerMove = false;
                    }
                    if (ListConstant.checkers[i][j]==2 && Math.abs(j - ListConstant.saveX) == 1) {
                        ListConstant.checkers[i][j] = 0;
                    }
                }
            }
        }else if(!ListConstant.firstPlayerMove && ListConstant.checkers[ListConstant.coordY][ListConstant.coordX]==3){

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (ListConstant.checkers[i][j]==2) {
                        dopX = j;
                        dopY = i;
                        while (dopX != ListConstant.saveX) {
                            if (ListConstant.checkers[dopY][dopX]==-1) {
                                ListConstant.firstPlayerMove = true;
                            }
                            if (ListConstant.firstPlayerMove && ListConstant.checkers[dopY][dopX]==2) {
                                ListConstant.checkers[dopY][dopX]=0;
                            }
                            if (dopX > ListConstant.saveX) {
                                dopX--;
                            }else {
                                dopX++;
                            }
                            if (dopY > ListConstant.saveY) {
                                dopY--;
                            }else {
                                dopY++;
                            }
                        }
                        if (!ListConstant.firstPlayerMove) {
                            ListConstant.checkers[i][j] = 0;
                        }
                    }
                }
            }
        }else if(ListConstant.firstPlayerMove && ListConstant.checkers[ListConstant.coordY][ListConstant.coordX]==-3){

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (ListConstant.checkers[i][j]==2) {
                        dopX = j;
                        dopY = i;
                        while (dopX != ListConstant.saveX) {
                            if (ListConstant.checkers[dopY][dopX]==1) {
                                ListConstant.firstPlayerMove = false;
                            }
                            if (!ListConstant.firstPlayerMove && ListConstant.checkers[dopY][dopX]==2) {
                                ListConstant.checkers[dopY][dopX]=0;
                            }
                            if (dopX > ListConstant.saveX) {
                                dopX--;
                            }else {
                                dopX++;
                            }
                            if (dopY > ListConstant.saveY) {
                                dopY--;
                            }else {
                                dopY++;
                            }
                        }
                        if (ListConstant.firstPlayerMove) {
                            ListConstant.checkers[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

}

