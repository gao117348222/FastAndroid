package com.gx303.fastandroid.image;

/**
 * https://github.com/square/picasso
 * compile 'com.squareup.picasso:picasso:2.5.2'
 */
public class Picasso {
    /*
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);

        Features

        ADAPTER DOWNLOADS

        Adapter re-use is automatically detected and the previous download canceled.

        @Override public void getView(int position, View convertView, ViewGroup parent) {
          SquaredImageView view = (SquaredImageView) convertView;
          if (view == null) {
            view = new SquaredImageView(context);
          }
          String url = getItem(position);

          Picasso.with(context).load(url).into(view);
        }
        IMAGE TRANSFORMATIONS

        Transform images to better fit into layouts and to reduce memory size.

        Picasso.with(context)
          .load(url)
          .resize(50, 50)
          .centerCrop()
          .into(imageView)
        You can also specify custom transformations for more advanced effects.

        public class CropSquareTransformation implements Transformation {
          @Override public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            Bitmap result = Bitmap.createBitmap(source, x, y, size, size);
            if (result != source) {
              source.recycle();
            }
            return result;
          }

          @Override public String key() { return "square()"; }
        }
        Pass an instance of this class to the transform method.

        PLACE HOLDERS

        Picasso supports both download and error placeholders as optional features.

        Picasso.with(context)
            .load(url)
            .placeholder(R.drawable.user_placeholder)
            .error(R.drawable.user_placeholder_error)
            .into(imageView);
        A request will be retried three times before the error placeholder is shown.

        RESOURCE LOADING

        Resources, assets, files, content providers are all supported as image sources.

        Picasso.with(context).load(R.drawable.landing_screen).into(imageView1);
        Picasso.with(context).load("file:///android_asset/DvpvklR.png").into(imageView2);
        Picasso.with(context).load(new File(...)).into(imageView3);



     */
}
