package cr.ac.ucr.ecci.cql.miexamen01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity implements Parcelable {
    public MainActivity() {
    }

    // Esto queda mas elegante pasando los objetos a partir de las clases
    // Considerar para la refactorización
    ListView list;

    String[] itemname = new String[5];
    String[] itemdescription = new String[5];
    TableTop[] TableList = new TableTop[5];
    /* String[] itemdescription ={
            "Picture yourself in the era of discoveries:\n" +
                    "after a long voyage of great deprivation,\n" +
                    "your ships have finally reached the coast of\n" +
                    "an uncharted island. Its name shall be Catan!\n" +
                    "But you are not the only discoverer. Other\n" +
                    "fearless seafarers have also landed on the\n" +
                    "shores of Catan: the race to settle the\n" +
                    "island has begun!",
            "The thrill of bankrupting an opponent, but it\n" +
                    "pays to play nice, because fortunes could\n" +
                    "change with the roll of the dice. Experience\n" +
                    "the ups and downs by collecting property\n" +
                    "colors sets to build houses, and maybe even\n" +
                    "upgrading to a hotel!",
            "An ancient evil is stirring. You are part of\n" +
                    "a team of unlikely heroes engaged in an\n" +
                    "international struggle to stop the gathering\n" +
                    "darkness. To do so, you’ll have to defeat\n" +
                    "foul monsters, travel to Other Worlds, and\n" +
                    "solve obscure mysteries surrounding this\n" +
                    "unspeakable horror.",
            "Magic: The Gathering is a collectible and\n" +
                    "digital collectible card game created by\n" +
                    "Richard Garfield. Each game of Magic\n" +
                    "represents a battle between wizards known as\n" +
                    "planeswalkers who cast spells, use artifacts,\n" +
                    "and summon creatures.",
            "Hanabi—named for the Japanese word for\n" +
                    "\"fireworks\"—is a cooperative game in which\n" +
                    "players try to create the perfect fireworks\n" +
                    "show by placing the cards on the table in the\n" +
                    "right order.",
    };*/
    Integer[] imgid={
            R.drawable.catan,
            R.drawable.monopoly,
            R.drawable.eldritch,
            R.drawable.mtg,
            R.drawable.hanabi,
    };

    protected MainActivity(Parcel in) {
        itemname = in.createStringArray();
        itemdescription = in.createStringArray();
    }

    public static final Creator<MainActivity> CREATOR = new Creator<MainActivity>() {
        @Override
        public MainActivity createFromParcel(Parcel in) {
            return new MainActivity(in);
        }

        @Override
        public MainActivity[] newArray(int size) {
            return new MainActivity[size];
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertarDatos();
        leerDatosLista();

        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid, itemdescription);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mostrarDetalles(TableList[0]);


            }
        });

    }

    //Inserta los datos dados previamente
    private void insertarDatos() {

        // Instancia la clase Estudiante y realiza la inserción de datos
        TableTop country = new TableTop("TT001","Catan", "1995", "Kosmos", "Germany", (float)48.774538, (float)9.188467,
                "Picture yourself in the era of discoveries: after a long voyage of great deprivation, your ships have finally reached the coast of an uncharted island. Its name shall be Catan! But you are not the only discoverer. Other fearless seafarers have also landed on the shores of Catan: the race to settle the island has begun!",
                "3-4", "10+", "1-2 hours");

        // inserta el estudiante, se le pasa como parametro el contexto de la app
        long newRowId =  country.insertar(getApplicationContext());

        country = new TableTop("TT002","Monopoly", "1935", "Hasbro", "United States", (float)41.883736, (float)-71.352259,
                "The thrill of bankrupting an opponent, but it" +
                        "pays to play nice, because fortunes could" +
                        "change with the roll of the dice. Experience" +
                        "the ups and downs by collecting property" +
                        "colors sets to build houses, and maybe even" +
                        "upgrading to a hotel!",
                "2-8", "8+", "20-180 minutes");
        // inserta el estudiante, se le pasa como parametro el contexto de la app
        newRowId =  country.insertar(getApplicationContext());

        country = new TableTop("TT003","Eldritch Horror", "2013", "Fantasy Flight Games", "United States", (float)45.015417, (float)-93.183995,
                "An ancient evil is stirring. You are part of" +
                        "a team of unlikely heroes engaged in an" +
                        "international struggle to stop the gathering" +
                        "darkness. To do so, you’ll have to defeat" +
                        "foul monsters, travel to Other Worlds, and" +
                        "solve obscure mysteries surrounding this" +
                        "unspeakable horror.",
                "1-8", "14+", "2-4 hours");
        // inserta el estudiante, se le pasa como parametro el contexto de la app
        newRowId =  country.insertar(getApplicationContext());

        country = new TableTop("TT004","Magic: the Gathering", "1993", "Hasbro", "United States", (float)41.883736, (float)-71.352259,
                "Magic: The Gathering is a collectible and" +
                        "digital collectible card game created by" +
                        "Richard Garfield. Each game of Magic" +
                        "represents a battle between wizards known as" +
                        "planeswalkers who cast spells, use artifacts," +
                        "and summon creatures.",
                "2+", "13+", "Varies");

        // inserta el estudiante, se le pasa como parametro el contexto de la app
        newRowId =  country.insertar(getApplicationContext());

        country = new TableTop("TT005","Hanabi", "2010", "Asmodee", "France", (float)48.761629, (float)2.065296,
                "Hanabi—named for the Japanese word for" +
                        "fireworks—is a cooperative game in which" +
                        "players try to create the perfect fireworks" +
                        "show by placing the cards on the table in the" +
                        "right order.",
                "2-5", "8+", "25 minutes");

        // inserta el estudiante, se le pasa como parametro el contexto de la app
        newRowId =  country.insertar(getApplicationContext());

        System.out.println("Datos ingresados correctamente");
    }

    private void leerDatosLista(){

// Instancia la clase TableTop y realiza la lectura de datos
        TableTop tableTop = new TableTop();
        // leer el estudiante, se le pasa como parametro el contexto de la app y ls identificacion
        tableTop.leer(getApplicationContext(), "TT001");
        TableList[0] = tableTop;
        itemname[0]=tableTop.getName();
        itemdescription[0]= tableTop.getDescription();
        System.out.println(tableTop.getDescription());

        tableTop = new TableTop();
        tableTop.leer(getApplicationContext(), "TT002");
        TableList[1] = tableTop;
        itemname[1]=tableTop.getName();
        itemdescription[1]= tableTop.getDescription();

        tableTop = new TableTop();
        tableTop.leer(getApplicationContext(), "TT003");
        TableList[2] = tableTop;
        itemname[2]=tableTop.getName();
        itemdescription[2]= tableTop.getDescription();

        tableTop = new TableTop();
        tableTop.leer(getApplicationContext(), "TT004");
        TableList[3] = tableTop;
        itemname[3]=tableTop.getName();
        itemdescription[3]= tableTop.getDescription();

        tableTop = new TableTop();
        tableTop.leer(getApplicationContext(), "TT005");
        TableList[4] = tableTop;
        itemname[4]=tableTop.getName();
        itemdescription[4]= tableTop.getDescription();
    }

    public void mostrarDetalles(TableTop t){
        // Intent para llamar a la Actividad Detalles
        Intent intent = new Intent(this, Detalles.class);
        intent.putExtra("tabletop",  t);
        startActivity(intent);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(itemname);
        dest.writeStringArray(itemdescription);
        dest.writeTypedArray(TableList, flags);
    }
}