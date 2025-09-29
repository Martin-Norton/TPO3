package com.tec.tpo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tec.tpo3.modelo.Producto;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.viewHolderProducto> {
    private Context context;
    private List<Producto> listado;
    private LayoutInflater li;

    public ProductoAdapter(Context context, List<Producto> listado, LayoutInflater li) {
        this.context = context;
        this.listado = listado;
        this.li = li;
    }

    @NonNull
    @Override
    public viewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = li.inflate(R.layout.item, parent, false);
        return new viewHolderProducto(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderProducto holder, int position) {
        Producto ProductoActual = listado.get(position);

        holder.nombre.setText("Nombre: " + ProductoActual.getNombre());
        holder.codigo.setText("Codigo: " + ProductoActual.getCodigo());
        holder.descripcion.setText("Descripcion: " + ProductoActual.getDescripcion());
        holder.precio.setText("Precio: " + ProductoActual.getPrecio());
    }

    @Override
    public int getItemCount() {
        return listado.size();
    }

    public class viewHolderProducto extends RecyclerView.ViewHolder {

        TextView nombre, codigo, descripcion, precio;

        public viewHolderProducto(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            codigo = itemView.findViewById(R.id.tvCodigo);
            descripcion = itemView.findViewById(R.id.tvDescripcion);
            precio = itemView.findViewById(R.id.tvPrecio);
        }
    }
}
