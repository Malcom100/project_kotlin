package adneom.project_kotlin.twilio

import adneom.project_kotlin.R
import adneom.project_kotlin.models.User
import adneom.project_kotlin.picture.PictureActivity
import adneom.project_kotlin.users.UsersActivity
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twilio.client.*
//impor layout
import kotlinx.android.synthetic.main.fragment_twilio.*


class TwilioFragment : Fragment(), TwilioContract.View, DeviceListener, ConnectionListener, View.OnClickListener {

    private lateinit var mPresenter : TwilioContract.Presenter
    val RECORD_AUDIO_CODE : Int = 89

    private lateinit var device : Device

    private lateinit var newState : String

    private var myUser : User? = null

    private var users : ArrayList<User>? = null

    companion object {
        fun newInstance() : TwilioFragment {
            return TwilioFragment()
        }
    }

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
     }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v : View = inflater!!.inflate(R.layout.fragment_twilio,container,false)
        return v
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(ActivityCompat.checkSelfPermission(activity,Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.RECORD_AUDIO),RECORD_AUDIO_CODE)
        }else{
            twilio()
        }

        btn_picture.setOnClickListener(this)
        btn_users.setOnClickListener(this)
    }

    fun twilio() {
        mPresenter.start()
    }


     override fun setPresenter(presenter: TwilioContract.Presenter) {
         mPresenter = presenter
     }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            RECORD_AUDIO_CODE -> {
                if(grantResults.size > 0){
                    twilio()
                }
            }
        }
    }

    val hh : Handler = Handler()
    val r : Runnable = Runnable() {
        kotlin.run {
            value_state.setText(newState)
            btn_picture.visibility = View.VISIBLE
            btn_users.visibility = View.VISIBLE
        }
    }
    override fun updateState(value: String) {
        newState = value
        hh.post(r)
    }

    override fun saveUser(user: User) {
        myUser = user
    }

    override fun saveUsers(users: ArrayList<User>) {
        this.users = users
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.btn_picture -> activity.startActivity(PictureActivity.redirectToPictureActivity(activity,myUser,users))//activity.startActivity(PictureActivity.redirectToPictureActivity(activity,myUser))
            R.id.btn_users -> activity.startActivity(UsersActivity.redirectIntent(this.activity,users!!))
            else -> println("no choice !!")
        }
    }


    //device :
    override fun onStartListening(p0: Device?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStopListening(p0: Device?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStopListening(p0: Device?, p1: Int, p2: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun receivePresenceEvents(p0: Device?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPresenceChanged(p0: Device?, p1: PresenceEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //connection :
    override fun onConnecting(p0: Connection?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnected(p0: Connection?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDisconnected(p0: Connection?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDisconnected(p0: Connection?, p1: Int, p2: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
 }