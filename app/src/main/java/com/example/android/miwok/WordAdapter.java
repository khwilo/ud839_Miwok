package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    MediaPlayer mMediaPlayer;

    // The context is used to inflate the layout file while the
    // list is the data we want to display.
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        // In this adapter the second argument is not used because a
        // separate file is defined for a custom view to be displayed instead of the default
        // one (...one TextView).
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    // The position - the position in the list of data to be displayed.
    // The convertView - the recycled view to populate.
    // The parent - the parent ViewGroup that is used for inflation.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item located at this position
        final Word currentWord = getItem(position);

        // Check if existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Find the TextViews in the list_item.xml layout
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english_default_text_view);

        // Get the different word translations from the Word object and
        // populate them onto the TextViews.
        miwokTextView.setText(currentWord.getMiwokTranslation());

        miwokTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer = MediaPlayer.create(getContext(), currentWord.getAudioResourceId());
                mMediaPlayer.start();
            }
        });

        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout file and
        // populate it with an image asset.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.word_image_view);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResource());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        // Find the view for the list item containing the texts
        View textViewContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container view
        textViewContainer.setBackgroundColor(color);

        // Return the list item layout to be shown on the ListView.
        return listItemView;
    }
}
