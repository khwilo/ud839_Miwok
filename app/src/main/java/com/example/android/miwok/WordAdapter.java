package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    // The context is used to inflate the layout file while the
    // list is the data we want to display.
    public WordAdapter(Context context, ArrayList<Word> words) {
        // In this adapter the second argument is not used because a
        // separate file is defined for a custom view to be displayed instead of the default
        // one (...one TextView).
        super(context, 0, words);
    }

    // The position - the position in the list of data to be displayed.
    // The convertView - the recycled view to populate.
    // The parent - the parent ViewGroup that is used for inflation.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item located at this position
        Word word = getItem(position);

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
        miwokTextView.setText(word.getMiwokTranslation());
        defaultTextView.setText(word.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout file and
        // populate it with an image asset.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.word_image_view);
        imageView.setImageResource(word.getImageResource());

        // Return the list item layout to be shown on the ListView.
        return listItemView;
    }
}
