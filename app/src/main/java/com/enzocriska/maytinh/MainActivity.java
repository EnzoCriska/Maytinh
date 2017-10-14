package com.enzocriska.maytinh;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends Activity implements View.OnClickListener{
    Float ts1, ts2;
    String toantu, xuatmanhinh="";
    EditText edtGT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtGT = (EditText) findViewById(R.id.ketQua);

        int[] idBtn = {R.id.s0, R.id.s1, R.id.s2, R.id.s3, R.id.s4, R.id.s5, R.id.s6, R.id.s7, R.id.s8,
                    R.id.s9, R.id.cham, R.id.chia, R.id.tru, R.id.cong, R.id.nhan, R.id.del, R.id.bang};
        for (int id:idBtn){
            View v =(View) findViewById(id);
            v.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cong:
                toantu = "+";
                ts1 = Float.parseFloat(edtGT.getText().toString());
                xuatmanhinh ="0";
                edtGT.setText("0");
                break;
            case R.id.tru:
                toantu = "-";
                ts1 = Float.parseFloat(edtGT.getText().toString());
                xuatmanhinh ="";
                edtGT.setText("0");
                break;

            case R.id.nhan:
                toantu = "*";
                ts1 = Float.parseFloat(edtGT.getText().toString());
                xuatmanhinh ="0";
                edtGT.setText("0");
                break;

            case R.id.chia:
                toantu = "/";
                ts1 = Float.parseFloat(edtGT.getText().toString());
                xuatmanhinh ="0";
                edtGT.setText("0");
                break;

            case R.id.bang:
                Float kq = null;
                ts2 = Float.parseFloat(edtGT.getText().toString());
                if (Objects.equals(toantu, "+")){
                    kq = ts1 + ts2;
                }

                if (toantu == "-"){
                    kq = ts1 - ts2;
                }

                if (toantu == "*"){
                    kq = ts1 * ts2;
                }

                if (toantu == "/"){
                    kq = ts1 / ts2;
                }

                edtGT.setText(String.valueOf(kq));
                ts1 = 0.0f;
                ts2 = 0.0f;
                xuatmanhinh = "0";
                break;
            case R.id.del:
                xuatmanhinh = xuatmanhinh.substring(0,xuatmanhinh.length());
                edtGT.setText(xuatmanhinh);
                Log.e("Man hinh hien",xuatmanhinh);
                break;

            default:
                if (xuatmanhinh.equals("0")) {xuatmanhinh = "";}

                xuatmanhinh += ((Button)v).getText().toString();
                edtGT.setText(xuatmanhinh);
                Log.e("Man hinh hien",xuatmanhinh);
        }
    }
}
