package com.tec.tpo3.ui.salir;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tec.tpo3.databinding.FragmentSalirBinding;
import com.tec.tpo3.ui.salir.SalirViewModel;

public class SalirFragment extends Fragment {

    private FragmentSalirBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SalirViewModel salirViewModel =
                new ViewModelProvider(this).get(SalirViewModel.class);

        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        salirViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        mostrarDialogoSalida();


        
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void mostrarDialogoSalida() {
        new AlertDialog.Builder(requireContext())
                .setTitle("Confirmar salida")
                .setMessage("¿Seguro que deseas salir de la aplicación?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    requireActivity().finishAffinity(); // Cierra la app
                    System.exit(0);
                })
                .setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss(); // Cierra el diálogo y sigue en la app
                })
                .show();
    }
}