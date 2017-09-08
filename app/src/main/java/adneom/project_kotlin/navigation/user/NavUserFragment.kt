package adneom.project_kotlin.navigation.user

import adneom.project_kotlin.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class NavUserFragment : Fragment(),NavUserContract.View {
    private lateinit var presenter : NavUserContract.Presenter

    companion object {
        fun newInstance() : NavUserFragment {
            return NavUserFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_nav_user,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setPresenter(mPresenter: NavUserContract.Presenter) {
        presenter = mPresenter
    }

}