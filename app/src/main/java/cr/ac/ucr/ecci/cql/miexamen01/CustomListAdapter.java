package cr.ac.ucr.ecci.cql.miexamen01;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final String[] itemdescription;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid, String[] itemdescription) {
        super(context, R.layout.mi_lista_personalizada, itemname);

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
        this.itemdescription = itemdescription;
    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mi_lista_personalizada, null, true);
        TextView nombre = (TextView) rowView.findViewById(R.id.name);
        ImageView imagen = (ImageView) rowView.findViewById(R.id.icon);
        TextView descripcion = (TextView) rowView.findViewById(R.id.description);
        nombre.setText(itemname[position]);
        imagen.setImageResource(imgid[position]);
        descripcion.setText(itemdescription[position]);
        return rowView;
    }
}