package husaynhakeem.io.tictactoe_mvvm.game

import android.arch.core.executor.testing.InstantTaskExecutorRule
import husaynhakeem.io.tictactoe_mvvm.model.Cell
import husaynhakeem.io.tictactoe_mvvm.model.Game
import husaynhakeem.io.tictactoe_mvvm.model.Player
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameShould {
    @Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var game: Game? = null
    private var player: Player? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Husayn", "Yasin")
        player = game?.player1
    }

    @Test
    @Throws(Exception::class)
    fun endGameIfHasThreeSameHorizontalCells() {
        val cell = Cell(player)

        game?.cells!![0][0] = cell
        game?.cells!![0][1] = cell
        game?.cells!![0][2] = cell

        val hasGameEnded = game?.hasGameEnded()

        if (hasGameEnded != null) {
            Assert.assertTrue(hasGameEnded)
        }
    }

    @Test
    @Throws(Exception::class)
    fun endGameIfHasThreeSameVerticalCells() {
        val cell = Cell(player)

        game?.cells!![0][0] = cell
        game?.cells!![1][0] = cell
        game?.cells!![2][0] = cell

        val hasGameEnded = game?.hasGameEnded()

        if (hasGameEnded != null) {
            Assert.assertTrue(hasGameEnded)
        }
    }

    @Test
    @Throws(Exception::class)
    fun endGameIfHasThreeSameDiagonalCells() {
        val cell = Cell(player)

        game?.cells!![0][0] = cell
        game?.cells!![1][1] = cell
        game?.cells!![2][2] = cell

        val hasGameEnded = game?.hasGameEnded()

        if (hasGameEnded != null) {
            Assert.assertTrue(hasGameEnded)
        }
    }

    @Test
    @Throws(Exception::class)
    fun endGameIfBoardIsFull() {
        val cell1 = Cell(Player("1", "x"))
        val cell2 = Cell(Player("2", "o"))
        val cell3 = Cell(Player("1", "x"))
        val cell4 = Cell(Player("2", "o"))
        val cell5 = Cell(Player("1", "x"))
        val cell6 = Cell(Player("2", "o"))
        val cell7 = Cell(Player("1", "x"))
        val cell8 = Cell(Player("2", "o"))
        val cell9 = Cell(Player("1", "x"))

        game?.cells!![0][0] = cell1
        game?.cells!![0][1] = cell2
        game?.cells!![0][2] = cell3
        game?.cells!![1][0] = cell4
        game?.cells!![1][1] = cell5
        game?.cells!![1][2] = cell6
        game?.cells!![2][0] = cell7
        game?.cells!![2][1] = cell8
        game?.cells!![2][2] = cell9

        val isBoardFull = game?.isBoardFull

        if (isBoardFull != null) {
            Assert.assertTrue(isBoardFull)
        }
    }

    @Test
    @Throws(Exception::class)
    fun switchFromPlayer1ToPlayer2() {
        game?.currentPlayer = game?.player1
        game?.switchPlayer()

        Assert.assertEquals(game?.player2, game?.currentPlayer)
    }
}