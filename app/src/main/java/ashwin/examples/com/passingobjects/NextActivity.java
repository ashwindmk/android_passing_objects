package ashwin.examples.com.passingobjects;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra("bundle");
            if (bundle != null) {
                if (bundle.containsKey("student")) {
                    Log.d("debug-logging", "object:");
                    Student student = bundle.getParcelable("student");
                    Log.d("debug-logging", "student: " + String.valueOf(student));
                } else if (bundle.containsKey("student_array")) {
                    Log.d("debug-logging", "object array:");
                    Parcelable[] studentArray = bundle.getParcelableArray("student_array");
                    for (Parcelable parcelable : studentArray) {
                        Student student = (Student) parcelable;
                        Log.d("debug-logging", "student: " + student);
                    }
                } else if (bundle.containsKey("student_list")) {
                    Log.d("debug-logging", "object arraylist:");
                    ArrayList<Student> studentList = bundle.getParcelableArrayList("student_list");
                    for (Student student: studentList) {
                        Log.d("debug-logging", "student: " + student);
                    }
                }
            } else {
                Log.d("debug-logging", "bundle is null");
            }
        } else {
            Log.d("debug-logging", "intent is null");
        }
    }

}
