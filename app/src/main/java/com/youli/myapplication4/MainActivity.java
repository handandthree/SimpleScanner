package com.youli.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    Context context = this;
    QRCodeScanner scanner = new QRCodeScanner(context);

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
//        Context context = this ;
//        QRCodeScanner scanner = new QRCodeScanner(context);
//        startActivity(new Intent(MainActivity.this,MainActivity2.class));
        scanner.startScan(this);

    }

    /**
     * 扫码方法

     private void scan() {
     IntentIntegrator integrator = new IntentIntegrator(this);
     // 设置要扫描的条码类型，ONE_D_CODE_TYPES：一维码，QR_CODE_TYPES-二维码
     integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
     //  integrator.setCaptureActivity(CaptureAct.class);
     integrator.setPrompt("扫描条码");
     integrator.setOrientationLocked(false);
     integrator.setCameraId(0);  // 使用默认的相机
     integrator.setBeepEnabled(false); // 扫到码后播放提示音
     integrator.setBarcodeImageEnabled(true);
     integrator.initiateScan();

     }
     */
    /**
     * 扫码结果事件
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        scanner.handleScanResult(requestCode, resultCode, data);
    }
}