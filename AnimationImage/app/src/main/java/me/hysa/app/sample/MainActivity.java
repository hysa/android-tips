package me.hysa.app.sample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import me.hysa.app.sample.animation.FrontBackAnimation;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.imageViewFront).setOnClickListener(this);
        findViewById(R.id.imageViewBack).setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switchFrontBackView(false);  // 表から裏にひっくり返す場合
//		switchFrontBackView(true);   // 裏から表にひっくり返す場合
    }

    private void switchFrontBackView(boolean isReverse) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout);
        View frontView = (ImageView)findViewById(R.id.imageViewFront);
        View backView = (ImageView)findViewById(R.id.imageViewBack);

        if(frontView == null || backView == null) return;

        FrontBackAnimation animator =
                new FrontBackAnimation(frontView, backView, backView.getWidth() /2 , backView.getHeight() / 2);
        if(isReverse) animator.reverse();
        relativeLayout.startAnimation(animator);
    }
}
