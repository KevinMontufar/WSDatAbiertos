package montufardevelopers.wsdatabiertos.datosAPI;

import java.util.List;

import montufardevelopers.wsdatabiertos.models.CarrosPOJO;
import montufardevelopers.wsdatabiertos.models.ViasPOJO;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kevin Montúfar on 22/05/2017.
 */

public interface DatosOpenApiService {
    @GET("rvmt-7x4r.json")
    Call<List<CarrosPOJO>> obtenerListaCarros();

    @GET("qvqk-dtmf.json")
    Call<List<ViasPOJO>> obtenerListaVias();

}
