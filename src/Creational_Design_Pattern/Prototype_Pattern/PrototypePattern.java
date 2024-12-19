package Creational_Design_Pattern.Prototype_Pattern;

import java.util.ArrayList;
import java.util.List;

interface Prototype{
    Prototype clone();
}

class GamePiece2 implements Prototype{
    String color;
    Integer position;

    GamePiece2(String color, Integer position){
        this.color = color;
        this.position = position;
    }

    @Override
    public GamePiece2 clone() {
        return new GamePiece2(color, position);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "GamePiece2{" +
                "color='" + color + '\'' +
                ", position=" + position +
                '}';
    }
}

class GameBoard2 implements Prototype{

    private List<GamePiece2> gamePieces;

    GameBoard2(List<GamePiece2> gamePieces){
        this.gamePieces = gamePieces;
    }

    public void addGamePiece(GamePiece2 gamePiece){
        this.gamePieces.add(gamePiece);
    }

    public List<GamePiece2> getGamePieces() {
        return gamePieces;
    }

    @Override
    public GameBoard2 clone() {
        // Deep copy of GameBoard2, including deep copying all GamePiece2 objects
        List<GamePiece2> clonedPieces = new ArrayList<>();
        for (GamePiece2 piece : gamePieces) {
            clonedPieces.add(piece.clone()); // Clone each GamePiece2 object
        }
        return new GameBoard2(clonedPieces);
    }
}
public class PrototypePattern {
    public static void main(String[] args) {

        GameBoard2 gameBoard2 = new GameBoard2(new ArrayList<>());
        gameBoard2.addGamePiece(new GamePiece2("red", 1));
        gameBoard2.addGamePiece(new GamePiece2("blue", 2));
        gameBoard2.addGamePiece(new GamePiece2("green", 3));
        System.out.println("Original Game Board: " + gameBoard2.getGamePieces());

        //copy
        //simpler to copy a complex object with the same data

        // Copy
        GameBoard2 copiedBoard = gameBoard2.clone();
        System.out.println("Copied Game Board: " + copiedBoard.getGamePieces());

        // Modify the copied board
        //it should not reflect over other objects :)
        copiedBoard.getGamePieces().get(0).setColor("yellow");
        System.out.println("Modified Copied Game Board: " + copiedBoard.getGamePieces());
        System.out.println("Original Game Board After Modification: " + gameBoard2.getGamePieces());

    }
}
