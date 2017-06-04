package montufardevelopers.wsdatabiertos.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import montufardevelopers.wsdatabiertos.DetalleVehiculo;
import montufardevelopers.wsdatabiertos.R;
import montufardevelopers.wsdatabiertos.models.CarrosPOJO;

/**
 * Created by Kevin Montúfar on 20/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PictureViewHolder>{

    /**
     * Arreglo de automoviles
     */
    private ArrayList<CarrosPOJO> dataset;

    /**
     * Contexto
     */
    private Context context;

    /**
     *
     */
    private Activity activity;

    /**
     *
     * @param context
     */
    public RecyclerViewAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new PictureViewHolder(view);
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        final CarrosPOJO pojo = dataset.get(position);
        //Log.e("AQUIIIIIIIIIIIIIIIII"," Clase: "+pojo.getClase()+"  -  Total: "+pojo.getTotal());
        holder.txtTipoAuto.setText(pojo.getClase());
        holder.txtTotalAutos.setText(pojo.getTotal());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleVehiculo.class);

                intent.putExtra("CLASE",pojo.getClase());
                intent.putExtra("OFICIAL",pojo.getOficial());
                intent.putExtra("EXTRANGERO",pojo.getExtranjero());
                intent.putExtra("PARTICULAR",pojo.getParticular());
                intent.putExtra("PUBLICO",pojo.getPublico());
                intent.putExtra("TOTAL",pojo.getTotal());
                context.startActivity(intent);

            }
        });


        switch (pojo.getClase()){
            case "AUTOMOVIL":
                holder.imagen.setImageResource(R.drawable.automovil);
                break;
            case "CAMPERO":
                holder.imagen.setImageResource(R.drawable.campero);
                break;
            case "MINIVAN":
                holder.imagen.setImageResource(R.drawable.minivan);
                break;
            case "MOTOTRICICLO":
                holder.imagen.setImageResource(R.drawable.mototriciclo);
                break;
            case "TRACTOMULA":
                holder.imagen.setImageResource(R.drawable.tractomula);
                break;
            case  "MOTOCICLETA":
                holder.imagen.setImageResource(R.drawable.moto);
                break;
            case "MAQUINARIA INDUSTRIAL":
                holder.imagen.setImageResource(R.drawable.maquinaria_ind);
                break;

            case "MAQUINARIA AGRICOLA":
                holder.imagen.setImageResource(R.drawable.maquinaria_agr);
                break;
            case "MAQUINARIA CONSTRUCCION":
                holder.imagen.setImageResource(R.drawable.maquinaria);
                break;
            case  "TRACCION ANIMAL":
                holder.imagen.setImageResource(R.drawable.traccion_animal);
                break;
            case  "MOTOCARGUERO":
                holder.imagen.setImageResource(R.drawable.motocarguero);
                break;
            case  "MINIBUS":
                holder.imagen.setImageResource(R.drawable.minibus);
                break;
            case "VAN":
                holder.imagen.setImageResource(R.drawable.van);
                break;
            case  "REMOLQUE":
                holder.imagen.setImageResource(R.drawable.remolque);
                break;
            case  "AMBULANCIA":
                holder.imagen.setImageResource(R.drawable.ambulancia);
                break;
            case  "SEMIREMOLQUE":
                holder.imagen.setImageResource(R.drawable.semi_remolque);
                break;
            case  "TRACTOR":
                holder.imagen.setImageResource(R.drawable.tractor);
                break;
            case "CAMIONETA":
                holder.imagen.setImageResource(R.drawable.camioneta);
                break;
            case "MINITRACTOR":
                holder.imagen.setImageResource(R.drawable.tractor2);
                break;
            case "CAMION":
                holder.imagen.setImageResource(R.drawable.camion);
                break;
            case "MOTOCARRO":
                holder.imagen.setImageResource(R.drawable.motocarguero);
                break;
            case "DOBLE TROQUE":
                holder.imagen.setImageResource(R.drawable.camion_2);
                break;
            case "TRACTO/CAMION":
                holder.imagen.setImageResource(R.drawable.camion);
                break;
            case "VOLQUETA":
                holder.imagen.setImageResource(R.drawable.volqueta);
                break;
            case "BUSETA":
                holder.imagen.setImageResource(R.drawable.minibus_2);
                break;
            case "MICROBUS":
                holder.imagen.setImageResource(R.drawable.minibus);
                break;
            case "BUS":
                holder.imagen.setImageResource(R.drawable.bus_3);
                break;
            case "CUATRIMOTO":
                holder.imagen.setImageResource(R.drawable.cuatrimoto);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarLista(ArrayList<CarrosPOJO> listaAutos) {
        dataset.addAll(listaAutos);
        notifyDataSetChanged();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        ImageView imagen;

        private TextView txtTipoAuto;

        private TextView txtTotalAutos;

        private LinearLayout layout;


        public PictureViewHolder(View itemView) {
            super(itemView);

            imagen   = (ImageView) itemView.findViewById(R.id.img_card);
            txtTipoAuto = (TextView) itemView.findViewById(R.id.tipo_automovil);
            txtTotalAutos   = (TextView) itemView.findViewById(R.id.txt_valor_total);
            layout = (LinearLayout) itemView.findViewById(R.id.layout_text_card);

        }
    }


}
