package sample.controller;

import sample.model.ListConstant;

public class AddSelectionCells {
    // класс для выяснения куда может сделать ход шашка
    public int x = 0, y = 0, provX, provY;
    private boolean block = false, impactCheckForDamka = false;

    public AddSelectionCells(){
        this.x = ListConstant.coordX;
        this.y = ListConstant.coordY;
        ListConstant.saveX = ListConstant.coordX;
        ListConstant.saveY = ListConstant.coordY;
        new ImpactCheck();
        if (ListConstant.firstPlayerMove) {
            if (ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] == 1) {
                this.addCellsSimpleFirstPlayer();
            }else if(ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] == 3) {
                this.addCellsDamka(1);
            }
        }else if(!ListConstant.firstPlayerMove) {
            if (ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] == -1) {
                this.addCellsSimpleSecondPlayer();
            }else if(ListConstant.checkers[ListConstant.coordY][ListConstant.coordX] == -3) {
                this.addCellsDamka(-1);
            }
        }
        ListConstant.impactCheck = false;
    }

    public void addCellsSimpleFirstPlayer() {
        // метод добавления выбора хода первого игрока простой шашки
        if (x == 0) {
            if (ListConstant.checkers[y-1][x+1]==0 && !ListConstant.impactCheck) {
                ListConstant.checkers[y-1][x+1] = 2;
            }
            if(y != 1) {
                if((ListConstant.checkers[y-1][x+1]==-1 || ListConstant.checkers[y-1][x+1]==-3) && ListConstant.checkers[y-2][x+2]==0) {
                    ListConstant.checkers[y-2][x+2] = 2;
                }
            }
            if(y != 7) {
                if((ListConstant.checkers[y+1][x+1]==-1 || ListConstant.checkers[y+1][x+1]==-3) && ListConstant.checkers[y+2][x+2]==0) {
                    ListConstant.checkers[y+2][x+2] = 2;
                }
            }
        }else if(x == 7) {
            if(y != 0) {
                if (ListConstant.checkers[y-1][x-1]==0 && !ListConstant.impactCheck) {
                    ListConstant.checkers[y-1][x-1] = 2;
                }
                if((ListConstant.checkers[y-1][x-1]==-1 || ListConstant.checkers[y-1][x-1]==-3) && ListConstant.checkers[y-2][x-2]==0) {
                    ListConstant.checkers[y-2][x-2] = 2;
                }
            }
            if(y != 6) {
                if((ListConstant.checkers[y+1][x-1]==-1 || ListConstant.checkers[y+1][x-1]==-3)  && ListConstant.checkers[y+2][x-2]==0) {
                    ListConstant.checkers[y+2][x-2] = 2;
                }
            }
        }else {
            if(y != 0) {
                if (ListConstant.checkers[y-1][x+1]==0 && !ListConstant.impactCheck) {
                    ListConstant.checkers[y-1][x+1] = 2;
                }
                if (ListConstant.checkers[y-1][x-1]==0 && !ListConstant.impactCheck) {
                    ListConstant.checkers[y-1][x-1] = 2;
                }
                if(y != 1) {
                    if((ListConstant.checkers[y-1][x+1]==-1 || ListConstant.checkers[y-1][x+1]==-3) && x<6) {
                        if (ListConstant.checkers[y-2][x+2]==0) {
                            ListConstant.checkers[y-2][x+2] = 2;
                        }
                    }
                    if((ListConstant.checkers[y-1][x-1]==-1 || ListConstant.checkers[y-1][x-1]==-3) && x>1) {
                        if (ListConstant.checkers[y-2][x-2] == 0) {
                            ListConstant.checkers[y-2][x-2]  = 2;
                        }
                    }
                }
            }
            if(y != 7 && y != 6) {
                if((ListConstant.checkers[y+1][x+1]==-1 || ListConstant.checkers[y+1][x+1]==-3) && x<6) {
                    if (ListConstant.checkers[y+2][x+2]== 0) {
                        ListConstant.checkers[y+2][x+2] = 2;
                    }
                }
                if((ListConstant.checkers[y+1][x-1]==-1 || ListConstant.checkers[y+1][x-1]==-3) && x>1) {
                    if (ListConstant.checkers[y+2][x-2] == 0) {
                        ListConstant.checkers[y+2][x-2]  = 2;
                    }
                }
            }
        }

    }

    public void addCellsSimpleSecondPlayer() {
        if (x == 0) {
            if (y != 7) {
                if (ListConstant.checkers[y+1][x+1]==0 && !ListConstant.impactCheck) {
                    ListConstant.checkers[y+1][x+1] = 2;
                }
                if((ListConstant.checkers[y+1][x+1]==1 || ListConstant.checkers[y+1][x+1]==3) && ListConstant.checkers[y+2][x+2]==0) {
                    ListConstant.checkers[y+2][x+2] = 2;
                }
            }
            if(y != 1) {
                if((ListConstant.checkers[y-1][x+1]==1 || ListConstant.checkers[y-1][x+1]==3) && ListConstant.checkers[y-2][x+2]==0) {
                    ListConstant.checkers[y-2][x+2] = 2;
                }
            }
        }else if(x == 7) {
            if (ListConstant.checkers[y+1][x-1]==0 && !ListConstant.impactCheck) {
                ListConstant.checkers[y+1][x-1] = 2;
            }
            if(y != 6) {
                if((ListConstant.checkers[y+1][x-1]==1 || ListConstant.checkers[y+1][x-1]==3) && ListConstant.checkers[y+2][x-2]==0) {
                    ListConstant.checkers[y+2][x-2] = 2;
                }
            }
            if(y != 0) {
                if((ListConstant.checkers[y-1][x-1]==1 || ListConstant.checkers[y-1][x-1]==3) && ListConstant.checkers[y-2][x-2]==0) {
                    ListConstant.checkers[y-2][x-2] = 2;
                }
            }
        }else {
            if (y != 7) {
                if (ListConstant.checkers[y+1][x+1]==0 && !ListConstant.impactCheck) {
                    ListConstant.checkers[y+1][x+1] = 2;
                }
                if (ListConstant.checkers[y+1][x-1]==0 && !ListConstant.impactCheck) {
                    ListConstant.checkers[y+1][x-1] = 2;
                }
                if(y != 6) {
                    if((ListConstant.checkers[y+1][x+1]==1 || ListConstant.checkers[y+1][x+1]==3) && x < 6) {
                        if (ListConstant.checkers[y+2][x+2]==0) {
                            ListConstant.checkers[y+2][x+2] = 2;
                        }
                    }
                }
                if(y != 6) {
                    if((ListConstant.checkers[y+1][x-1]==1 || ListConstant.checkers[y+1][x-1]==3) && x > 1) {
                        if (ListConstant.checkers[y+2][x-2] ==0) {
                            ListConstant.checkers[y+2][x-2]  = 2;
                        }
                    }
                }
            }
            if(y != 0 && y != 1) {
                if((ListConstant.checkers[y-1][x+1]==1 || ListConstant.checkers[y-1][x+1]==3) && x < 6) {
                    if (ListConstant.checkers[y-2][x+2]==0) {
                        ListConstant.checkers[y-2][x+2] = 2;
                    }
                }
                if((ListConstant.checkers[y-1][x-1]==1 || ListConstant.checkers[y-1][x-1]==3) && x>1) {
                    if (ListConstant.checkers[y-2][x-2] == 0) {
                        ListConstant.checkers[y-2][x-2]  = 2;
                    }
                }
            }
        }
    }

    private void addCellsDamka(int player) {
        provX = x;
        provY = y;
        block = false;
        while (provX < 7 && provY < 7) {
            if (ListConstant.checkers[provY+1][provX+1]==0 && !ListConstant.impactCheck) {
                ListConstant.checkers[provY+1][provX+1] = 2;
            }else if ((ListConstant.checkers[provY+1][provX+1]==-1*player || ListConstant.checkers[provY+1][provX+1]==-3*player)
                    && provX+1 != 7 && provY+1 != 7 && !block) {
                if (ListConstant.checkers[provY+2][provX+2] == 0) {
                    ListConstant.impactCheck = false;
                    impactCheckForDamka = true;
                    ListConstant.checkers[provY+2][provX+2] = 2;
                    provX++;
                    provY++;
                    block = true;
                }else {
                    break;
                }
            }
            provX++;
            provY++;
        }
        provX = x;
        provY = y;
        if (impactCheckForDamka) {
            ListConstant.impactCheck = true;
            impactCheckForDamka = false;
        }
        block = false;
        while (provX < 7 && provY > 0) {
            if (ListConstant.checkers[provY-1][provX+1]==0 && !ListConstant.impactCheck) {
                ListConstant.checkers[provY-1][provX+1] = 2;
            }else if ((ListConstant.checkers[provY-1][provX+1]==-1*player || ListConstant.checkers[provY-1][provX+1]==-3*player)
                    && provX+1 != 7 && provY-1 != 0 && !block) {
                if (ListConstant.checkers[provY-2][provX+2] == 0) {
                    ListConstant.impactCheck = false;
                    impactCheckForDamka = true;
                    ListConstant.checkers[provY-2][provX+2] = 2;
                    block = true;
                    provX++;
                    provY--;
                }else {
                    break;
                }
            }
            provX++;
            provY--;
        }
        provX = x;
        provY = y;
        if (impactCheckForDamka) {
            ListConstant.impactCheck = true;
            impactCheckForDamka = false;
        }
        block = false;
        while (provX > 0 && provY >0) {
            if (ListConstant.checkers[provY-1][provX-1]==0 && !ListConstant.impactCheck) {
                ListConstant.checkers[provY-1][provX-1] = 2;
            }else if ((ListConstant.checkers[provY-1][provX-1]==-1*player || ListConstant.checkers[provY-1][provX-1]==-3*player)
                    && provX-1 != 0 && provY-1 != 0 && !block) {
                if (ListConstant.checkers[provY-2][provX-2] == 0) {
                    ListConstant.impactCheck = false;
                    impactCheckForDamka = true;
                    ListConstant.checkers[provY-2][provX-2] = 2;
                    block = true;
                    provX--;
                    provY--;
                }else {
                    break;
                }
            }
            provX--;
            provY--;
        }
        provX = x;
        provY = y;
        if (impactCheckForDamka) {
            ListConstant.impactCheck = true;
            impactCheckForDamka = false;
        }
        while (provX > 0 && provY < 7) {
            if (ListConstant.checkers[provY+1][provX-1]==0 && !ListConstant.impactCheck) {
                ListConstant.checkers[provY+1][provX-1] = 2;
            }else if ((ListConstant.checkers[provY+1][provX-1]==-1*player || ListConstant.checkers[provY+1][provX-1]==-3*player)
                    && provX-1 != 0 && provY+1 != 7 && !block) {
                if (ListConstant.checkers[provY+2][provX-2] == 0) {
                    ListConstant.impactCheck = false;
                    impactCheckForDamka = true;
                    ListConstant.checkers[provY+2][provX-2] = 2;
                    block = true;
                    provX--;
                    provY++;
                }else {
                    break;
                }
            }
            provX--;
            provY++;
        }
        if (impactCheckForDamka) {
            ListConstant.impactCheck = true;
            impactCheckForDamka = false;
        }
        block = false;
    }
}

