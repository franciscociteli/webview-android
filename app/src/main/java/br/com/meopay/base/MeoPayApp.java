package br.com.meopay.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class MeoPayApp extends Application {

       // private static IDAL dal;
        private static Context appContext;

        @Override
        public void onCreate() {
            super.onCreate();
            appContext = getApplicationContext();
           // dal = getDal();
        }


}
