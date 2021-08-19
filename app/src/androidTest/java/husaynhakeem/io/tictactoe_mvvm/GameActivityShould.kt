package husaynhakeem.io.tictactoe_mvvm

import android.support.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import husaynhakeem.io.tictactoe_mvvm.model.Player
import husaynhakeem.io.tictactoe_mvvm.view.GameActivity
import org.junit.Rule
import org.junit.Test

class GameActivityShould {
    @Rule
    var activityRule = ActivityTestRule(
        GameActivity::class.java
    )

    private val player1 = Player("Husayn", "x")
    private val player2 = Player("Yasin", "o")

    @Test
    fun end_game_when_one_player_wins() {
        writeTo(R.id.et_player1, player1.name!!)
        writeTo(R.id.et_player2, player2.name!!)

        BaristaDialogInteractions.clickDialogPositiveButton()

        clickOn(R.id.cell_00)
        clickOn(R.id.cell_10)
        clickOn(R.id.cell_01)
        clickOn(R.id.cell_11)
        clickOn(R.id.cell_02)

        assertDisplayed(R.id.tv_winner)
        assertDisplayed(player1.name!!)
    }
}