package sample.view;

import sample.controller.PlayerAction;

import javax.swing.*;

class MainClass {
    private static void run() {
        JFrame window = new JFrame("Russian checkers");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board();
        Checkers checkers = new Checkers();
        board.setBounds(0, 0, 490, 510);
        checkers.setBounds(0, 0, 490, 510);
        window.add(checkers);
        window.add(board);
        window.setSize(490, 510);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.addMouseListener(new PlayerAction(window));
    }
    public static void main(String[] args) {
        run();
    }
}