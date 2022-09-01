package com.example.napo01;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PfListAdapter extends BaseAdapter {
    private ArrayList<PfListVO> pfItems = new ArrayList<PfListVO>();
    String dirpath;
    View itemView;
    Context context;
    int width;
    int height;

    public PfListAdapter(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public int getCount() {
        return pfItems.size();
    }

    @Override
    public Object getItem(int i) {
        return pfItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        context = viewGroup.getContext();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.pofollist_in_lv, viewGroup, false);
            itemView = view;
        }

        PfListVO vo = pfItems.get(i);
        ImageView pf_img = view.findViewById(R.id.pf_img);
        TextView coDate = view.findViewById(R.id.tv_coDate);
        EditText pfTitle = view.findViewById(R.id.edt_pfTitle);
        TextView pdf = view.findViewById(R.id.pdf);

        pf_img.setImageDrawable(vo.getPf_img());
        coDate.setText(vo.getDate());
        pfTitle.setText(vo.getTitle());

        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("testtttt", "클릭감지");
                Toast.makeText(context,"PDF 파일 생성!",Toast.LENGTH_SHORT).show();
                try {
                    layoutToImage(itemView);
                    imageToPDF();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

        return view;
    }

    public void addItems(Drawable img, String date, String title) {
        PfListVO vo = new PfListVO(img, date, title);
        pfItems.add(vo);
    }

    public void layoutToImage (View view) {

        //기기 화면 크기 구하기
        Log.d("크기", width+"/ "+height);


        // get view group using reference
        LinearLayout linearLayout = view.findViewById(R.id.itemLayout);

        itemView.measure(
                View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY));

        Bitmap bbmm = Bitmap.createBitmap(itemView.getMeasuredWidth(), itemView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvasBitmap = new Canvas(bbmm);
        itemView.draw(canvasBitmap);

        // convert view group to bitmap
        linearLayout.setDrawingCacheEnabled(true);
        linearLayout.buildDrawingCache();
        Bitmap bm = linearLayout.getDrawingCache();
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        PdfDocument doc = new PdfDocument();
        Paint paint = new Paint();

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(width,height,2).create();
        PdfDocument.Page page = doc.startPage(pageInfo);

        Canvas canvas = page.getCanvas();
        canvas.drawBitmap(bbmm, 30, 50 ,paint);
        doc.finishPage(page);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ File.separator + "myPDF.pdf");

        Log.v("파일저장경로", file.getAbsolutePath());

        try{
            doc.writeTo(new FileOutputStream(file));
            doc.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void imageToPDF() throws FileNotFoundException {
        try {
            Document document = new Document();
            dirpath = android.os.Environment.getExternalStorageDirectory().toString();
            PdfWriter.getInstance(document, new FileOutputStream(dirpath + "/NewPDF.pdf")); //  Change pdf's name.
            document.open();
            Image img = Image.getInstance(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - 0) / img.getWidth()) * 100;
            img.scalePercent(scaler);
            img.setAlignment(Image.ALIGN_CENTER | Image.ALIGN_TOP);
            document.add(img);
            document.close();

        } catch (Exception e) {

        }
    };
}




