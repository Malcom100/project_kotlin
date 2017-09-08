package adneom.project_kotlin.users

import adneom.project_kotlin.R
import adneom.project_kotlin.models.User
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.users_list_row.*

class UserAdapter(cxt : Context, items : ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private lateinit var list : ArrayList<User>
    private lateinit var context : Context
    init {
        list = items
        context = cxt
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder {
        var itemView : View = LayoutInflater.from(context).inflate(R.layout.users_list_row,parent,false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        val user : User = list.get(position)
        holder!!.name.setText(user.name)
        holder!!.userName.setText(user.username)
        holder!!.email.setText(user.email)
        holder!!.id.setText(user.id.toString())
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class UserViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        lateinit var name : TextView
        lateinit var userName : TextView
        lateinit var email : TextView
        lateinit var id : TextView
        init {
            name = view.findViewById(R.id.name) as TextView
            userName = view.findViewById(R.id.username) as TextView
            email = view.findViewById(R.id.email) as TextView
            id = view.findViewById(R.id.id) as TextView
        }
    }
}