package adneom.project_kotlin.users

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import adneom.project_kotlin.R
import adneom.project_kotlin.models.User
import android.content.Context
import android.content.Intent

class UsersActivity : AppCompatActivity() {

    private lateinit var presenter : UsersContract.Presenter
    private lateinit var users : ArrayList<User>

    companion object {

        val KEY_LIST : String = "key_list"
        fun redirectIntent(cxt : Context, list : ArrayList<User>) : Intent{
            var intent : Intent = Intent(cxt,UsersActivity::class.java)
            intent.putExtra(KEY_LIST,list)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        manageIntent(intent)

        var fragment : UsersFragment? = supportFragmentManager.findFragmentById(R.id.container) as? UsersFragment
        if(fragment == null){
            fragment = UsersFragment.newInstance(users)
            supportFragmentManager.beginTransaction().replace(R.id.container,fragment,"FRG").commit()
        }

        presenter = UsersPresneter(fragment)
    }

    private fun manageIntent(intent : Intent){
        if(intent != null){
            if(intent.hasExtra(KEY_LIST)){
                users = intent.getParcelableArrayListExtra(KEY_LIST)
            }
        }
    }
}
