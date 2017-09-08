package adneom.project_kotlin.navigation.choiceThree

/**
 * Created by gtshilombowanticale on 08-09-17.
 */

class NavChoiceThreePresenter (mView : ChoiceThreeContract.View) : ChoiceThreeContract.Presenter {
    private lateinit var view : ChoiceThreeContract.View
    init {
        view = mView
        view.setPresenter(this)
    }

}