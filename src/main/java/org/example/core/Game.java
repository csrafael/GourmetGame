package org.example.core;

import org.example.structure.Leaf;
import org.example.structure.Node;

import javax.swing.*;
import java.util.Scanner;

import static org.example.ui.Message.*;

public class Game {

    private JFrame window;

    private Node root;

    /**
     *  Execute game with GUI based in JOptionPanes
     */
    public void graphicRun() {
        createFrame();  // create main frame
        setRoot();      // create tree root
    }

    /**
     *  Execute game with a Text User Interface using commandline
     */
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
        scanner.close();
    }

    /**
     *  Create the main frame and the first message
     *  to start the game
     */
    private void createFrame() {
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

    /**
     *  Start Text Based Game
     */
    private void printIntro() {
        System.out.println(CUT_LINE.getMessage());
        System.out.println(INTRO.getMessage());
        System.out.println(PROCEED.getMessage());
    }

    /**
     * Create tree root with started plates and feature.
     */
    private void setRoot() {
        Node rightNode = new Leaf(window, "bolo de chocolate");
        Node leftNode = new Leaf(window,"lasanha");
        leftNode.setLeft(true);

        this.root = new Node(window, "massa",leftNode,rightNode);
    }
}
