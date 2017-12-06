package com.example.shivang.calculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
    boolean temp_decimal = false;
    Stack<Character> stack = new Stack<Character>();
    static Stack<Character> brac = new Stack<Character>();
    TextView exp;
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar AB=getSupportActionBar();
        AB.hide();
        exp = (TextView) findViewById(R.id.exp);
        ans = (TextView) findViewById(R.id.ans);
        int orientation = this.getResources().getConfiguration().orientation;
        Button b0 = (Button) findViewById(R.id.b0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button b5 = (Button) findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button b6 = (Button) findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button b7 = (Button) findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button b8 = (Button) findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button b9 = (Button) findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button bd1 = (Button) findViewById(R.id.bd1);
        bd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
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
            }
        });
        Button bc = (Button) findViewById(R.id.bc);
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp.setText("");
                ans.setText("");
                stack.clear();
                brac.clear();
                temp_decimal = false;
            }
        });
        Button bp = (Button) findViewById(R.id.bp);
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
                if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.' && str.charAt(str.length()-1)!='(') {
                    str += '+';
                    exp.setText(str);
                    stack.push('+');
                    temp_decimal = false;
                }
            }
        });
        Button bs = (Button) findViewById(R.id.bs);
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
                if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.' && str.charAt(str.length()-1)!='(') {
                    str += '-';
                    exp.setText(str);
                    stack.push('-');
                    temp_decimal = false;
                }
            }
        });
        Button bm = (Button) findViewById(R.id.bm);
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
                if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.' && str.charAt(str.length()-1)!='(') {
                    str += '×';
                    exp.setText(str);
                    stack.push('×');
                    temp_decimal = false;
                }
            }
        });
        Button bd = (Button) findViewById(R.id.bd);
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
                if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.' && str.charAt(str.length()-1)!='(') {
                    str += '÷';
                    exp.setText(str);
                    stack.push('÷');
                    temp_decimal = false;
                }
            }
        });
        Button be = (Button) findViewById(R.id.be);
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
                if(!TextUtils.isEmpty(str) && stack.empty()
                        && str.charAt(str.length()-1)!='.') {
                    ans.setText(evaluate(str)+"");
                }
            }
        });

        /* LANDSCAPE LAYOUT BEGINS */



        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Button bsin = (Button) findViewById(R.id.bsin);
            bsin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str)) {
                        exp.setText("sin(");
                        brac.push(')');
                    }

                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
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
                }
            });
            Button bcos = (Button) findViewById(R.id.bcos);
            bcos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str)) {
                        exp.setText("cos(");
                        brac.push(')');
                    }

                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
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
                }
            });
            Button btan = (Button) findViewById(R.id.btan);
            btan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str)) {
                        exp.setText("tan(");
                        brac.push(')');
                    }

                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
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
                }
            });
            Button bsinh = (Button) findViewById(R.id.bsinh);
            bsinh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str)) {
                        exp.setText("sinh(");
                        brac.push(')');
                    }

                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
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
                }
            });
            Button bcosh = (Button) findViewById(R.id.bcosh);
            bcosh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str)) {
                        exp.setText("cosh(");
                        brac.push(')');
                    }

                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
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
                }
            });
            Button btanh = (Button) findViewById(R.id.btanh);
            btanh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str)) {
                        exp.setText("tanh(");
                        brac.push(')');
                    }

                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
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
                }
            });
            Button bln = (Button) findViewById(R.id.bln);
            bln.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str)) {
                        exp.setText("ln(");
                        brac.push(')');
                    }

                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
                            || str.charAt(str.length()-1) == '%'
                            || str.charAt(str.length()-1) == '^'
                            || str.charAt(str.length()-1) == '('){
                        if(stack.empty()) {
                            str+="ln(";
                            brac.push(')');
                        }

                        else {
                            stack.pop();
                            str = str  + "ln(";
                            brac.push(')');
                        }
                        exp.setText(str);
                    }
                }
            });
            Button blog = (Button) findViewById(R.id.blog);
            blog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str)) {
                        exp.setText("log(");
                        brac.push(')');
                    }

                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
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
                }
            });
            Button bpow = (Button) findViewById(R.id.bpow);
            bpow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.' && str.charAt(str.length()-1)!='(') {
                        str += '^';
                        exp.setText(str);
                        stack.push('^');
                        temp_decimal = false;
                    }
                }
            });
            Button bperc = (Button) findViewById(R.id.bperc);
            bperc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.' && str.charAt(str.length()-1)!='(') {
                        str += '%';
                        exp.setText(str);
                        stack.push('%');
                        temp_decimal = false;
                    }
                }
            });
            Button bpi = (Button) findViewById(R.id.bpi);
            bpi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str))
                        exp.setText("π");
                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
                            || str.charAt(str.length()-1) == '%'
                            || str.charAt(str.length()-1) == '^'
                            || str.charAt(str.length()-1) == '(') {
                        if(stack.empty())
                            str+="π";
                        else {
                            stack.pop();
                            str = str  + "π";
                        }
                        exp.setText(str);
                    }
                }
            });
            Button bexp = (Button) findViewById(R.id.bexp);
            bexp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str))
                        exp.setText("e");
                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
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
                }
            });
            Button bbb = (Button) findViewById(R.id.bbb);
            bbb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(TextUtils.isEmpty(str)) {
                        exp.setText("(");
                        brac.push(')');
                    }

                    else if(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
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
                }
            });
            Button bbe = (Button) findViewById(R.id.bbe);
            bbe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(!TextUtils.isEmpty(str) && !(str.charAt(str.length()-1) == '+'
                            || str.charAt(str.length()-1) == '-'
                            ||str.charAt(str.length()-1) == '×'
                            || str.charAt(str.length()-1) == '÷'
                            || str.charAt(str.length()-1) == '%'
                            || str.charAt(str.length()-1) == '^'
                            || str.charAt(str.length()-1) == '(')) {
                        if(stack.empty()) {
                            str+=")";
                            brac.pop();
                        }
                        exp.setText(str);
                    }
                }
            });
            Button bdel = (Button) findViewById(R.id.bdel);
            bdel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = exp.getText().toString();
                    if(!TextUtils.isEmpty(str)) {
                        if(str.charAt(str.length()-1)=='(') {
                            if(str.charAt(str.length()-2)=='s' || str.charAt(str.length()-2)=='g') {
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
                                        || str.charAt(str.length()-2)=='×'
                                        || str.charAt(str.length()-2)=='÷'
                                        || str.charAt(str.length()-2)=='%'
                                        || str.charAt(str.length()-2)=='^')
                                    stack.push(str.charAt(str.length()-2));
                                String newStr = "";
                                for(int i=0;i<str.length()-1;i++)
                                    newStr += str.charAt(i);
                                exp.setText(newStr);
                            }
                            brac.pop();
                        }
                        else {
                            if(str.charAt(str.length()-1)=='+'
                                    || str.charAt(str.length()-1)=='-'
                                    || str.charAt(str.length()-1)=='×'
                                    || str.charAt(str.length()-1)=='÷'
                                    || str.charAt(str.length()-1)=='%'
                                    || str.charAt(str.length()-1)=='^')
                                stack.pop();
                            else {
                                if(str.charAt(str.length()-2)=='+'
                                        || str.charAt(str.length()-2)=='-'
                                        || str.charAt(str.length()-2)=='×'
                                        || str.charAt(str.length()-2)=='÷'
                                        || str.charAt(str.length()-2)=='%'
                                        || str.charAt(str.length()-2)=='^')
                                    stack.push(str.charAt(str.length()-2));
                                if(str.charAt(str.length()-1)=='.')
                                    temp_decimal = false;
                            }
                            String newStr = "";
                            for(int i=0;i<str.length()-1;i++)
                                newStr += str.charAt(i);
                            exp.setText(newStr);
                        }
                    }
                }
            });
        }





    }


    public int evaluate(String expr)
    {
        while(!brac.empty()) {
            expr += brac.pop();
        }
        exp.setText(expr);
        return NULL;
    }






}
