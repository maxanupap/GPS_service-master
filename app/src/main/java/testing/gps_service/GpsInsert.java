package testing.gps_service;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap; import
        java.util.Map;

public class GpsInsert extends StringRequest {
    private static final String LOCATION_REQUEST_URL = "http://www.manocamera.com/sentlocation1.php";
    private Map <String, String> params;

    public GpsInsert(String stlat, String stlon, String boat, String type, String lineboat, Response.Listener<String> responseListener) {
        super(Method.POST, LOCATION_REQUEST_URL, responseListener, null);
        params = new HashMap<>();
        params.put("lat", stlat);
        params.put("lon", stlon);
        params.put("boat", boat);
        params.put("type", type);
        params.put("lineboat", lineboat);
    }

    @Override
    public Map <String, String> getParams() {
        return params;
    }
}