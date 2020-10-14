import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.model.FoodModel
import com.example.gameforchildren.utilits.*
import kotlinx.android.synthetic.main.fragment_edible_game_question.*

class EdibleGameQuestionFragment : Fragment(R.layout.fragment_edible_game_question) {

    lateinit var items: List<FoodModel>
    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = getString(R.string.EdibleGameTitle)
        initFood()
        drawNewQuest()
edibleImageFirstItem.setOnClickListener { drawNewQuest() }
    }

    private fun drawNewQuest() {
        items = getRandomFood()
        edibleFirstItemName.text = items[0].name
        edibleSecondItemName.text = items[0].name
        edibleImageFirstItem.setImageResource(items[0].image)
        ediableImageSecondItem.setImageResource(items[1].image)
    }
}
