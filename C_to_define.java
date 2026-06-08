
package c_to_define;

import extJavaLib.extNumLib.Ariphmetical;

import java.io.IOException;
import java.io.FileWriter;

public class C_to_define {

static final Ariphmetical[][] points;


    public static String show(Ariphmetical[][] Lambda)
        {
        int i=0;
        Ariphmetical[] Ls;
        //while(i<16)
        //    {
        //        Ls = points[i];
        //        System.out.print(Ls[0]+" "+Ls[1]+"\n");
        //        i++;
        //    }
        //System.exit(0);
        //i=0;
        String ans = "";
        while(i<16)
            {
            int j=0;
            Ls = Lambda[i];
            while(j<16)
                {
                ans =ans+ Ls[j]+" ";
                //System.out.print(Ls[j]+" ");
                j++;
                }
            
            
            i++;
            ans = ans+"\n";
            //System.out.print("\n");
            }
        return ans;
        //System.exit(0);
        }
    
    
    public static void main(String[] args)
        {
        Ariphmetical[][] res = mainqwe(args);
        //Ariphmetical qwe = new Ariphmetical(0,0);
        //System.out.print(Ariphmetical.prod(qwe, new Ariphmetical(-1,1)));
        //ExtNum a,b,c;
        //a = new ExtNum(0);
        //b = new ExtNum(-1);
        //c = ExtNum.prod(a, b);
        //System.out.print(c.sign()+"\n");
        //System.out.print(c.soutput_10()+"\n");
         String qwe,ans="<html><head><title>Tablicy</title><style>table,tr,td{border-style:solid;border-width:2px;border-collapse:collapse}</style></head><table>";
         int i,j;
         ans = ans+"<tr><td>number</td><td>n(x^n)</td><td>m(y^m)</td></tr>";
         i=0;
         qwe="";
         while(i<4)
            {
            j=0;
            while(j<4)
                {
                qwe = qwe+    
                    "<tr>"+
                    "<td>"+((i<<2)+j+1)+"</td>"
                        +
                        "<td>"+(i)+"</td>"
                        +
                        "<td>"+(j)+"</td>"
                        +"</tr>"   
                        ;
                    j++;
                }
            i++;
            }
         ans = ans+qwe+"</table><br/><table><tr><td>number</td><td>alpha</td><td>beta</td></tr>";
         qwe = "";
         i=0;
         Ariphmetical[] Ls;
         while(i<16)
            {
            Ls = points[i];
            qwe = qwe+
            "<tr>"+
                  "<td>"+(i+1)+"</td>"
                    +
                  "<td>"+Ls[0].toString()+"</td>"
                    +
                  "<td>"+Ls[1].toString()+"</td>"
                    +
                   "</tr>" ;
            i++;
            }
         
        ans = ans+qwe+"</table><br/><table>";
        qwe = ""; 
        i=0;
        String qweb,numb,num,ll="",l,lb,llb="";
        qweb="";
        while(i<16)
            {
            j=0;
            String ewq="",ewqewq="";
            Ls = res[i];
            l="";
            lb="";
            while(j<16)
                {
                num ="Raci("+ Ls[j+16].toString()+")";
                //Ls[j]=null;
                
                numb = "Raci("+ Ls[j+32].toString()+")";
                
                ewq = ewq+"<td>"
                        +
                        num
                        +"</td>";
                ewqewq = ewqewq+"<td>"
                        +
                        numb
                        +"</td>";
                j++;
                if(j==16){
                    l = "["+l+num+"]";
                        lb = "["+lb+numb+"]";
                        }
                else{
                    l = l +num+",";
                    lb = lb +numb+",";
                    }
                }
            
            //Ls=res[i]=null;
            qwe = qwe+"<tr>" +ewq+"</tr>";
            qweb = qweb+"<tr>" +ewqewq+"</tr>";
            i++;
            if(i==16){
                ll = "["+ll+l+"]";
                llb = "["+llb+lb+"]";
                }
            else
                {
                ll = ll+l+",";
                llb = llb+lb+",";
                }
            }
        //System.out.println(ll);
        //    System.out.println(llb);
        ans =ans+ qwe+"</table><br/>"+ll;
        qwe=ll = l = num = null;
        qwe = "<br/>Исходная матрица<br/>";
        ans = ans+qwe+"<table>";
        ans =ans+ qweb+"</table><br/>"+llb;
        
        i=0;
        while(i<16)
            {
                j=0;
                while(j<16)
                    {
                    Ariphmetical S = Ariphmetical.N8;
                    int k=0;
                    while(k<16)
                        {
                            Ariphmetical tmp = Ariphmetical.prod(res[i][k+16], res[k][j+32]);
                            S = Ariphmetical.sum(S,tmp);
                            k++;
                        }
                    res[i][j]=S;
                    j++;
                    }
                i++;
            }
        System.out.print("Умножение справа:\n");
        System.out.print(show(res)+"\n\n");
        while(i<16)
            {
                j=0;
                while(j<16)
                    {
                    Ariphmetical S = Ariphmetical.N8;
                    int k=0;
                    while(k<16)
                        {
                            Ariphmetical tmp = Ariphmetical.prod(res[k][j+16], res[i][k+32]);
                            S = Ariphmetical.sum(S,tmp);
                            k++;
                        }
                    res[i][j]=S;
                    j++;
                    }
                i++;
            }
        System.out.print("Умножение слева:\n");
        System.out.print(show(res)+"\n\n");
        //System.out.print(ans+"\n\n");
        
        try
            {
            (new FileWriter("delo.html")).write(ans);
            }
        catch(IOException e)
            {
            
            }
        
        }
    
