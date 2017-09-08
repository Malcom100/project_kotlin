package adneom.project_kotlin.twilio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import adneom.project_kotlin.R
import adneom.project_kotlin.models.User
import adneom.project_kotlin.picture.PictureActivity
import android.content.Context
import android.content.Intent

class TwilioActivity : AppCompatActivity() {

    private lateinit var presenter : TwilioPresenter

    companion object {
        fun redirectToTwilioActivity(context : Context, u : User) : Intent{
            val intent : Intent = Intent(context,TwilioActivity::class.java)
            intent.putExtra(PictureActivity.KEY_USER,u)
            return intent
        }
    }

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

    override fun onResume() {
        super.onResume()
        println("in on resume")
    }
}
