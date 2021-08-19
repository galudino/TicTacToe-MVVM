package husaynhakeem.io.tictactoe_mvvm.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayMap
import husaynhakeem.io.tictactoe_mvvm.model.Cell
import husaynhakeem.io.tictactoe_mvvm.model.Game
import husaynhakeem.io.tictactoe_mvvm.model.Player
import husaynhakeem.io.tictactoe_mvvm.utilities.StringUtility

class GameViewModel : ViewModel() {
    var cells: ObservableArrayMap<String?, String?>? = null
    private var game: Game? = null

    fun init(player1: String?, player2: String?) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row: Int, column: Int) {
        if (game?.cells!![row][column] == null) {
            game?.cells!![row][column] = Cell(game?.currentPlayer)
            cells!![StringUtility.stringFromNumbers(row, column)] = game?.currentPlayer?.value

            if (game?.hasGameEnded() == true) {
                game?.reset()
            } else {
                game?.switchPlayer()
            }
        }
    }

    val winner: LiveData<Player?>?
        get() = game?.winner
}