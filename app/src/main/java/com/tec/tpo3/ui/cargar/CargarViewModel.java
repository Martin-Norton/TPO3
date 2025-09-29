package com.tec.tpo3.ui.cargar;

import android.app.Application;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tec.tpo3.MainActivity;
import com.tec.tpo3.modelo.Producto;

import java.util.ArrayList;
import static com.tec.tpo3.MainActivity.*;
public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<Producto> mutable;
    public CargarViewModel(@NonNull Application aplication) {
        super(aplication);
    }
    public LiveData getMutable(){
        if (mutable == null){
            mutable = new MutableLiveData<>();
        }
        return mutable;
    }
    public void cargarProducto(String nombre, String codigo, String descripcion, String precioCad){

        if (nombre.isEmpty() || codigo.isEmpty() || descripcion.isEmpty() || precioCad.isEmpty()) {
            Toast.makeText(getApplication(), "Todos los campos son obligatorios", Toast.LENGTH_LONG).show();
            return;
        }
        double precio;
        try {
            precio = Double.parseDouble(precioCad);
        } catch (NumberFormatException e) {
            Toast.makeText(getApplication(), "El precio debe ser un número válido", Toast.LENGTH_LONG).show();
            return;
        }

        Producto p = new Producto(nombre, codigo, descripcion, precio);

        if (productos.contains(p)){
            Toast.makeText(getApplication(), "El codigo del producto esta duplicado", Toast.LENGTH_LONG).show();
            return;
        }
        productos.add(p);
        Toast.makeText(getApplication(), "El producto se cargo correctamente", Toast.LENGTH_LONG).show();
    }
}