package adneom.project_kotlin.navigation.choiceTwo

import adneom.project_kotlin.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by gtshilombowanticale on 08-09-17.
 */

class NavChoiceTwoFragment : Fragment(), ChoiceTwoContract.View {
    private lateinit var presenter : ChoiceTwoContract.Presenter

    companion object {
        fun newInstance() : NavChoiceTwoFragment {
            return NavChoiceTwoFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_nav_choice_two,container,false)
    }
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun setPresenter(mPresenter: ChoiceTwoContract.Presenter) {
        presenter = mPresenter
    }

}