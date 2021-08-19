package husaynhakeem.io.tictactoe_mvvm.game

import husaynhakeem.io.tictactoe_mvvm.model.Cell
import husaynhakeem.io.tictactoe_mvvm.model.Game
import husaynhakeem.io.tictactoe_mvvm.model.Player
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameDiagonalCellsShould {
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
    fun returnTrueIfHasThreeSameDiagonalCellsFromLeft() {
        val cell = Cell(player)

        game?.cells!![0][0] = cell
        game?.cells!![1][1] = cell
        game?.cells!![2][2] = cell

        val hasThreeSameDiagonalCells = game?.hasThreeSameDiagonalCells()

        if (hasThreeSameDiagonalCells != null) {
            Assert.assertTrue(hasThreeSameDiagonalCells)
        }
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromRight() {
        val cell = Cell(player)

        game?.cells!![0][2] = cell
        game?.cells!![1][1] = cell
        game?.cells!![2][0] = cell

        val hasThreeSameDiagonalCells = game?.hasThreeSameDiagonalCells()

        if (hasThreeSameDiagonalCells != null) {
            Assert.assertTrue(hasThreeSameDiagonalCells)
        }
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameDiagonalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game!!.cells!![0][2] = cell
        game!!.cells!![1][1] = cell
        game!!.cells!![2][0] = anotherCell
        val hasThreeSameDiagonalCells = game!!.hasThreeSameDiagonalCells()
        Assert.assertFalse(hasThreeSameDiagonalCells)
    }
}