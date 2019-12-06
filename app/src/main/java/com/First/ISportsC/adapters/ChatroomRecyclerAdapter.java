package com.First.ISportsC.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.First.ISportsC.R;
import com.First.ISportsC.models.Game;

import java.util.ArrayList;

public class ChatroomRecyclerAdapter extends RecyclerView.Adapter<ChatroomRecyclerAdapter.ViewHolder>{

    private ArrayList<Game> mGames = new ArrayList<>();
    private ChatroomRecyclerClickListener mChatroomRecyclerClickListener;

    public ChatroomRecyclerAdapter(ArrayList<Game> games, ChatroomRecyclerClickListener chatroomRecyclerClickListener) {
        this.mGames = games;
        mChatroomRecyclerClickListener = chatroomRecyclerClickListener;
    }

//    private Set<Game> mGames = new HashSet<>();
//    private ChatroomRecyclerClickListener mChatroomRecyclerClickListener;
//
//    public ChatroomRecyclerAdapter(Set<Game> chatrooms, ChatroomRecyclerClickListener chatroomRecyclerClickListener) {
//        this.mGames = chatrooms;
//        mChatroomRecyclerClickListener = chatroomRecyclerClickListener;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_chatroom_list_item, parent, false);
        final ViewHolder holder = new ViewHolder(view, mChatroomRecyclerClickListener);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        ((ViewHolder)holder).chatroomTitle.setText(((Game)(mGames.toArray()[position])).getTitle());
        ((ViewHolder)holder).chatroomTitle.setText(mGames.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mGames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener
    {
        TextView chatroomTitle;
        ChatroomRecyclerClickListener clickListener;

        public ViewHolder(View itemView, ChatroomRecyclerClickListener clickListener) {
            super(itemView);
            chatroomTitle = itemView.findViewById(R.id.active_game);
            this.clickListener = clickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onChatroomSelected(getAdapterPosition());
        }
    }

    public interface ChatroomRecyclerClickListener {
        public void onChatroomSelected(int position);
    }
}
















