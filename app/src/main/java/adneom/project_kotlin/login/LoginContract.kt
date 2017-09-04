package adneom.project_kotlin.login

import adneom.project_kotlin.BasePresenter
import adneom.project_kotlin.BaseView


interface LoginContract {

    interface View : BaseView<Presenter> {
        fun callTwilioView()
    }


    interface Presenter : BasePresenter {
        fun connexcion()
    }
}
