package adneom.project_kotlin.navigation.choiceTwo

/**
 * Created by gtshilombowanticale on 08-09-17.
 */

class NavChoiceTwoPresenter (mView : ChoiceTwoContract.View) : ChoiceTwoContract.Presenter {
    private lateinit var view : ChoiceTwoContract.View
    init {
        view = mView
        view.setPresenter(this)
    }
}