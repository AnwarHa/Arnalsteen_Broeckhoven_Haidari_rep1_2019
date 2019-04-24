package domain;

public class CaesarCypher implements CodeStrategy{
    private char[] chars = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', '!', '@',
            '#', '$', '%', '^', '&', '(', ')', '+',
            '-', '*', '/', '[', ']', '{', '}', '=',
            '<', '>', '?', '_', '"', '.', ',', ' '};

    @Override
    public String encode(String str)

    {
        int key = 5;
        String encrypted = "";

        for(int i = 0; i < str.length(); i++)

        {

            int c = str.charAt(i);



            if (Character.isUpperCase(c))

            {

                //26 letters of the alphabet so mod by 26

                c = c + (key % 26);

                if (c > 'Z')

                c = c - 26;

            }else if (Character.isLowerCase(c)){

                c = c + (key % 26);

                if (c > 'z')

                c = c - 26;

            }

            encrypted += (char) c;

        }

        return encrypted;

    }

    @Override
    public String decode(String str)

    {
        int key = 5;
        String decrypted = "";

        for(int i = 0; i < str.length(); i++)

        {

            int c = str.charAt(i);

            if (Character.isUpperCase(c))

            {

                c = c - (key % 26);

                if (c < 'A')

                c = c + 26;

            }

            else if (Character.isLowerCase(c))

            {

                c = c - (key % 26);

                if (c < 'a')

                c = c + 26;

            }

            decrypted += (char) c;

        }

        return decrypted;

    }

}
