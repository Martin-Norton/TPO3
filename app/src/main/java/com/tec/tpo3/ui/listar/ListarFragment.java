package com.tec.tpo3.ui.listar;

import static androidx.lifecycle.AndroidViewModel_androidKt.getApplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.tec.tpo3.ProductoAdapter;
import com.tec.tpo3.databinding.FragmentListarBinding;
import com.tec.tpo3.modelo.Producto;

import java.util.List;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel lvm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        lvm = new ViewModelProvider(this).get(ListarViewModel.class);
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        lvm.getMutable().observe(getViewLifecycleOwner(), new Observer<List<Producto>>() {
            @Override
            public void onChanged(List<Producto> productos) {
                ProductoAdapter productoAdapter = new ProductoAdapter(getContext(), productos, getLayoutInflater());
                GridLayoutManager glm = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.navListar.setLayoutManager(glm);
                binding.navListar.setAdapter(productoAdapter);
            }
        });
        lvm.cargarLista();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}