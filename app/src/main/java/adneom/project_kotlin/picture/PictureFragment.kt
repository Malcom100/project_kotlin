package adneom.project_kotlin.picture

import adneom.project_kotlin.R
import adneom.project_kotlin.models.User
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_picture.*


class PictureFragment : Fragment(), PictureContract.View {
    private lateinit var mPresenter: PictureContract.Presenter
    private var myUser: User? = null

    override fun setPresenter(presenter: PictureContract.Presenter) {
        mPresenter = presenter
    }


    companion object {
        fun newInstance(u: User): PictureFragment {
            var pictureFragment: PictureFragment = PictureFragment()
            var arguments: Bundle = Bundle()
            arguments.putString(PictureActivity.KEY_TEST, "my test")
            arguments.putParcelable(PictureActivity.KEY_USER, u)
            pictureFragment.arguments = arguments
            return pictureFragment
        }

        fun newInstance(): PictureFragment {
            var pictureFragment: PictureFragment = PictureFragment()
            var arguments: Bundle = Bundle()
            arguments.putString(PictureActivity.KEY_TEST, "my test")
            pictureFragment.arguments = arguments
            return pictureFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args: Bundle = arguments
        if (args != null) {
            val value: String = args.getString(PictureActivity.KEY_TEST, "null")
            myUser = args.getParcelable(PictureActivity.KEY_USER)
            println("my value is ".plus(value).plus(" - ").plus(myUser.toString()))
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_picture, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name.setText(myUser!!.name)
        username.setText(myUser!!.username)
    }

}