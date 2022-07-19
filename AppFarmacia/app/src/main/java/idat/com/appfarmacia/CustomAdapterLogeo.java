package idat.com.appfarmacia;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import idat.com.appfarmacia.model.Producto;

public class CustomAdapterLogeo extends RecyclerView.Adapter<CustomAdapterLogeo.ViewHolderLogeo> {

    public static class ViewHolderLogeo extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView nombre;
        private TextView marca;
        private TextView precio;

        public ViewHolderLogeo(@NonNull View itemView){
            super(itemView);

            imagen = (ImageView) itemView.findViewById(R.id.imagenLog);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreLog);
            marca = (TextView) itemView.findViewById(R.id.tvMarcaLog);
            precio = (TextView) itemView.findViewById(R.id.tvPrecioLog);
        }
    }

    private List<Producto> listaProducto;

    public CustomAdapterLogeo(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    @NonNull
    @Override
    public ViewHolderLogeo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLogeo holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
