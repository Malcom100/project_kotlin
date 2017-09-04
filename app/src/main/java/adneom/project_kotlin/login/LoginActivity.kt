package adneom.project_kotlin.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import adneom.project_kotlin.R

class LoginActivity : AppCompatActivity() {

    private lateinit var presenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var fragment : LoginFragment? = supportFragmentManager.findFragmentById(R.id.containner) as? LoginFragment
        if(fragment == null) {
            fragment = LoginFragment.newInstance()
            supportFragmentManager.beginTransaction().replace(R.id.containner,fragment,"FRAGMENT").commit()
        }

        //create the prsenter
        presenter = LoginPresenter(fragment)

    }
}
