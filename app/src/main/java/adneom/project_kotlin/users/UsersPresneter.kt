package adneom.project_kotlin.users

/**
 * Created by gtshilombowanticale on 07-09-17.
 */

class UsersPresneter (mView : UsersContract.View): UsersContract.Presenter {
    private lateinit var view : UsersContract.View
    init {
        view = mView
        view.setPresenter(this)
    }

}