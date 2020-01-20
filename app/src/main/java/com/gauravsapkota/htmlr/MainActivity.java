package com.gauravsapkota.htmlr;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public EditText mainText;
    public TextView numberLine;
    public ScrollView scrollView_numberLine;
    public ScrollView scrollView_mainText;
    String file_name_to_save;
    int PICK = 1;
    int space;
    String opfile;
    InterstitialAd oncompilead;
    InterstitialAd onfeedbackad;
    InterstitialAd ontutorials;
    File fe;
    private String uri ="";
    private Uri uri2;
    boolean wrappison =true;
    public Button button;
    public  EditText editText;
public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    public Button button10;
    public Button button11;
    public Button button12;
    public Button button13;
    public Button button14;
    public Button button15;
    public Button button16;
    public Button button17;
    public Button button18;
    public Button button19;
    public Button button20;
    public Button button21;

    public Button button22;


    boolean blacktheme = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Editor");
        verifyStoragePermissions(this);
        ////initializing class
        mainText = (EditText) findViewById(R.id.editText);//initializing main text edit
        numberLine = (TextView) findViewById(R.id.textView);//initializing number line
        ////buttons initializing
  editText = (EditText)findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10=(Button)findViewById(R.id.button10);
        button11=(Button)findViewById(R.id.button11);
        button12=(Button)findViewById(R.id.button12);
        button13=(Button)findViewById(R.id.button13);
        button14=(Button)findViewById(R.id.button14);
        button15=(Button)findViewById(R.id.button15);
        button16=(Button)findViewById(R.id.button16);
        button17=(Button)findViewById(R.id.button17);
        button18=(Button)findViewById(R.id.button18);
        button19=(Button)findViewById(R.id.button19);
        button20=(Button)findViewById(R.id.button20);
        button21 = (Button)findViewById(R.id.buttonheading1);
        button22=(Button)findViewById(R.id.buttonparagraph);
        MobileAds.initialize(this,"ca-app-pub-8611438191981746~1201974687");

        ///finished button initializing
        oncompilead = new InterstitialAd(this);
        oncompilead.setAdUnitId("ca-app-pub-8611438191981746/6299346559");
        oncompilead.loadAd(new AdRequest.Builder().build());
        onfeedbackad=new InterstitialAd(this);
        onfeedbackad.setAdUnitId("ca-app-pub-8611438191981746/3674302778");
        onfeedbackad.loadAd(new AdRequest.Builder().build());
        ontutorials = new InterstitialAd(this);
        ontutorials.setAdUnitId("ca-app-pub-8611438191981746/7721073588");
        ontutorials.loadAd(new AdRequest.Builder().build());
        ////other buttons things
        editText.setHint("<></>");
mainText.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        if(!editText.getText().toString().isEmpty()){
            String toadd = editText.getText().toString();
            int Selection = mainText.getSelectionEnd();
            String first = mainText.getText().toString().substring(0,Selection);
            String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
            mainText.setText(first+"<"+toadd+"></"+toadd+">"+second);
            mainText.setSelection(Selection+toadd.length()+2);
mainText.setSelected(true);
editText.setSelected(false);
            editText.setText("");
            coloring();

        }else{

        }

        return false;
    }
});

