package Behaviroural_Design_Pattern.Command_Pattern;

//command interface
interface Command {
    void execute();
}


//concrete class for command
class BoldCommand implements Command {

    private TextEdit textEdit;

    public BoldCommand(TextEdit textEdit) {
        this.textEdit = textEdit;
    }

    @Override
    public void execute() {
        textEdit.boldText();
    }
}

class ItalicCommand implements Command {

    private TextEdit textEdit;

    public ItalicCommand(TextEdit textEdit) {
        this.textEdit = textEdit;
    }

    @Override
    public void execute() {
        textEdit.italicText();
    }
}

class UnderlineCommand implements Command {
    private TextEdit textEdit;

    public UnderlineCommand(TextEdit textEdit) {
        this.textEdit = textEdit;
    }

    @Override
    public void execute() {
        textEdit.underlineText();
    }
}

//Button
class Button {

    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void onClick() {
        command.execute();
    }
}


class TextEdit {

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

public class CommandPattern {
    public static void main(String[] args) {
        TextEdit textEdit = new TextEdit();
        Button button = new Button(new BoldCommand(textEdit));
        button.onClick();
    }
}
