import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solver {
    private static  String DIVIDERS = "*/-+";     
    private static final int RIGHT_DIRECTION = 1;
    private static final int LEFT_DIRECTION = -1;
    String expression;
    public String main(String ex)
    {
        expression= ex;
        String[] constval={"3.14","0.000000000667","300000000","2.718","0.0000012566","602200000000000000000","8.3144"};
        String[] cval={"pi","G","C","E","µ°","NA","R"};
        for(int i=0;i<7;i++)
        {
            expression=expression.replace(cval[i],constval[i]);
        }

        return(calc(expression));
    }

    private String calc(String expression) {
        int pos = 0;

        if (-1 != (pos = expression.indexOf("("))) {

            String subexp = extractExpressionFromBraces(expression,pos);
            expression = expression.replace("("+subexp+")", calc(subexp));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("cosec­¹"))) {

            pos += 6;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);
            expression = expression.replace("cosec­¹"+number, 
                Double.toString(Math.asin(1.0/Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("sec­¹"))) {

            pos += 4;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("sec­¹"+number, 
                Double.toString(Math.acos(1.0/Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("cot­¹"))) {

            pos += 4;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("cot­¹"+number, 
                Double.toString(Math.atan(1.0/Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("tan­¹"))) {

            pos += 4;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("tan­¹"+number, 
                Double.toString(Math.atan(Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("cos­¹"))) {

            pos += 4;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("cos­¹"+number, 
                Double.toString(Math.acos(Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("sin­¹"))) {

            pos += 4;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("sin­¹"+number, 
                Double.toString(Math.asin(Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("sin"))) {

            pos += 2;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);
            expression = expression.replace("sin"+number, 
                Double.toString(Math.sin(Double.parseDouble(number))));
            return calc(expression);

        } 

        else if (-1 != (pos = expression.indexOf("tan"))) {

            pos += 2;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("tan"+number, 
                Double.toString(Math.tan(Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("cot"))) {

            pos += 2;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("cot"+number, 
                Double.toString(1.0/Math.tan(Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("cosec"))) {

            pos += 4;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("cosec"+number, 
                Double.toString(1.0/Math.sin(Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("cos"))) {

            pos += 2;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("cos"+number, 
                Double.toString(Math.cos(Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("sec"))) {

            pos += 2;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("sec"+number, 
                Double.toString(1.0/Math.cos(Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("antilog"))) {

            pos += 6;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("antilog"+number, 
                Double.toString(Math.pow(10,Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("ln"))) {

            pos += 1;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("ln"+number, 
                Double.toString(Math.log(Double.parseDouble(number))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("log"))) {

            pos += 2;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("log"+number, 
                Double.toString(Math.log10(Double.parseDouble(number))));

            return calc(expression);

        }

        else if (-1 != (pos = expression.indexOf("sqrt"))) {

            pos += 3;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("sqrt"+number, 
                Double.toString(Math.pow(Double.parseDouble(number),0.5)));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("sqr"))) {

            pos += 2;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("sqr"+number, 
                Double.toString((Double.parseDouble(number)*(Double.parseDouble(number)))));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("cubrt"))) {

            pos += 4;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("cubrt"+number, 
                Double.toString(Math.pow(Double.parseDouble(number),0.333)));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("cub"))) {

            pos += 2;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("cub"+number, 
                Double.toString(Math.pow(Double.parseDouble(number),3)));

            return calc(expression);

        }
        else if (-1 != (pos = expression.indexOf("!"))) {

            String number = extractNumber(expression, pos, LEFT_DIRECTION);
            if(Double.parseDouble(number)==0)
            {
                expression = expression.replace(number+"!", 
                    1.0+"");
            }
            if(Double.parseDouble(number)<0)
                expression="NaN";

            else
            {

                double m=1.0;
                for(int i=Integer.parseInt(number);i>=1;i--)
                {
                    m=m*i;
                }

                expression = expression.replace(number+"!", 
                    m+"");
            }
            return calc(expression);

        }

        else if (-1 != (pos = expression.indexOf("exp"))) {

            pos += 2;

            String number = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace("exp" + number, 
                Double.toString(Math.exp(Double.parseDouble(number))));

            return calc(expression);

        } else if (expression.indexOf("*") > 0 | expression.indexOf("/") > 0) {

            int multPos = expression.indexOf("*");
            int divPos = expression.indexOf("/");

            pos = Math.min(multPos, divPos);
            if (multPos < 0) pos = divPos; 
            else if (divPos < 0) pos = multPos; 

            char divider = expression.charAt(pos);
            String leftNum = extractNumber(expression, pos, LEFT_DIRECTION);
            String rightNum = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace(leftNum + divider + rightNum, 
                calcShortExpr(leftNum, rightNum, divider));

            return calc(expression);

        } else if (expression.indexOf("+") > 0 | expression.indexOf("-") > 0) {

            int summPos = expression.indexOf("+");
            int minusPos = expression.indexOf("-");

            pos = Math.min(summPos, minusPos);

            if (summPos < 0) pos = minusPos; else if (minusPos < 0) pos = summPos;

            char divider = expression.charAt(pos);

            String leftNum = extractNumber(expression, pos, LEFT_DIRECTION);
            String rightNum = extractNumber(expression, pos, RIGHT_DIRECTION);

            expression = expression.replace(leftNum + divider + rightNum, 
                calcShortExpr(leftNum, rightNum, divider));

            return calc(expression);

        } else return expression;
    }

    private static String extractExpressionFromBraces(String expression, int pos) {
        int braceDepth = 1;
        String subexp="";

        for (int i = pos+1; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '(':
                braceDepth++;
                subexp += "(";
                break;
                case ')':
                braceDepth--;
                if (braceDepth != 0) subexp += ")";
                break;
                default:
                if (braceDepth > 0) subexp += expression.charAt(i);

            }
            if (braceDepth == 0 && !subexp.equals("")) return subexp;
        }
        return "Failure!";
    }

    private static String extractNumber(String expression, int pos, int direction) {

        String resultNumber = "";
        int currPos = pos + direction;

        if (expression.charAt(currPos) == '-') {
            resultNumber+=expression.charAt(currPos);
            currPos+=direction;
        }

        for (; currPos >= 0 &&
        currPos < expression.length() &&
        DIVIDERS.contains(expression.charAt(currPos)+"")==false;
        currPos += direction) {
            resultNumber += expression.charAt(currPos);
        }

        if (direction==LEFT_DIRECTION) 
            resultNumber = new 
            StringBuffer(resultNumber).reverse().toString();

        return resultNumber;
    }

    private static String calcShortExpr(String leftNum, String rightNum, char divider) {
        switch (divider) {
            case '*':
            return Double.toString(Double.parseDouble(leftNum) * 
                Double.parseDouble(rightNum));
            case '/':
            return Double.toString(Double.parseDouble(leftNum) / 
                Double.parseDouble(rightNum));
            case '+':
            return Double.toString(Double.parseDouble(leftNum) + 
                Double.parseDouble(rightNum));
            case '-':
            return Double.toString(Double.parseDouble(leftNum) - 
                Double.parseDouble(rightNum));
            default:
            return "0";
        }
    }
}