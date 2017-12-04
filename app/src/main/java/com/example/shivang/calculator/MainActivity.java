package com.example.shivang.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    boolean temp_decimal = false;
    Stack<Character> stack = new Stack<Character>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar AB=getSupportActionBar();
        AB.hide();
        final EditText exp = (EditText) findViewById(R.id.exp);
        final EditText ans = (EditText) findViewById(R.id.ans);
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
                temp_decimal = false;
            }
        });
        Button bp = (Button) findViewById(R.id.bp);
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = exp.getText().toString();
                if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.') {
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
                if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.') {
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
                if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.') {
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
                if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.') {
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
                if(!TextUtils.isEmpty(str) && stack.empty() && str.charAt(str.length()-1)!='.') {
                    ans.setText(eval(str) + "");
                }
            }
        });

    }

    double eval(String exp) {
        /* Create stacks for operators and operands */
        Stack<Integer> op  = new Stack<>();
        Stack<Double> val = new Stack<>();
        /* Create temporary stacks for operators and operands */
        Stack<Integer> optmp  = new Stack<>();
        Stack<Double> valtmp = new Stack<>();
        String input = exp;
        input = "0" + input;
        input = input.replaceAll("-","+-");
        /* Store operands and operators in respective stacks */
        String temp = "";
        for (int i = 0;i < input.length();i++)
        {
            char ch = input.charAt(i);
            if (ch == '-')
                temp = "-" + temp;
            else if (ch != '+' &&  ch != '×' && ch != '÷')
                temp = temp + ch;
            else
            {
                val.push(Double.parseDouble(temp));
                op.push((int)ch);
                temp = "";
            }
        }
        val.push(Double.parseDouble(temp));
        /* Create char array of operators as per precedence */
        /* -ve sign is already taken care of while storing */
        char operators[] = {'÷','×','+'};
        /* Evaluation of expression */
        for (int i = 0; i < 3; i++)
        {
            boolean it = false;
            while (!op.isEmpty())
            {
                int optr = op.pop();
                double v1 = val.pop();
                double v2 = val.pop();
                if (optr == operators[i])
                {
                    /* if operator matches evaluate and store in temporary stack */
                    if (i == 0)
                    {
                        valtmp.push(v2 / v1);
                        it = true;
                        break;
                    }
                    else if (i == 1)
                    {
                        valtmp.push(v2 * v1);
                        it = true;
                        break;
                    }
                    else if (i == 2)
                    {
                        valtmp.push(v2 + v1);
                        it = true;
                        break;
                    }
                }
                else
                {
                    valtmp.push(v1);
                    val.push(v2);
                    optmp.push(optr);
                }
            }
            /* Push back all elements from temporary stacks to main stacks */
            while (!valtmp.isEmpty())
                val.push(valtmp.pop());
            while (!optmp.isEmpty())
                op.push(optmp.pop());
            /* Iterate again for same operator */
            if (it)
                i--;
        }
        return val.pop();
    }
}