    public static Ariphmetical[][] mainqwe(String[] args) {
        // TODO code application logic here
        Ariphmetical[][] Lambda = new Ariphmetical[16][32+16]; 
        int i=0;
        Ariphmetical[] pa=new Ariphmetical[4],
                       pb=new Ariphmetical[4],Ls;
        
        pa[0] = pb[0] = Ariphmetical.E8;
        //формировка
        while(i<16)
            {
            int j=2;
            Ariphmetical alpha = points[i][0],
                         beta = points[i][1];
            pa[1] = alpha;
            pb[1] = beta;
            while(j<4)
                {
                pa[j] = Ariphmetical.prod(pa[j-1], alpha);
                pb[j] = Ariphmetical.prod(pb[j-1], beta);
                j++;
                }
            Ls = Lambda[i];
            j=16;
            while(j<32)
                Ls[j++]=Ariphmetical.N8;
            Ls[i+16] = Ariphmetical.E8;
            j = 0;
            // pa j
            // pb k
            while(j<4)
                {
                int k=0,jj=j<<2,q;
                while(k<4)
                    {
                        //Ls[jj+k] = Ariphmetical.prod(pa[j],pb[k]);
                        if(j==0)
                            if(k==0)
                                Ls[q=0]=Ariphmetical.E8;
                            else
                                Ls[q=k] = pb[k];
                        else
                            if(k==0)
                                Ls[q=jj] = pa[j];
                            else
                                Ls[q=jj+k] = Ariphmetical.prod(pa[j],pb[k]);
                        Ls[q+32]=Ls[q];
                        k++;
                    }
                j++;
                }
            i++;
            }
        //нахоэдение обратной матрицы
        //System.out.print(show(Lambda)+"\n________________________________\n");
        i=0;
        //System.exit(0);
        while(i<16)
            {
            Ariphmetical a_ii = Lambda[i][i];
            //System.out.print(show(Lambda)+"\n________________________________\n");
            if(a_ii.zero())
            {
            
            int j=i+1;
            while(true)
                if(j==16)
                    {
                    
                        System.exit(1);
                    }
                else
                    if(i==j||Lambda[j][i].zero())
                            j++;
                    else {
            //обмен строками
            System.out.print("Обмен строками:\t"+i+" "+j+"\n");
            //if(i!=j)
                {
                Ls = Lambda[i];
                Ariphmetical[] Lss = Lambda[j];
                Ariphmetical tmp;
                int k=0;
                while(k<32)
                    {
                    tmp = Ls[k];
                    Ls[k]=Lss[k];
                    Lss[k]=tmp;
                    k++;
                    }
                }
                break;
                }
            }
            else
            {
            int j=0;
            Ls = Lambda[i];
            while(j<32){
                if(j==i) Ls[j] = Ariphmetical.E8;
                else Ls[j] = Ariphmetical.div(Ls[j], a_ii);
                j++;
            }
            j=0;
            Ariphmetical[] Lss;
            Ariphmetical a_ji;
            while(j<16)
                {
                if(!(i==j || (a_ji=(Lss=Lambda[j])[i]).zero())) 
                {
                int k=i;
                
                while(k<32)
                    {
                    if(k==i)
                        Lss[k]=Ariphmetical.N8;
                    else
                        {
                        Ariphmetical tmp = Ariphmetical.prod(Ls[k],a_ji);
                        Lss[k] = Ariphmetical.sub(Lss[k], tmp);
                        }
                    
                    k++;
                    }
                //j++;
                }
                j++;
                }
            i++;
            }
            
            
            
            }
        
        
        
        return Lambda;
        
        
    }

