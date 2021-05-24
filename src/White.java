public class White {
	boolean knightThreat = false;
	boolean kingThreat = false;
	boolean bishopThreat = false;
	boolean rookThreat = false;
	boolean pawnThreat = false;
	boolean queenThreat = false;
	int score;
	int whitePawnThreatCount = 0, whiteBishopThreatCount = 0, whiteKnightThreatCount = 0, whiteRookThreatCount = 0;
	int whiteKingThreatCount = 0, whiteQueenThreatCount = 0;

	int pawn = 0, knight = 0, rook = 0, bishop = 0, king = 0, queen;

	public void score() {
		double score = (whitePawnThreatCount * 0.5) + (pawn - whitePawnThreatCount);
		score += (whiteBishopThreatCount * 1.5) + (bishop - whiteBishopThreatCount) * 3;
		score += (whiteKnightThreatCount * 1.5) + (knight - whiteKnightThreatCount) * 3;
		score += whiteRookThreatCount * 2.5 + (rook - whiteRookThreatCount) * 5;
		score += whiteKingThreatCount * 4.5 + (king - whiteKingThreatCount) * 9;
		score += whiteQueenThreatCount * 50 + (queen - whiteQueenThreatCount) * 100;

		System.out.println("White: " + score);

	}

	public void write(String board[][]) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].equalsIgnoreCase("fb")) {
					bishop++;
				}
				if (board[i][j].equalsIgnoreCase("pb")) {
					pawn++;
				}
				if (board[i][j].equalsIgnoreCase("ab")) {
					knight++;
				}
				if (board[i][j].equalsIgnoreCase("vb")) {
					king++;
				}
				if (board[i][j].equalsIgnoreCase("sb")) {
					queen++;
				}
				if (board[i][j].equalsIgnoreCase("kb")) {
					rook++;
				}
			}
		}
	}

	// Control of the threatening white bishop is ensured.
	public void whiteBishopThreatControl(String board[][]) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].equalsIgnoreCase("fs")) {

					x = i;
					y = j;
					while (x > 0 && y > 0) {

						comparison(x - 1, y - 1, board);
						if (board[x - 1][y - 1].charAt(1) == 'b' || board[x - 1][y - 1].charAt(1) == 's') {
							break;

						}
						x--;
						y--;

					}
					x = i;
					y = j;
					while (x < 7 && y > 0) {
						comparison(x + 1, y - 1, board);
						if (board[x + 1][y - 1].charAt(1) == 'b' || board[x + 1][y - 1].charAt(1) == 's') {
							break;

						}
						x++;
						y--;
					}
					x = i;
					y = j;
					while (x > 0 && y < 7) {

						comparison(x - 1, y + 1, board);
						if (board[x - 1][y + 1].charAt(1) == 'b' || board[x - 1][y + 1].charAt(1) == 's') {
							break;

						}
						x--;
						y++;
					}
					x = i;
					y = j;
					while (x < 7 && y < 7) {

						comparison(x + 1, y + 1, board);
						if (board[x + 1][y + 1].charAt(1) == 'b' || board[x + 1][y + 1].charAt(1) == 's') {
							break;
						}
						x++;
						y++;
					}
				}
			}
		}
	}

	// Comparison of the values of the pieces on the chessboard according to their
	// condition.
	public void comparison(int i, int j, String board[][]) {
		if (board[i][j].equalsIgnoreCase("pb")) 
		{
			whitePawnThreatCount++;
		}
		if (board[i][j].equalsIgnoreCase("vb")) 
		{
			whiteKingThreatCount++;
		}
		if (board[i][j].equalsIgnoreCase("ab")) 
		{
			whiteKnightThreatCount++;
		}
		if (board[i][j].equalsIgnoreCase("fb")) 
		{
			whiteBishopThreatCount++;
		}
		if (board[i][j].equalsIgnoreCase("sb")) 
		{
			whiteQueenThreatCount++;
		}
		if (board[i][j].equalsIgnoreCase("kb")) 
		{
			whiteRookThreatCount++;
		}
	}

	// Control of the threatening white knight is ensured.
	public void whiteKnightThreatControl(String board[][]) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].equalsIgnoreCase("as")) {

					if (i >= 1 && j >= 2 && board[i - 1][j - 2].charAt(1) == 'b') {
						comparison(i - 1, j - 2, board);
					}
					if (j >= 2 && i < 7 && board[i + 1][j - 2].charAt(1) == 'b') {
						comparison(i + 1, j - 2, board);
					}
					if (i < 7 && j >= 2 && board[i + 1][j - 2].charAt(1) == 'b') {
						comparison(i - 2, j - 1, board);
					}
					if (i >= 2 && j < 7 && board[i - 2][j + 1].charAt(1) == 'b') {
						comparison(i - 2, j + 1, board);
					}
					if (j >= 1 && i < 6 && board[i + 2][j - 1].charAt(1) == 'b') {
						comparison(i + 2, j - 1, board);
					}
					if (i < 6 && j < 7 && board[i + 2][j + 1].charAt(1) == 'b') {
						comparison(i + 2, j + 1, board);
					}
					if (i >= 1 && j < 6 && board[i - 1][j + 2].charAt(1) == 'b') {
						comparison(i - 1, j + 2, board);
					}
					if (i < 7 && j < 6 && board[i + 1][j + 2].charAt(1) == 'b') {
						comparison(i + 1, j + 2, board);
					}
					if (i >= 2 && j > 1 && board[i - 2][j - 1].charAt(1) == 'b') {
						comparison(i - 2, j - 1, board);
					}
				}
			}
		}
	}
}