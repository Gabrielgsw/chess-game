package boardgame;

public class Piece {
	
	// Protecte
	protected Position position;
	private Board board;
	
	// position nao entra no construtor, pois a posição inicial de cada peça é null
	public Piece(Board board) {
		this.board = board;
		position=null;
	}

	protected Board getBoard() {
		return board;
	}
		
}
