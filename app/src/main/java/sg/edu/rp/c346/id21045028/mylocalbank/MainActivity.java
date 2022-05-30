package sg.edu.rp.c346.id21045028.mylocalbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView DBS;
    TextView OCBC;
    TextView UOB;

    String wordClicked = "";

    boolean isCheckedDBS = false;
    boolean isCheckedOCBC = false;
    boolean isCheckedUOB = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.textView);
        OCBC = findViewById(R.id.textView2);
        UOB = findViewById(R.id.textView3);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);


        if (v == DBS) {
            wordClicked = "DBS";
        } else if (v == OCBC) {
            wordClicked = "OCBC";
        } else if (v == UOB) {
            wordClicked = "UOB";
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (id == R.id.websiteSelection) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.bank1URL)));
                startActivity(intent);
                return true;
            } else if (id == R.id.contactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.bank1NO)));
                startActivity(intentCall);
                return true;
            }else if (id == R.id.FavSelection) {
                if(isCheckedDBS == true){
                    DBS.setTextColor(Color.BLACK);
                    isCheckedDBS = false;
                }else{
                    DBS.setTextColor(Color.RED);
                    isCheckedDBS = true;
                }

                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (id == R.id.websiteSelection) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.bank2URL)));
                startActivity(intent);
                return true;
            } else if (id == R.id.contactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.bank2NO)));
                startActivity(intentCall);
                return true;
            }else if (id == R.id.FavSelection) {
                if(isCheckedOCBC){
                    OCBC.setTextColor(Color.BLACK);
                    isCheckedOCBC = false;
                }else{
                    OCBC.setTextColor(Color.RED);
                    isCheckedOCBC = true;
                }

                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (id == R.id.websiteSelection) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.bank3URL)));
                startActivity(intent);
                return true;
            } else if (id == R.id.contactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.bank3NO)));
                startActivity(intentCall);
                return true;
            }else if (id == R.id.FavSelection) {
                if(isCheckedUOB){
                    UOB.setTextColor(Color.BLACK);
                    isCheckedUOB = false;
                }else{
                    UOB.setTextColor(Color.RED);
                    isCheckedUOB = true;
                }

                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText(getString(R.string.Bank1));
            OCBC.setText(getString(R.string.Bank2));
            UOB.setText(getString(R.string.Bank3));
            return true;
        } else if (id == R.id.ChineseSelection) {
            DBS.setText(getString(R.string.bank1chinese));
            OCBC.setText(getString(R.string.bank2chinese));
            UOB.setText(getString(R.string.bank3chinese));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}




