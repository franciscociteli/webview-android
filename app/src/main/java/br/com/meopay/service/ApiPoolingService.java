package br.com.meopay.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ApiPoolingService extends Service {

    private Handler handler;

    public static final long DEFAULT_SYNC_INTERVAL = 5 * 1000;

    private Runnable runnableService = new Runnable() {
        @Override
        public void run() {
            //implementar chamada para API

            handler.postDelayed(runnableService, DEFAULT_SYNC_INTERVAL);
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler = new Handler();
        handler.post(runnableService);
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("M", intent.toString());
        return null;
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(runnableService);
        stopSelf();
        super.onDestroy();
    }
}
