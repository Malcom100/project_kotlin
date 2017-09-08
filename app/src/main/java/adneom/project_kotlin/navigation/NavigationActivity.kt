package adneom.project_kotlin.navigation

import adneom.project_kotlin.R
import adneom.project_kotlin.navigation.choiceThree.ChoiceThreeContract
import adneom.project_kotlin.navigation.choiceThree.NavChoiceThreeFragment
import adneom.project_kotlin.navigation.choiceThree.NavChoiceThreePresenter
import adneom.project_kotlin.navigation.choiceTwo.ChoiceTwoContract
import adneom.project_kotlin.navigation.choiceTwo.NavChoiceTwoFragment
import adneom.project_kotlin.navigation.choiceTwo.NavChoiceTwoPresenter
import adneom.project_kotlin.navigation.user.NavUserContract
import adneom.project_kotlin.navigation.user.NavUserFragment
import adneom.project_kotlin.navigation.user.NavUserPresenter
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var nav : BottomNavigationView? = null

    private lateinit var presenterUser : NavUserContract.Presenter
    private lateinit var presenterChoiceTwo : ChoiceTwoContract.Presenter
    private lateinit var presenterChoicetThree : ChoiceThreeContract.Presenter

    private var fragmentsLis : ArrayList<Fragment> = ArrayList<Fragment>()

    companion object {
        fun newIntent(cxt : Context) : Intent {
            return Intent(cxt, NavigationActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        nav = id_bottom_navigation
        (nav as BottomNavigationView).setOnNavigationItemSelectedListener(this)

        val frgDefault : NavUserFragment = NavUserFragment.newInstance()
        displayGoodFragment(frgDefault,true)
        presenterUser = NavUserPresenter(frgDefault)
        fragmentsLis.add(frgDefault)
    }

    //change fragments here
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var selected : Fragment? = null
        when(item.itemId){
            R.id.menu_item_add_user ->
            {
                println(" add user ")
                selected = checkFragment(1)
                if(selected != null && selected is NavUserFragment){
                    displayGoodFragment(selected,false)
                }else{
                    selected = NavUserFragment.newInstance()
                    presenterUser = NavUserPresenter(selected)
                    fragmentsLis.add(selected)
                }
            }
            R.id.menu_item_choice_2 -> {
                println(" choice 2 ")
                selected = checkFragment(2)
                if(selected != null && selected is NavChoiceTwoFragment){
                    displayGoodFragment(selected,false)
                }else{
                    selected = NavChoiceTwoFragment.newInstance()
                    presenterChoiceTwo = NavChoiceTwoPresenter(selected)
                    fragmentsLis.add(selected)
                }
            }
            R.id.menu_item_choice_3 ->
            {
                println(" choice 3 ")
                selected = checkFragment(3)
                if(selected != null && selected is NavChoiceThreeFragment){
                    displayGoodFragment(selected,false)
                }else{
                    selected = NavChoiceThreeFragment.newInstance()
                    presenterChoicetThree= NavChoiceThreePresenter(selected)
                    fragmentsLis.add(selected)
                }
            }
        }

        displayGoodFragment(selected!!,false)
        return true
    }

    private fun displayGoodFragment(frg: Fragment, firstTime : Boolean) {
        if(firstTime){
            supportFragmentManager.beginTransaction().add(R.id.container,frg,"frg").commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.container,frg,"frg").commit()
        }
    }

    private fun checkFragment(type : Int) : Fragment{
        var found : Boolean = false
        var index : Int = 0
        var frg : Fragment? = null
        if(fragmentsLis.size > 0){
            while(index < fragmentsLis.size && !found) {
                when (type) {
                    1 -> {
                        found = fragmentsLis.get(index) is NavUserFragment
                        frg = fragmentsLis.get(index)
                    }
                    2 -> {
                        found = fragmentsLis.get(index) is NavChoiceTwoFragment
                        frg = fragmentsLis.get(index)
                    }
                    3 -> {
                        found = fragmentsLis.get(index) is NavChoiceThreeFragment
                        frg = fragmentsLis.get(index)
                    }
                }
                index++
            }
        }
        return frg!!
    }
}
