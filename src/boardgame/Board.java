package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Erro: o tabuleiro não pode ter menos que uma linha ou uma coluna! ");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; 
	}
	public int getRows() {
		return rows;
	}
	
	
	public int getColumns() {
		return columns;
	}
	
	
	public Piece piece(int row, int column) {
		if(!positionExists(row,column)) {
			throw new BoardException("Erro: posição inválida! ");
		}
		return pieces[row][column];
	}
	
	public Piece piece (Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Erro: posição inválida! ");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça na posição: "+position);
		}
		// Atribuindo o argumento piece à matriz que define a posicao da peça no tabuleiro
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("A posição não se encontra no tabuleiro! ");
			
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	// método para verificar a existencia da posição
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	// metodo para verificar se há alguma peça na posição passada
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("A posição não está no tabuleiro! ");
		}
		return piece(position) != null;
		
	}
}
