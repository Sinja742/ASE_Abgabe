package Error;

public class FalseInputException extends Exception{
    public FalseInputException() {
        super("ERROR: Die Eingabe entspricht nicht den vorgegebenen Vorschlägen.\nPrüfen Sie auf korrekte Rechtschreibung und Trennung der Wörter durch ein Leerzeichen.\nBitte versuchen Sie es nochmal.");
    }
}
