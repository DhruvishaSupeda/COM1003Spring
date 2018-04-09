package assignment2018;

import assignment2018.*;

public class HumanPlayer {


  public int checkCoords(char xCoord) {
    int equivInt = 0;
    switch (xCoord) {
      case 'A': equivInt = 0;
                break;
      case 'B': equivInt = 1;
                break;
      case 'C': equivInt = 2;
                break;
      case 'D': equivInt = 3;
                break;
      case 'E': equivInt = 4;
                break;
      case 'F': equivInt = 5;
                break;
      case 'G': equivInt = 6;
                break;
      case 'H': equivInt = 7;
                break;
    }
    return equivInt;
  }

  //Interacts with the user through the console and keyboard to move the pieces


  /*MOVING Pieces
  --Get input from console
  --Chess requests new move from players in turn (supplied as to and from coordinates) e.g. A2 A3 moves from A2 to A3
  --Check whats in there (use PieceCode?/Pieces)
  --Or even better, getPiece or something then use pieceName.availableMoves()
  --Iterate through ArrayList, if Move they wanna make equal to any in ArrayList, let them make the move, taking over
  other piece if there is one there, else ask for input (while loop?)
  --If king, declare game over and winner

  Methods:
  --checkIfKing - need parameter of flag if its the king to take back to Chess or something
  --Check if legal moves
  --


  */
}
