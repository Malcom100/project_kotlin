package adneom.project_kotlin.picture

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import adneom.project_kotlin.R
import adneom.project_kotlin.models.User
import adneom.project_kotlin.picture.map.MapContract
import adneom.project_kotlin.picture.map.MapFragment
import adneom.project_kotlin.picture.map.MapPresenter
import adneom.project_kotlin.twilio.TwilioActivity
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.widget.Toast

class PictureActivity : AppCompatActivity() {

    private lateinit var presenterPicture : PictureContract.Presenter
    private lateinit var presenterMap : MapContract.Presenter
    private var myUser : User? = null

    companion object {
        val CAMERA_VALUE : Int = 589;
        val KEY_TEST : String = "test_key"
        val KEY_USER : String = "user_key"
        val KEY_USERS_LIST : String = "list_key"

        fun redirectToPictureActivity(cxt : Context, user : User?) : Intent {
            var intent : Intent = Intent(cxt,PictureActivity::class.java)
            intent.putExtra(KEY_USER,user)
            return intent
        }

        fun redirectToPictureActivity(cxt : Context, user : User?, users : ArrayList<User>?) : Intent {
            var intent : Intent = Intent(cxt,PictureActivity::class.java)
            intent.putExtra(KEY_USER,user)
            intent.putParcelableArrayListExtra(KEY_USERS_LIST,users)
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
            showMap()
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            CAMERA_VALUE ->
            {
                if(grantResults.size > 0){
                    showCamera()
                    showMap()
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
            fragment = PictureFragment.newInstance(myUser as User)
            supportFragmentManager.beginTransaction().replace(R.id.container,fragment,"FRG").commit()
        }

        //create the presenter
        presenterPicture = PicturePresenter(fragment)
    }

    private fun showMap(){
        var mapFragment : MapFragment? = supportFragmentManager.findFragmentById(R.id.container_map) as? MapFragment
        if(mapFragment == null){
            mapFragment = MapFragment.newInstance()
            supportFragmentManager.beginTransaction().replace(R.id.container_map,mapFragment,"FRG_MAP").commit()
        }

        //create the presenter
        presenterMap = MapPresenter(mapFragment)
    }
}
