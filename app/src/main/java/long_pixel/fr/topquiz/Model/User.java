package long_pixel.fr.topquiz.Model;

/**
 * Created by Clou on 13/09/2017.
 */

public class User {
    private String mFistName;

    public String getFistName() {
        return mFistName;
    }

    public void setFistName(String fistName) {
        mFistName = fistName;
    }

    @Override
    public String toString() {
        return "User{" +
                "mFistName='" + mFistName + '\'' +
                '}';
    }
}
