package com.example.auliaheryanov.auliaheryanov_1202150063_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CariGambar extends AppCompatActivity {

    private EditText mInputLink;
    private Button mButtonCari;
    private ImageView mTampilGambar;
    private ProgressDialog mProgressDialog;


//   sebelum itu masukkan <uses-permission android:name="android.permission.INTERNET"/> kedalam manifest

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_cari_gambar);

        mInputLink = findViewById(R.id.inputLink);
        mButtonCari = findViewById(R.id.buttonCari);
        mTampilGambar = findViewById(R.id.tampilGambar);
    }

    public void klikCari(View view) {
        loadImageInit();
    }

    private void loadImageInit(){
        String ImgUrl = mInputLink.getText().toString();
        //AsyncTask mencari gambar di internet
        new loadImage().execute(ImgUrl);
    }

    private class loadImage extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Membuat Progress Dialog
            mProgressDialog = new ProgressDialog(CariGambar.this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            //ngoper string ke onPost
            return params[0];
        }

        @Override
        protected void onPostExecute(String ImgUrl) {
            super.onPostExecute(ImgUrl);
            //memakai library picasso untuk mengambil gambar dari internet dan ditaro di layout
            Picasso.get().load(ImgUrl).into(mTampilGambar);

            // menghilangkan Progress Dialog
            mProgressDialog.dismiss();
        }
    }
}
