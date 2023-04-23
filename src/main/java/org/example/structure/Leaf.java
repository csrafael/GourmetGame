package org.example.structure;

import javax.swing.*;

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

    /**
     * Responsable to redirect to next questions according to user answer
     * @param parentNode
     */
    @Override
    public void ask (Node parentNode) {
        if (isThisSomething(plate)) {
            showSuccessDialog();
        }else {
            String newPlate = getNewPlate();
            String newFeature = getNewFeature(newPlate);

            insertNewNode(parentNode, newPlate, newFeature);
        }
    }

    /**
     * Add new question to the game
     * @param parentNode
     * @param newPlate to be added
     * @param newFeature to be added
     */
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

    /**
     * Responsable to receive the correct thought plate
     * @return String plate that user thought
     */
    //TODO put this method in a specific UI class
    private String getNewPlate() {
        if(hasWindow()) {
            return JOptionPane.showInputDialog(getWindow(), THOUGHT_PLATE.getMessage(), GIVE_UP.getMessage(), 3);
        }
        System.out.println(CUT_LINE.getMessage());
        System.out.println(THOUGHT_PLATE.getMessage());
        return getScanner().nextLine();
    }

    /**
     * @param newPlate correct thought plate that was added by user
     * @return String feature that differs the correct plate from suggested plate
     */
    //TODO put this method in a specific UI class
    private String getNewFeature(String newPlate) {
        String question = NEW_FEATURE.putComplement(newPlate,this.plate);
        if(hasWindow()) {
            return JOptionPane.showInputDialog(getWindow(), question, COMPLETE.getMessage(), 3);
        }
        System.out.println(CUT_LINE.getMessage());
        System.out.println(question);
        return getScanner().nextLine();
    }

    /**
     * Show Success Dialog
     */
    //TODO put this method in a specific UI class
    private void showSuccessDialog() {
        if(hasWindow()) {
            JOptionPane.showMessageDialog(getWindow(), SUCCESS.getMessage(), CONFIRM.getMessage(), 1);
        }else {
            System.out.println(SUCCESS.getMessage());
            System.out.println(CUT_LINE.getMessage());
        }
    }
}
