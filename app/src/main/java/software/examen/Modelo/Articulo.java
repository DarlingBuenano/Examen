package software.examen.Modelo;

import android.content.Context;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONObject;

import software.examen.R;

@NonReusable
@Layout(R.layout.articulos)
public class Articulo {

    @View(R.id.txtPublication_article)
    TextView publication_id;
    @View(R.id.txtTitle_article)
    TextView title;
    @View(R.id.txtDoi_article)
    TextView doi;
    @View(R.id.txtAbstract_article)
    TextView resumen;
    @View(R.id.txtDataPublished_article)
    TextView date_published;
    @View(R.id.btnPDF)
    TextView galeys_PDF;
    @View(R.id.btnHTML)
    TextView galeys_HTML;
    @View(R.id.txtKeyWords_article)
    TextView keywords;
    @View(R.id.txtAuthors_article)
    TextView authors;

    private Context context;
    private JSONObject jsonArticulo;

    public Articulo(Context context, JSONObject jsonObject){
        this.context = context;
        this.jsonArticulo = jsonObject;
    }
}
