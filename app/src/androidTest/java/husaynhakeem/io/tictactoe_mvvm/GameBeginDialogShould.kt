package husaynhakeem.io.tictactoe_mvvm

import android.support.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import husaynhakeem.io.tictactoe_mvvm.view.GameActivity
import org.junit.Rule
import org.junit.Test

class GameBeginDialogShould {
    @Rule
    var activityRule = ActivityTestRule(
        GameActivity::class.java
    )

    @Test
    @Throws(Exception::class)
    fun display_empty_names_message_if_names_empty() {
        writeTo(R.id.et_player1, "")
        writeTo(R.id.et_player2, "")

        BaristaDialogInteractions.clickDialogPositiveButton()

        assertDisplayed(R.string.game_dialog_empty_name)
    }

    @Test
    @Throws(Exception::class)
    fun display_same_names_message_if_names_same() {
        writeTo(R.id.et_player1, "husaynhakeem")
        writeTo(R.id.et_player2, "husaynhakeem")

        BaristaDialogInteractions.clickDialogPositiveButton()

        assertDisplayed(R.string.game_dialog_same_names)
    }

    @Test
    @Throws(Exception::class)
    fun display_empty_name_message_if_one_name_empty() {
        writeTo(R.id.et_player1, "")
        writeTo(R.id.et_player2, "husaynhakeem")

        BaristaDialogInteractions.clickDialogPositiveButton()

        assertDisplayed(R.string.game_dialog_empty_name)
    }

    @Test
    @Throws(Exception::class)
    fun close_dialog_after_names_valid() {
        writeTo(R.id.et_player1, "husaynhakeem 1")
        writeTo(R.id.et_player2, "husaynhakeem 2")

        BaristaDialogInteractions.clickDialogPositiveButton()

        assertNotExist(R.id.layout_player1)
    }
}