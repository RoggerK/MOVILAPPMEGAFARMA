package idat.com.appfarmacia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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

    private Context context;
    private List<Producto> listaProducto;

    public CustomAdapterLogeo(Context context, List<Producto> listaProducto) {
        this.context = context;
        this.listaProducto = listaProducto;
    }

    @NonNull
    @Override
    public ViewHolderLogeo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_card_logeado,
                parent,false);
        ViewHolderLogeo viewHoler = new ViewHolderLogeo(view);

        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLogeo holder, int position) {
        String nombreProducto = listaProducto.get(position).getNombre();
        //agrego libreria Picasso
        Picasso.with(context)
                .load(listaProducto.get(position).getUrlImg())
                .error(R.drawable.ic_launcher_foreground) //en caso que la url no sea válida muestro otra imagen
                .into(holder.imagen);

        holder.imagen.setContentDescription(nombreProducto);
        holder.nombre.setText(nombreProducto);
        holder.marca.setText(listaProducto.get(position).getMarca());
        holder.precio.setText(listaProducto.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return listaProducto.size();
    }

}
