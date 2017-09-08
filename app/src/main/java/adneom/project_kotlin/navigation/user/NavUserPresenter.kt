package adneom.project_kotlin.navigation.user

/**
 * Created by gtshilombowanticale on 08-09-17.
 */
 class NavUserPresenter (mView : NavUserContract.View): NavUserContract.Presenter {
 private lateinit var view : NavUserContract.View
 init {
     view = mView
  view.setPresenter(this)
 }

}