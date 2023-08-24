package com.example.event.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.event.models.Event;
import java.util.List;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.event.R;
import com.squareup.picasso.Picasso;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private Context context;
    private List<Event> events;

    public EventAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = events.get(position);

        holder.eventTitle.setText(event.getTitle());
        holder.eventName.setText(event.getName());
        holder.eventDate.setText(event.getDate());
        holder.eventLocation.setText(event.getLocation());

        Picasso.get()
                .load(event.getImageUrl()) // Use the URL of the image
                .placeholder(R.drawable.ic_launcher_foreground) // Placeholder image
                .error(R.drawable.ic_launcher_foreground) // Error image if loading fails
                .into(holder.eventImage);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView eventImage;
        TextView eventTitle;
        TextView eventName;
        TextView eventDate;
        TextView eventLocation;

        EventViewHolder(View itemView) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.eventImage);
            eventTitle = itemView.findViewById(R.id.eventTitle);
            eventName = itemView.findViewById(R.id.eventTitle);
            eventDate = itemView.findViewById(R.id.eventTime);
            eventLocation = itemView.findViewById(R.id.eventLocation);
        }
    }
}

