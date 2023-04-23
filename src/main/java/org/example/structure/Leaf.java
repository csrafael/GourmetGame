package org.example.structure;

import javax.swing.*;
import java.util.Scanner;

import static org.example.ui.Message.*;

public class Leaf extends Node{

    private String plate;

    public Leaf (String plate) {
        super();
        this.plate = plate;
    }
    public Leaf (JFrame window, String plate) {
        super(window);
        this.plate = plate;
    }

    public void ask (Node parentNode) {
        if (isThisSomething(plate)) {
            showSuccessDialog();
        }else {
            String newPlate = getNewPlate();
            String newFeature = getNewFeature(newPlate);

            insertNewNode(parentNode, newPlate, newFeature);
        }
    }

    private void insertNewNode(Node parentNode, String newPlate, String newFeature) {

        Node newAnswer = new Leaf(getWindow(), newPlate);
        Node newQuestion = new Node(getWindow(),newFeature,newAnswer,this);

        if (this.isLeft()) {
            newQuestion.setLeft(true);
            parentNode.setLeftNode(newQuestion);
        }else {
            parentNode.setRightNode(newQuestion);
        }
    }

    private String getNewPlate() {
        if(hasWindow()) {
            return JOptionPane.showInputDialog(getWindow(), THOUGHT_PLATE.getMessage(), "Desisto", 3);
        }
        System.out.println(THOUGHT_PLATE.getMessage());
        return getScanner().nextLine();
    }

    private String getNewFeature(String newPlate) {
        String question = NEW_FEATURE.putComplement(newPlate,this.plate);
        if(hasWindow()) {
            return JOptionPane.showInputDialog(getWindow(), question, "Complete", 3);
        }
        System.out.println(question);
        return getScanner().nextLine();
    }

    private void showSuccessDialog() {
        if(hasWindow()) {
            JOptionPane.showMessageDialog(getWindow(), SUCCESS.getMessage(), "Confirm", 1);
        }else {
            System.out.println(SUCCESS.getMessage());
        }
    }
}
