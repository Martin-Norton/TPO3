package com.tec.tpo3.ui.listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static com.tec.tpo3.MainActivity.*;

import com.tec.tpo3.modelo.Producto;

import java.util.Comparator;
import java.util.List;

public class ListarViewModel extends ViewModel {
    private MutableLiveData<List<Producto>> mutable;

    public ListarViewModel() {
        mutable = new MutableLiveData<>();
    }

    public LiveData<List<Producto>> getMutable() {
        if (mutable == null) {
            mutable = new MutableLiveData<>();
        }
        return mutable;
    }

    public void cargarLista() {
        productos.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return o1.getDescripcion().compareTo(o2.getDescripcion());
            }
        });
        mutable.setValue(productos);
    }
}