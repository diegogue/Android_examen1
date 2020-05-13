package cr.ac.ucr.ecci.cql.miexamen01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Recibe el objeto TableTop
        Intent intent = getIntent();
        TableTop tSeleccionado =  intent.getParcelableExtra("tabletop");

    }
}
