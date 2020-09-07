package sample.controller;

import sample.model.ListConstant;

public class ImpactCheck {
    // класс для выяснения может ли какая-то шашка побить шашку противника
    // если да, то при выполнение класса AddSelectionCells отображаются только те клетки, которы позволяют побить шашку противника
    private int provX, provY;
    public ImpactCheck(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ListConstant.firstPlayerMove) {
                    if (ListConstant.checkers[i][j] == 1) {
                        this.checkSimpleCheckers(i, j, 1);
                    }else if(ListConstant.checkers[i][j] == 3) {
                        this.checkDamka(i, j, 1);
                    }
                }else if(!ListConstant.firstPlayerMove) {
                    if (ListConstant.checkers[i][j] == -1) {
                        this.checkSimpleCheckers(i, j, -1);
                    }else if(ListConstant.checkers[i][j] == -3) {
                        this.checkDamka(i, j, -1);
                    }
                }
            }
        }
    }

    public void checkSimpleCheckers(int i, int j, int player) {
        //метод проверяет, может ли побить кого-то простая шашка
        if (i == 0 || i == 7 || j == 0 || j == 7) {
            if (i == 0) {
                if (j == 7) {
                    if ((ListConstant.checkers[i+1][j-1] == -1*player || ListConstant.checkers[i+1][j-1] == -3*player)
                            && ListConstant.checkers[i+2][j-2] == 0) {
                        ListConstant.impactCheck = true;
                    }
                }else {
                    if (ListConstant.checkers[i+1][j+1] == -1*player || ListConstant.checkers[i+1][j+1] == -3*player) {
                        if (ListConstant.checkers[i+2][j+2] == 0) {
                            ListConstant.impactCheck = true;
                        }
                    }
                    if ((ListConstant.checkers[i+1][j-1] == -1*player || ListConstant.checkers[i+1][j-1] == -3*player)
                            && j-1 != 0) {
                        if (ListConstant.checkers[i+2][j-2] == 0) {
                            ListConstant.impactCheck = true;
                        }
                    }
                }
            }
            if (i == 7) {
                if (j == 0) {
                    if ((ListConstant.checkers[i-1][j+1] == -1*player || ListConstant.checkers[i-1][j+1] == -3*player)
                            && ListConstant.checkers[i-2][j+2] == 0) {
                        ListConstant.impactCheck = true;
                    }
                }else {
                    if (ListConstant.checkers[i-1][j-1] == -1*player || ListConstant.checkers[i-1][j-1] == -3*player) {
                        if (ListConstant.checkers[i-2][j-2] == 0) {
                            ListConstant.impactCheck = true;
                        }
                    }
                    if ((ListConstant.checkers[i-1][j+1] == -1*player || ListConstant.checkers[i-1][j+1] == -3*player)
                            && j+1 != 7) {
                        if (ListConstant.checkers[i-2][j+2] == 0) {
                            ListConstant.impactCheck = true;
                        }
                    }
                }
            }
            if (j == 0 && i != 7) {
                if (ListConstant.checkers[i+1][j+1] == -1*player || ListConstant.checkers[i+1][j+1] == -3*player) {
                    if (ListConstant.checkers[i+2][j+2] == 0) {
                        ListConstant.impactCheck = true;
                    }
                }
                if ((ListConstant.checkers[i-1][j+1] == -1*player || ListConstant.checkers[i-1][j+1] == -3*player)
                        && i-1 != 0) {
                    if (ListConstant.checkers[i-2][j+2] == 0) {
                        ListConstant.impactCheck = true;
                    }
                }
            }
            if (j == 7 && i != 0) {
                if ((ListConstant.checkers[i+1][j-1] == -1*player || ListConstant.checkers[i+1][j-1] == -3*player)
                        && i+1 != 7) {
                    if (ListConstant.checkers[i+2][j-2] == 0) {
                        ListConstant.impactCheck = true;
                    }
                }
                if (ListConstant.checkers[i-1][j-1] == -1*player || ListConstant.checkers[i-1][j-1] == -3*player) {
                    if (ListConstant.checkers[i-2][j-2] == 0) {
                        ListConstant.impactCheck = true;
                    }
                }
            }
        }else{
            if ((ListConstant.checkers[i+1][j+1] == -1*player || ListConstant.checkers[i+1][j+1] == -3*player)
                    && i+1 != 7 && j+1 != 7) {
                if (ListConstant.checkers[i+2][j+2] == 0) {
                    ListConstant.impactCheck = true;
                }
            }
            if ((ListConstant.checkers[i+1][j-1] == -1*player || ListConstant.checkers[i+1][j-1] == -3*player)
                    && i+1 != 7 && j-1 != 0) {
                if (ListConstant.checkers[i+2][j-2] == 0) {
                    ListConstant.impactCheck = true;
                }
            }
            if ((ListConstant.checkers[i-1][j-1] == -1*player || ListConstant.checkers[i-1][j-1] == -3*player)
                    && i-1 != 0 && j-1 != 0) {
                if (ListConstant.checkers[i-2][j-2] == 0) {
                    ListConstant.impactCheck = true;
                }
            }
            if ((ListConstant.checkers[i-1][j+1] == -1*player || ListConstant.checkers[i-1][j+1] == -3*player)
                    && i-1 != 0 && j+1 != 7) {
                if (ListConstant.checkers[i-2][j+2] == 0) {
                    ListConstant.impactCheck = true;
                }
            }
        }
    }

    private void checkDamka(int i, int j, int player) {
        provX = i;
        provY = j;
        while (provX < 7 && provY < 7) {
            if ((ListConstant.checkers[provX+1][provY+1]==-1*player || ListConstant.checkers[provX+1][provY+1]==-3*player)
                    && provX+1 != 7 && provY+1 != 7 ) {
                if (ListConstant.checkers[provX+2][provY+2] == 0) {
                    ListConstant.impactCheck = true;
                    break;
                }
            }
            provX++;
            provY++;
        }
        provX = i;
        provY = j;
        while (provX > 0 && provY < 7) {
            if ((ListConstant.checkers[provX-1][provY+1]==-1*player || ListConstant.checkers[provX-1][provY+1]==-3*player)
                    && provX-1 != 0 && provY+1 != 7) {
                if (ListConstant.checkers[provX-2][provY+2] == 0) {
                    ListConstant.impactCheck = true;
                    break;
                }
            }
            provX--;
            provY++;
        }
        provX = i;
        provY = j;
        while (provX > 0 && provY > 0) {
            if ((ListConstant.checkers[provX-1][provY-1]==-1*player || ListConstant.checkers[provX-1][provY+1]==-3*player)
                    && provX-1 != 0 && provY-1 != 0) {
                if (ListConstant.checkers[provX-2][provY-2] == 0) {
                    ListConstant.impactCheck = true;
                    break;
                }
            }
            provX--;
            provY--;
        }
        provX = i;
        provY = j;
        while (provX < 7 && provY > 0) {
            if ((ListConstant.checkers[provX+1][provY-1]==-1*player || ListConstant.checkers[provX+1][provY-1]==-3*player)
                    && provX+1 != 7 && provY-1 != 0) {
                if (ListConstant.checkers[provX+2][provY-2] == 0) {
                    ListConstant.impactCheck = true;
                    break;
                }
            }
            provX++;
            provY--;
        }
    }

}
