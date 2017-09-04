package adneom.project_kotlin.twilio

import adneom.project_kotlin.BasePresenter
import adneom.project_kotlin.BaseView


interface TwilioContract {

    interface View : BaseView<Presenter> {
        fun updateState(value : String)
    }

    interface Presenter : BasePresenter {
        fun start()
    }
}