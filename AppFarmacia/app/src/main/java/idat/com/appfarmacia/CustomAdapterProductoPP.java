package idat.com.appfarmacia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import idat.com.appfarmacia.model.ProductoPyP;

public class CustomAdapterProductoPP extends RecyclerView.Adapter<CustomAdapterProductoPP.ViewHolderProductoPP> {

    public static class ViewHolderProductoPP extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView cantidad;
        private TextView precio_unidad;
        private TextView importe;

        public ViewHolderProductoPP(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.tvNombrePro);
            cantidad = (TextView)  itemView.findViewById(R.id.tvCantidadPro);
            precio_unidad = (TextView) itemView.findViewById(R.id.tvPrecioUni);
            importe = (TextView) itemView.findViewById(R.id.tvPrecioImp);

        }
    }


    private List<ProductoPyP> listaProductoPyP;

    public CustomAdapterProductoPP( List<ProductoPyP> listaProductoPyP) {
        this.listaProductoPyP = listaProductoPyP;
    }

    @NonNull
    @Override
    public ViewHolderProductoPP onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_card_productoprecio,
                    parent, false);
        ViewHolderProductoPP viewHolder = new ViewHolderProductoPP(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductoPP holder, int position) {
        String nombreProductoPP = listaProductoPyP.get(position).getNombre();

        holder.nombre.setText(nombreProductoPP);
        holder.cantidad.setText((listaProductoPyP.get(position).getCantidad()).toString());
        holder.precio_unidad.setText((listaProductoPyP.get(position).getPrecio_unitario()).toString());
        holder.importe.setText((listaProductoPyP.get(position).getImporte()).toString());

    }

    @Override
    public int getItemCount() {
        return listaProductoPyP.size();
    }

}
