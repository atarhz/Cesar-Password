import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String passType = scan.next();
        String password = scan.next();
        if (passType.charAt(0)=='e'){
                String encrypt = encrypt(password,0);
                System.out.print(encrypt);
        }
        if (passType.charAt(0)=='d'){
            String decrypt = decrypt(password,1);
            System.out.print(decrypt);
        }
    }
public static  String encrypt(String plainText, int shift){
        if (shift>26){
            shift = shift%26;
        }
        else  if (shift<0){
            shift = (shift%26)+26;
        }
        String cipherText = "";
        int length = plainText.length();
        for (int i = 0; i<length;i++){
            shift = fibo(i+1);
            if (shift>26){
                shift = shift%26;
            }
            else  if (shift<0){
                shift = (shift%26)+26;
            }
            char ch = plainText.charAt(i);
            if (Character.isLetter(ch)){
                if (Character.isLowerCase(ch)){
                    char c = (char)(ch+shift);
                    if (c>'z'){
                        cipherText += (char)(ch - (26-shift));
                    }
                    else {
                        cipherText += c;
                    }
                }
                else if (Character.isUpperCase(ch)){
                    char c = (char)(ch+shift);
                    if (c>'Z'){
                        cipherText += (char)(ch - (26-shift));
                    }
                    else {
                        cipherText += c;
                    }
                }
            }
            else {
                cipherText += ch;
            }
        }
        return cipherText;

}
static int fibo (int x ) {
        int f[] = new int[x+2];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= x; i++)
        {
            f[i] = f[i-1] + f[i-2];
        }

        return f[x];
    }
    public static  String decrypt(String plainText, int shift){
        if (shift>26){
            shift = shift%26;
        }
        else  if (shift<0){
            shift = (shift%26)+26;
        }
        String cipherText = "";
        int length = plainText.length();
        for (int i = 0; i<length;i++){
            shift = fibo(i+1);
            if (shift>26){
                shift = shift%26;
            }
            else  if (shift<0){
                shift = (shift%26)+26;
            }
            char ch = plainText.charAt(i);
            if (Character.isLetter(ch)){
                if (Character.isLowerCase(ch)){
                    char c = (char)(ch-shift);
                    if (c<'a'){
                        cipherText += (char)(ch + (26-shift));
                    }
                    else {
                        cipherText += c;
                    }
                }
                else if (Character.isUpperCase(ch)){
                    char c = (char)(ch-shift);
                    if (c<'A'){
                        cipherText += (char)(ch + (26-shift));
                    }
                    else {
                        cipherText += c;
                    }
                }
            }
            else {
                cipherText += ch;
            }
        }
        return cipherText;
    }

}

