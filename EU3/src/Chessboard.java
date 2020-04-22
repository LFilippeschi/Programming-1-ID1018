
public class Chessboard {

	public class NotValidFieldException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public NotValidFieldException(String message) {
			super(message);
		}
	}

	// field define each "box"
	public static class Field {
		private char row;
		private byte column;
		private Chesspiece piece = null; // the piece on the field?
		private boolean marked = false; // used to show the possible moves of this.piece

		public Field(char row, byte column) {
			this.row = row;
			this.column = column;
		}

		public void put(Chesspiece piece) {
			this.piece = piece;
		}

		public Chesspiece take() { // ?? remove the piece ??
//			Chesspiece takenPiece1 = (Chesspiece) new this.piece.getClass(this.piece.color, this.piece.name);
//			this.piece.getClass() takenPiece = new this.piece.getClass(this.piece.color, this.piece.name);
			return piece;
		}

		public void mark() { // display possible moves of the piece on the field for a short time DELAY
			marked = true;
		}

		public void unmark() { // resets the field to unmarked after a short DELAY, called from mark()
			marked = false;
		}

		public String toString() {
			String s = (marked) ? " xx" : " --"; // if the field is selected and there's no piece on the field prints
													// the
													// two options if marked or not
			return (piece == null) ? s : " " + piece.toString(); // if there's a piece on the field prints the name of
																	// the
																	// piece on the field otherwise prints s
		}

	}

	public static final int NUMBER_OF_ROWS = 8;
	public static final int NUMBER_OF_COLUMNS = 8;
	public static final int FIRST_ROW = 'a';
	public static final int FIRST_COLUMN = 1;
	private Field[][] fields;

	public Chessboard() {
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		char row = 0;
		byte column = 0;
		for (int r = 0; r < NUMBER_OF_ROWS; r++) {
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;
			for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				fields[r][c] = new Field(row, column);
				column++;
			}
		}
	}

	public String toString() { // display the Chessboard
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int i = 1; i <= NUMBER_OF_COLUMNS; i++) // prints the first row
			sb.append(i + "   ");
		sb.append("\n");
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {
			sb.append((char) (FIRST_ROW + row)); // prints the name of the row
			for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
				sb.append(fields[col][row].toString() + " ");
			}
			sb.append("\n"); // new line when the row has finished printing
		}
		return sb.toString();
	}

	public boolean isValidField(char row, byte column) { // true if the piece can be placed on this field
		boolean rtrn = true;

		if (row < 'a' || row > 'a' + NUMBER_OF_ROWS - 1) // check on rows and columns out of range
			rtrn = false;
		if (column < 1 || column > NUMBER_OF_COLUMNS)
			rtrn = false;

		// white or black piece on the field !one piece at a time on the board!
		// if(fields[row][column].piece.color)

		return rtrn;
	}

	public abstract class Chesspiece {
		private char color;
		// w - white , b - black
		private char name;
		// K - King , Q - Queen , R - Rook , B - Bishop , N - Knight ,
		// P Pawn
		protected char row = 0;
		protected byte column = -1;

		protected Chesspiece(char color, char name) {
			this.color = color;
			this.name = name;
			row = (char) (Math.random() * 7 + FIRST_ROW);
			column = (byte) (Math.random() * 7 + FIRST_COLUMN);
			Chessboard.this.fields[(int) row - (int) FIRST_ROW][(int) column - (int) FIRST_COLUMN].put(this);
			markReachableFields();
			// print the board
			System.out.println(Chessboard.this.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException iox) {
			}
			this.unmarkReachableFields();
			System.out.println(Chessboard.this.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException iox) {
			}
			this.moveOut();
			System.out.println(Chessboard.this.toString());

		}

		public String toString() {
			return "" + color + name;
		}

		public boolean isOnBoard() {
			return Chessboard.this.isValidField(row, column);
		}

		public void moveTo(char row, byte column) throws NotValidFieldException {
			if (!Chessboard.this.isValidField(row, column))
				throw new NotValidFieldException("bad field : " + row + column);
			this.row = row;
			this.column = column;
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			Chessboard.this.fields[r][c].put(this);
		}

		public void moveOut() {
			Chessboard.this.fields[(int) row - (int) FIRST_ROW][(int) column - (int) FIRST_COLUMN].piece = null;
			row = 0;
			column = -1;
		}

		public abstract void markReachableFields();

		public abstract void unmarkReachableFields();
	}

	public class Pawn extends Chesspiece {
		public Pawn(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
		}

		public void unmarkReachableFields() {
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
		}
	}

	public class Rook extends Chesspiece {
		public Rook(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			for (int i = 0; i < NUMBER_OF_COLUMNS; i++) { // marks all the columns keeping the same row
				byte col = (byte) (i + FIRST_COLUMN);
				if (Chessboard.this.isValidField(row, col)) {
					int r = row - FIRST_ROW;
					int c = col - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}
			for (int j = 0; j < NUMBER_OF_ROWS; j++) { // marks all the rows keeping the same column
				char row = (char) (FIRST_ROW + j);
				if (Chessboard.this.isValidField(row, column)) {
					int r = row - FIRST_ROW;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}
		}

		public void unmarkReachableFields() {
			for (int i = 0; i < NUMBER_OF_COLUMNS; i++) { // marks all the columns keeping the same row
				byte col = (byte) (i + FIRST_COLUMN);
				if (Chessboard.this.isValidField(row, col)) {
					int r = row - FIRST_ROW;
					int c = col - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}
			for (int j = 0; j < NUMBER_OF_ROWS; j++) { // marks all the rows keeping the same column
				char row = (char) (FIRST_ROW + j);
				if (Chessboard.this.isValidField(row, column)) {
					int r = row - FIRST_ROW;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}
		}

	}

	public class Knight extends Chesspiece {
		public Knight(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			int i = 1;
			int j = 2;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
			i = 1;
			j = -2;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
			i = 2;
			j = 1;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
			i = 2;
			j = -1;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
			i = -1;
			j = 2;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
			i = -1;
			j = -2;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
			i = -2;
			j = 1;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
			i = -2;
			j = -1;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}

		}

		public void unmarkReachableFields() {
			int i = 1;
			int j = 2;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
			i = 1;
			j = -2;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
			i = 2;
			j = 1;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
			i = 2;
			j = -1;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
			i = -1;
			j = 2;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
			i = -1;
			j = -2;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
			i = -2;
			j = 1;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
			i = -2;
			j = -1;
			if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
		}
	}

	public class Bishop extends Chesspiece {
		public Bishop(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			int i = 1; // marks all the fields north-east
			int j = 1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
				i++;
				j++;
			}

			i = -1; // marks all the fields south-west
			j = -1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
				i--;
				j--;
			}

			i = -1; // marks all the fields north-west
			j = 1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
				i--;
				j++;
			}

			i = 1; // marks all the fields south-east
			j = -1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
				i++;
				j--;
			}
		}

		public void unmarkReachableFields() {
			int i = 1; // unmarks all the fields north-east
			int j = 1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
				i++;
				j++;
			}

			i = -1; // unmarks all the fields south-west
			j = -1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
				i--;
				j--;
			}

			i = -1; // unmarks all the fields north-west
			j = 1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
				i--;
				j++;
			}

			i = 1; // unmarks all the fields south-east
			j = -1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
				i++;
				j--;
			}
		}
	}

	public class Queen extends Chesspiece {
		public Queen(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			for (int i = 0; i < NUMBER_OF_COLUMNS; i++) { // marks all the columns keeping the same row
				byte col = (byte) (i + FIRST_COLUMN);
				if (Chessboard.this.isValidField(row, col)) {
					int r = row - FIRST_ROW;
					int c = col - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}
			for (int j = 0; j < NUMBER_OF_ROWS; j++) { // marks all the rows keeping the same column
				char row = (char) (FIRST_ROW + j);
				if (Chessboard.this.isValidField(row, column)) {
					int r = row - FIRST_ROW;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}

			int i = 1; // marks all the fields north-east
			int j = 1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
				i++;
				j++;
			}

			i = -1; // marks all the fields south-west
			j = -1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
				i--;
				j--;
			}

			i = -1; // marks all the fields north-west
			j = 1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
				i--;
				j++;
			}

			i = 1; // marks all the fields south-east
			j = -1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
				i++;
				j--;
			}

		}

		public void unmarkReachableFields() {
			for (int i = 0; i < NUMBER_OF_COLUMNS; i++) { // unmarks all the columns keeping the same row
				byte col = (byte) (i + FIRST_COLUMN);
				if (Chessboard.this.isValidField(row, col)) {
					int r = row - FIRST_ROW;
					int c = col - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}
			for (int j = 0; j < NUMBER_OF_ROWS; j++) { // unmarks all the rows keeping the same column
				char row = (char) (FIRST_ROW + j);
				if (Chessboard.this.isValidField(row, column)) {
					int r = row - FIRST_ROW;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}

			int i = 1; // unmarks all the fields north-east
			int j = 1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
				i++;
				j++;
			}

			i = -1; // unmarks all the fields south-west
			j = -1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
				i--;
				j--;
			}

			i = -1; // unmarks all the fields north-west
			j = 1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
				i--;
				j++;
			}

			i = 1; // unmarks all the fields south-east
			j = -1;
			while (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
				int r = row + i - FIRST_ROW;
				int c = column + j - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
				i++;
				j--;
			}
		}
	}

	public class King extends Chesspiece {
		public King(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {

			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
						int r = row + i - FIRST_ROW;
						int c = column + j - FIRST_COLUMN;
						Chessboard.this.fields[r][c].mark();
					}
				}
			}
		}

		public void unmarkReachableFields() {
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (Chessboard.this.isValidField((char) (row + i), (byte) (column + j))) {
						int r = row + i - FIRST_ROW;
						int c = column + j - FIRST_COLUMN;
						Chessboard.this.fields[r][c].unmark();
					}
				}
			}
		}
	}
}
