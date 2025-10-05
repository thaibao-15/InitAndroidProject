package com.example.initproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        processSms(context,intent);
    }

    private void processSms(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String message = "";
        String address = "";
        String body ="";
        if(bundle != null){
            Object[] mysms = (Object[]) bundle.get("pdus");
            // có nhiều tin nhắn từ object nên cần duyệt tất cả tin nhắn
            for (int i= 0; i< mysms.length; i++){
                SmsMessage sms;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    String format = bundle.getString("format");
                    sms = SmsMessage.createFromPdu((byte[]) mysms[i], format);
                } else {
                    sms = SmsMessage.createFromPdu((byte[]) mysms[i]);
                }
                body += sms.getMessageBody();
                address = sms.getOriginatingAddress();
            }
            message ="có 1 tin nhan từ" + address +"\n"
                    + "nội dung: "+ body +"vừa mới gửi";
            Toast.makeText(context,message, Toast.LENGTH_LONG).show();
        }
    }
}