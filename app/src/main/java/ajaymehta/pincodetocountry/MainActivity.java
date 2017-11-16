package ajaymehta.pincodetocountry;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText pincode;
    TextView tvData;

    String myData="";

    String getPin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pincode = (EditText) findViewById(R.id.et_pincode);
        tvData = (TextView) findViewById(R.id.tv_data);
    }

    public void submit(View view) {
        myData="";

        getPin = pincode.getText().toString();

        findLocationName();

    }

    public void  findLocationName()
    {
        try {
            Geocoder gcd = new Geocoder(this, Locale.getDefault());
            List<Address> addresses;

            addresses = gcd.getFromLocationName(getPin,5);  //put hisar instead of getPin

            for(int i=0;i<addresses.size();i++){
                Log.e("ajaymehta","in loop");
                Log.e("ajaymehta","lat :,,,,,,,,,,,,,"+addresses.get(i).getLatitude()+"  long............"+addresses.get(i).getLongitude());

                myData+= addresses.get(i).getCountryName()+"\n";
                myData+= addresses.get(i).getLocality()+"\n";
                myData+= addresses.get(i).getLocale()+"\n";
                myData+= addresses.get(i).getAdminArea()+"\n";
                myData+= addresses.get(i).getAddressLine(i)+"\n";
                myData+= addresses.get(i).getFeatureName()+"\n";
                myData+= addresses.get(i).getCountryCode()+"\n";
                myData+= addresses.get(i).getPhone()+"\n";
                myData+= addresses.get(i).getPostalCode()+"\n";
                myData+= addresses.get(i).getPremises()+"\n";
                myData+= addresses.get(i).getSubLocality()+"\n";
                myData+= addresses.get(i).getSubAdminArea()+"\n";
                myData+= addresses.get(i).getSubLocality()+"\n";
                myData+= addresses.get(i).getExtras()+"\n";
                myData+= addresses.get(i).getLatitude()+"\n";
                myData+= addresses.get(i).getLongitude()+"\n";
                myData+= addresses.get(i).getMaxAddressLineIndex()+"\n";

                tvData.setText(myData.toString());

              /*  Toast.makeText(this, "lat : "+addresses.get(i).getLatitude(),Toast.LENGTH_LONG).show();
                Toast.makeText(this, "long : "+addresses.get(i).getLongitude(),Toast.LENGTH_LONG).show();
                Toast.makeText(this, "long : "+addresses.get(i).getCountryName(),Toast.LENGTH_LONG).show();
                Toast.makeText(this, "long : "+addresses.get(i).getLocality(),Toast.LENGTH_LONG).show();
                Toast.makeText(this, "long : "+addresses.get(i).getLocale(),Toast.LENGTH_LONG).show();*/
            }

        }
        catch (IOException e) {e.printStackTrace();}
    }
}
