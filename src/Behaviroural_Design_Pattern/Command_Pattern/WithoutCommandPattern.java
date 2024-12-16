package Behaviroural_Design_Pattern.Command_Pattern;

class TextEditor {

    public void boldText() {
        System.out.println("Text has been bolded..");
    }

    public void italicText() {
        System.out.println("Text has been italicized..");
    }

    public void underlineText() {
        System.out.println("Text has been underlined");
    }
}

//Hardcoded class for Bold
class BoldButton{

    private TextEditor textEditor;

    public BoldButton(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void click() {
        textEditor.boldText();
    }
}

//Hardcoded class for Italic
class ItalicButton{

    private TextEditor textEditor;

    public ItalicButton(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void click() {
        textEditor.italicText();
    }
}

//Hardcoded class for underline
class UnderlineButton{

    private TextEditor textEditor;

    public UnderlineButton(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void click() {
        textEditor.underlineText();
    }
}

public class WithoutCommandPattern {
    public static void main(String[] args) {
    TextEditor textEditor = new TextEditor();
    //tightly coupled with the editor
    BoldButton boldButton = new BoldButton(textEditor);
    ItalicButton italicButton = new ItalicButton(textEditor);
    UnderlineButton underlineButton = new UnderlineButton(textEditor);

    boldButton.click();
    italicButton.click();
    underlineButton.click();
    }
}
