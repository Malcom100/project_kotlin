package adneom.project_kotlin.picture

/**
 * Created by gtshilombowanticale on 05-09-17.
 */

class PicturePresenter(pictureView : PictureContract.View) : PictureContract.Presenter {
    private lateinit var view : PictureContract.View
    init {
        view = pictureView
        view.setPresenter(this)
    }

}