import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.gameforchildren.R
import com.example.gameforchildren.utilits.fullListOfFood
import com.example.gameforchildren.utilits.getRandomFood
import com.example.gameforchildren.utilits.initFood
import com.example.gameforchildren.utilits.replaceFragment

class EdibleGameQuestionFragment : Fragment(R.layout.fragment_edible_game_question) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       initFood()

        }
    }
