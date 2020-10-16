import android.view.View
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.model.FoodModel
import com.example.gameforchildren.ui.fragments.LevelSelectionFragment
import com.example.gameforchildren.utilits.*
import kotlinx.android.synthetic.main.fragment_edible_game_question.*


class EdibleGameQuestionFragment : Fragment(R.layout.fragment_edible_game_question) {
    var trueCount = 0
    var rounds = 10
    var count = 0
    var result: Boolean = false
    lateinit var items: List<FoodModel>
    override fun onResume() {
        super.onResume()
        initBaseActions()
        initFood()
        drawNewQuest()
    }

    private fun initBaseActions() {
                button_back_to_menu_from_edible.setOnClickListener {
            replaceFragment(LevelSelectionFragment(), false)
        }
        APP_ACTIVITY.title = getString(R.string.EdibleGameTitle)
    }

    private fun resultFunc() {
        if (result) trueCount++
        result.progressChange(count)
        count++
        if (count < rounds) {
            drawNewQuest()
        } else endLevel(trueCount, rounds)
    }


    private fun drawNewQuest() {
        result = false
        items = getRandomFood()
        edibleFirstItemName.text = items[0].name
        edibleSecondItemName.text = items[1].name
        edibleImageFirstItem.setImageResource(items[0].image)
        ediableImageSecondItem.setImageResource(items[1].image)
        edibleImageFirstItem.isClickable = true
        ediableImageSecondItem.isClickable = true
         updateListeners()

    }

    fun updateListeners() {
        val listener1 = ChooseTouchListener(edibleImageFirstItem, items[0].edible) {
            result = items[0].edible
            resultFunc()
        }
        val listener2 = ChooseTouchListener(ediableImageSecondItem, items[1].edible) {
            result = items[1].edible
            resultFunc()
        }
        edibleImageFirstItem.setOnTouchListener(listener1)
        ediableImageSecondItem.setOnTouchListener(listener2)
    }
}
