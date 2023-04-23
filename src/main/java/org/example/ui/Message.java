package org.example.ui;

import lombok.Getter;

@Getter
public enum Message {
    CUT_LINE("-----------------------------------------"),
    INTRO("Pense em um prato que gosta."),
    FEATURE("O prato que pensou é %s?"),
    NEW_FEATURE("%s é ________, mas %s não."),
    PLATE("O prato que você pensou é %s?"),
    SUCCESS("acertei de novo!"),
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
