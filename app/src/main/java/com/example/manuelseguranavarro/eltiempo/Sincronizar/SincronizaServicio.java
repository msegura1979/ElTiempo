package com.example.manuelseguranavarro.eltiempo.Sincronizar;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by manuelseguranavarro on 9/1/16.
 */
public class SincronizaServicio extends Service {
    public final String LOG_TAG = SincronizaServicio.class.getSimpleName();
    private static final Object sSyncAdapterLock = new Object();
    private static SincronizaAdaptador sSunshineSyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d(LOG_TAG,"SincornizarServicio onCreate");
        synchronized (sSyncAdapterLock){
            if (sSunshineSyncAdapter == null){
                sSunshineSyncAdapter = new SincronizaAdaptador(getApplication(),true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return sSunshineSyncAdapter.getSyncAdapterBinder();
    }
}
