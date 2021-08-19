package husaynhakeem.io.tictactoe_mvvm.model

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import husaynhakeem.io.tictactoe_mvvm.utilities.StringUtility

class Game(playerOne: String?, playerTwo: String?) {
    @JvmField
    var player1: Player? = null

    @JvmField
    var player2: Player? = null

    @JvmField
    var currentPlayer = player1

    @JvmField
    var cells: Array<Array<Cell?>>?

    var winner = MutableLiveData<Player?>()

    fun hasGameEnded(): Boolean {
        if (hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()) {
            winner.value = currentPlayer
            return true
        }

        if (isBoardFull) {
            winner.value = null
            return true
        }
        return false
    }

    fun hasThreeSameHorizontalCells(): Boolean {
        return try {
            for (i in 0 until BOARD_SIZE) if (areEqual(
                    cells!![i][0]!!,
                    cells!![i][1]!!,
                    cells!![i][2]!!
                )
            ) return true
            false
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message)
            false
        }
    }

    fun hasThreeSameVerticalCells(): Boolean {
        return try {
            for (i in 0 until BOARD_SIZE)
                if (areEqual(
                    cells!![0][i]!!,
                    cells!![1][i]!!,
                    cells!![2][i]!!)) {
                        return true
                }
            false
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message)
            false
        }
    }

    fun hasThreeSameDiagonalCells(): Boolean {
        return try {
            areEqual(cells!![0][0]!!, cells!![1][1]!!, cells!![2][2]!!) ||
                    areEqual(cells!![0][2]!!, cells!![1][1]!!, cells!![2][0]!!)
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message)
            false
        }
    }

    val isBoardFull: Boolean
        get() {
            for (row in cells!!) {
                for (cell in row) {
                    if (cell == null || cell.isEmpty) {
                        return false
                    }
                }
            }
            return true
        }

    /**
     * 2 cells are equal if:
     * - Both are none null
     * - Both have non null values
     * - both have equal values
     *
     * @param cells: Cells to check if are equal
     * @return
     */
    private fun areEqual(vararg cells: Cell): Boolean {
        if (cells.isEmpty()) {
            return false
        }

        for (cell in cells) {
            if (StringUtility.isNullOrEmpty(cell.player?.value)) {
                return false
            }
        }

        val comparisonBase = cells[0]

        for (i in 1 until cells.size) {
            if (comparisonBase.player!!.value != cells[i].player?.value) {
                return false
            }
        }

        return true
    }

    fun switchPlayer() {
        currentPlayer = if (currentPlayer === player1) player2 else player1
    }

    fun reset() {
        player1 = null
        player2 = null

        currentPlayer = null

        cells = null
    }

    companion object {
        private val TAG = Game::class.java.simpleName
        private const val BOARD_SIZE = 3
    }

    init {
        cells = Array(BOARD_SIZE) { arrayOfNulls(BOARD_SIZE) }

        player1 = Player(playerOne, "x")
        player2 = Player(playerTwo, "o")

        currentPlayer = player1
    }
}