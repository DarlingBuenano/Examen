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

import software.examen.Articulos;
import software.examen.R;
import software.examen.Volumenes;

@NonReusable
@Layout(R.layout.volumenes)
public class Volumen {

    @View(R.id.imgCover)
    ImageView imgCover;

    @View(R.id.txtTitle)
    TextView txtTitle;

    @View(R.id.txtDataPublished)
    TextView txtDataPublished;

    @View(R.id.txtDoi)
    TextView txtDoi;

    @View(R.id.txtVolume)
    TextView txtVolume;

    @View(R.id.txtYear)
    TextView txtYear;

    @View(R.id.txtNumber)
    TextView txtNumber;

    @View(R.id.txtIssue_id)
    TextView txtIssue_id;

    private Context context;
    private JSONObject jsonVolumen;

    public Volumen(Context context, JSONObject jsonVolumen){
        this.context = context;
        this.jsonVolumen = jsonVolumen;
    }

    @Resolve
    public void onResolved(){
        try {
            Glide.with(this.context).load(jsonVolumen.getString("cover")).into(this.imgCover);
            txtTitle.setText( "Título: " + jsonVolumen.getString("title"));
            txtDataPublished.setText( "Publicado: " + jsonVolumen.getString("date_published"));
            txtDoi.setText( "Doi: " + jsonVolumen.getString("doi"));
            txtVolume.setText( "Volumen: " + jsonVolumen.getString("volume"));
            txtYear.setText( "Año: " + jsonVolumen.getString("year"));
            txtNumber.setText( "Numero: " + jsonVolumen.getString("number"));
            txtIssue_id.setText( "Issue id: " + jsonVolumen.getString("issue_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Click(R.id.rlVolumen)
    public void Click_RL_Volumen(){
        Intent cambiarActivity = new Intent(this.context, Articulos.class);
        try {
            cambiarActivity.putExtra("issue_id", this.jsonVolumen.getString("issue_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        context.startActivity(cambiarActivity);
    }
}
