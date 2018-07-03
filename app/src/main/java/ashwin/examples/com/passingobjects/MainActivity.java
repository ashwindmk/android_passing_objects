package ashwin.examples.com.passingobjects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void passObject(View view) {
        Student student = new Student(1, "alice", false);
        Bundle bundle = new Bundle();
        bundle.putParcelable("student", student);
        Intent intent = new Intent(MainActivity.this, NextActivity.class);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }

    public void passObjectArray(View view) {
        Student[] studentArray = new Student[3];
        studentArray[0] = new Student(1, "alice", false);
        studentArray[1] = new Student(2, "bob", true);
        studentArray[2] = new Student(3, "clara", false);
        Bundle bundle = new Bundle();
        bundle.putParcelableArray("student_array", studentArray);
        Intent intent = new Intent(MainActivity.this, NextActivity.class);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }

    public void passObjectList(View view) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "alice", false));
        studentList.add(new Student(2, "bob", true));
        studentList.add(new Student(3, "clara", false));
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("student_list", studentList);
        Intent intent = new Intent(MainActivity.this, NextActivity.class);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }

}
