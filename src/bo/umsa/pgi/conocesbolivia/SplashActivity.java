package bo.umsa.pgi.conocesbolivia;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SplashActivity extends BaseActivity {
    TextView titulo1;
    TextView titulo2;
    TableLayout tablaImg;
    TableRow fila;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        iniciarAnimacion();
    }
    
    public void iniciarAnimacion(){	
    	titulo1=(TextView)findViewById(R.id.TextViewTitulo1);
    	Animation animacion1=AnimationUtils.loadAnimation(this, R.anim.animacion1);
    	titulo1.startAnimation(animacion1);
    	
    	titulo2=(TextView)findViewById(R.id.TextViewTitulo2);
    	Animation animacion2=AnimationUtils.loadAnimation(this, R.anim.animacion2);
    	titulo2.startAnimation(animacion2);
    	
    	tablaImg=(TableLayout)findViewById(R.id.TablaImagenes);
    	Animation animacion3=AnimationUtils.loadAnimation(this, R.anim.animacion3);
    	LayoutAnimationController controlador=new LayoutAnimationController(animacion3);
    	for (int i = 0; i < tablaImg.getChildCount(); i++) {
    		fila = (TableRow)tablaImg.getChildAt(i);
    		fila.setLayoutAnimation(controlador);
    	}
    	
    	animacion2.setAnimationListener(new AnimationListener() {
			public void onAnimationStart(Animation animation) {
			}
			public void onAnimationRepeat(Animation animation) {
			}
			public void onAnimationEnd(Animation animation) {
				startActivity(new Intent(SplashActivity.this,
						MenuActivity.class));
				SplashActivity.this.finish();
			}
		});
    }
}