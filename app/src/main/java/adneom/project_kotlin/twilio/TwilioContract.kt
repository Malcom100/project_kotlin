package adneom.project_kotlin.twilio

import adneom.project_kotlin.BasePresenter
import adneom.project_kotlin.BaseView
import adneom.project_kotlin.models.User


interface TwilioContract {

    interface View : BaseView<Presenter> {
        fun updateState(value : String)
        fun saveUser(user: User)
    }

    interface Presenter : BasePresenter {
        fun start()
    }
}