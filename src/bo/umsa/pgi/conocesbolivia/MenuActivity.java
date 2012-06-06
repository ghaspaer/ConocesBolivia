package bo.umsa.pgi.conocesbolivia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MenuActivity extends BaseActivity {
	ListView lista;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuprincipal);
		lista = (ListView)findViewById(R.id.ListaMenu);
		String items[]={getResources().getString(R.string.item_iniciar),
				getResources().getString(R.string.item_puntajes),
				getResources().getString(R.string.item_configuraciones),
				getResources().getString(R.string.item_ayuda)};
		ArrayAdapter<String> adaptador=new ArrayAdapter<String>
		(this, R.layout.item_menu, items);
		lista.setAdapter(adaptador);

		lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> padre, View itemClikeado, int posicion,
					long id) {
				TextView item=(TextView)itemClikeado;
				String texto=item.getText().toString();
				if(texto.equalsIgnoreCase(getResources().getString(R.string.item_iniciar))){
					//startActivity(new Intent(MenuActivity.this, IniciarActivity.class));
				}else{
					if(texto.equalsIgnoreCase(getResources().getString(R.string.item_puntajes))){
						startActivity(new Intent(MenuActivity.this, PuntajesActivity.class));
					}else{
						if(texto.equalsIgnoreCase(getResources().getString(R.string.item_configuraciones))){
							startActivity(new Intent(MenuActivity.this, ConfiguracionesActivity.class));
						}else{
							startActivity(new Intent(MenuActivity.this, AyudaActivity.class));
						}
					}
				}
			}
		});
	}
}