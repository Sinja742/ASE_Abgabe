package Error;

public class FalseInputException extends Exception{
    public FalseInputException() {
        super("Die Eingabe entspricht nicht den vorgegebenen Vorschlägen. Bitte versuchen Sie es nochmal.");
    }
}
