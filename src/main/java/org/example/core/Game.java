package org.example.core;

import org.example.structure.Leaf;
import org.example.structure.Node;

import javax.swing.*;
import java.util.Scanner;

import static org.example.ui.Message.*;

public class Game {

    private JFrame window;

    private Node root;

    public void run() {
        printIntro();

        setRoot();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        String running = YES.getMessage();

        while (running.equals(YES.getMessage())) {
            root.ask(this.root);
            System.out.println(CONTINUE.getMessage());
            running = scanner.nextLine();
        }
    }

    public void graphicRun() {
        createFrame();
        setRoot();
    }

    private void printIntro() {
        System.out.println(CUT_LINE.getMessage());
        System.out.println(INTRO.getMessage());
        System.out.println(PROCEED.getMessage());
    }

    private void setRoot() {
        Node rightNode = new Leaf(window, "bolo de chocolate");
        Node leftNode = new Leaf(window,"lasanha");
        leftNode.setLeft(true);

        this.root = new Node(window, "massa",leftNode,rightNode);
    }

    public void createFrame() {
        this.window = new JFrame(TITLE.getMessage());

        JPanel panel = new JPanel();

        JButton button = new JButton(OK.getMessage());
        button.addActionListener(e -> root.ask(this.root));

        panel.add(new JLabel(INTRO.getMessage()));
        panel.add(button);

        window.add(panel);
        window.setSize(250, 100);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
