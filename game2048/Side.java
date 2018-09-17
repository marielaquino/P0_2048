package game2048;

/** Symbolic names for the four sides of a board.
 *  @author P. N. Hilfinger */
enum Side {
    /** The parameters (COL0, ROW0, DCOL, and DROW) for each of the
     *  symbolic directions, D, below are to be interpreted as follows:
     *     The board's standard orientation has the top of the board
     *     as NORTH, and rows and columns (see Model) are numbered
     *     from its lower-left corner. Consider the board oriented
     *     so that side D of the board is farthest from you. Then
     *        * (COL0*s, ROW0*s) are the standard coordinates of the
     *          lower-left corner of the reoriented board (where s is the
     *          board size), and
     *        * If (c, r) are the standard coordinates of a certain
     *          square on the reoriented board, then (c+DCOL, r+DROW)
     *          are the standard coordinates of the squares immediately
     *          above it on the reoriented board.
     *  The idea behind going to this trouble is that by using the
     *  col() and row() methods below to translate from reoriented to
     *  standard coordinates, one can arrange to use exactly the same code
     *  to compute the result of tilting the board in any particular
     *  direction. */

    NORTH(0, 0, 0, 1), EAST(0, 1, 1, 0), SOUTH(1, 1, 0, -1),
    WEST(1, 0, -1, 0);

    /** The side that is in the direction (DCOL, DROW) from any square
     *  of the board.  Here, "direction (DCOL, DROW) means that to
     *  move one space in the direction of this Side increases the row
     *  by DROW and the colunn by DCOL.  (COL0, ROW0) are the row and
     *  column of the lower-left square when sitting at the board facing
     *  towards this Side. */
    Side(int col0, int row0, int dcol, int drow) {
        _row0 = row0;
        _col0 = col0;
        _drow = drow;
        _dcol = dcol;
    }

    /** Return the standard column number for square (C, R) on a board
     *  of size SIZE oriented with this Side on top. */
    int col(int c, int r, int size) {
        return _col0 * (size - 1) + c * _drow + r * _dcol;
    }

    /** Return the standard row number for square (C, R) on a board
     *  of size SIZE oriented with this Side on top. */
    int row(int c, int r, int size) {
        return _row0 * (size - 1) - c * _dcol + r * _drow;
    }

    /** Parameters describing this Side, as documented in the comment at the
     *  start of this class. */
    private int _row0, _col0, _drow, _dcol;

};

