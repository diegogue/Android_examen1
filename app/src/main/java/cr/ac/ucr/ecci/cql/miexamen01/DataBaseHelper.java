package cr.ac.ucr.ecci.cql.miexamen01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Clase DataBaseHelper que hereda de SQLiteOpenHelper
public class DataBaseHelper extends SQLiteOpenHelper {
    // Cada vez que cambie el esquema de la base de datos DataBaseContract,
//      debemos incrementar la version de la base de datos
    public static final int DATABASE_VERSION = 3;
    // Nombre de la base de datos
    public static final String DATABASE_NAME = "AndroidStorage.db";

    // constructor de la clase, el contexto tiene la informacion global sobre el ambiente de la app
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // implementamos el metodo para la creacion de la base de datos
    public void onCreate(SQLiteDatabase db) {
        // Crear la base de datos de la app
        db.execSQL(DataBaseContract.SQL_CREATE_TABLETOP);
    }

    // implementamos el metodo para la actualizacion de la base de datos
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Administracion de actualizaciones
        db.execSQL(DataBaseContract.SQL_DELETE_TABLETOP);
        onCreate(db);
    }

    // inplementamos el metodo para volver a la version anterior de la base de datos
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}