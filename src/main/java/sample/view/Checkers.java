package sample.view;

import sample.model.ListConstant;

import javax.swing.*;
import java.awt.*;


public class Checkers extends JLabel{
    private int width = 10, height = 10;
    private final int radius = 40;

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ListConstant.checkers[i][j]==1){ // 1 - обычная шашка первого игрока (снизу)
                    g.setColor(new Color(160, 82, 45));
                    g.fillOval(width, height, radius, radius);
                    g.setColor(Color.BLACK);
                    g.fillOval(width+15, height+15, 10, 10);
                }else if(ListConstant.checkers[i][j]==-1){ // -1 - обычная шашка второго игрока (сверху)
                    g.setColor(new Color(255, 228, 225));
                    g.fillOval(width, height, radius, radius);
                    g.setColor(Color.BLACK);
                    g.fillOval(width+15, height+15, 10, 10);
                }else if(ListConstant.checkers[i][j]==2){ // 2 - предоставление выбора хода
                    g.setColor(new Color(128, 128, 128));
                    g.fillOval(width, height, radius, radius);
                }else if(ListConstant.checkers[i][j]==3){ // -3 - дамка второго игрока
                    g.setColor(new Color(160, 82, 45));
                    g.fillOval(width, height, radius, radius);
                    g.setColor(Color.BLACK);
                    g.drawString("D", width+16, height+25);
                }else if(ListConstant.checkers[i][j]==-3){ // 3 - дамка первого игрока
                    g.setColor(new Color(255, 228, 225));
                    g.fillOval(width, height, radius, radius);
                    g.setColor(Color.BLACK);
                    g.drawString("D", width+16, height+25);
                }
                width += 60;
            }
            width = 10;
            height += 60;
        }
        height = 10;
        this.repaint();
    }
}
