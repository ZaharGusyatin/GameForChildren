import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.model.FoodModel
import com.example.gameforchildren.ui.fragments.EndLevelFragment
import com.example.gameforchildren.ui.fragments.LevelSelectionFragment
import com.example.gameforchildren.utilits.*
import kotlinx.android.synthetic.main.fragment_edible_game_question.*
import kotlinx.coroutines.*
import java.lang.Exception
import java.util.logging.Handler


class EdibleGameQuestionFragment : Fragment(R.layout.fragment_edible_game_question) {
    private var trueCount = 0
    private var rounds = 10
    private var count = 0
    private  var result: Boolean = false
    private lateinit var items: List<FoodModel>
    override fun onResume() {
        super.onResume()

        initBaseActions()
        initClickers()
        initFood()
        drawNewQuest()

    }


    private fun initClickers() {
        edibleImageFirstItem.setOnClickListener {
            result = items[0].edible
            edibleImageFirstItem.showResult(result)
            resultFunc()
        }
        ediableImageSecondItem.setOnClickListener {
            result = items[1].edible
            ediableImageSecondItem.showResult(result)
            resultFunc()
        }
    }

    private fun initBaseActions() {
        button_back_to_menu_from_edible.setOnClickListener {
            replaceFragment(LevelSelectionFragment(), false)
        }
        APP_ACTIVITY.title = getString(R.string.EdibleGameTitle)
    }

    private fun resultFunc() {
        result.progressChange(count)
        if (result) trueCount++
        count++
        clickDelay(ediableImageSecondItem, edibleImageFirstItem) {
            if (count != rounds) {
                drawNewQuest()
            } else {
                replaceFragment(EndLevelFragment(trueCount,rounds,EdibleGameQuestionFragment()))
            }
        }
    }

    private fun drawNewQuest() {
        result = false
        items = getRandomFood()
        ediableImageSecondItem.drawQuestItem(items[1].image)
        edibleImageFirstItem.drawQuestItem(items[0].image)
        edibleFirstItemName.text = items[0].name
        edibleSecondItemName.text = items[1].name

    }


}















