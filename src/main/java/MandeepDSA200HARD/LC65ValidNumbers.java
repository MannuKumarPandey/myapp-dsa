package MandeepDSA200HARD;


class LC65ValidNumbers {
    public boolean isNumber(String s) {

        if(s.equals("")){
            return false;
        }
        if(s.length() == 1 && (s.charAt(0) >= '0' && s.charAt(0) <= '9')){
            return true;
        }
        if(s.length() == 1 && (s.charAt(0) <= '0' || s.charAt(0) >= '9')){
            return false;
        }


        s = s.toLowerCase();

        if(s.charAt(0) == 'e'){
            return false;
        }

        if(isThereLetters(s)){
            return false;
        }
        if(!isThereNumbers(s)){
            return false;
        }

        int dotCounter = 0;
        int dotIndex = -1;
        int eIndex = 20;
        for(int i = 1; i < s.length(); ++i){
            char currentChar = s.charAt(i);
            char previousChar = s.charAt(i - 1);
            if(previousChar == '.' && dotIndex != i - 1){
                ++dotCounter;
            }

            if(!isNumber(currentChar)){
                if(currentChar == '.'){
                    if((previousChar == '+' || previousChar == '-') && i != s.length() - 1){
                        char nextChar = s.charAt(i + 1);
                        if(!isNumber(nextChar)){
                            return false;
                        }
                    }
                    if(i > eIndex){
                        return false;
                    }
                    if(i > 1){
                        ++dotCounter;
                        dotIndex = i;
                    }
                    if(previousChar == '.'){
                        return false;
                    }
                    if(!isNumber(previousChar) && i == s.length() - 1){
                        return false;
                    }
                } else if(currentChar == 'e'){
                    if(eIndex != 20){
                        return false;
                    } else {
                        eIndex = i;
                    }
                    if(previousChar == '.' && i == 1){
                        return false;
                    }
                    if(previousChar == '-' || previousChar == '+'){
                        return false;
                    } else if(i == s.length() - 1){
                        return false;
                    }
                } else if(currentChar == '+' || currentChar == '-'){
                    if(previousChar != 'e'){
                        return false;
                    } else if(i == s.length() - 1){
                        return false;
                    }
                }
            }
            if(dotCounter > 1){
                return false;
            }
        }
        return true;

    }

    public boolean isThereLetters(String s){
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                if(s.charAt(i) != 'e'){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isThereNumbers(String s){
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                return true;
            }
        }
        return false;
    }

    public boolean isNumber(char ch){
        if(ch >= '0' && ch <= '9'){
            return true;
        } else {
            return false;
        }
    }
}