package adneom.project_kotlin.users

import adneom.project_kotlin.BasePresenter
import adneom.project_kotlin.BaseView


interface UsersContract {
    interface View : BaseView<Presenter> {

    }
    interface Presenter : BasePresenter {

    }
}