package sg.edu.rp.demofilereadingwriting;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    Button btnWrite, btnRead;
    String folderLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = (Button)findViewById(R.id.btnRead);
        btnWrite = (Button)findViewById(R.id.btnWrite);

        folderLocation = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyFolder";

        File folder = new File(folderLocation);
        if (folder.exists() == false){
            boolean result = folder.mkdir();
            if (result == true){
                Log.d("File Read/Write", "Folder created");
            }
        }

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String folderLocation_I = getFilesDir().getAbsolutePath() + "/Folder";
                File folder_I = new File(folderLocation_I, "text.txt");
                if(folder_I.exists() == false) {
                    boolean result = folder_I.mkdir();
                    if(result == true) {
                        Log.d("File Read/Write", "Folder created");
                    }
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                File targetFile = new File(folderLocation, "data.txt");
//
//                if(targetFile.exists() ==  true) {
//                    String data = "";
//                    try {
//                        FileWriter writer_I = new FileWriter(targetFile, true);
//                    }
//                }

                try {
                    String folderLocation_I = getFilesDir().getAbsolutePath() + "/Folder";
                    File targetFile_I = new File(folderLocation_I, "test.txt");
                    FileWriter writer_I = new FileWriter(targetFile_I, true);
                    writer_I.flush();
                    writer_I.close();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Failed to write!", Toast.LENGTH_LONG).show();
                }
            }
        });


        String folderLocation = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/MyFolder"; //  Step 1 determine location

//        File folder = new File(folderLocation);
//        if(folder.exists() == false) {
//            boolean result = folder.mkdir();
//            if (result == true) {
//                Log.d("File Read/Write", "Folder created");
//            }
//        }
    }
}
//
//package sg.edu.rp.demofilereadingwriting;
//
//import android.Manifest;
//import android.os.Environment;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.content.PermissionChecker;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import java.io.File;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        int permissionCheck_Storage = ContextCompat.checkSelfPermission(
//                MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//
//        if (permissionCheck_Storage != PermissionChecker.PERMISSION_GRANTED) {
//            Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
//            ActivityCompat.requestPermissions(MainActivity.this,
//                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
//            finish();
//        }
//
//        String folderLocation = Environment.getExternalStorageDirectory()
//                .getAbsolutePath() + "/MyFolder";
//
//        File folder = new File(folderLocation);
//        if (folder.exists() == false){
//            boolean result = folder.mkdir();
//            if (result == true){
//                Log.d("File Read/Write", "Folder created");
//            } else {
//                Log.e("File Read/Write", "Folder creation failed");
//            }
//        }
//    }
//}

