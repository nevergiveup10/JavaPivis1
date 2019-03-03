package application;


public class StringData {
    public String string1;
    public String string2;

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }

    StringData(String str1, String str2) {

        string1 = str1;
        string2 = str2;
    }

    public void setString1(String str) {
        string1 = str;
    }

    public void setString2(String str){
        string2 = str;
    }
}