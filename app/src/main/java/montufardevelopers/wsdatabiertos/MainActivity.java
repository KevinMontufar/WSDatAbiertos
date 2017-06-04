package montufardevelopers.wsdatabiertos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import montufardevelopers.wsdatabiertos.adapters.RecyclerViewAdapter;
import montufardevelopers.wsdatabiertos.datosAPI.DatosOpenApiService;
import montufardevelopers.wsdatabiertos.models.CarrosPOJO;
import montufardevelopers.wsdatabiertos.models.ViasPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "Datos abiertos Colombia";

    private RecyclerView recyclerView;

    private RecyclerViewAdapter adapterRecycler;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //conexion del objeto retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recyclerView = (RecyclerView) findViewById(R.id.miRecycler);
        adapterRecycler = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapterRecycler);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        obtenerDatosCarros();
        //obtenerDatosVias();
    }

    private void obtenerDatosCarros() {

        DatosOpenApiService service = retrofit.create(DatosOpenApiService.class);
        Call<List<CarrosPOJO>> respuestaCall = service.obtenerListaCarros();

        respuestaCall.enqueue(new Callback<List<CarrosPOJO>>() {
            @Override
            public void onResponse(Call<List<CarrosPOJO>> call, Response<List<CarrosPOJO>> response) {
                if(response.isSuccessful()){

                    ArrayList<CarrosPOJO> lista = (ArrayList<CarrosPOJO>) response.body();
                    adapterRecycler.adicionarLista(lista);


                    /*for(int i=0;i<lista.size();i++)
                    {
                        CarrosPOJO p = (CarrosPOJO)lista.get(i);
                        Log.i(TAG," Clase: "+p.getClase()+"  -  Total: "+p.getTotal());
                    }*/

                }else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<CarrosPOJO>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }


    private void obtenerDatosVias() {

        DatosOpenApiService service = retrofit.create(DatosOpenApiService.class);
        Call<List<ViasPOJO>> respuestaCall = service.obtenerListaVias();

        respuestaCall.enqueue(new Callback<List<ViasPOJO>>() {

            @Override
            public void onResponse(Call<List<ViasPOJO>> call, Response<List<ViasPOJO>> response) {

                if(response.isSuccessful()){
                    List lista = response.body();

                    for(int i=0;i<lista.size();i++){

                        ViasPOJO p = (ViasPOJO)lista.get(i);
                        Log.i(TAG," Nombre via: "+p.getNombrevia()+"  -  Longitud: "+p.getLongitudvia());

                    }

                }else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<ViasPOJO>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
}
