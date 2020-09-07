package sample.view;
import sample.model.ListConstant;

import javax.swing.*;
import java.awt.*;

public class Board extends JLabel{
    private int width = 0, height = 0;
    private final int cageWidth = 60;
    public void paintComponent(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ListConstant.board[i][j]==1){
                    g.setColor(Color.WHITE);
                }else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(width, height, cageWidth, cageWidth);
                width += cageWidth;
            }
            width = 0;
            height += cageWidth;
        }
        height = 0;
    }
}