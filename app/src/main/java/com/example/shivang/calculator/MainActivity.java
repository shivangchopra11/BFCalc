package com.example.shivang.calculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    boolean temp_decimal = false;
    boolean temp_view = false;
    Stack<Character> stack = new Stack<Character>();
    static Stack<Character> brac = new Stack<Character>();
    Button badv;
    TextView exp;
    TextView ans;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

     double evaluate_port(String exp) {
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


    Stack<String> oprtr = new Stack<>();
    Stack<Double> oprnd = new Stack<>();
    Double e = 2.718281828;
    Double pi = 3.14159;
    public Double evaluate_land(String expr) {
        while(!brac.empty()) {
            expr += brac.pop();
        }
        exp.setText(expr);
        Log.v("ABC",expr);
        String newStr = "";
        for(int i=0;i<expr.length();i++) {
            if(expr.charAt(i)=='0'
                    ||expr.charAt(i)=='1'
                    ||expr.charAt(i)=='2'
                    ||expr.charAt(i)=='3'
                    ||expr.charAt(i)=='4'
                    ||expr.charAt(i)=='5'
                    ||expr.charAt(i)=='6'
                    ||expr.charAt(i)=='7'
                    ||expr.charAt(i)=='8'
                    ||expr.charAt(i)=='9'
                    ||expr.charAt(i)=='.') {
                newStr += expr.charAt(i);
                Log.v("ABC",newStr);
            }
            else {
                if(expr.charAt(i)!='(' && newStr.length()>0) {
                    Log.v("ABC", newStr);
                    double d = Double.parseDouble(newStr);
                    Log.v("ABC", newStr + d + "");
                    oprnd.push(d);
                    newStr = "";
                }
                if(expr.charAt(i)=='+'
                        ||expr.charAt(i)=='-'
                        ||expr.charAt(i)=='×'
                        ||expr.charAt(i)=='÷'
                        ||expr.charAt(i)=='^'
                        ||expr.charAt(i)=='%'
                        ||expr.charAt(i)=='(') {
                    oprtr.push(expr.charAt(i) + "");
                }
                else if(expr.charAt(i)==')') {
                    do {

                        String op = oprtr.peek();
                        Log.v("ABC", op );
                        if(op.length()==2)
                            oprnd.push(calc(oprtr.pop(),oprnd.pop(),0.0));
                        else if(oprtr.peek().compareTo("(")!=0)
                            oprnd.push(calc(oprtr.pop(),oprnd.pop(),oprnd.pop()));
                    } while(oprtr.peek().compareTo("(")!=0);
                    oprtr.pop();
                }
                else {
                    if(expr.charAt(i)=='e')
                        oprnd.push(e);
                    else if(expr.charAt(i)=='π')
                        oprnd.push(pi);
                    else if(expr.charAt(i)=='s') {
                        if(expr.charAt(i+3)=='h') {
                            oprtr.push("sh");
                            i+=3;
                        }
                        else {
                            oprtr.push("sn");
                            i+=2;
                        }
                    }
                    else if(expr.charAt(i)=='c') {
                        if(expr.charAt(i+3)=='h') {
                            oprtr.push("ch");
                            i+=3;
                        }
                        else {
                            oprtr.push("cs");
                            i+=2;
                        }
                    }
                    else if(expr.charAt(i)=='t') {
                        if(expr.charAt(i+3)=='h') {
                            oprtr.push("th");
                            i+=3;
                        }
                        else {
                            oprtr.push("tn");
                            i+=2;
                        }
                    }
                    else if(expr.charAt(i)=='l') {
                        if(expr.charAt(i+2)=='g') {
                            oprtr.push("lg");
                            i+=2;
                        }
                        else {
                            oprtr.push("ln");
                            i++;
                        }
                    }
                }
            }
        }
        return oprnd.pop();
    }
    private Double calc( String op,Double b, Double a) {
        switch(op) {
            case "+":return a+b;
            case "-":return a-b;
            case "×":return a*b;
            case "÷":return a/b;
            case "^":return Math.pow(a,b);
            case "%":return a%b;
            case "sn":return Math.sin(b);
            case "cs":return Math.cos(b);
            case "tn":return Math.tan(b);
            case "ln":return Math.log(b);
            case "lg":return Math.log10(b);
            case "sh":return Math.sinh(b);
            case "ch":return Math.cosh(b);
            case "th":return Math.tanh(b);
        }
        return 0.0;
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
            // Show 3 total pages.
            return 2;
        }
    }


}
