package org.example.ui;

import lombok.Getter;

@Getter
public enum Message {
    COMPLETE("Complete"),
    CONFIRM("Confirm"),
    CONTINUE("Deseja continuar?"),
    CUT_LINE("-----------------------------------------"),
    FEATURE("O prato que pensou é %s?"),
    GIVE_UP("Desisto!"),
    INTRO("Pense em um prato que gosta."),
    NEW_FEATURE("%s é ________, mas %s não."),
    OK("OK"),
    PLATE("O prato que você pensou é %s?"),
    PROCEED("Aperte enter para seguir!"),
    SUCCESS("acertei de novo!"),
    TITLE("GORMET GAME"),
    THOUGHT_PLATE("Qual prato você pensou?"),
    YES("sim");

    private String message;

    Message(String message){
        this.message = message;
    }

    public String putComplement(String complement) {
        return String.format(this.message, complement);
    }
    public String putComplement(String complement1, String complement2) {
        return String.format(this.message, complement1, complement2);
    }
}