SharedPreferences preferences = getSharedPreferences("prefs",MODE_PRIVATE);
boolean firstStart = preferences.getBoolean("firstStart",true);
if(firstStart){
    onfirstdialog();
}


        button9.setText("<>");
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+button9.getText()+second);
                mainText.setSelection(Selection+1);
                coloring();

            }

        });
        button8.setText("</>");
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+button8.getText()+second);
                mainText.setSelection(Selection+2);
                coloring();

            }

        });
        button7.setText("Class");
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+button7.getText().toString().toLowerCase()+"=\"\""+second);
                mainText.setSelection(Selection+7);
                coloring();
            }

        });
        button6.setText("img");
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<img src=\"\"></img>"+second);
                mainText.setSelection(Selection+10);
                coloring();
            }

        });
        button5.setText("a");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<a href=\"\"></a>"+second);
                mainText.setSelection(Selection+9);
                coloring();
            }

        });
        button4.setText("Script");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<script></script>"+second);
                mainText.setSelection(Selection+8);
                coloring();
            }

        });
        button3.setText("B");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<b></b>"+second);
                mainText.setSelection(Selection+3);
                coloring();
            }

        });
        button2.setText("U");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<u></u>"+second);
                mainText.setSelection(Selection+3);
                coloring();
            }

        });
        button.setText("I");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<i></i>"+second);
                mainText.setSelection(Selection+3);
                coloring();
            }

        });
        button10.setText("<br>");
        button10.setAllCaps(false);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<br>"+second);
                mainText.setSelection(Selection+4);
                coloring();
            }

        });
        button11.setText("<hr>");
        button11.setAllCaps(false);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<hr>"+second);
                mainText.setSelection(Selection+4);
                coloring();
            }

        });
        button12.setText("font");
        button12.setAllCaps(true);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<font ></font>"+second);
                mainText.setSelection(Selection+6);
                coloring();
            }

        });
        button13.setText("=\"\"");
        button13.setAllCaps(false);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"=\"\""+second);
                mainText.setSelection(Selection+2);
                coloring();
            }

        });
        button14.setText("()");
        button14.setAllCaps(false);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"()"+second);
                mainText.setSelection(Selection+1);
                coloring();
            }

        });
        button15.setText("{}");
        button15.setAllCaps(false);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"{}"+second);
                mainText.setSelection(Selection+1);
                coloring();
            }

        });
        button16.setText("marquee");
        button16.setAllCaps(true);
        button16.setTextSize(12);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<marquee></marquee>"+second);
                mainText.setSelection(Selection+9);
                coloring();
            }

        });
        button17.setText("TAB");
        button17.setAllCaps(true);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"    "+second);
                mainText.setSelection(Selection+4);
                coloring();
            }

        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mainText.getText().toString().isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Clear?").setMessage("Are you sure you want to clear all?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mainText.setText("");
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
                    coloring();}
                else {
                    toaster("Already Empty");
                }
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"\"\""+second);
                mainText.setSelection(Selection+1);
                coloring();
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<div></div>"+second);
                mainText.setSelection(Selection+5);
                coloring();
            }
        });
        button21.setText("<h1>");
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<h1></h1>"+second);
                mainText.setSelection(Selection+4);
                coloring();
            }
        });
        button22.setText("<p>");
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Selection = mainText.getSelectionEnd();
                String first = mainText.getText().toString().substring(0,Selection);
                String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                mainText.setText(first+"<p></p>"+second);
                mainText.setSelection(Selection+3);coloring();
            }
        });
        mainText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                coloring();
                return false;
            }
        });

