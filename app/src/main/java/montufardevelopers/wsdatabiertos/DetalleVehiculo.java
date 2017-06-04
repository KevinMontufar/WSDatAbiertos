package montufardevelopers.wsdatabiertos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleVehiculo extends AppCompatActivity {

    private ImageView imagen;
    private TextView valorClase;
    private TextView valorExtrangero;
    private TextView valorOficial;
    private TextView valorParticular;
    private TextView valorPublico;
    private TextView valorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_vehiculo);

        imagen = (ImageView) findViewById(R.id.img_card_detalle);
        valorClase = (TextView) findViewById(R.id.txt_clase);
        valorExtrangero = (TextView) findViewById(R.id.txt_valor_extrangero);
        valorOficial = (TextView) findViewById(R.id.txt_valor_oficial);
        valorParticular = (TextView) findViewById(R.id.txt_valor_particular);
        valorPublico = (TextView) findViewById(R.id.txt_valor_publico);
        valorTotal = (TextView) findViewById(R.id.txt_valor_total);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null) {
            /*String clase = (String) bundle.get("CLASE");
            String extrangero = (String) bundle.get("EXTRANGERO");
            String particular = (String) bundle.get("PARTICULAR");
            String publico = (String) bundle.get("PUBLICO");
            String total = (String) bundle.get("TOTAL");*/

            valorClase.setText((String) bundle.get("CLASE"));
            valorOficial.setText((String) bundle.get("OFICIAL"));
            valorExtrangero.setText((String) bundle.get("EXTRANGERO"));
            valorParticular.setText((String) bundle.get("PARTICULAR"));
            valorPublico.setText((String) bundle.get("PUBLICO"));
            valorTotal.setText((String) bundle.get("TOTAL"));

            switch ((String) bundle.get("CLASE")){
                case "AUTOMOVIL":
                    imagen.setImageResource(R.drawable.automovil);
                    break;
                case "CAMPERO":
                    imagen.setImageResource(R.drawable.campero);
                    break;
                case "MINIVAN":
                    imagen.setImageResource(R.drawable.minivan);
                    break;
                case "MOTOTRICICLO":
                    imagen.setImageResource(R.drawable.mototriciclo);
                    break;
                case "TRACTOMULA":
                    imagen.setImageResource(R.drawable.tractomula);
                    break;
                case  "MOTOCICLETA":
                    imagen.setImageResource(R.drawable.moto);
                    break;
                case "MAQUINARIA INDUSTRIAL":
                    imagen.setImageResource(R.drawable.maquinaria_ind);
                    break;

                case "MAQUINARIA AGRICOLA":
                    imagen.setImageResource(R.drawable.maquinaria_agr);
                    break;
                case "MAQUINARIA CONSTRUCCION":
                    imagen.setImageResource(R.drawable.maquinaria);
                    break;
                case  "TRACCION ANIMAL":
                    imagen.setImageResource(R.drawable.traccion_animal);
                    break;
                case  "MOTOCARGUERO":
                    imagen.setImageResource(R.drawable.motocarguero);
                    break;
                case  "MINIBUS":
                    imagen.setImageResource(R.drawable.minibus);
                    break;
                case "VAN":
                    imagen.setImageResource(R.drawable.van);
                    break;
                case  "REMOLQUE":
                    imagen.setImageResource(R.drawable.remolque);
                    break;
                case  "AMBULANCIA":
                    imagen.setImageResource(R.drawable.ambulancia);
                    break;
                case  "SEMIREMOLQUE":
                    imagen.setImageResource(R.drawable.semi_remolque);
                    break;
                case  "TRACTOR":
                    imagen.setImageResource(R.drawable.tractor);
                    break;
                case "CAMIONETA":
                    imagen.setImageResource(R.drawable.camioneta);
                    break;
                case "MINITRACTOR":
                    imagen.setImageResource(R.drawable.tractor2);
                    break;
                case "CAMION":
                    imagen.setImageResource(R.drawable.camion);
                    break;
                case "MOTOCARRO":
                    imagen.setImageResource(R.drawable.motocarguero);
                    break;
                case "DOBLE TROQUE":
                    imagen.setImageResource(R.drawable.camion_2);
                    break;
                case "TRACTO/CAMION":
                    imagen.setImageResource(R.drawable.camion);
                    break;
                case "VOLQUETA":
                    imagen.setImageResource(R.drawable.volqueta);
                    break;
                case "BUSETA":
                    imagen.setImageResource(R.drawable.minibus_2);
                    break;
                case "MICROBUS":
                    imagen.setImageResource(R.drawable.minibus);
                    break;
                case "BUS":
                    imagen.setImageResource(R.drawable.bus_3);
                    break;
                case "CUATRIMOTO":
                    imagen.setImageResource(R.drawable.cuatrimoto);
                    break;
            }

        }
    }
}
