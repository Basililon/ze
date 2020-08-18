package mengze.ze;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class FetchNum 
{
    public static void main( String[] args )
    {
    	int count = 500000;
    	int resultCount = 100000;
    	ArrayList<Integer> list = new ArrayList<Integer>(count);
    	ArrayList<Integer> resultList = new ArrayList<Integer>(resultCount);
    	//生成包含50W个整数的list
    	int i = 0;
        while (i < count ) {
        	list.add(i++);
        }
        
        //记录开始时间
        long begin = System.currentTimeMillis();
        //执行取数方法
        resultList = getRandomNumList(list,resultCount);
        //记录结束时间
        long end = System.currentTimeMillis();
        
        //输出取数结果
        //System.out.println(resultList.toString());
        //输出执行时间
        System.out.println("执行共耗时："+(end-begin)+"ms");
    }
    
    /**
     * 
     * @param list 传入包含整数的List
     * @param num 需要返回整数的个数
     * @return resultList 整数放入list返回
     */
    public static ArrayList<Integer> getRandomNumList(ArrayList<Integer> list,int num){
    	Random random = new Random();
    	//创建Set集合存储随机产生的索引(不重复)
    	HashSet<Integer> indexSet = new HashSet<Integer>(num);
    	while(indexSet.size() < num) {
    		indexSet.add(random.nextInt(list.size()));
    	}
    	ArrayList<Integer> resultList = new ArrayList<Integer>(num);
    	for (Integer index : indexSet) {
    		//获取索引上的整数
    		resultList.add(list.get(index));
		}
    	return resultList;
    }
}
