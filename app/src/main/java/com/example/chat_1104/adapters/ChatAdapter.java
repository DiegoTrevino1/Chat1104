//import package
package com.example.chat_1104.adapters;

//import statements
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat_1104.databinding.ItemContainerReceivedMessageBinding;
import com.example.chat_1104.databinding.ItemContainerSentMessageBinding;
import com.example.chat_1104.models.ChatMessage;

import java.util.List;

import kotlinx.coroutines.channels.ReceiveChannel;

// Main class named ChatAdapter to handle the message (sending and receiver)
// Extend RecyclerView to generate all information
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    // Initialize receiverProfileImage, chatMessages, sendId, and counters
    private Bitmap receiverProfileImage;
    private final List<ChatMessage> chatMessages;
    private final String sendId;
    public static final int VIEW_TYPE_SENT = 1;
    public static final int VIEW_TYPE_RECEIVED = 2;


    //create constructors for variables
    public ChatAdapter(List<ChatMessage> chatMessage, Bitmap receiverProfileImage, String sendId) {
        this.chatMessages = chatMessage;
        this.receiverProfileImage = receiverProfileImage;
        this.sendId = sendId;
    }

    // Set the position
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SENT){
            return new SentMessageViewHolder(ItemContainerSentMessageBinding.inflate(LayoutInflater.from
                    (parent.getContext()),parent, false ));

        } else {
            return new ReceiverMessageViewHolder(ItemContainerReceivedMessageBinding
                    .inflate(LayoutInflater.from
                    (parent.getContext()),parent,false));
        }
    }

    // Continue setting the position
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_SENT){
            ((SentMessageViewHolder)holder).setData(chatMessages.get(position));

        } else {
            ((ReceiverMessageViewHolder)holder).setData(chatMessages.get(position),receiverProfileImage);
        }

    }

    // Return message size
    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    // function that gets ItemView
    @Override
    public int getItemViewType(int position){
        if (chatMessages.get(position).senderId.equals(sendId)) {
            return VIEW_TYPE_SENT;
        } else {
            return VIEW_TYPE_RECEIVED;
        }
    }

    // Display our chat message in our screen
    static class SentMessageViewHolder extends RecyclerView.ViewHolder{

        // Initialize binding
        private final ItemContainerSentMessageBinding binding;

        // Hold message data
        public SentMessageViewHolder(ItemContainerSentMessageBinding itemContainerSentMessageBinding) {
            super(itemContainerSentMessageBinding.getRoot());
            binding = itemContainerSentMessageBinding;

        }
        // Set the data
        void setData(ChatMessage chatMessage){
            binding.textMessage.setText(chatMessage.message);
            binding.textDataTime.setText(chatMessage.dateTime);
        }
    }

    /**
     * Create class ReceiverMessageViewHolder that gets information from recyclerView holder
     */
    static class ReceiverMessageViewHolder extends RecyclerView.ViewHolder{
        private final ItemContainerReceivedMessageBinding binding;

        public ReceiverMessageViewHolder(ItemContainerReceivedMessageBinding
                                                 itemContainerReceivedMessageBinding){
            super(itemContainerReceivedMessageBinding.getRoot());
            binding = itemContainerReceivedMessageBinding;
        }

        void setData(ChatMessage chatMessage, Bitmap receiverProfileImage){
            binding.textMessage.setText(chatMessage.message);
            binding.textDataTime.setText(chatMessage.dateTime);

//            if (receiverProfileImage = null){}
            binding.imageProfile.setImageBitmap(receiverProfileImage);
        }
    }

}
