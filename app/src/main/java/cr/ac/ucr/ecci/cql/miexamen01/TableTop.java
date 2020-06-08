package cr.ac.ucr.ecci.cql.miexamen01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TableTop extends AppCompatActivity implements Parcelable{

    //Variables para los atributos de la tabla
    private String id;
    private String name;
    private String year;
    private String publisher;
    private String country;
    private float latitud;
    private float longitud;
    private String description;
    private String NoPlayers;
    private String Ages;
    private String playingTime;

    public TableTop() {
        super();
    }

    //Creator
    public static final Creator<MainActivity> CREATOR = new Creator<MainActivity>() {

        @Override
        public MainActivity createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public MainActivity[] newArray(int size) {
            return new MainActivity[0];
        }
    };

    //Constructor con sus parámetros
    public TableTop(String id, String name, String year, String publisher, String country, float latitud, float longitud, String description,
                    String NoPlayers, String Ages, String playingTime){
        this.id = id;
        this.name = name;
        this.year = year;
        this.publisher = publisher;
        this.country = country;
        this.latitud = latitud;
        this.longitud = longitud;
        this.description = description;
        this.NoPlayers = NoPlayers;
        this.Ages = Ages;
        this.playingTime = playingTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoPlayers() {
        return NoPlayers;
    }

    public void setNoPlayers(String noPlayers) {
        NoPlayers = noPlayers;
    }

    public String getAges() {
        return Ages;
    }

    public void setAges(String ages) {
        Ages = ages;
    }

    public String getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(String playingTime) {
        this.playingTime = playingTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    protected TableTop(Parcel in) {
        id = in.readString();
        name = in.readString();
        year = in.readString();
        publisher = in.readString();
        country = in.readString();
        latitud =  Float.parseFloat(in.readString());
        longitud = Float.parseFloat(in.readString());
        description = in.readString();
        NoPlayers = in.readString();
        Ages = in.readString();
        playingTime = in.readString();
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(year);
        dest.writeString(publisher);
        dest.writeString(country);
        dest.writeString(String.valueOf(longitud));
        dest.writeString(String.valueOf(latitud));
        dest.writeString(description);
        dest.writeString(NoPlayers);
        dest.writeString(Ages);
        dest.writeString(playingTime);
    }

    // insertar un juego en la base de datos
    public long insertar(Context context) {

        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_ID, getId());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_NAME, getName());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_YEAR, getYear());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_PUBLISHER, getPublisher());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_COUNTRY, getCountry());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_LATITUD, getLatitud());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_LONGITUD, getLongitud());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPTION, getDescription());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_NO_PLAYERS, getNoPlayers());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_AGES, getPlayingTime());

        // Insertar la nueva fila
        return db.insert(DataBaseContract.DataBaseEntry.TABLE_NAME_TABLETOP, null, values);
    }

    // leer un juego desde la base de datos
    public void leer(Context context, String id) {

        // usar la clase DataBaseHelper para realizar la operacion de leer
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

        // Obtiene la base de datos en modo lectura
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

        // Define cuales columnas quiere solicitar
        // en este caso todas las de la clase
        String[] projection = {
                DataBaseContract.DataBaseEntry.COLUMN_NAME_ID,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_NAME,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_YEAR,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_PUBLISHER,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_COUNTRY,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_LATITUD,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_LONGITUD,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPTION,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_NO_PLAYERS,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_AGES,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_PLAYING_TIME
        };

        // Filtro para el WHERE
        String selection = DataBaseContract.DataBaseEntry.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = {id};

        // Resultados en el cursor
        Cursor cursor = db.query(
                DataBaseContract.DataBaseEntry.TABLE_NAME_TABLETOP, // tabla
                projection,                                        // columnas
                selection,                                         // where
                selectionArgs,                                     // valores del where
                null,                                              // agrupamiento
                null,                                              // filtros por grupo
                null                                               // orden
        );

        // recorrer los resultados y asignarlos a la clase // aca podria implementarse un ciclo si es necesario
        if (cursor.moveToFirst() && cursor.getCount() > 0) {
            setId(cursor.getString(cursor.getColumnIndexOrThrow( DataBaseContract.DataBaseEntry.COLUMN_NAME_ID)));
            setName(cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContract.DataBaseEntry.COLUMN_NAME_NAME)));
            setYear(cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContract.DataBaseEntry.COLUMN_NAME_YEAR)));
            setPublisher(cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContract.DataBaseEntry.COLUMN_NAME_PUBLISHER)));
            setCountry(cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContract.DataBaseEntry.COLUMN_NAME_COUNTRY)));
            setLatitud((cursor.getColumnIndexOrThrow(DataBaseContract.DataBaseEntry.COLUMN_NAME_LATITUD)));
            setLongitud((cursor.getColumnIndexOrThrow( DataBaseContract.DataBaseEntry.COLUMN_NAME_LONGITUD)));
            setCountry(cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPTION)));
            setCountry(cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContract.DataBaseEntry.COLUMN_NAME_NO_PLAYERS)));
            setCountry(cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContract.DataBaseEntry.COLUMN_NAME_AGES)));
            setCountry(cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContract.DataBaseEntry.COLUMN_NAME_PLAYING_TIME)));
        }
    }

}
