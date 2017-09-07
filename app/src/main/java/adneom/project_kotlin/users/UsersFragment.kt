package adneom.project_kotlin.users

import adneom.project_kotlin.R
import adneom.project_kotlin.models.User
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_user.*

/**
 * Created by gtshilombowanticale on 07-09-17.
 */

class UsersFragment : Fragment(), UsersContract.View {


    private lateinit var presenter : UsersContract.Presenter
    private lateinit var users : ArrayList<User>
    private lateinit var adapter : UserAdapter
    private lateinit var myRecyclerView : RecyclerView

    companion object {
        fun newInstance(list: ArrayList<User>) : UsersFragment {
            var arguments : Bundle = Bundle()
            arguments.putParcelableArrayList(UsersActivity.KEY_LIST,list)
            var fragment : UsersFragment = UsersFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        manageArguments(arguments)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_user,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myRecyclerView = recycler_view

        adapter = UserAdapter(this.activity,users)
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this.activity)
        myRecyclerView.layoutManager = layoutManager
        myRecyclerView.itemAnimator = DefaultItemAnimator()
        myRecyclerView.adapter = adapter
    }

    override fun setPresenter(presenter: UsersContract.Presenter) {
    }

    fun manageArguments(args : Bundle) {
        if(args != null){
            users = args.getParcelableArrayList(UsersActivity.KEY_LIST)
        }
    }
}