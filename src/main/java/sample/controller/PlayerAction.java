package sample.controller;

import sample.model.ListConstant;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayerAction implements MouseListener{
    // класс предназначен для того, чтобы отлавливать события мыши
    public JFrame window;

    public PlayerAction(JFrame window){
        this.window = window;
    }

    public void mouseClicked(MouseEvent e) {
        ListConstant.coordX = e.getX() / 60;
        ListConstant.coordY = (e.getY()-30) / 60;

        new MouseClickProcessing();

    }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }
}
