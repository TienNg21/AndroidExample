package vn.tien.androidexample.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import vn.tien.androidexample.R;
import vn.tien.androidexample.ui.data.CustomAdapter;
import vn.tien.androidexample.ui.data.Language;
import vn.tien.androidexample.ui.data.LanguageDataUtils;

public class LayoutAttributeActivity extends Activity {

    private Spinner spinner;
    private List<Language> languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_attribute);
        //Button
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LayoutAttributeActivity.this, "onClick Button", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(LayoutAttributeActivity.this, "onLongClick Button", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //Image Button
        findViewById(R.id.imgbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LayoutAttributeActivity.this, "onClick Image Button", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.imgbtn).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(LayoutAttributeActivity.this, "onLongClick Image Button", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //Check Box
        findViewById(R.id.checkbox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status;
                CheckBox checkBox = findViewById(R.id.checkbox);
                if(checkBox.isChecked()){
                    status = "Checked";
                }else{
                    status = "Unchecked";
                }
                Toast.makeText(LayoutAttributeActivity.this, "onClick Check Box\n" + status, Toast.LENGTH_SHORT).show();
            }
        });
        //Togle Button
        findViewById(R.id.tglbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status;
                if(findViewById(R.id.checkbox).createAccessibilityNodeInfo().isChecked()){
                    status = "Checked";
                }else{
                    status = "Unchecked";
                }
                Toast.makeText(LayoutAttributeActivity.this, "onClick Toggle Button\n" + status, Toast.LENGTH_SHORT).show();
            }
        });
        //Radio Button
        RadioButton radioButton = findViewById(R.id.rdobtn);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton.isChecked()){
                    Toast.makeText(LayoutAttributeActivity.this, "Active Radio Button", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Progress Bar
        Button prgrBtn = findViewById(R.id.btnprgr);
        prgrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar progressBar = findViewById(R.id.prgrbar);
                if(progressBar.getVisibility() == View.GONE){
                    Toast.makeText(LayoutAttributeActivity.this, "Turn on Progress", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.VISIBLE);
                    prgrBtn.setText("Turn off Progress");
                }else{
                    Toast.makeText(LayoutAttributeActivity.this, "Turn off Progress", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    prgrBtn.setText("Turn on Progress");
                }
            }
        });
        //Spinner
        // Data:
        this.languages = LanguageDataUtils.getLanguages();
        this.spinner = (Spinner) this.findViewById(R.id.spinner);

        // Adapter"
        CustomAdapter adapter = new CustomAdapter(LayoutAttributeActivity.this,
                R.layout.spinner_item_layout_resource,
                R.id.textView_item_name,
                R.id.textView_item_percent,
                this.languages);

        this.spinner.setAdapter(adapter);
        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Language thislang = languages.get((int) id);
                if(thislang.getId() != 0){
                    Toast.makeText(LayoutAttributeActivity.this, "Select Language" + "\nId: " + thislang.getId() + "\nName: " + thislang.getName() + "\nPercent: " + thislang.getPercent(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}