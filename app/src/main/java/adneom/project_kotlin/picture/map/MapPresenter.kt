package adneom.project_kotlin.picture.map


class MapPresenter (mView : MapContract.View) : MapContract.Presenter {
    private lateinit var view : MapContract.View
    init {
        view = mView
        view.setPresenter(this)
    }
}