package adneom.project_kotlin.twilio

import adneom.project_kotlin.MyApplication
import adneom.project_kotlin.models.User
import android.app.Activity
import android.content.Context
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TwilioPresenter (mView : TwilioContract.View, context : Context, activity : Activity): TwilioContract.Presenter {
    private lateinit var view : TwilioContract.View
    private lateinit var ctxt : Context
    private lateinit var act : Activity
    private lateinit var myUser : User
    private var myUsers : ArrayList<User> = ArrayList<User>()
    init {
        view = mView
        view.setPresenter(this)
        ctxt = context
        act = activity
    }

    private  var number : Int? = null

    override fun start() {
        //firstRequest()
        obsRequest()
    }

    private fun firstRequest(){
        var response : Call<List<User>> = (act.application as MyApplication).getService().getUsers()
        response.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>?) {
                if (response != null && response!!.isSuccessful()) {
                    var users : List<User>? = response.body()
                    if(users != null && users.size > 0 ){
                        val users : List<User> = createList(users)
                        filterList(users)
                    }
                } else {
                    //show error message
                    println("error")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                println(t.message)
            }
        });

    }

    private fun obsRequest() {
        var obs : Observable<List<User>> = (act.application as MyApplication).getService().getUsersObs()
        obs
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .subscribe(
                {
                    users ->
                    val u : List<User> = createList(users)
                    filterList(u)
                },
                {
                    e -> print(e.message)
                    e.printStackTrace()
                },
                {
                    if(isNotNullView()){
                        view.saveUser(myUser)
                        view.saveUsers(myUsers)
                        view.updateState("the response is equal to ".plus(number))
                    }
                }
        )
    }

    private fun isNotNullView() : Boolean {
        return view != null
    }

    private fun createList(users : List<User>) : MutableList<User>{
        var listUser : MutableList<User> = mutableListOf<User>()
        for(u in users){
            listUser.add(u)
            myUsers.add(u)
        }
        number = users.size
        return listUser
    }

    private fun filterList(us : List<User>) {
        us.filter { user ->  (user.id!! % 2) == 0}.forEach {
            println(it)
            myUser = it
        }
    }
}
