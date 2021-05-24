public class Black {

	int blackPawnThreatCount = 0, blackBishopThreatCount = 0, blackKnightThreatCount = 0, blackRookThreatCount = 0;
	int blackKingThreatCount = 0, blackQueenThreatCount = 0;
	int pawn = 0, knight = 0, rook = 0, bishop = 0, king = 0, queen;

	public void score() {
		double score = (blackPawnThreatCount * 0.5) + (pawn - blackPawnThreatCount);
		score += (blackBishopThreatCount * 1.5) + (bishop - blackBishopThreatCount) * 3;
		score += (blackKnightThreatCount * 1.5) + (knight - blackKnightThreatCount) * 3;
		score += blackRookThreatCount * 2.5 + (rook - blackRookThreatCount) * 5;
		score += blackKingThreatCount * 4.5 + (king - blackKingThreatCount) * 9;
		score += blackQueenThreatCount * 50 + (queen - blackQueenThreatCount) * 100;

		System.out.print("\t\tBlack: " + score + "\t,");

	}

	public void write(String board[][]) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].equalsIgnoreCase("fs")) {
					bishop++;
				}
				if (board[i][j].equalsIgnoreCase("ps")) {
					pawn++;
				}
				if (board[i][j].equalsIgnoreCase("as")) {
					knight++;
				}
				if (board[i][j].equalsIgnoreCase("vs")) {
					king++;
				}
				if (board[i][j].equalsIgnoreCase("ss")) {
					queen++;
				}
				if (board[i][j].equalsIgnoreCase("ks")) {
					rook++;
				}
			}
		}
	}

	// Control of the threatening black bishop is ensured.
	public void blackBishopThreatControl(String board[][]) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].equalsIgnoreCase("fb")) {
					x = i;
					y = j;
					while (x > 0 && y > 0) {

						comparison(x - 1, y - 1, board);
						if (board[x - 1][y - 1].charAt(1) == 's') {
							break;

						}
						x--;
						y--;

					}
					x = i;
					y = j;
					while (x < 7 && y > 0) {
						comparison(x + 1, y - 1, board);
						if (board[x + 1][y - 1].charAt(1) == 's') {
							break;

						}
						x++;
						y--;
					}
					x = i;
					y = j;
					while (x > 0 && y < 7)
					{

						comparison(x - 1, y + 1, board);
						if (board[x][y].charAt(1) == 's') {
							break;

						}
						x--;
						y++;
					}
					x = i;
					y = j;
					while (x < 7 && y < 7) {

						comparison(x + 1, y + 1, board);
						if (board[x + 1][y + 1].charAt(1) == 's') {
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
		if (board[i][j].equalsIgnoreCase("ps")) {
			blackPawnThreatCount++;
		}
		if (board[i][j].equalsIgnoreCase("vs")) {
			blackKingThreatCount++;
		}
		if (board[i][j].equalsIgnoreCase("as")) {
			blackKnightThreatCount++;
		}
		if (board[i][j].equalsIgnoreCase("fs")) {
			blackBishopThreatCount++;
		}
		if (board[i][j].equalsIgnoreCase("ss")) {
			blackQueenThreatCount++;
		}
		if (board[i][j].equalsIgnoreCase("ks")) {
			blackRookThreatCount++;
		}
	}

	// Control of the threatening black knight is ensured.
	public void blackKnightThreatControl(String board[][]) {

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {
				if (board[i][j].equalsIgnoreCase("ab")) {
					if (i >= 1 && j >= 2 && board[i - 1][j - 2].charAt(1) == 's') {
						comparison(i - 1, j - 2, board);
					}
					if (j >= 2 && i < 7 && board[i + 1][j - 2].charAt(1) == 's') {
						comparison(i + 1, j - 2, board);
					}
					if (i < 7 && j >= 2 && board[i + 1][j - 2].charAt(1) == 's') {
						comparison(i - 2, j - 1, board);
					}
					if (i >= 2 && j < 7 && board[i - 2][j + 1].charAt(1) == 's') {
						comparison(i - 2, j + 1, board);
					}

					if (i >= 2 && j > 1 && board[i - 2][j - 1].charAt(1) == 's') {
						comparison(i - 2, j - 1, board);
					}
					if (j >= 1 && i < 6 && board[i + 2][j - 1].charAt(1) == 's') {
						comparison(i + 2, j - 1, board);
					}
					if (i < 6 && j >= 1 && board[i + 2][j - 1].charAt(1) == 's') {
						comparison(i + 2, j - 1, board);
					}
					if (i >= 1 && j < 6 && board[i - 1][j + 2].charAt(1) == 's') {
						comparison(i - 1, j + 2, board);
						board[i - 1][j + 2] = "xx";
					}
					if (i < 7 && j < 6 && board[i + 1][j + 2].charAt(1) == 's') {
						comparison(i + 1, j + 2, board);
					}
				}
			}
		}
	}
}