package student_database.nayan.com.studentdatabase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Button take_photo, save_data, search_data, view_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv= (ImageView) findViewById(R.id.my_image);
        take_photo= (Button) findViewById(R.id.take_photo);

        take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(myIntent, 99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 99 && requestCode == RESULT_OK && data != null){
            Bitmap myBitmap= (Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(myBitmap);
        }
    }
}
