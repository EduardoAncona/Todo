package ancona.todo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class SegundaVentana extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_ventana);

        ImageView imageView = (ImageView) findViewById(R.id.imagen);
        TextView a = (TextView) findViewById(R.id.dia);
        TextView d = (TextView) findViewById(R.id.condicion);
        TextView e = (TextView) findViewById(R.id.textView2);


        Bundle b= getIntent().getExtras();
        String day = b.getString("dia");
        int photo = b.getInt("imagen");
        String climb = b.getString("clima");
        String year = b.getString("temperatura");

         a.setText("" + day);
        imageView.setImageResource(photo);
        d.setText("" + climb);
        e.setText(""+ year);


    }


}
