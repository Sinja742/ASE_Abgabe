package Error;

public class ElementIsNullException extends Exception{
    public ElementIsNullException(String element) {
       super("ERROR: "+ element + "ist Null");
    }
}
