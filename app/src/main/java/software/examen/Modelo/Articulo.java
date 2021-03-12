package software.examen.Modelo;

import android.content.Context;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONArray;
import org.json.JSONException;
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

    @Resolve
    protected void onResolve(){
        try {

            title.setText( "Título: " + jsonArticulo.getString("title") );
            resumen.setText( "Resumen: " + jsonArticulo.getString("abstract") );
            doi.setText( "DOI: " + jsonArticulo.getString("doi") );
            publication_id.setText( "N publicación: " + jsonArticulo.getString("publication_id") );
            date_published.setText( "Publicado: " + jsonArticulo.getString("date_published") );

            JSONArray jsonArray = jsonArticulo.getJSONArray("keywords");
            String keywords_string = "";
            for (int i = 0; i < jsonArray.length(); i++){
                keywords_string = keywords_string + jsonArray.getJSONObject(i).getString("keyword");
                if(i < (jsonArray.length() - 1) )
                    keywords_string = keywords_string + ", ";
            }
            this.keywords.setText( "Palabras claves: " + keywords_string);

            jsonArray = jsonArticulo.getJSONArray("authors");
            String authors_string = "";
            for (int j = 0; j < jsonArray.length(); j++){
                authors_string = authors_string + jsonArray.getJSONObject(j).getString("nombres");
                if(j < (jsonArray.length() - 1) )
                    authors_string = authors_string + ", ";
            }
            this.authors.setText("Autores: " + authors_string);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
