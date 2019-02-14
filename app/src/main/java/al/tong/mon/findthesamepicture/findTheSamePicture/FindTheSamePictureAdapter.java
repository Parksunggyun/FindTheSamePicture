package al.tong.mon.findthesamepicture.findTheSamePicture;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Vector;

import al.tong.mon.findthesamepicture.R;
import al.tong.mon.findthesamepicture.databinding.ItemPictureBinding;


public class FindTheSamePictureAdapter extends RecyclerView.Adapter<FindTheSamePictureAdapter.ViewHolder> {

    Vector<Picture> pictures = new Vector<>();

    private Activity activity;
    private Context context;

    private int width = 0, height = 0;

    private boolean startAnimate = false;

    FindTheSamePictureAdapter(Activity activity) {
        this.activity = activity;
        this.context = activity.getApplicationContext();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPictureBinding binding = ItemPictureBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemPictureBinding binding = holder.binding;

        if (height != 0 && width != 0) {
            binding.pictureLayout.getLayoutParams().width = width;
            binding.pictureLayout.getLayoutParams().height = height;
        }

        Picture picture = pictures.get(position);
        String display = picture.getDisplay();
        int check = picture.getCheck();
        binding.pictureTxtView.setText(display);
        Log.e("check[" + position + "] = ", String.valueOf(check));
        if(check == 0 && startAnimate) {
            binding.pictureTxtView.animate()
                    .rotationY(90)
                    .setDuration(200)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            binding.pictureTxtView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
                            binding.pictureTxtView.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
                            binding.pictureTxtView.animate()
                                    .rotationYBy(90)
                                    .rotationY(180)
                                    .setDuration(200)
                                    .setListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            picture.setCheck(1);
                                        }
                                    })
                                    .start();
                        }
                    })
                    .start();
        } else if (check == 2) {
            binding.pictureTxtView.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
            binding.pictureTxtView.setBackgroundColor(Color.BLACK);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    void setUpPicture(Vector<Picture> pictures) {
        this.pictures = pictures;
        notifyDataSetChanged();
    }

    void setLength(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void setStartAnimate(boolean startAnimate) {
        this.startAnimate = startAnimate;
        notifyDataSetChanged();
    }

    void update(int pos, int check) {
        pictures.get(pos).setCheck(check);
        notifyItemChanged(pos);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemPictureBinding binding;

        ViewHolder(ItemPictureBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}

