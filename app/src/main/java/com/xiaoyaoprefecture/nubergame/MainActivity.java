package com.xiaoyaoprefecture.nubergame;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 点击一下控件模拟双色球出票
 */
public class MainActivity extends AppCompatActivity {
    Button Btn;
    TextView Tv1,Tv2,Tv3,Tv4,Tv5,Tv6,Tv7;
    List<Integer>list=new ArrayList<>();
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * 初始化数据
     */
    private void init() {
        findView();
        setText1();
        setListener();
    }
    /**
     * 排除已经选中的数字,形成新的集合
     * @param list1
     * @param
     * @return
     */
    private List newList(List<Integer>list1,int a) {
        List<Integer>list2=new ArrayList<>();
        for (int i=1;i<list1.size()+1;i++){
            if (a==list1.get(i-1)){
                continue;
            }else {
                list2.add(list1.get(i-1));
            }
        }
        return list2;
    }

    /**
     * 设置不同的随机数字的优化版
     */
    private void setText1() {
       list=addlist1(list);
        List<Integer>list4=new ArrayList<>();
        List<Integer>list5=new ArrayList<>();
        List<Integer>list6=new ArrayList<>();
        List<Integer>list7=new ArrayList<>();
        List<Integer>list8=new ArrayList<>();
        List<Integer>list9=new ArrayList<>();
        //这是我抽取到的随机数
       int a=new Random().nextInt(list.size())+1;
        Log.e("-------",a+"随机到的数字");
        //找到集合里面随机数对应的位置上的值
       int b=list.get(a-1);
        Log.e("-------",b+"选中的数字");
        Tv1.setText(b+"");
        //删除已经选中的数字形成新的集合
        list4=newList(list,b);
        Log.e("-------",list4.size()+"集合内的个数");
        //抽取第二个随机数字
        int a2=new Random().nextInt(list4.size())+1;
        Log.e("-------",a2+"随机到的数字");
        //找到集合里面随机数对应的位置上的值
        int b2=list4.get(a2-1);
        Log.e("-------",b2+"选中的数字");
        Tv2.setText(b2+"");
        //删除已经选中的数字形成新的集合
        list5=newList(list4,b2);
        Log.e("-------",list5.size()+"集合内的个数");
        //抽取第3个随机数字
        int a3=new Random().nextInt(list5.size())+1;
        Log.e("-------",a3+"随机到的数字");
        //找到集合里面随机数对应的位置上的值
        int b3=list5.get(a3-1);
        Log.e("-------",b3+"选中的数字");
        Tv3.setText(b3+"");
        //删除已经选中的数字形成新的集合
        list6=newList(list5,b3);
        Log.e("-------",list6.size()+"集合内的个数");
        //抽取第4个随机数字
        int a4=new Random().nextInt(list6.size())+1;
        Log.e("-------",a4+"随机到的数字");
        //找到集合里面随机数对应的位置上的值
        int b4=list6.get(a4-1);
        Log.e("-------",b4+"选中的数字");
        Tv4.setText(b4+"");
        //删除已经选中的数字形成新的集合
        list7=newList(list6,b4);
        Log.e("-------",list7.size()+"集合内的个数");
        //抽取第5个随机数字
        int a5=new Random().nextInt(list7.size())+1;
        Log.e("-------",a5+"随机到的数字");
        //找到集合里面随机数对应的位置上的值
        int b5=list7.get(a5-1);
        Log.e("-------",b5+"选中的数字");
        Tv5.setText(b5+"");
        //删除已经选中的数字形成新的集合
        list8=newList(list7,b5);
        Log.e("-------",list8.size()+"集合内的个数");
        //抽取第6个随机数字
        int a6=new Random().nextInt(list8.size())+1;
        Log.e("-------",a6+"随机到的数字");
        //找到集合里面随机数对应的位置上的值
        int b6=list8.get(a6-1);
        Log.e("-------",b6+"选中的数字");
        Tv6.setText(b6+"");
        //删除已经选中的数字形成新的集合
        list9=newList(list8,b6);
        Log.e("-------",list9.size()+"集合内的个数");
        Tv7.setText(new Random().nextInt(16)+1+"");
    }



    /**
     * 给list1添加数据
     */
    private List addlist1(List<Integer>list1) {
        for (int i=1;i<33;i++){
            list1.add(i);
        }
        return list1;
    }

    /**
     * 设置不同的随机数字
     * 这个方法有很大的机会造成anr，因为这里面可能会很久都不能随机到一个不同的数字，所以需要改进
     */
    private void setdifferenceText() {
       while(true){
           int s=getNumber();
           if (!(list.contains(s))){
               list.add(s);
           }
           if (list.size()==6){
               int s1=new Random().nextInt(16)+1;
               list.add(s1);
               break;
           }
       }
        Tv1.setText(list.get(0)+"");
        Tv2.setText(list.get(1)+"");
        Tv3.setText(list.get(2)+"");
        Tv4.setText(list.get(3)+"");
        Tv5.setText(list.get(4)+"");
        Tv6.setText(list.get(5)+"");
        Tv7.setText(list.get(6)+"");
    }

    /**
     * 给按钮设置监听事件
     */
    private void setListener() {
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // setText();
              //  setdifferenceText();
                setText1();
            }
        });
    }

    /**
     * 给textview设置随机数字
     */
    private void setText() {
        Tv1.setText(new Random().nextInt(32)+1+"");
        Tv2.setText(new Random().nextInt(32)+1+"");
        Tv3.setText(new Random().nextInt(32)+1+"");
        Tv4.setText(new Random().nextInt(32)+1+"");
        Tv5.setText(new Random().nextInt(32)+1+"");
        Tv6.setText(new Random().nextInt(32)+1+"");
        Tv7.setText(new Random().nextInt(16)+1+"");

    }

    /**
     * 找控件
     */
    private void findView() {
        Btn= (Button) findViewById(R.id.mBtn);
        Tv1= (TextView) findViewById(R.id.TextView1);
        Tv2= (TextView) findViewById(R.id.TextView2);
        Tv3= (TextView) findViewById(R.id.TextView3);
        Tv4= (TextView) findViewById(R.id.TextView4);
        Tv5= (TextView) findViewById(R.id.TextView5);
        Tv6= (TextView) findViewById(R.id.TextView6);
        Tv7= (TextView) findViewById(R.id.TextView7);
    }

    /**
     * 获取随机数字
     * @return
     */
    public Integer getNumber() {
        return new Random().nextInt(32)+1;
    }
}
