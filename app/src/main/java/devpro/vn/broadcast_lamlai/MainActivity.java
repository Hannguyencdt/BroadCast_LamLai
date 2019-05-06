package devpro.vn.broadcast_lamlai;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvStatur;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            tvStatur.setText(" Đang sạc pin");
        }
            // nếu sự kiện nhận đưọc là rút sạc
            if (intent.getAction().endsWith(Intent.ACTION_POWER_DISCONNECTED)) {
                tvStatur.setText(" Đã rút sạc");
            }
            if (intent.getAction().equals(String.valueOf(Constans.KEY_NETWORK_STATUS))) {
                Toast.makeText(context, "Có kết nối mạng", Toast.LENGTH_SHORT).show();
            }
        }
    };
    IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatur = findViewById(R.id.tvStatur);
        filter = new IntentFilter();
        filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");

    }
        @Override
        public void onDestroy () {
            // hủy đăng ký
            super.onDestroy();

        }

        @Override
        public void onResume () {
            registerReceiver(receiver, filter);
            // hủy đăng ký
            super.onResume();

        }
}
