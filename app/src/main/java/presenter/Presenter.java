package presenter;

import android.content.Intent;
import android.view.View;

/**
 * Created by sq719 on 2018/3/7.
 *
 */

public interface Presenter {
    void onCreate();

    void onStart();

    void onStop();

    void pause();

    void attachView(View view);

    void attachIncomingIntent(Intent intent);
}
