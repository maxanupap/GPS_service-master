package testing.gps_service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class Logo extends Activity implements
        AdapterView.OnItemSelectedListener {
    String line,boat,typ;
    Spinner spinnerline,spinnernameboat,spinnertype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        spinnerline = (Spinner) findViewById(R.id.spinnerline);
        spinnernameboat = (Spinner) findViewById(R.id.spinnernameboat);
        spinnertype = (Spinner) findViewById(R.id.spinnertype);
        final ImageButton btnext = (ImageButton) findViewById(R.id.btnSignin);


        spinnerline.setOnItemSelectedListener(this);
        List<String> categoriesline = new ArrayList<>();
        categoriesline.add("เรือด่วนธงส้ม(Orange)");
        categoriesline.add("เรือด่วนธงเหลือง(Yellow)");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, categoriesline);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerline.setAdapter(dataAdapter);


        spinnernameboat.setOnItemSelectedListener(this);
        List<String> categoriesname = new ArrayList<>();
        categoriesname.add("171");
        categoriesname.add("172");
        categoriesname.add("173");
        categoriesname.add("174");
        ArrayAdapter<String> dataAdaptername = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, categoriesname);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnernameboat.setAdapter(dataAdaptername);
        spinnertype.setOnItemSelectedListener(this);
        List<String> categoriestype = new ArrayList<>();
        categoriestype.add("นนทบุรี(Nonthaburi)");
        categoriestype.add("วัดราชสิงขร(Wat Rajsingkorn)");
        ArrayAdapter<String> dataAdaptertype = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoriestype);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertype.setAdapter(dataAdaptertype);

        btnext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mapuserIntent = new Intent(Logo.this, MainActivity.class);
                Logo.this.startActivity(mapuserIntent);

                Intent intent = new Intent(Logo.this,GPS_Service.class);
                intent.putExtra("line",line);
                intent.putExtra("boat",boat);
                intent.putExtra("typ",typ);
                startService(intent);

            }
        });

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        Spinner spinner = (Spinner) parent;
        if (spinner.getId() == R.id.spinnerline)
        {
            line = parent.getItemAtPosition(position).toString();
            if (line == "เรือด่วนธงส้ม(Orange)") {
                line = "0";
            } else if (line == "เรือด่วนธงเหลือง(Yellow)") {
                line = "1";
            }
        }
        else if (spinner.getId() == R.id.spinnernameboat)
        {
            boat = parent.getItemAtPosition(position).toString();
        }
        else if (spinner.getId() == R.id.spinnertype)
        {
            typ = parent.getItemAtPosition(position).toString();
            if (typ == "นนทบุรี(Nonthaburi)") {
                typ = "0";
            } else {
                typ = "1";
            }
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
