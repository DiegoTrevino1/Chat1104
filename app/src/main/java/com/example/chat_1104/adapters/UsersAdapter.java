package com.example.chat_1104.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat_1104.databinding.ItemContainerUserBinding;
import com.example.chat_1104.listeners.UserListener;
import com.example.chat_1104.models.User;

import java.util.List;

// Handle the user part and users information using a UserAdapter class
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder>{

    //
    private final List<User> users;

    //
    private final UserListener userListener;

    //
    public UsersAdapter(List<User> users, UserListener userListener) {
        this.users = users;
        this.userListener = userListener;
    }

    // Generate method
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemContainerUserBinding itemContainerUserBinding = ItemContainerUserBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent,false);

        return new UserViewHolder(itemContainerUserBinding);
    }

    // Generate method to get user position
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUserData(users.get(position));

    }

    // Generate method to return the size of the user list
    @Override
    public int getItemCount() {
        return users.size();
    }


    // implement a UserViewHolder to help contain information
    class UserViewHolder extends RecyclerView.ViewHolder{
        ItemContainerUserBinding binding;


        // create UserViewHolder to use all components defined in ItemContainerUser
        public UserViewHolder(ItemContainerUserBinding itemContainerUserBinding) {
            super(itemContainerUserBinding.getRoot());
            binding = itemContainerUserBinding;
        }

        // decode the stream value to the regular image
        void setUserData(User user){
            binding.textName.setText(user.name);
            binding.textName.setText(user.email);
            binding.imageProfile.setImageBitmap(getUserImage(user.image));

            //jump to main activity
            binding.getRoot().setOnClickListener(v -> userListener.onUserClicked(user));
        }
    }
    private Bitmap getUserImage(String encodedImage){
        byte [] bytes = Base64.decode(encodedImage,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

    }

}
