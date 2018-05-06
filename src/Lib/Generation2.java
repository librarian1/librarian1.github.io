package Lib;

import InputException.OperationNumException;

import java.io.PrintStream;

/**
 * test2
 * Created by TestUser on 2018/5/5.
 */
public class Generation2 {


    public String gene(int n,int m1,int m2,int b,int o,int c )
    {
    	
    	Generation g = new Generation();//修改
    	g.OperationNum = n;
    	g.lower = m1;
    	g.upper = m2;
    	g.CRange = o;
        if (c==1){
         g.ifM_D = true;
        }else{
         g.ifM_D = false;
        }
        if (b==1){
          g.ifB = true;
        }else{
          g.ifB  = false;
        }

        //返回的应该为你生成的四则运算
          return g.operation(g);
    	

/*        int n1 = n;
        int lower = m1;
        int upper =m2;
        int CRange = o;
        if (c==1){
        boolean ifM_D = true;
        }else{
       boolean ifM_D = false;
        }
        if (b==1){
          boolean ifB = true;
        }else{
          boolean ifB  = false;
        }


        //返回的应该为你生成的四则运算
          return "2+3+4+5";
  */
    }



/*    public String[] operation(Generation g)

    {

        int OperationNum = g.OperationNum;
        int CRange = g.CRange;

        String[] operations = new String[OperationNum];
        int i = 0;

        while(!(OperationNum == 0))
        {
            g.CharacterN = 1 + (int)(Math.random() * (CRange));
            g.OperatorN = g.CharacterN + 1;
            g.OperatorL =  g.operator(g);
            g.CharaL = g.character(g);

            operations[i] =  g.bracket(g);
            if(!g.ifLegal)
            {
                i--;
                OperationNum++;
            }
            i++;
            OperationNum--;
            g.ifLegal = true;
        }

        return operations;
    }

    public strOperation operator(Generation g)
    {
        int OperatorN = g.OperatorN;
        int lower = g.lower;
        int upper = g.upper;

        strOperation OperatorL = new strOperation();

        while(!(OperatorN == 0))
        {
            int integer = lower + (int)(Math.random() * (upper-lower+1));//Vrange

            OperatorL.insertFirstd(integer);

            OperatorN --;
        }

        return OperatorL;
    }

    public strOperation character(Generation g)
    {
        boolean ifM_D = g.ifM_D;
        int CharacterN = g.CharacterN;
        strOperation OperatorL = g.OperatorL;

        strOperation CharaL = new strOperation();
        boolean ifLegal = false;//小数

        while(!ifLegal)
        {
            ifLegal = true;
            if(ifM_D)
            {
                //生成c
                int temp = CharacterN;
                int add=0,subtract=0, multiply=0, divide=0;

                while(!(CharacterN == 0))
                {
                    int CharaType = 0;
                    CharaType = (int)(Math.random() * 4);

                    switch (CharaType)
                    {
                        case 0:{
                            CharaL.insertFirstc("+");
                            CharacterN--;
                            add++;
                        }
                        break;
                        case 1:{
                            CharaL.insertFirstc("-");
                            CharacterN--;
                            subtract++;
                        }
                        break;
                        case 2:{
                            CharaL.insertFirstc("*");
                            CharacterN--;
                            multiply++;
                        }
                        break;
                        case 3:{
                            CharaL.insertFirstc("÷");
                            CharacterN--;
                            divide++;
                        }
                        break;
                        default:
                            break;
                    }
                }
                if(temp > 1 && (add==temp||subtract==temp||multiply==temp||divide==temp))//运算符大于等于2
                {
                    ifLegal = false;
                }

                //judge

                int result = 0;
                strOperation.Node p = OperatorL.first;
                strOperation.Node q = CharaL.first;
                int cur1 = 0;
                String chara = "";

                result = p.data;
                cur1 = p.next.data;
                chara = q.character;

                while(!(q == null))
                {
                    cur1 = p.next.data;
                    chara = q.character;
                    if(chara == "+" )
                    {
                        result = result + cur1;
                        p = p.next;
                        q = q.next;
                    }
                    else if (chara == "-")
                    {
                        result = result - cur1;
                        p = p.next;
                        q = q.next;
                    }
                    else if (chara == "*")
                    {
                        result = result * cur1;
                        p = p.next;
                        q = q.next;
                    }
                    else if (chara  == "÷")
                    {
                        if(cur1 == 0) {//!0
                            ifLegal = false;
                            break;
                        }
                        int cur3 = result;
                        result = result / cur1;
                        if(cur3 > result * cur1)//小数
                        {
                            ifLegal = false;
                            g.ifLegal = false;
                            return CharaL;
                        }
                        p = p.next;
                        q = q.next;
                    }
                }
            }
            else//+-
            {
                //生成
                int temp = CharacterN;
                int add=0,subtract=0;

                while(!(CharacterN == 0))
                {
                    int CharaType = 0;
                    CharaType = (int)(Math.random() * 2);

                    switch (CharaType)
                    {
                        case 0:{
                            CharaL.insertFirstc("+");
                            CharacterN--;
                            add++;
                        }
                        break;
                        case 1:{
                            CharaL.insertFirstc("-");
                            CharacterN--;
                            subtract++;
                        }
                        break;

                        default:
                            break;
                    }
                }
                if(temp > 1 && (add==temp||subtract==temp))//运算符大于等于2
                {
                    ifLegal = false;
                }
            }
        }
        return CharaL;
    }

    public String bracket(Generation g)
    {
        strOperation OperatorL = g.OperatorL;
        strOperation CharaL = g.CharaL;
        boolean ifB = g.ifB;
        boolean ifLegal = false;//无括号


        strOperation.Node p = OperatorL.first;
        strOperation.Node q = CharaL.first;
        String operation = p.data + "";

        while(!ifLegal)
        {
            ifLegal = true;
            int priority1 = 0, priority2 = 0;

            while(!(q == null))
            {
                p = p.next;
                String fchara = q.character;
                priority1 = priority2 = 0;

                if(!(q.next == null))
                {
                    String lchara = q.next.character;

                    if(fchara == "+"  || fchara == "-")
                        priority1 = 0;
                    else if(fchara == "*" || fchara == "÷")
                        priority1 = 1;

                    if(lchara == "+" || lchara == "-")
                        priority2 = 0;
                    else if(lchara == "*" || lchara == "÷")
                        priority2 = 1;
                }

                if(priority1 == 0 && priority2 == 1)
                {
                    operation ="(" + operation + q.character
                            + p.data  + ")";

                    if(!ifB) {
                        ifLegal = false;
                        g.ifLegal = false;
                        return operation;
                    }
                }
                else
                {
                    operation = operation + q.character + p.data;
                }
                q = q.next;
            }
        }
        return operation;
    }
*/

}
