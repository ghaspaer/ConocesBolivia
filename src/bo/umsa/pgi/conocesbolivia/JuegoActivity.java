package bo.umsa.pgi.conocesbolivia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class JuegoActivity extends BaseActivity {
	ListView lista;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        
    }
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	getMenuInflater().inflate(R.menu.menu_opciones, menu);
    	menu.findItem(R.id.item_menu_ayuda).setIntent(
    			new Intent(this, AyudaActivity.class));
    	menu.findItem(R.id.item_menu_configuraciones).setIntent(
    			new Intent(this, ConfiguracionesActivity.class));
    	return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
    	super.onOptionsItemSelected(item);
    	startActivity(item.getIntent());
    	Toast tos=Toast.makeText(this, "hizo click", Toast.LENGTH_SHORT);
    	tos.show();
    	return true;
    }
}