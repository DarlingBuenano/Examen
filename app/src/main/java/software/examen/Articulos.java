package software.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import software.examen.Modelo.Articulo;
import software.examen.Modelo.Volumen;
import software.examen.WebService.Asynchtask;
import software.examen.WebService.WebService;

public class Articulos extends AppCompatActivity implements Asynchtask {

    PlaceHolderView phvArticulos;
    TextView section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);

        String issue_id = getIntent().getStringExtra("issue_id");

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://revistas.uteq.edu.ec/ws/pubs.php?i_id=" + issue_id,
                datos, this, this);
        ws.execute("GET");

        this.section = findViewById(R.id.txtSection);
        this.phvArticulos = findViewById(R.id.phvArticulos);
    }

    @Override
    public void processFinish(String result) throws JSONException {
        try {
            JSONArray jsonArray = new JSONArray(result);

            JSONObject jsonObject = jsonArray.getJSONObject(0);
            this.section.setText(jsonObject.getString("section"));

            for (int i = 0; i < jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);
                this.phvArticulos.addView(new Articulo(getApplicationContext(), jsonObject));
            }
        }
        catch (JSONException ex){
            System.out.println(ex.getMessage());
        }
    }
}