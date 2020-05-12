package cr.ac.ucr.ecci.cql.miexamen01;
import android.provider.BaseColumns;

public class DataBaseContract {

    // Para asegurar que no se instancie la clase hacemos el constructor privado
    private DataBaseContract() {}

    // Definimos una clase interna que define las tablas y columnas
    // Implementa la interfaz BaseColumns para heredar campos estandar del marco de Android _ID
    public static class DataBaseEntry implements BaseColumns {

        // Clase TableTop
        public static final String TABLE_NAME_TABLETOP = "TABLETOP";
        private String tabletop;
        public static final String COLUMN_NAME_ID = "ID";
        private String id;
        public static final String COLUMN_NAME_NAME = "Name";
        private String name;
        public static final String COLUMN_NAME_YEAR = "Year";
        private String year;
        public static final String COLUMN_NAME_PUBLISHER = "Publisher";
        private int publisher;
        public static final String COLUMN_NAME_COUNTRY = "Country";
        private int country;
        public static final String COLUMN_NAME_LATITUD = "Latitud";
        private String latitud;
        public static final String COLUMN_NAME_LONGITUD = "Longitud";
        private float longitud;
        public static final String COLUMN_NAME_DESCRIPTION = "Description";
        private float description;
        public static final String COLUMN_NAME_NO_PLAYERS = "NoPlayers";
        private float noplayers;
        public static final String COLUMN_NAME_AGES = "Ages";
        private float ages;
        public static final String COLUMN_NAME_PLAYING_TIME = "PlayingTime";
        private float playingTime;
    }

    // Construir las tablas de la base de datos
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REAL_TYPE = " REAL";
    private static final String COMMA_SEP = ",";

    // Creacion de tablas Persona, Estudiante, Funcionario

    public static final String SQL_CREATE_TABLETOP = "CREATE TABLE " + DataBaseEntry.TABLE_NAME_TABLETOP + " (" + DataBaseEntry.COLUMN_NAME_ID + TEXT_TYPE + "PRIMARY KEY," +
            DataBaseEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP + DataBaseEntry.COLUMN_NAME_YEAR + TEXT_TYPE + COMMA_SEP +  DataBaseEntry.COLUMN_NAME_PUBLISHER + TEXT_TYPE +
            COMMA_SEP  + DataBaseEntry.COLUMN_NAME_COUNTRY + TEXT_TYPE + COMMA_SEP +  DataBaseEntry.COLUMN_NAME_LATITUD + TEXT_TYPE + COMMA_SEP +
            DataBaseEntry.COLUMN_NAME_LONGITUD + TEXT_TYPE  + COMMA_SEP + DataBaseEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP + DataBaseEntry.COLUMN_NAME_NO_PLAYERS +
            COMMA_SEP + DataBaseEntry.COLUMN_NAME_AGES + TEXT_TYPE  + COMMA_SEP + DataBaseEntry.COLUMN_NAME_PLAYING_TIME + TEXT_TYPE + " )";

    public static final String SQL_DELETE_TABLETOP = "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_TABLETOP;


}
