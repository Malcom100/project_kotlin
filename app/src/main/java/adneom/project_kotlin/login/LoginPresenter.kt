package adneom.project_kotlin.login

class LoginPresenter (mView : LoginContract.View ): LoginContract.Presenter{
    private val view : LoginContract.View

    init {
        view = mView
        view.setPresenter(this)
    }


    override fun connexcion() {
        view.callTwilioView()
    }
}