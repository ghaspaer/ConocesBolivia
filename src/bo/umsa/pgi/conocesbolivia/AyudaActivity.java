package bo.umsa.pgi.conocesbolivia;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AyudaActivity extends BaseActivity {
	ListView lista;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda);
        
        InputStream archivo=getResources().openRawResource(R.raw.ayuda);
        try{
        	TextView txtAyuda=(TextView)findViewById(R.id.TextViewAyuda);
        	String cadenaArch = inputStreamToString(archivo);
        	txtAyuda.setText(cadenaArch);
        }catch(Exception e){
        	Toast msg=Toast.makeText(this, "Error al leer el Archivo", Toast.LENGTH_SHORT);
        	msg.show();
        }
    }
    public String inputStreamToString(InputStream is) throws IOException{
    	StringBuffer buffer=new StringBuffer();
    	DataInputStream datos = new DataInputStream(is);
    	String lineaCadena=null;
    	while((lineaCadena=datos.readLine())!=null){
    		buffer.append(lineaCadena+"\n");
    	}
    	datos.close();
    	is.close();
    	return buffer.toString();
    }
}