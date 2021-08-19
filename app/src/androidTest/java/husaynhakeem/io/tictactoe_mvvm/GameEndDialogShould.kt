package husaynhakeem.io.tictactoe_mvvm

import android.support.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions
import husaynhakeem.io.tictactoe_mvvm.model.Player
import husaynhakeem.io.tictactoe_mvvm.view.GameActivity
import org.junit.Rule
import org.junit.Test

/**
 * Created by husaynhakeem on 9/5/17.
 */
class GameEndDialogShould {
    @Rule
    var activityRule = ActivityTestRule(
        GameActivity::class.java
    )

    @Test
    @Throws(Exception::class)
    fun display_winner_when_game_ends() {
        givenGameEnded()
        assertDisplayed(R.id.tv_winner)
    }

    @Test
    @Throws(Exception::class)
    fun display_begin_dialog_when_done_clicked() {
        givenGameEnded()

        BaristaDialogInteractions.clickDialogPositiveButton()

        assertNotExist(R.id.tv_winner)
        assertDisplayed(R.id.et_player1)
    }

    private fun givenGameEnded() {
        activityRule.activity.onGameWinnerChanged(Player("husaynhakeem", "x"))
    }
}