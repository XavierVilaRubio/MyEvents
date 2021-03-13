package dam.invisere.gtidic.udl.cat.myevents;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeoCoderUtils {

    private Geocoder geocoder;

    public GeoCoderUtils(Context context){
        geocoder = new Geocoder(context, Locale.getDefault());
    }

    public String getCountry(double lat, double lon) throws IOException {
            List<Address> addresses = geocoder.getFromLocation(lat, lon, 1);
            return addresses.get(0).getCountryName();
    }

    public String getCountryOrNull(double lat, double lon) throws IOException {
        List<Address> addresses = geocoder.getFromLocation(lat, lon, 1);
        return (addresses.size() > 0) ? addresses.get(0).getCountryName() : null;
    }
}
