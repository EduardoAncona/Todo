package ancona.todo;


import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

import static android.widget.Toast.LENGTH_LONG;

public class TodoListView extends Activity {
    private List<Car> myCar= new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_listview);
        populateCarList();
        populateListView();
        registerClickCallback();
        /*segunda();*/

    }




    private void  populateCarList(){
        myCar.add(new Car("Lunes","23min/24max",R.drawable.soleado,"Soleado"));
        myCar.add(new Car("Martes", "24min/25max", R.drawable.nublado, "Nublado"));
        myCar.add(new Car("Miercoles", "23min/24max", R.drawable.lluvioso, "Lluvioso"));
        myCar.add(new Car("Jueves", "17min/18max", R.drawable.lluvioso, "Lluvioso"));
        myCar.add(new Car("Viernes", "12min/14max", R.drawable.nublado, "Nublado"));
        myCar.add(new Car("Sabado", "8min/10max", R.drawable.nublado, "Nublado"));
        myCar.add(new Car("Domingo", "15min/16max", R.drawable.soleado, "soleado"));
    }
    private void populateListView() {
        ArrayAdapter<Car> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.Car);
        list.setAdapter(adapter);


    }

    private void registerClickCallback(){
        ListView list = (ListView)findViewById(R.id.Car);
        list.setOnItemClickListener(new OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Car clickedCar = myCar.get(position);
                int a = position;
                int b = 1;
                int D = a + b;

               /* String message = "  La posicion del click es:   " + D +
                        "    El dia que eligio es:   " + clickedCar.getMake() + "   El clima sera:  " + clickedCar.getCondition();
                Toast.makeText(TodoListView.this, message, Toast.LENGTH_LONG).show();*/
                Intent i = new Intent(TodoListView.this,SegundaVentana.class);

                String dia = clickedCar.getMake();/* variable que almacena el dia*/
                String year = clickedCar.getYear();
                int foto = clickedCar.getIcon();
                String clima = clickedCar.getCondition();

                i.putExtra("dia", dia);
                i.putExtra("clima",clima);
                i.putExtra("imagen",foto);
                i.putExtra("temperatura",year);


                startActivity(i);



            }
        });
    }

/*    private void segunda(){
        ListView list = (ListView)findViewById(R.id.Car);
        list.setOnItemClickListener(new OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View viewCliked, int position, long id) {
                Car clickedCar = myCar.get(position);


                Intent  ancona = new Intent(TodoListView.this,SegundaVentana.class);
                String dia = clickedCar.getMake();
                String condicion = clickedCar.getCondition();
                ancona.putExtra("dia",dia);
                ancona.putExtra("concicion",condicion);
                startActivity(ancona);

            }
        });
    }
*/
    private class MyListAdapter extends ArrayAdapter<Car>{
        public MyListAdapter(){
            super(TodoListView.this, R.layout.item_view, myCar);
        }


        public View getView(int position, View convertView, ViewGroup parent){
           View itemView= convertView;
            if (itemView == null){
                itemView =getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }
            Car currentCar = myCar.get(position);

            ImageView imageview = (ImageView)itemView.findViewById(R.id.item_icon);
            imageview.setImageResource(currentCar.getIcon());


            TextView makeText = (TextView)itemView.findViewById(R.id.item_txtMake);
            makeText.setText(currentCar.getMake());

            TextView conditionText = (TextView)itemView.findViewById(R.id.item_txtCondition);
            conditionText.setText(currentCar.getCondition());

            TextView yearText = (TextView)itemView.findViewById(R.id.item_txtYear);
            yearText.setText("" + currentCar.getYear());





            return itemView;
      }
    }





}
