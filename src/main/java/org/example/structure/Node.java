package org.example.structure;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.example.ui.Message;

import javax.swing.*;
import java.util.Scanner;

import static org.example.ui.Message.CUT_LINE;
import static org.example.ui.Message.YES;

@Getter
@Setter
public class Node {

    @Setter(AccessLevel.NONE)
    private Scanner scanner;

    @Setter(AccessLevel.NONE)
    private JFrame window;

    private Node leftNode; //yesNode
    private Node rightNode; //noNode

    private String feature;

    private boolean isLeft;

    public Node () {
        this.scanner = new Scanner(System.in);
    }
    public Node (JFrame window) {
        this();
        this.window = window;
    }

    /**
     * Constructor for Text User Interface Game
     * @param feature that defines the difference between leafNodes
     * @param leftNode that is defined (AGREE) by the feature
     * @param rightNode that IS NOT (DISAGREE) defined by the feature
     */
    public Node (String feature, Node leftNode, Node rightNode) {
        this();
        this.feature = feature;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * Constructor for Graphic User Interface Game
     * @param window Frame that messages will be shown
     * @param feature that defines the difference between leafNodes
     * @param leftNode that is defined (AGREE) by the feature
     * @param rightNode that IS NOT (DISAGREE) defined by the feature
     */
    public Node (JFrame window, String feature, Node leftNode, Node rightNode) {
        this(feature,leftNode,rightNode);
        this.window = window;
    }

    /**
     * Responsable to redirect to next questions according to user answer
     * @param parentNode
     */
    public void ask(Node parentNode) {
        if (isThisSomething(this.feature)) {
            this.leftNode.setLeft(true);
            this.leftNode.ask(this);
        }else {
            this.rightNode.ask(this);
        }
    }

    /**
     * responsable to make the questions and show to user
     * according to User Interface that is running
     * @param something is the plate or the feature of this node
     * @return true if user answer matches with the question
     */
    protected boolean isThisSomething (String something) {
        String question = this.feature != null
                ? Message.FEATURE.putComplement(something)
                : Message.PLATE.putComplement(something);

        if(hasWindow()) {
            return JOptionPane.showConfirmDialog(getWindow(), question, "Confirm", 0) == 0;
        }

        System.out.println(CUT_LINE.getMessage());
        System.out.println(question);
        String result = scanner.nextLine();

        return YES.getMessage().equals(result);
    }

    /**
     * @return true when it is playing GUI based game
     */
    protected boolean hasWindow() {
        return this.window != null;
    }
}
