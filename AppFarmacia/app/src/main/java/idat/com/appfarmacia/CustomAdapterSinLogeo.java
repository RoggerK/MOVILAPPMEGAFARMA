package idat.com.appfarmacia;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import idat.com.appfarmacia.model.Producto;

public class CustomAdapterSinLogeo extends RecyclerView.Adapter<CustomAdapterSinLogeo.ViewHolderSinLogeo> {

    public static class ViewHolderSinLogeo extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView nombre;
        private TextView marca;
        private TextView precio;

        public ViewHolderSinLogeo(@NonNull View itemView){
            super(itemView);

            imagen = (ImageView) itemView.findViewById(R.id.imagenSin);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreSin);
            marca = (TextView) itemView.findViewById(R.id.tvMarcaSin);
            precio = (TextView) itemView.findViewById(R.id.tvPrecioSin);
        }
    }

    private List<Producto> listaProducto;

    public CustomAdapterSinLogeo(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    @NonNull
    @Override
    public ViewHolderSinLogeo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSinLogeo holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
