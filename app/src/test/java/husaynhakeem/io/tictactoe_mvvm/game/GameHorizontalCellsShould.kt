package husaynhakeem.io.tictactoe_mvvm.game

import husaynhakeem.io.tictactoe_mvvm.model.Game.hasGameEnded
import husaynhakeem.io.tictactoe_mvvm.model.Game.isBoardFull
import husaynhakeem.io.tictactoe_mvvm.model.Game.switchPlayer
import husaynhakeem.io.tictactoe_mvvm.model.Game.hasThreeSameDiagonalCells
import husaynhakeem.io.tictactoe_mvvm.model.Game.hasThreeSameVerticalCells
import husaynhakeem.io.tictactoe_mvvm.model.Game.hasThreeSameHorizontalCells
import android.arch.core.executor.testing.InstantTaskExecutorRule
import husaynhakeem.io.tictactoe_mvvm.model.Cell
import husaynhakeem.io.tictactoe_mvvm.model.Game
import husaynhakeem.io.tictactoe_mvvm.model.Player
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.Exception
import kotlin.Throws

class GameHorizontalCellsShould {
    private var game: Game? = null
    private var player: Player? = null
    private var anotherPlayer: Player? = null
    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Husayn", "Yasin")
        player = game!!.player1
        anotherPlayer = game!!.player2
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow1() {
        val cell = Cell(player)
        game!!.cells!![0][0] = cell
        game!!.cells!![0][1] = cell
        game!!.cells!![0][2] = cell
        val hasThreeSameHorizontalCells = game!!.hasThreeSameHorizontalCells()
        Assert.assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow2() {
        val cell = Cell(player)
        game!!.cells!![1][0] = cell
        game!!.cells!![1][1] = cell
        game!!.cells!![1][2] = cell
        val hasThreeSameHorizontalCells = game!!.hasThreeSameHorizontalCells()
        Assert.assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow3() {
        val cell = Cell(player)
        game!!.cells!![2][0] = cell
        game!!.cells!![2][1] = cell
        game!!.cells!![2][2] = cell
        val hasThreeSameHorizontalCells = game!!.hasThreeSameHorizontalCells()
        Assert.assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameHorizontalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game!!.cells!![0][0] = cell
        game!!.cells!![0][1] = cell
        game!!.cells!![0][2] = anotherCell
        val hasThreeSameHorizontalCells = game!!.hasThreeSameHorizontalCells()
        Assert.assertFalse(hasThreeSameHorizontalCells)
    }
}