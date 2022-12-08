package com.example.maya06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    ListView lv;
    TextView tv1,tv2,tv3,tv4;
    Spinner spin;
    String[] classes={"classes", "First", "Second", "Third", "Fourth"};
    String[][] names={{"avi","betty","cameron","dora","elimelech","fredrich","guy","mallisa","ivan","jada"},
            {"aya","bar","sivan","maya","mika","tal","yuval","nitzan","yohay","yossi"},
            {"ariel","baruch","carri","damon","erel","dan","michael","hen","yakov","edna"},
            {"avihay","avihoo","lital","dana","yair","elinoam","harel","jonatan","eden","inbar"}};
    String[][] lastN={{"Avraham","cohen","levy","david","groysman","Frensiss","Groisman","michaelan","menahem","Jhonson"},
            {"ben baruch","levi","sela","azulai","simon","leivovich","zini","goldberg","macDonald","jersi"},
            {"Aharoni","aisha","dadon","shtarker","bunkin","shvartz","shteinberg","stangrit","gabay","zurablov"},
            {"cohen","levi","reinstein","ofek","mayzus","gedj","krief","shemesh","david","ben shitrit"}};
    String[][] dates={{"12/1/2006","2/11/2006","3/4/2006","4/7/2006","5/1/2006","6/12/2006","17/1/2006","8/9/2006","9/1/2006","10/11/2006"},
            {"14/12/2006","22/5/2006","11/4/2006","14/2/2006","18/12/2006","27/2/2006","17/12/2006","8/2/2006","9/2/2006","10/2/2006"},
            {"1/11/2006","2/12/2006","3/10/2006","4/1/2006","5/6/2006","6/7/2006","7/8/2006","8/10/2006","9/11/2006","10/12/2006"},
            {"1/1/2006","2/1/2006","3/3/2006","4/6/2006","5/1/2006","6/1/2006","7/1/2006","8/1/2006","9/1/2006","10/1/2006"}};
    String[][] phoneN={{"0504442905","0502007136","0542007102","052358168","0545381648","0525341678","0525381641","0502007131","0543312678","0525347855"},
            {"0504407135","0502007162","0542007192","052358118","0545381628","0525341658","0525381649","0502007132","0543312679","0525347859"},
            {"0504407134","0502007172","0542007182","052358178","0545381608","0525341618","0525381647","0502007133","0543312670","0525347857"},
            {"0504407133","0502007122","0542007112","052358188","0545381638","0525341698","0525381643","0502007134","0543312671","0525347854"}};
    int count=0;
    int num=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        ArrayAdapter<String> adp= new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, classes);
        spin.setAdapter(adp);
        spin.setOnItemSelectedListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);
    }
    void initialize(){
        lv=findViewById(R.id.lv);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        spin=findViewById(R.id.spin);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        count++;
        if (count>1){
            if (i==1){
                ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names[0]);
                lv.setAdapter(adp);
                num=0;
            }
            else if (i==2){
                ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names[1]);
                lv.setAdapter(adp);
                num=1;
            }
            else if (i==3){
                ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names[2]);
                lv.setAdapter(adp);
                num=2;
            }
            else if (i==4){
                ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names[3]);
                lv.setAdapter(adp);
                num=3;
            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        tv1.setText(lastN[num][i]);
        tv2.setText(names[num][i]);
        tv3.setText(dates[num][i]);
        tv4.setText(phoneN[num][i]);
    }
}