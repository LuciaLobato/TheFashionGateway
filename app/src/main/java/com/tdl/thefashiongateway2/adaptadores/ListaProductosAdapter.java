package com.tdl.thefashiongateway2.adaptadores;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tdl.thefashiongateway2.R;
import com.tdl.thefashiongateway2.entidades.Productos;
import java.util.ArrayList;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.ProductoViewHolder> {
    ArrayList<Productos> listaProductos;
    public ListaProductosAdapter(ArrayList<Productos> listaProductos){
        this.listaProductos=listaProductos;
    }

    ///Este metodo nos va a ayudar a asignar el diseño q va a tener cada elemento de la lista
    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_producto, null,false);
        return new ProductoViewHolder(view);
    }

    ///Este metodo es done vamos a asignar los elementos q corresponde para cada opción (ej; nombre, descripcion imagen)
    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.viewNombre.setText(listaProductos.get(position).getNombre());
        holder.viewGrupo.setText(listaProductos.get(position).getGrupo());
        holder.viewTipo.setText(listaProductos.get(position).getTipo());
        holder.viewColor.setText(listaProductos.get(position).getColor());
        holder.viewPrecio.setText(String.valueOf(listaProductos.get(position).getPrecio()));
        holder.viewRebaja.setText(String.valueOf(listaProductos.get(position).getRebaja()));
        holder.viewImagen.setImageBitmap(listaProductos.get(position).getImagen2());
    }

    ///DEvuleve el tamaño de la lista
    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder{
        TextView viewNombre, viewGrupo, viewTipo,viewColor, viewPrecio, viewRebaja;
        ImageView viewImagen;
        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.txtnombreprod);
            viewGrupo = itemView.findViewById(R.id.txtgrupo);
            viewTipo = itemView.findViewById(R.id.txttipo);
            viewColor = itemView.findViewById(R.id.txtcolor);
            viewPrecio = itemView.findViewById(R.id.txtprecio);
            viewRebaja = itemView.findViewById(R.id.txtrebaja);
            viewImagen = itemView.findViewById(R.id.imgProducto);
        }
    }
}
