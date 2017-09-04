package adneom.project_kotlin.login

import adneom.project_kotlin.R
import adneom.project_kotlin.twilio.TwilioActivity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
//impor layout
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(), LoginContract.View, View.OnClickListener {
    private lateinit var mPresenter : LoginContract.Presenter

    companion object {
        public fun newInstance() : LoginFragment {
            return LoginFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var vi : View = inflater!!.inflate(R.layout.fragment_login,container,false)
        return vi
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login.setOnClickListener(this)
    }

    override fun setPresenter(presenter: LoginContract.Presenter) {
        mPresenter = presenter
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.login ->  { mPresenter.connexcion() }
            else -> println("else")
        }
    }

    override fun callTwilioView() {
        val intent : Intent = Intent(activity,TwilioActivity::class.java)
        activity.startActivity(intent)
    }


}