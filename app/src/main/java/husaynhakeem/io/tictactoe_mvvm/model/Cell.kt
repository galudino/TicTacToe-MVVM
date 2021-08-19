package husaynhakeem.io.tictactoe_mvvm.model

import husaynhakeem.io.tictactoe_mvvm.utilities.StringUtility

class Cell(var player: Player?) {
    val isEmpty: Boolean
        get() = player == null || StringUtility.isNullOrEmpty(player?.value)
}
