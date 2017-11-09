package layout;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import br.com.uniftec.trabalhofinal.R;

/**
 * Implementation of App Widget functionality.
 */
public class WidgetActivity extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // CONSTRUTOR DO REMOTEVIEW
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_activity);

        // INSTRUI O WIDGET MANAGER A DAR UPDATE NO WIDGET
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // ATUALIZA TODAS AS INSTANCIAS DOS WIDGETS
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // FUNCAO EXECUTADA QUANDO A PRIMEIRA INSTANCIA DO WIDGET É CRIADA
    }

    @Override
    public void onDisabled(Context context) {
        // FUNCAO EXECUTADA QUANDO A ULTIMA INSTANCIA DO WIDGET É EXCLUIDA
    }
}

