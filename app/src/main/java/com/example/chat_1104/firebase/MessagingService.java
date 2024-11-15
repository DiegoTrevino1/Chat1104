
//import package
package com.example.chat_1104.firebase;


//import statements
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

//MessagingService method
public class MessagingService extends FirebaseMessagingService {

    //method for onNewToken to show message if function is successful
    @Override
    public void onNewToken(@NonNull String token){
        super.onNewToken(token);
        Log.d("FCM", "Token: "+token);
    }

    //method for onMessageReceived to show message if function is successful
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        Log.d("FCM", "460 Message: "+message.getNotification().getBody());

    }
}
