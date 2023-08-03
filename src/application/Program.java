package application;

import boardgame.Position;
import chess.ChessMatch;
import boardgame.Board;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch chessMatch = new ChessMatch();
		
		// Passando a matriz de peças como argumento para a classe User Interface no método printBoard
		UI.printBoard(chessMatch.getPieces());
	}

}
