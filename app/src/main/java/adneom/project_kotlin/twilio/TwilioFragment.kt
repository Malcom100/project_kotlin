package adneom.project_kotlin.twilio

import adneom.project_kotlin.MyApplication
import adneom.project_kotlin.R
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


class TwilioFragment : Fragment(), TwilioContract.View, DeviceListener, ConnectionListener {
    private lateinit var mPresenter : TwilioContract.Presenter
    val RECORD_AUDIO_CODE : Int = 89

    private lateinit var device : Device

    private lateinit var newState : String

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
        kotlin.run { value_state.setText(newState) }
    }
    override fun updateState(value: String) {
        newState = value
        hh.post(r)
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