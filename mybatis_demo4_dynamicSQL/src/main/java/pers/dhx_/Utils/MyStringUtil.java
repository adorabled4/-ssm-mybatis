package pers.dhx_.Utils;

/**
 * @author Dhx_
 * @className MyStringUtil
 * @description TODO
 * @date 2022/7/21 14:10
 */
public class MyStringUtil {

    public static String genericRandomNumber(int size)
    {
        StringBuffer res=new StringBuffer("");
        while(size--!=0)
        {
            res.append((char)(Math.random()*100%10+48));
        }
        return res.toString();
    }
    public static String genericRandomLetter(int size)
    {
        StringBuffer res=new StringBuffer("");
        if(size==3)
            res.append((char) (Math.random()*100%26+65));
        while(size--!=0)
        {
            res.append((char)(Math.random()*100%26+97));
        }
        return res.toString();
    }

}
