package Practice;

import java.util.ArrayList;
import java.util.List;

class TextEditor {

    private String text="";

    public void typeText(String text) {
        this.text += text+" ";
    }

    public String getText() {
        return text;
    }

    public void restoreText(TextEditorMemento memento) {
        this.text = memento.getText();
    }

    public TextEditorMemento saveText() {
        return new TextEditorMemento(text);
    }
}

class TextEditorMemento {

    private final String text;

    public TextEditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class TextEditorHistory {

    private final TextEditor textEditor;

    private final List<TextEditorMemento> historyList;

    TextEditorHistory(TextEditor textEditor) {
        this.textEditor = textEditor;
        this.historyList = new ArrayList<>();
    }

    public void save() {
        this.historyList.add(textEditor.saveText());
    }

    public void undo() {
        if(historyList.isEmpty()) {
            return;
        }
        historyList.remove(historyList.size() - 1);
        textEditor.restoreText(this.historyList.get(historyList.size() - 1));
    }
}

public class MementoPatternExample {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory(textEditor);

        textEditor.typeText("Hello");
        history.save();

        System.out.println(textEditor.getText());

        textEditor.typeText("World");
        history.save();

        System.out.println(textEditor.getText());
        history.undo();

        System.out.println(textEditor.getText());
    }
}
