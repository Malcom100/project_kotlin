package adneom.project_kotlin.navigation.choiceThree

import adneom.project_kotlin.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by gtshilombowanticale on 08-09-17.
 */

class NavChoiceThreeFragment : Fragment(), ChoiceThreeContract.View{

    private lateinit var presenter : ChoiceThreeContract.Presenter

    companion object {
        fun newInstance() : NavChoiceThreeFragment {
            return NavChoiceThreeFragment()
        }
    }

    override fun setPresenter(mPresenter: ChoiceThreeContract.Presenter) {
        presenter = mPresenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_nav_choice_three,container,false)
    }
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}