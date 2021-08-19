package husaynhakeem.io.tictactoe_mvvm.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import husaynhakeem.io.tictactoe_mvvm.R
import husaynhakeem.io.tictactoe_mvvm.databinding.ActivityGameBinding
import husaynhakeem.io.tictactoe_mvvm.model.Player
import husaynhakeem.io.tictactoe_mvvm.utilities.StringUtility
import husaynhakeem.io.tictactoe_mvvm.viewmodel.GameViewModel

class GameActivity : AppCompatActivity() {
    private var gameViewModel: GameViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        promptForPlayers()
    }

    fun promptForPlayers() {
        val dialog: GameBeginDialog = GameBeginDialog.Companion.newInstance(this)

        dialog.isCancelable = false
        dialog.show(supportFragmentManager, GAME_BEGIN_DIALOG_TAG)
    }

    fun onPlayersSet(player1: String?, player2: String?) {
        initDataBinding(player1, player2)
    }

    private fun initDataBinding(player1: String?, player2: String?) {
        val activityGameBinding: ActivityGameBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_game)

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        gameViewModel?.init(player1, player2)

        activityGameBinding.gameViewModel = gameViewModel
        setUpOnGameEndListener()
    }

    private fun setUpOnGameEndListener() {
        gameViewModel?.winner?.observe(this) { winner: Player? -> onGameWinnerChanged(winner) }
    }

    @VisibleForTesting
    fun onGameWinnerChanged(winner: Player?) {
        val winnerName =
            if (winner == null || StringUtility.isNullOrEmpty(winner.name)) NO_WINNER else winner.name!!

        val dialog: GameEndDialog = GameEndDialog.Companion.newInstance(this, winnerName)

        dialog.isCancelable = false
        dialog.show(supportFragmentManager, GAME_END_DIALOG_TAG)
    }

    companion object {
        private const val GAME_BEGIN_DIALOG_TAG = "game_dialog_tag"
        private const val GAME_END_DIALOG_TAG = "game_end_dialog_tag"
        private const val NO_WINNER = "No one"
    }
}