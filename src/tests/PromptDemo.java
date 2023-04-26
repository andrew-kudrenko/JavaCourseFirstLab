package tests;

import auth.Prompt;

public class PromptDemo implements Demo {
    private final Prompt prompt = new Prompt();
    private final String correctPassword = "prompt1+2";

    @Override
    public void demo() {
        var verifier = prompt.getVerifier();

        verifier.setCorrectPassword(correctPassword);
        prompt.promptWithWhileLoop();

        System.out.println("\n\nAnd then `for` loop!\n\n");
        prompt.setPrelude("With `For` Loop Password::>");
        verifier.setIncorrectAttemptsLimit(2);
        prompt.promptWithForLoop();
    }
}
