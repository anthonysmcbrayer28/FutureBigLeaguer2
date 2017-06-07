package com.jrsdevelopers.futurebigleaguer;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CardActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE1 = "playerName";
    public static final String EXTRA_MESSAGE2 = "teamPosition";
    public static final Double ExTRA = Double.parseDouble("0.000");
    public static final int SELECT_PICTURE = 20;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_activity);
        Bundle bundle = getIntent().getExtras();
        Bundle b = getIntent().getExtras();
        String message = bundle.getString(EXTRA_MESSAGE1);
        String message2 = bundle.getString(EXTRA_MESSAGE2);
        double message3 = b.getDouble(String.valueOf(ExTRA));
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(String.format("%.3f", message3));
        textView.setText(message);
        textView2.setText(message2);


    }

    public void addpicture(View view) {
       
        Button photoButton = (Button) this.findViewById(R.id.pictureButton);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setDataAndType(Uri.parse("file://" + "/sdcard/Cam App"), "image/*");
                startActivityForResult(Intent.createChooser(intent, "Select image to share:"), SELECT_PICTURE);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (resultCode == RESULT_OK) {
            // if we are here, everything processed successfully.
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                //OI FILE Manager
                String filemanagerstring = selectedImageUri.getPath();

                //MEDIA GALLERY
                String selectedImagePath = getPath(selectedImageUri);

                //NOW WE HAVE OUR WANTED STRING
                if (selectedImagePath != null)
                    System.out.println("selectedImagePath is the right one for you!");
                else
                    System.out.println("filemanagerstring is the right one for you!");
                TextView textView = (TextView) findViewById(R.id.textView);
                TextView textView2 = (TextView) findViewById(R.id.textView2);
                TextView avrage = (TextView) findViewById(R.id.average);
                TextView textView3 = (TextView) findViewById(R.id.textView3);
                String one = textView.getText().toString();
                String two = textView2.getText().toString();
                String three = avrage.getText().toString();
                String four = textView3.getText().toString();
                String card = makeCard(one, two, three, four);


                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);


                shareIntent.putExtra(Intent.EXTRA_TEXT, card);


                shareIntent.putExtra(Intent.EXTRA_STREAM, selectedImageUri);
                shareIntent.setType("image/*");
                startActivity(Intent.createChooser(shareIntent, "Share image via:"));
            }
        }
    }

    @SuppressWarnings("deprecation")
    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if (cursor != null) {
            //HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            //THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else return null;
    }

    private String makeCard(String one, String two, String three, String four) {
        String card = one + "\n" + two + "\n" + three + four;
        return card;


    }
}
