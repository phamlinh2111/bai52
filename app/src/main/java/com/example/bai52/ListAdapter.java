package com.example.bai52;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Fruit> {

    static class FruitViewHolder {
        ImageView fruitImg;
        TextView fruitName;
        TextView calories;
    }

    public ListAdapter(Context context, List<Fruit> fruitList) {
        super(context, 0, fruitList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        FruitViewHolder viewHolder;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.listview, parent, false);

            viewHolder = new FruitViewHolder();
            viewHolder.fruitImg = row.findViewById(R.id.fruitImg);
            viewHolder.fruitName = row.findViewById(R.id.fruitName);
            viewHolder.calories = row.findViewById(R.id.calories);

            row.setTag(viewHolder);
        } else {
            viewHolder = (FruitViewHolder) row.getTag();
        }

        Fruit fruit = getItem(position);

        Bitmap originalBitmap = BitmapFactory.decodeResource(getContext().getResources(), fruit.getFruitImg());
        Bitmap resizedBitmap = resizeBitmap(originalBitmap, 70, 70);

        viewHolder.fruitImg.setImageBitmap(resizedBitmap);
        viewHolder.fruitName.setText(fruit.getFruitName());
        viewHolder.calories.setText(fruit.getCalories());

        return row;
    }

    private Bitmap resizeBitmap(Bitmap originalBitmap, int width, int height) {
        return Bitmap.createScaledBitmap(originalBitmap, width, height, true);
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
