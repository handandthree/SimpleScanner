import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.youli.myapplication4.R;

public class CustomCaptureActivity extends AppCompatActivity {

    private CaptureManager captureManager;
    private DecoratedBarcodeView barcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_capture);

        barcodeView = findViewById(R.id.viewfinder_view);
        captureManager = new CaptureManager(this, barcodeView);
        captureManager.initializeFromIntent(getIntent(), savedInstanceState);
        captureManager.decode();
    }

    @Override
    protected void onResume() {
        super.onResume();
        captureManager.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        captureManager.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        captureManager.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        captureManager.onSaveInstanceState(outState);
    }
}
