package adneom.project_kotlin.widgets

import adneom.project_kotlin.R
import adneom.project_kotlin.twilio.TwilioActivity
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class NewActionWidgetProvider : AppWidgetProvider() {
    private var cxt : Context? = null
    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        cxt = context
        var remoteView : RemoteViews = RemoteViews(context!!.packageName, R.layout.layout_widget_action)
        remoteView.setOnClickPendingIntent(R.id.new_action,openView())

        if (appWidgetManager != null) {
            appWidgetManager.updateAppWidget(appWidgetIds!![0],remoteView)
        }
    }


    private fun openView(): PendingIntent {
        val intent : Intent = Intent(cxt, TwilioActivity::class.java)
        val pIntent : PendingIntent = PendingIntent.getActivity(cxt, System.currentTimeMillis().toInt(),intent, PendingIntent.FLAG_CANCEL_CURRENT)
        return pIntent
    }
}