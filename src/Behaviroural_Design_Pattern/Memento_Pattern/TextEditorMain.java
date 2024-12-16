package Behaviroural_Design_Pattern.Memento_Pattern;

/*
 * TextEditor where user can do or undo the changes such as addition, deletion or formatting.
 * This editor stores the snapshot of each state which is text content after each change that
 * helps the user to revert back the change to previous state
 * */

import java.util.Stack;

//originator class
class TextEditor {

    private String content;

    public void writeContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    //saves the current state of the editor
    public EditorMemento save() {
        return new EditorMemento(content);
    }

    //restore
    public void restore(EditorMemento editorMemento) {
        content=editorMemento.getContent();
    }
}

// stores the internal state
// like a median between originator and caretaker
class EditorMemento {

    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
}

// managing the state
// managing mementos (snapshot of the TextEditor)
class Caretaker {

    private final Stack<EditorMemento> history = new Stack<>();

    public void saveState(TextEditor editor) {
        history.push(editor.save());
    }

    public void undoState(TextEditor editor) {
        if(!history.isEmpty()) {
            history.pop();
            editor.restore(history.peek());
        }
    }
}


public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        textEditor.writeContent("Hello World!!!");
        caretaker.saveState(textEditor);

        textEditor.writeContent("Hello Universe!!!");
        caretaker.saveState(textEditor);

        textEditor.writeContent("Hello Multiverse!!!");
        caretaker.saveState(textEditor);

        System.out.println(textEditor.getContent());

        caretaker.undoState(textEditor);
        System.out.println(textEditor.getContent());
    }
}
