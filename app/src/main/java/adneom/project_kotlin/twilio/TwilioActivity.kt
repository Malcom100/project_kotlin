package adneom.project_kotlin.twilio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import adneom.project_kotlin.R

class TwilioActivity : AppCompatActivity() {

    private lateinit var presenter : TwilioPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twilio)

        var fragment : TwilioFragment? = supportFragmentManager.findFragmentById(R.id.containner) as? TwilioFragment
        if(fragment == null){
            fragment = TwilioFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.containner,fragment,"TAG_FRG").commit()
        }

        //create presenter :
        presenter = TwilioPresenter(fragment,applicationContext,this)
    }
}
