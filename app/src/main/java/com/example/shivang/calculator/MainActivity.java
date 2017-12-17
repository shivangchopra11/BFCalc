package com.example.shivang.calculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements expressionUpdate {
    boolean temp_decimal = false;
    boolean temp_view = false;
    Stack<Character> stack = new Stack<Character>();
    static Stack<Character> brac = new Stack<Character>();
    Button badv;
    TextView exp;
    TextView ans;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    int orientation;
    Expression expression;
    BigDecimal result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        orientation = this.getResources().getConfiguration().orientation;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar AB=getSupportActionBar();
        AB.hide();
        exp = (TextView) findViewById(R.id.exp);
        ans = (TextView) findViewById(R.id.ans);
        final int orientation = this.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            mViewPager.setAdapter(mSectionsPagerAdapter);
        }
        else {
            final BasicButtons frag1 = new BasicButtons();
            getSupportFragmentManager().beginTransaction().add(R.id.container_1,frag1).commit();
            final AdvButtons frag2 = new AdvButtons();
            getSupportFragmentManager().beginTransaction().add(R.id.container_2,frag2).commit();
        }

    }

    @Override
    public void expAdd(int bId) {
        String str = exp.getText().toString();
        switch(bId) {
            case R.id.b0:
                if(TextUtils.isEmpty(str))
                    exp.setText("0");
                else {
                    if(stack.empty()) {
                        if(str.charAt(str.length()-1)!='0' || str.length()>1)
                            str+="0";
                    }
                    else {
                        stack.pop();
                        str = str  + "0";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.b1:
                if(TextUtils.isEmpty(str))
                    exp.setText("1");
                else {
                    if(stack.empty())
                        str+="1";
                    else {
                        stack.pop();
                        str = str  + "1";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.b2:
                if(TextUtils.isEmpty(str))
                    exp.setText("2");
                else {
                    if(stack.empty())
                        str+="2";
                    else {
                        stack.pop();
                        str = str  + "2";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.b3:
                if(TextUtils.isEmpty(str))
                    exp.setText("3");
                else {
                    if(stack.empty())
                        str+="3";
                    else {
                        stack.pop();
                        str = str  + "3";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.b4:
                if(TextUtils.isEmpty(str))
                    exp.setText("4");
                else {
                    if(stack.empty())
                        str+="4";
                    else {
                        stack.pop();
                        str = str  + "4";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.b5:
                if(TextUtils.isEmpty(str))
                    exp.setText("5");
                else {
                    if(stack.empty())
                        str+="5";
                    else {
                        stack.pop();
                        str = str  + "5";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.b6:
                if(TextUtils.isEmpty(str))
                    exp.setText("6");
                else {
                    if(stack.empty())
                        str+="6";
                    else {
                        stack.pop();
                        str = str  + "6";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.b7:
                if(TextUtils.isEmpty(str))
                    exp.setText("7");
                else {
                    if(stack.empty())
                        str+="7";
                    else {
                        stack.pop();
                        str = str  + "7";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.b8:
                if(TextUtils.isEmpty(str))
                    exp.setText("8");
                else {
                    if(stack.empty())
                        str+="8";
                    else {
                        stack.pop();
                        str = str  + "8";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.b9:
                if(TextUtils.isEmpty(str))
                    exp.setText("9");
                else {
                    if(stack.empty())
                        str+="9";
                    else {
                        stack.pop();
                        str = str  + "9";
                    }

                    exp.setText(str);
                }
                break;
            case R.id.bd1:
                if(TextUtils.isEmpty(str))
                    exp.setText("0.");
                else if(temp_decimal==false) {
                    if(stack.empty())
                        str+=".";
                    else {
                        stack.pop();
                        str= str + "0.";
                    }
                    exp.setText(str);
                }
                temp_decimal = true;
                break;
            case R.id.bc:
                exp.setText("");
                ans.setText("");
                stack.clear();
                brac.clear();
                temp_decimal = false;
                break;
            case R.id.bp:
                if(!TextUtils.isEmpty(str) && stack.empty()
                        && str.charAt(str.length()-1)!='.'
                        && str.charAt(str.length()-1)!='(') {
                    str += '+';
                    exp.setText(str);
                    stack.push('+');
                    temp_decimal = false;
                }
                break;
            case R.id.bs:
                if(!TextUtils.isEmpty(str) && stack.empty()
                        && str.charAt(str.length()-1)!='.'
                        && str.charAt(str.length()-1)!='(') {
                    str += '-';
                    exp.setText(str);
                    stack.push('-');
                    temp_decimal = false;
                }
                break;
            case R.id.bm:
                if(!TextUtils.isEmpty(str) && stack.empty()
                        && str.charAt(str.length()-1)!='.'
                        && str.charAt(str.length()-1)!='(') {
                    str += '*';
                    exp.setText(str);
                    stack.push('*');
                    temp_decimal = false;
                }
                break;
            case R.id.bd:
                if(!TextUtils.isEmpty(str) && stack.empty()
                        && str.charAt(str.length()-1)!='.'
                        && str.charAt(str.length()-1)!='(') {
                    str += '/';
                    exp.setText(str);
                    stack.push('/');
                    temp_decimal = false;
                }
                break;
            case R.id.be:
                if(!TextUtils.isEmpty(str) && stack.empty()
                        && str.charAt(str.length()-1)!='.') {

                    brac.push(')');
                    while(!brac.empty()) {
                        str += brac.pop();
                    }
                    exp.setText("("+str);
                    expression = new Expression(exp.getText().toString());
                    result = expression.eval();
                    ans.setText(result+"");

                }
                break;
            case R.id.bbb:
                if(TextUtils.isEmpty(str)) {
                    exp.setText("(");
                    brac.push(')');
                }

                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '(') {
                    if(stack.empty()) {
                        str+="(";
                        brac.push(')');
                    }

                    else {
                        stack.pop();
                        str = str  + "(";
                        brac.push(')');
                    }
                    exp.setText(str);
                }
                break;
            case R.id.bbe:
                if(!TextUtils.isEmpty(str)
                        && !(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '(')) {
                    if(stack.empty()) {
                        str+=")";
                        brac.pop();
                    }
                    exp.setText(str);
                }
                break;
            case R.id.bsin:
                if(TextUtils.isEmpty(str)) {
                    exp.setText("sin(");
                    brac.push(')');
                }

                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '(') {
                    if(stack.empty()) {
                        str+="sin(";
                        brac.push(')');
                    }

                    else {
                        stack.pop();
                        str = str  + "sin(";
                        brac.push(')');
                    }
                    exp.setText(str);
                }
                break;
            case R.id.bcos:
                if(TextUtils.isEmpty(str)) {
                    exp.setText("cos(");
                    brac.push(')');
                }

                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '('){
                    if(stack.empty()) {
                        str+="cos(";
                        brac.push(')');
                    }

                    else {
                        stack.pop();
                        str = str  + "cos(";
                        brac.push(')');
                    }
                    exp.setText(str);
                }
                break;
            case R.id.btan:
                if(TextUtils.isEmpty(str)) {
                    exp.setText("tan(");
                    brac.push(')');
                }

                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '('){
                    if(stack.empty()) {
                        str+="tan(";
                        brac.push(')');
                    }

                    else {
                        stack.pop();
                        str = str  + "tan(";
                        brac.push(')');
                    }
                    exp.setText(str);
                }
                break;
            case R.id.bsinh:
                if(TextUtils.isEmpty(str)) {
                    exp.setText("sinh(");
                    brac.push(')');
                }

                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '('){
                    if(stack.empty()) {
                        str+="sinh(";
                        brac.push(')');
                    }

                    else {
                        stack.pop();
                        str = str  + "sinh(";
                        brac.push(')');
                    }
                    exp.setText(str);
                }
                break;
            case R.id.bcosh:
                if(TextUtils.isEmpty(str)) {
                    exp.setText("cosh(");
                    brac.push(')');
                }

                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '('){
                    if(stack.empty()) {
                        str+="cosh(";
                        brac.push(')');
                    }

                    else {
                        stack.pop();
                        str = str  + "cosh(";
                        brac.push(')');
                    }
                    exp.setText(str);
                }
                break;
            case R.id.btanh:
                if(TextUtils.isEmpty(str)) {
                    exp.setText("tanh(");
                    brac.push(')');
                }

                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '('){
                    if(stack.empty()) {
                        str+="tanh(";
                        brac.push(')');
                    }

                    else {
                        stack.pop();
                        str = str  + "tanh(";
                        brac.push(')');
                    }
                    exp.setText(str);
                }
                break;
            case R.id.bln:
                if(TextUtils.isEmpty(str)) {
                    exp.setText("log(");
                    brac.push(')');
                }

                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '('){
                    if(stack.empty()) {
                        str+="log(";
                        brac.push(')');
                    }

                    else {
                        stack.pop();
                        str = str  + "log(";
                        brac.push(')');
                    }
                    exp.setText(str);
                }
                break;
            case R.id.blog:
                if(TextUtils.isEmpty(str)) {
                    exp.setText("log10(");
                    brac.push(')');
                }

                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '('){
                    if(stack.empty()) {
                        str+="log10(";
                        brac.push(')');
                    }

                    else {
                        stack.pop();
                        str = str  + "log10(";
                        brac.push(')');
                    }
                    exp.setText(str);
                }
                break;
            case R.id.bpow:
                if(!TextUtils.isEmpty(str) && stack.empty()
                        && str.charAt(str.length()-1)!='.'
                        && str.charAt(str.length()-1)!='(') {
                    str += '^';
                    exp.setText(str);
                    stack.push('^');
                    temp_decimal = false;
                }
                break;
            case R.id.bperc:
                if(!TextUtils.isEmpty(str) && stack.empty()
                        && str.charAt(str.length()-1)!='.'
                        && str.charAt(str.length()-1)!='(') {
                    str += '%';
                    exp.setText(str);
                    stack.push('%');
                    temp_decimal = false;
                }
                break;
            case R.id.bpi:
                if(TextUtils.isEmpty(str))
                    exp.setText("PI");
                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '(') {
                    if(stack.empty())
                        str+="PI";
                    else {
                        stack.pop();
                        str = str  + "PI";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.bexp:
                if(TextUtils.isEmpty(str))
                    exp.setText("e");
                else if(str.charAt(str.length()-1) == '+'
                        || str.charAt(str.length()-1) == '-'
                        ||str.charAt(str.length()-1) == '*'
                        || str.charAt(str.length()-1) == '/'
                        || str.charAt(str.length()-1) == '%'
                        || str.charAt(str.length()-1) == '^'
                        || str.charAt(str.length()-1) == '('){
                    if(stack.empty())
                        str+="e";
                    else {
                        stack.pop();
                        str = str  + "e";
                    }
                    exp.setText(str);
                }
                break;
            case R.id.bdel:
                if(!TextUtils.isEmpty(str)) {
                    if(str.charAt(str.length()-1)=='(') {
                        if(str.charAt(str.length()-2)=='s'
                                || str.charAt(str.length()-2)=='g') {
                            String newStr = "";
                            for(int i=0;i<str.length()-4;i++)
                                newStr += str.charAt(i);
                            exp.setText(newStr);
                        }
                        else if(str.charAt(str.length()-2)=='h') {
                            String newStr = "";
                            for(int i=0;i<str.length()-5;i++)
                                newStr += str.charAt(i);
                            exp.setText(newStr);
                        }
                        else if(str.charAt(str.length()-2)=='n') {
                            if(str.charAt(str.length()-3)=='l') {
                                String newStr = "";
                                for(int i=0;i<str.length()-3;i++)
                                    newStr += str.charAt(i);
                                exp.setText(newStr);
                            }
                            else {
                                String newStr = "";
                                for(int i=0;i<str.length()-4;i++)
                                    newStr += str.charAt(i);
                                exp.setText(newStr);
                            }
                        }
                        else {
                            if(str.charAt(str.length()-2)=='+'
                                    || str.charAt(str.length()-2)=='-'
                                    || str.charAt(str.length()-2)=='*'
                                    || str.charAt(str.length()-2)=='/'
                                    || str.charAt(str.length()-2)=='%'
                                    || str.charAt(str.length()-2)=='^')
                                stack.push(str.charAt(str.length()-2));
                            String newStr = "";
                            for(int i=0;i<str.length()-1;i++)
                                newStr += str.charAt(i);
                            exp.setText(newStr);
                        }
                        if(!brac.empty())
                            brac.pop();
                    }
                    else {
                        if(str.charAt(str.length()-1)=='+'
                                || str.charAt(str.length()-1)=='-'
                                || str.charAt(str.length()-1)=='*'
                                || str.charAt(str.length()-1)=='/'
                                || str.charAt(str.length()-1)=='%'
                                || str.charAt(str.length()-1)=='^')
                            if(!stack.empty())
                                stack.pop();
                        else {
                            if(str.length()==1){
                                str="";
                            }
                            else {
                                if(str.charAt(str.length()-2)=='+'
                                        || str.charAt(str.length()-2)=='-'
                                        || str.charAt(str.length()-2)=='*'
                                        || str.charAt(str.length()-2)=='/'
                                        || str.charAt(str.length()-2)=='%'
                                        || str.charAt(str.length()-2)=='^')
                                    stack.push(str.charAt(str.length()-2));
                                if(str.charAt(str.length()-1)=='.')
                                    temp_decimal = false;
                            }

                        }
                        String newStr = "";
                        for(int i=0;i<str.length()-1;i++)
                            newStr += str.charAt(i);
                        exp.setText(newStr);
                    }
                }
                break;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position==0)
                return new BasicButtons();
            else
                return new AdvButtons();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }



}