    static
    {
    
        
    Ariphmetical[] tmp;
    
    points = new Ariphmetical[16][];
    //1
    tmp = new Ariphmetical[2];
        //tmp[0] = new Ariphmetical(99,100);
        //tmp[1] = new Ariphmetical(1,200);
        tmp[0] = new Ariphmetical(2,3);
        tmp[1] = new Ariphmetical(1,6);
           points[0] = tmp;
    //2
    tmp = new Ariphmetical[2];
        //tmp[0] = new Ariphmetical(1,200);
        //tmp[1] = new Ariphmetical(99,100);
        tmp[0] = new Ariphmetical(1,6);
        tmp[1] = new Ariphmetical(2,3);
           points[1] = tmp;
    //3
    tmp = new Ariphmetical[2];
        //tmp[0] = new Ariphmetical(1,200);
        //tmp[1] = new Ariphmetical(1,200);
        tmp[0] = new Ariphmetical(1,6);
        tmp[1] = new Ariphmetical(1,6);
           points[2] = tmp;
    //4
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(1,3);
        tmp[1] = new Ariphmetical(1,3);
           points[3] = tmp;
    //5
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(1,2);
        tmp[1] = new Ariphmetical(0,1);
           points[4] = tmp;
    //6
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(0,1);
        tmp[1] = new Ariphmetical(1,2);
           points[5] = tmp;
    //7
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(1,2);
        tmp[1] = new Ariphmetical(1,2);
           points[6] = tmp;
    //8
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(1,4);
        tmp[1] = new Ariphmetical(3,4);
           points[7] = tmp;
    //9
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(3,4);
        tmp[1] = new Ariphmetical(1,4);
           points[8] = tmp;
    //10
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(0,1);
        tmp[1] = new Ariphmetical(3,4);
           points[9] = tmp;       
    //11
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(0,1);
        tmp[1] = new Ariphmetical(1,4);
           points[10] = tmp;       
    //12
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(3,4);
        tmp[1] = new Ariphmetical(0,1);
           points[11] = tmp;
    //13
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(1,4);
        tmp[1] = new Ariphmetical(0,1);
           points[12] = tmp;       
    //14
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(1,4);
        tmp[1] = new Ariphmetical(1,2);
           points[13] = tmp;       
    //15
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(1,2);
        tmp[1] = new Ariphmetical(1,4);
           points[14] = tmp;        
    //16
    tmp = new Ariphmetical[2];
        tmp[0] = new Ariphmetical(1,4);
        tmp[1] = new Ariphmetical(1,4);
           points[15] = tmp;       
     /*
    int i=0,j;
    while(i<16)
        {
        System.out.print((j=i+1)+"\t"+points[i][0]+" "+points[i][1]+"\n");
        i=j;
        }
    */
   
    }
    
    
}
