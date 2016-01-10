package com.example.manuelseguranavarro.eltiempo.Sincronizar;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by manuelseguranavarro on 9/1/16.
 */
public class ServicioAutenticacion extends Service{
    private Autenticacion autenticacion;

    @Override
    public void onCreate(){
        //Creamos nuevo objeto autenticacion
        autenticacion = new Autenticacion(this);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return autenticacion.getIBinder();
    }
}
