package vn.tien.androidexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import vn.tien.androidexample.ui.AbsoluteLayoutActivity;
import vn.tien.androidexample.ui.FrameLayoutActivity;
import vn.tien.androidexample.ui.GridViewActivity;
import vn.tien.androidexample.ui.LayoutAttributeActivity;
import vn.tien.androidexample.ui.LinearLayoutActivity;
import vn.tien.androidexample.ui.RelativeLayoutActivity;
import vn.tien.androidexample.ui.TableLayoutActivity;

public class UIActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiactivity);
        String mess = getIntent().getStringExtra("value");
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();

        findViewById(R.id.buttonGoToGG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIActivity.this, "Open google.com.vn", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.google.com.vn/"));
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonLinearLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIActivity.this, "Open Linear Layout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UIActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonRelativeLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIActivity.this, "Open Relative Layout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UIActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonTableLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIActivity.this, "Open Table Layout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UIActivity.this, TableLayoutActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonAbsoluteLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIActivity.this, "Open Absolute Layout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UIActivity.this, AbsoluteLayoutActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonFrameLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIActivity.this, "Open Frame Layout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UIActivity.this, FrameLayoutActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonGridView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIActivity.this, "Open Grid View", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UIActivity.this, GridViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnLayoutAttribute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIActivity.this, "Open Layout Attributes", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UIActivity.this, LayoutAttributeActivity.class);
                startActivity(intent);
            }
        });
    }
}