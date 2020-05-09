package com.geekbrains.broadcastrecievertraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Экшн
    public static final String MURA_SAW_JHENULA_ACTION = "ru.geekbrains.anasdro.action.SAW_JHANE";
    //Строка сообщения
    public static final String SAW_MESSAGE = "Мур увидел Женю!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button sendMsgBtn = findViewById(R.id.sendMsgBtn);

        sendMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MURA_SAW_JHENULA_ACTION);
                //Или так
                //Intent intent = new Intent();
                //intent.setAction(MURA_SAW_JHENULA);
                intent.putExtra("ru.geekbrains.anasdro.broadcast.message", SAW_MESSAGE);
                //Для старых устройств этого было вполне достаточно, но начиная с Android 3.0,
                // в целях безопасности сообщения будут игнорироваться остановленными приложениями,
                // чтобы они не запускались. Поэтому следует добавлять дополнительный флаг, разрешающий запуск активности.
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);
            }
        });


    }


}
