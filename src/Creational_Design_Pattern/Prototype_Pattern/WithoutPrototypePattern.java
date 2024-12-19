package Creational_Design_Pattern.Prototype_Pattern;

import java.util.ArrayList;
import java.util.List;

class GamePiece{
    private Integer position;
    private String color;

    public GamePiece(Integer position, String color) {
        this.position = position;
        this.color = color;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "GamePiece{" +
                "position=" + position +
                ", color='" + color + '\'' +
                '}';
    }
}

class GameBoard {

   private final List<GamePiece> gamePieces;

   public GameBoard(List<GamePiece> gamePieces) {
       this.gamePieces = gamePieces;
   }

   public void addGamePiece(GamePiece gamePiece) {
       this.gamePieces.add(gamePiece);
   }

   public List<GamePiece> getGamePieces() {
       return gamePieces;
   }

}

//client
public class WithoutPrototypePattern {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(new ArrayList<>());
        gameBoard.addGamePiece(new GamePiece(1, "red"));
        gameBoard.addGamePiece(new GamePiece(2, "blue"));
        gameBoard.addGamePiece(new GamePiece(3, "green"));

        System.out.println(gameBoard.getGamePieces());

        // wanted to copy the same ???
        // longer way and will be difficult for complex objects
        GameBoard copiedBoard = new GameBoard(new ArrayList<>());
        for (GamePiece gamePiece : gameBoard.getGamePieces()) {
            copiedBoard.addGamePiece(new GamePiece(gamePiece.getPosition(), gamePiece.getColor()));
        }

        System.out.println(copiedBoard.getGamePieces());

    }
}
