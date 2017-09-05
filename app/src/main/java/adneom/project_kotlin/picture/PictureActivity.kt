package adneom.project_kotlin.picture

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import adneom.project_kotlin.R
import adneom.project_kotlin.models.User
import adneom.project_kotlin.twilio.TwilioActivity
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.widget.Toast
//impor layout
import kotlinx.android.synthetic.main.activity_picture.*

class PictureActivity : AppCompatActivity() {

    private lateinit var presenter : PictureContract.Presenter
    private var myUser : User? = null

    companion object {
        val CAMERA_VALUE : Int = 589;
        val KEY_TEST : String = "test_key"
        val KEY_USER : String = "user_key"

        fun redirectToPictureActivity(cxt : Context, user : User?) : Intent {
            var intent : Intent = Intent(cxt,PictureActivity::class.java)
            intent.putExtra(KEY_USER,user)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        getArguments(intent)
        checkPermissions()
    }

    private fun getArguments(intent : Intent){
        if(intent != null){
            if(intent.hasExtra(KEY_USER)){
                myUser = intent.getParcelableExtra(KEY_USER);
            }
        }
    }

    private fun checkPermissions() {
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE),CAMERA_VALUE)

        }else{
            showCamera()
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            CAMERA_VALUE ->
            {
                if(grantResults.size > 0){
                    showCamera()
                }
            }
            else ->
            {
                println("no permissions accepted")
                Toast.makeText(this,resources.getString(R.string.permissions_denied),Toast.LENGTH_LONG).show()
                startActivity(TwilioActivity.redirectToTwilioActivity(this, myUser!!))
            }


        }
    }

    private fun showCamera() {
        var fragment : PictureFragment? = supportFragmentManager.findFragmentById(R.id.containner) as? PictureFragment
        if(fragment == null){
            fragment = PictureFragment.newInstance()
            supportFragmentManager.beginTransaction().replace(R.id.container,fragment,"FRG").commit()
        }

        //create the presenter
        presenter = PicturePresenter(fragment)
    }
}
