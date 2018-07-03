package ashwin.examples.com.passingobjects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ashwin on 03/07/18.
 */

public class Student implements Parcelable {

    private int id;
    private String name;
    private boolean married;

    public Student() {
    }

    public Student(int id, String name, boolean married) {
        this.id = id;
        this.name = name;
        this.married = married;
    }

    protected Student(Parcel in) {
        id = in.readInt();
        name = in.readString();
        married = in.readByte() != 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + id + ". " + name + ", married: " + married + "]";
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeByte((byte) (married ? 1 : 0));
    }

}
