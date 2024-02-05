package com.example.myapplication6;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    EditText inputEt;
    Button btnRead, btnWrite;
    TextView readTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEt = (EditText) findViewById(R.id.inputEt);
        readTv = (TextView) findViewById(R.id.readTv);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                readTv.setText(getFileContent());
            }
        });
        btnWrite.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                writeToFile(inputEt.getText().toString());
            }
        });
    }
    private void writeToFile(String text) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    openFileOutput("userinput.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(text);
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getFileContent() {
        String fileContent = "";
        try {
            InputStream inputStream = openFileInput("userinput.txt");
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(
                        inputStream);
                BufferedReader bufferedReader = new BufferedReader(
                        inputStreamReader);
                String line = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                inputStream.close();
                fileContent = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
        e.printStackTrace();
    }
return fileContent;
}
}