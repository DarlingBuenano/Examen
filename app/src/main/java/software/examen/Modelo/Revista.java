package software.examen.Modelo;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONException;
import org.json.JSONObject;

import software.examen.R;
import software.examen.Volumenes;

@NonReusable
@Layout(R.layout.revistas)
public class Revista {
    @View(R.id.imgPortada)
    ImageView imgPortada;

    @View(R.id.txtNombre)
    TextView txtNombre;

    @View(R.id.txtDescripcion)
    TextView txtDescripcion;

    private Context mContext;
    private JSONObject itemRevista;

    public Revista(Context context, JSONObject itemRevista){
        this.mContext = context;
        this.itemRevista = itemRevista;
    }

    @Resolve
    protected void onResolved(){
        try{
            //Esto para cargar una url en la imagen
            //Glide.with(this.mContext).load(this.url).into(this.imgPortada);

            //Esto para establecer datos en las vistas
            this.txtNombre.setText(this.itemRevista.getString("name"));
            this.txtDescripcion.setText(this.itemRevista.getString("description"));
            Glide.with(this.mContext).load(this.itemRevista.getString("portada")).into(this.imgPortada);
        }
        catch (JSONException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Click(R.id.rlCard)
    public void ClicrlCard(){
        Intent cambiarActivity = new Intent(this.mContext, Volumenes.class);
        try {
            cambiarActivity.putExtra("journal_id", this.itemRevista.getString("journal_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mContext.startActivity(cambiarActivity);
    }

}
