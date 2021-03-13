package dam.invisere.gtidic.udl.cat.myevents.models;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginUtils {

    private boolean isEmpty(EditText et){
        return (et.length() == 0) ? true : false;
    }

    public boolean isValidEmailAddress(EditText et){
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        if(et.getText().toString().matches(regex))
            return true;
        et.setError(getEmailAddressErrorMessage(et));
        return false;
    }

    public String getEmailAddressErrorMessage(EditText et){
        if(isEmpty(et))
            return "Email must not be empty";
        return "Email not valid";
    }

    public boolean isValidPassword(EditText et) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(et.getText().toString());
        if(matcher.matches())
            return true;
        et.setError(getPasswordErrorMessage(et));
        return false;
    }

    public String getPasswordErrorMessage(EditText et){
        if(isEmpty(et))
            return "Password must not be empty";
        else if(et.length() < 4)
            return "Password must be 4 characters long";
        return "Password not valid";
    }
}
