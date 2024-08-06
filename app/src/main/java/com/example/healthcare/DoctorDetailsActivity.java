package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Doctor Name : Keshav Maharaj","Hospital Address : Jhanjeri", "Exp yrs : 5yrs","Mobile No: 9898437423","600"},
                    {"Doctor Name : Hari Narayan","Hospital Address : Landran", "Exp yrs : 3yrs","Mobile No: 7889434327","500"},
                    {"Doctor Name : Purshottam Raj","Hospital Address : Kharar", "Exp yrs : 6yrs","Mobile No: 8985437462","900"},
                    {"Doctor Name : Om Prakash","Hospital Address : TDI,Mohali", "Exp yrs : 8yrs","Mobile No: 7988437436","1000"},
                    {"Doctor Name : Rahul Singh","Hospital Address : Chhuni", "Exp yrs : 7yrs","Mobile No: 7991439462","700"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Keshav Maharaj","Hospital Address : Jhanjeri", "Exp yrs : 5yrs","Mobile No: 9898437423","600"},
                    {"Doctor Name : Hari Narayan","Hospital Address : Landran", "Exp yrs : 3yrs","Mobile No: 7889434327","500"},
                    {"Doctor Name : Om Prakash","Hospital Address : TDI,Mohali", "Exp yrs : 8yrs","Mobile No: 7988437436","1000"},
                    {"Doctor Name : Purshottam Raj","Hospital Address : Kharar", "Exp yrs : 6yrs","Mobile No: 8985437462","900"},
                    {"Doctor Name : Rahul Singh","Hospital Address : Chhuni", "Exp yrs : 7yrs","Mobile No: 7991439462","700"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Keshav Maharaj","Hospital Address : Jhanjeri", "Exp yrs : 5yrs","Mobile No: 9898437423","600"},
                    {"Doctor Name : Purshottam Raj","Hospital Address : Kharar", "Exp yrs : 9yrs","Mobile No: 8985437462","900"},
                    {"Doctor Name : Hari Narayan","Hospital Address : Landran", "Exp yrs : 3yrs","Mobile No: 7889434327","1200"},
                    {"Doctor Name : Om Prakash","Hospital Address : TDI,Mohali", "Exp yrs : 8yrs","Mobile No: 7988437436","1000"},
                    {"Doctor Name : Rahul Singh","Hospital Address : Chhuni", "Exp yrs : 7yrs","Mobile No: 7991439462","1300"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Hari Narayan","Hospital Address : Landran", "Exp yrs : 3yrs","Mobile No: 7889434327","500"},
                    {"Doctor Name : Purshottam Raj","Hospital Address : Kharar", "Exp yrs : 9yrs","Mobile No: 8985437462","900"},
                    {"Doctor Name : Sushila Devi","Hospital Address : Jhanjeri", "Exp yrs : 8yrs","Mobile No: 9898437423","1600"},
                    {"Doctor Name : Om Prakash","Hospital Address : TDI,Mohali", "Exp yrs : 8yrs","Mobile No: 7988437436","1000"},
                    {"Doctor Name : Rahul Singh","Hospital Address : Chhuni", "Exp yrs : 7yrs","Mobile No: 7991439462","700"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Manish Singh","Hospital Address : Jhanjeri", "Exp yrs : 5yrs","Mobile No: 9898437423","500"},
                    {"Doctor Name : Hari Shah","Hospital Address : Landran", "Exp yrs : 3yrs","Mobile No: 7889434327","800"},
                    {"Doctor Name : Abhay","Hospital Address : TDI,Mohali", "Exp yrs : 8yrs","Mobile No: 7988437436","1000"},
                    {"Doctor Name : Sohail","Hospital Address : Kharar", "Exp yrs : 6yrs","Mobile No: 8985437462","1500"},
                    {"Doctor Name : Rahul Singh","Hospital Address : Chhuni", "Exp yrs : 7yrs","Mobile No: 7991439462","700"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details ={};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewCartLabTitle);
        btn=findViewById(R.id.buttonlabCartBack);
        Intent it = getIntent();
        String title =it.getStringExtra("title");
        tv.setText(title);
            if (title.compareTo("Family Physicians")==0) {
                doctor_details= doctor_details1;
            }
            else
            if (title.compareTo("Dieticians")==0) {
                doctor_details= doctor_details2;
            }
            else
            if (title.compareTo("Dentist")==0) {
                doctor_details= doctor_details3;
            }
            else
            if (title.compareTo("Surgeon")==0) {
                doctor_details= doctor_details4;
            }
            else
            {
                doctor_details= doctor_details5;
            }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int  i= 0; i <doctor_details.length ; i++) {
            item=new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}