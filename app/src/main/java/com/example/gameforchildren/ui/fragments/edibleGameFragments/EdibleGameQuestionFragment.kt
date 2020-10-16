import android.app.AlertDialog
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
        button_back_to_menu_from_edible.setOnClickListener {
            replaceFragment(LevelSelectionFragment(),false)
        }

        APP_ACTIVITY.title = getString(R.string.EdibleGameTitle)
        initFood()
        drawNewQuest()
        edibleImageFirstItem.setOnClickListener {
            if (items[0].edible) result = true
            nextFun()
        }
        ediableImageSecondItem.setOnClickListener {
            if (items[1].edible) result = true
            nextFun()
        }

    }


    private fun nextFun() {

        edibleImageFirstItem.isClickable = false
        ediableImageSecondItem.isClickable = false
        if (result) {
            edibleImageResult.setImageResource(R.drawable.edible_true)
        trueCount ++
        }
        else{
            edibleImageResult.setImageResource(R.drawable.ediable_false)
        }
        edibleImageResult.visibility = View.VISIBLE
        android.os.Handler().postDelayed({resultFunc()},800)


    }



    private fun resultFunc() {
        edibleImageResult.visibility = View.GONE
        result.progressChange(count)
        count++
        if (count < rounds){
                        drawNewQuest()}
        else endLevel()
    }

    private fun endLevel() {
        val builder = AlertDialog.Builder(APP_ACTIVITY)
        builder.setTitle("Игра окончена")
            .setMessage("Вы ответили на  $trueCount из $rounds правильно. Вы молодец и бла бла бла")
            .setPositiveButton("Начать снова"){dialogInterface, i -> replaceFragment(EdibleGameQuestionFragment()) }
            .setNeutralButton("Вернуться к выбору игры"){dialogInterface, i -> replaceFragment(LevelSelectionFragment()) }
            .show()
    }
    private fun drawNewQuest() {
        edibleImageResult.visibility = View.GONE
        result = false
        items = getRandomFood()
        edibleFirstItemName.text = items[0].name
        edibleSecondItemName.text = items[1].name
        edibleImageFirstItem.setImageResource(items[0].image)
        ediableImageSecondItem.setImageResource(items[1].image)
        edibleImageFirstItem.isClickable = true
        ediableImageSecondItem.isClickable = true
    }



}
