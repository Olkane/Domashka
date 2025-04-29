import static java.lang.Math.pow;


public class Hexdecimal extends NumeralSystem{
    public Hexdecimal(String hexdecimal){
        setHexdecimal(hexdecimal);
    }

    @Override
    public String getDecimal(){
        int result = 0;
        if (!hexdecimal.equals("0")){
            char[] number = hexdecimal.toCharArray();
            int len = hexdecimal.length() - 1;
            for (int i = 0; i <= len; i++) {
                int index = 0;
                for (int j = 0; j < Util.hexDigits.length; j++) {
                    if (Util.hexDigits[j] == number[len-i]){
                        index = j;
                        break;
                    }
                }
                result += (int) (index * pow(16, i));
            }
        }
        setDecimal(String.valueOf(result));
        return decimal;
    }

    @Override
    public String getBinary(){
        String result = "";
        if (hexdecimal.equals("0")){
            result = "0";
        }else {
            for (char c : hexdecimal.toCharArray()) {
                result += Util.binaryMap.get(String.valueOf(c));
            }

        }
        setBinary(result);
        return binary;
    }

    @Override
    public void setValue(String hexdecimal){
        setHexdecimal(hexdecimal);
    }

    @Override
    public String getAdditionResult(NumeralSystem system) {
        return new Decimal(String.valueOf(Integer.parseInt(this.getDecimal()) + Integer.parseInt(system.getDecimal()))).getHexdecimal();
    }

    @Override
    public String getSubtractionResult(NumeralSystem system) {
        return new Decimal(String.valueOf(Integer.parseInt(this.getDecimal()) - Integer.parseInt(system.getDecimal()))).getHexdecimal();
    }

    @Override
    public String toString() {
        return "Шестнадцатеричная";
    }
}
