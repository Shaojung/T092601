package tw.com.pcschool.t092601;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        wv = (WebView) findViewById(R.id.webView);
        Intent it = getIntent();
        String link = it.getStringExtra("link");
        wv.setWebChromeClient(new WebChromeClient());
        wv.loadUrl(link);

    }
}