////button settings finished
        scrollView_mainText = (ScrollView) findViewById(R.id.maintextscroll);
        scrollView_numberLine = (ScrollView) findViewById(R.id.numberlinescroll);
        scrollView_numberLine.setVerticalScrollBarEnabled(false);
        scrollView_mainText.setVerticalScrollBarEnabled(false);
        numberLine.setText("1");
        /////////text listner
        mainText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                linetxt(mainText.getLineCount());
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        /////finished text listner
        mainText.setKeepScreenOn(true);
        scrollView_mainText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(!editText.getText().toString().isEmpty()){
                    String toadd = editText.getText().toString();
                    int Selection = mainText.getSelectionEnd();
                    String first = mainText.getText().toString().substring(0,Selection);
                    String second = mainText.getText().toString().substring(Selection,mainText.getText().length());
                    mainText.setText(first+"<"+toadd+"></"+toadd+">"+second);
                    mainText.setSelection(Selection+toadd.length()+2);
                    mainText.setSelected(true);
                    editText.setSelected(false);
                    editText.setText("");
                    coloring();

                }else{

                }

                return false;
            }
        });
        scrollView_mainText.setSmoothScrollingEnabled(true);
        /////scrolling action
        scrollView_mainText.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                scrollView_numberLine.scrollTo(scrollX, scrollY);

            }
        });
        scrollView_numberLine.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                scrollView_mainText.scrollTo(scrollX, scrollY);

            }
        });
        final Intent intent = getIntent();
        final String action = intent.getAction();
        File filelele = new File("storage/emulated/0/HTMLr");
        if(!filelele.exists()){
            filelele.mkdirs();
        }

        if(Intent.ACTION_VIEW.equals(action)){
            //uri = intent.getStringExtra("URI");
            uri2 = intent.getData();
            opfile = uri2.getPath();
            try {
                Scanner sc = new Scanner(new File(opfile));
                String contentxt = sc.nextLine();
                while (sc.hasNext()) {
                    contentxt = contentxt + "\n" + sc.nextLine();
                }
                mainText.setText(contentxt);
                toaster("Opened file:" + opfile);
                setTitle(opfile.substring(opfile.lastIndexOf("/")+1));


            } catch (Exception e) {
                toaster("Opened file:" + opfile+"though the file is empty");
                setTitle(opfile.substring(opfile.lastIndexOf("/")+1));
            }
        } else {

        }
        coloring();
    }
    //toaster
    public void toaster(String totoast) {
        Toast.makeText(this, totoast, Toast.LENGTH_SHORT).show();
    }

    //////lines count method
    public void linetxt(int lines) {


        String linestext = "1";
        for (int i = 2; i <= lines; i++) {

            linestext = linestext + "\n" + i;


        }
        numberLine.setText(linestext);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.load: {
                if(getTitle().equals("Editor")){
                    if(mainText.getText().toString().isEmpty()){
                        mainText.setText(" <!DOCTYPE html>\n<html>\n<head>\n<title>\nThis is the title\n</title>\n</head>\n<body>\n<h1>Heading</h1>\n<p>Main text</p>\n</body>\n</html>");
                        mainText.setSelection(mainText.getText().toString().indexOf("<body>")+6);
                        coloring();

                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Save File").setMessage("Do you want to save file or discard").setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                savefile(false,true,false);


                            }
                        }).setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                mainText.setText(" <!DOCTYPE html>\n<html>\n<head>\n<title>\nThis is the title\n</title>\n</head>\n<body>\n<h1>Heading</h1>\n<p>Main text</p>\n</body>\n</html>");
                                mainText.setSelection(mainText.getText().toString().indexOf("<body>")+6);
                                coloring();
                            }
                        }).show();
                    }
                }else {
                    mainText.setText(" <!DOCTYPE html>\n<html>\n<head>\n<title>\nThis is the title\n</title>\n</head>\n<body>\n<h1>Heading</h1>\n<p>Main text</p>\n</body>\n</html>");
                    mainText.setSelection(mainText.getText().toString().indexOf("<body>")+6);
                    coloring();
                }


            }break;
            case R.id.compile:{
              final   Intent inten = new Intent(this,WebviewA.class);
                if(oncompilead.isLoaded()){
                    oncompilead.show();
                    oncompilead.loadAd(new AdRequest.Builder().build());
                    oncompilead.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            inten.putExtra("title","Compiler");
                            inten.putExtra("khatamajukarafoka",mainText.getText().toString());
                            startActivity(inten);
                        }
                    });
                }else if(!oncompilead.isLoaded()){
                    oncompilead.loadAd(new AdRequest.Builder().build());

                    inten.putExtra("title","Compiler");
                    inten.putExtra("khatamajukarafoka",mainText.getText().toString());
                    startActivity(inten);
                }



                coloring();


            }break;
            case R.id.theme:{
                if(blacktheme){
                    scrollView_numberLine.setBackgroundColor(Color.parseColor("#ffffff"));
                    scrollView_mainText.setBackgroundColor(Color.parseColor("#ffffff"));
                    mainText.setTextColor(Color.parseColor("#291d1d"));
                    numberLine.setTextColor(Color.parseColor("#291d1d"));
                    blacktheme=false;
                }else{
                    scrollView_numberLine.setBackgroundColor(Color.parseColor("#291d1d"));
                    scrollView_mainText.setBackgroundColor(Color.parseColor("#291d1d"));
                    mainText.setTextColor(Color.parseColor("#ffffff"));
                    numberLine.setTextColor(Color.parseColor("#ffffff"));
                    blacktheme=true;
                }
                coloring();
            }break;
            case R.id.tutorials:{
                final Intent intent = new Intent(this,WebviewA.class);
                if(ontutorials.isLoaded()){
                    ontutorials.show();
                    ontutorials.loadAd(new AdRequest.Builder().build());
                    ontutorials.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {
                            intent.putExtra("title","Html Tutorials");
                            intent.putExtra("khatamajukarafoka","<a href=\"https://www.w3schools.com/html/default.asp\"><h1>load tutorials</h1></a");
                            startActivity(intent);
                        }
                    });
                }else {
                    intent.putExtra("title","Html Tutorials");
                    intent.putExtra("khatamajukarafoka","<a href=\"https://www.w3schools.com/html/default.asp\"><h1>load tutorials</h1></a");
                    startActivity(intent);
                    ontutorials.loadAd(new AdRequest.Builder().build());
                }

                coloring();

            }break;
            case R.id.rate:{
                Uri playstore = Uri.parse("https://play.google.com/store/apps/details?id=com.gauravsapkota.htmlr");
                Intent i = new Intent(Intent.ACTION_VIEW,playstore);
                startActivity(i);
                coloring();

            }break;
            case R.id.save:{
                if(getTitle().equals("Editor")) {
                    savefile(false,false,false);

                }else{
                    Savefile2();

                }
                coloring();
            }break;
            case R.id.open:{
                openFile();


            }break;
            case R.id.saveas:{
                savefile(false,false,false);
                coloring();

            }break;
            case R.id.newl:{
                if(getTitle().equals("Editor")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Discard changes?");
                    builder.setMessage("You havent saved the file");
                    builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            savefile(false,false,true);
                        }
                    });
                    builder.setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            setTitle("Editor");
                            mainText.setText("");
                        }
                    });
                    builder.show();
                    coloring();

                }else {
                    Savefile2();
                    setTitle("Editor");
                    mainText.setText("");
                    coloring();

                }
            }break;

            case R.id.wrap:{

                if(wrappison){
                    mainText.setHorizontallyScrolling(true);
                    item.setTitle("Wrap text");
                    wrappison = false;


                }else{
                    mainText.setHorizontallyScrolling(false);
                    wrappison=true;
                    item.setTitle("No WordWrap");

                }
                coloring();

            }break;
            case R.id.feedback:{
                final Intent intent = new Intent(this,FeedBack.class);
                if(onfeedbackad.isLoaded()){
                    onfeedbackad.show();
                    onfeedbackad.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {
                            startActivity(intent);
                            onfeedbackad.loadAd(new AdRequest.Builder().build());
                        }
                    });
                    onfeedbackad.loadAd(new AdRequest.Builder().build());
                }else {

startActivity(intent);
                    onfeedbackad.loadAd(new AdRequest.Builder().build());
                }

            }break;


        }
        return super.onOptionsItemSelected(item);
    }
    public void verifyStoragePermissions(Activity activity) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PICK);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PICK);
            }
        }
    }
    public void openFile() {
        try {
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.setType("text/html");
            i.addCategory(Intent.CATEGORY_OPENABLE);
            startActivityForResult(i, PICK);
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "File explorer not installed", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK) {

            if (resultCode == RESULT_OK) {
                opfile = data.getData().getPath();


                try {
                    Scanner sc = new Scanner(new File(opfile));
                    String contentxt = sc.nextLine();
                    while (sc.hasNext()) {
                        contentxt = contentxt + "\n" + sc.nextLine();
                    }
                    mainText.setText(contentxt);
                    toaster("Opened file:" + opfile);
                    setTitle(opfile.substring(opfile.lastIndexOf("/")+1));
                    mainText.setSelection(contentxt.length());
                    coloring();
                } catch (Exception e) {
                    toaster("Opened file:" + opfile+" though the file is empty.");
                    mainText.setText("");
                    setTitle(opfile.substring(opfile.lastIndexOf("/")+1));
                }
            } else {

            }
        } else {

        }
    }

    public void savefile(final boolean exit1, final  boolean load ,final boolean newl) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Save");
        final EditText editText1 = new EditText(this);
        editText1.setHint("eg:myfile.txt");
        editText1.setSelection(0);
        builder.setMessage("Enter your preferred filename");
        builder.setView(editText1);
        builder.setIcon(R.drawable.saveico);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (!editText1.getText().toString().isEmpty()) {
                    file_name_to_save = editText1.getText().toString();
                    setTitle(file_name_to_save);
                    fe = new File("storage/emulated/0/HTMLr/" + file_name_to_save);

                    FileOutputStream fos;
                    if(fe.exists()){
                        toaster("Overwrited "+file_name_to_save);
                    }
                    try {
                        fos = new FileOutputStream(fe);
                        fos.write(mainText.getText().toString().getBytes());
                        fos.close();
                        alet("Saved", "Your file has saved sucessfully to " + fe.getPath().toString().substring(19, fe.getPath().toString().length()), "Ok");
                        file_name_to_save = fe.getPath().toString();
                        if(exit1){
                            finish();
                        }else if(load){
                            mainText.setText(" <!DOCTYPE html>\n<html>\n<head>\n<title>\nThis is the title\n</title>\n</head>\n<body>\n<h1>Heading</h1>\n<p>Main text</p>\n</body>\n</html>");
                            mainText.setSelection(mainText.getText().toString().indexOf("<body>")+6);
                            coloring();
                            setTitle("Editor");
                        }else if(newl){
                            setTitle("Editor");
                            mainText.setText("");
                        }
                    } catch (FileNotFoundException e) {
                        alet("Failed", "Cant save file right now,try again later", "Ok");
                        File adf = new File("storage/emulated/0/HTMLr");
                        if(!adf.exists()){


                        adf.mkdir();
                        }
                    } catch (IOException e) {
                        alet("Failed", "Cant save file right now,try again later", "Ok");
                        File adf = new File("storage/emulated/0/HTMLr");
                        if(!adf.exists()){


                            adf.mkdir();
                        }
                    }


                } else {
                    alet("No filename", "No file name was given,unable to save", "Ok");
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
    public void alet(String Title, String message, String oktext) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Title);
        builder.setMessage(message);
        builder.setPositiveButton(oktext, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
    public void Savefile2(){
        File f;
        f= new File("storage/emulated/0/HTMLr/"+getTitle());
        if(!f.exists()) {
            f = new File(opfile);
        } else{
            f= new File("storage/emulated/0/HTMLr/"+getTitle());
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(f);
            outputStream.write(mainText.getText().toString().getBytes());
            outputStream.close();
            toaster("Saved file");
        }catch(FileNotFoundException ex){

        } catch (IOException e) {

        }
    }
    public void fortoolbar(){
        String filename =getTitle().toString();
        ActionBar actionBar = this.getActionBar();

        if(filename.equals("Editor")){
            actionBar.setIcon(R.drawable.iconeditorj);
        }else if(filename.substring(filename.lastIndexOf(".",filename.length())).toLowerCase().equals("html")){
            actionBar.setIcon(R.drawable.htmlfile);
        }else if(filename.substring(filename.lastIndexOf(".",filename.length())).toLowerCase().equals("txt")){
            actionBar.setIcon(R.drawable.textfile);
        }else{
            actionBar.setIcon(R.drawable.question);
        }
    }

    @Override
    public void onBackPressed() {
        if(mainText.getText().toString().isEmpty()){
            finish();
        }else {
            if (getTitle().equals("Editor")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("File not saved").setMessage("File is not save.Do you want to save the file?").setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        savefile(true, false,false);
                        finishActivity(1);

                    }
                }).setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("File not saved").setMessage("File is not save.Do you want to save the file?").setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Savefile2();
                        finish();
                    }
                }).setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        }
    }


    public void coloring(){
        SpannableString ss = new SpannableString(mainText.getText().toString());
        String smallendingtags = "<(/[a-zA-Z0-9\\s]{0,})>";////for like </nepal>
        Pattern pattern = Pattern.compile(smallendingtags);
        Pattern pattern1 = Pattern.compile("<([!a-zA-Z0-9\\s]{0,})");//for like <nepal
        Matcher matcher1 = pattern1.matcher(ss);
        Matcher matcher = pattern.matcher(ss);
        Pattern pattern2 = Pattern.compile(" ([a-zA-Z0-9\\W]{0,})=\"([a-zA-Z0-9\\s\\W/>]{0,})\"");
        Matcher m =pattern2.matcher(ss);
        Pattern pattern3 = Pattern.compile(">");
        Matcher matcher2 = pattern3.matcher(ss);


        while (matcher2.find()){
            ss.setSpan(new ForegroundColorSpan(Color.parseColor("#42cbf4")), matcher2.start(), matcher2.end(), Spanned.SPAN_PRIORITY);
        }
        while(m.find()) {
            ss.setSpan(new ForegroundColorSpan(Color.GRAY), m.start(), m.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        while (matcher.find()) {
            ss.setSpan(new ForegroundColorSpan(Color.RED), matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        while (matcher1.find()){
            ss.setSpan(new ForegroundColorSpan(Color.parseColor("#42cbf4")), matcher1.start(), matcher1.end(), Spanned.SPAN_PRIORITY);
        }

        int selection = mainText.getSelectionEnd();
        mainText.setText(ss);
        mainText.setSelection(selection);
        ontutorials.loadAd(new AdRequest.Builder().build());
        onfeedbackad.loadAd(new AdRequest.Builder().build());
        oncompilead.loadAd(new AdRequest.Builder().build());


    }

public  void  onfirstdialog(){
    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
    alertDialog.setTitle("First Run").setMessage("This app is in development stage and we know it has a sack of bugs.We will appreciate your suggestions.Feel free to send us feedback. And  watch the youtube video for some basics if it is your first time here.")
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Uri uri= Uri.parse("https://youtube.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    }).create().show();
    SharedPreferences preferences =getSharedPreferences("prefs",MODE_PRIVATE);
    SharedPreferences.Editor editor =preferences.edit();
    editor.putBoolean("firstStart",false);
    editor.apply();
}
}
