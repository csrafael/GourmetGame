package org.example.structure;

import lombok.Getter;
import lombok.Setter;
import org.example.ui.Message;

import javax.swing.*;
import java.util.Scanner;

import static org.example.ui.Message.YES;

@Getter
@Setter
public class Node {

    private Scanner scanner;
    private JFrame window;
    private Node leftNode; //yesNode
    private Node rightNode; //noNode

    private String feature;
    private String plate;

    private boolean isLeft;

    public Node () {
        this.scanner = new Scanner(System.in);
    }
    public Node (JFrame window) {
        this();
        this.window = window;
    }

    public Node (JFrame window, String feature, Node leftNode, Node rightNode) {
        this(window);
        this.feature = feature;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public void ask(Node parentNode) {
        if (isThisSomething(this.feature)) {
            leftNode.setLeft(true);
            leftNode.ask(this);
        }else {
            rightNode.ask(this);
        }
    }

    protected boolean isThisSomething (String something) {
        String question = this.feature != null
                ? Message.FEATURE.putComplement(something)
                : Message.PLATE.putComplement(something);

        if(hasWindow()) {
            return JOptionPane.showConfirmDialog(getWindow(), question, "Confirm", 0) == 0;
        }

        System.out.println(question);
        String result = scanner.nextLine();

        return YES.getMessage().equals(result);
    }

    protected boolean hasWindow() {
        return this.window != null;
    }
}
