package test.zhangdy.interview.algorithm.recursion;

/**
 * 用递归算法完成：有52张牌，使它们全部正面朝上，
 * 第一轮是从第2张开始，凡是2的倍数位置上的牌翻成正面朝下；
 * 第二轮从第3张牌开始，凡是3的倍数位置上的牌，正面朝上的翻成正面朝下,正面朝下的翻成正面朝上；
 * 第三轮从第4张牌开始，凡是4的倍数位置上的牌按上面相同规则翻转，以此类推，直到第一张要翻的牌超过52为止。
 * 统计最后有几张牌正面朝上，以及它们的位置号。

 * @author esw
 *
 */
public class DiGui {
	private int n;
	// private int a;
	private int p[] = null;// 存放所有牌的正反面信息

	public DiGui(int n) {
		this.n = n;
		// a=n;
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = 0;// 这里0表示是正面，1表示是反面
		}
	}

	public void process(int a) {// ======相当于f(n)
		int b = a;
		if (a == 1)
			return;// 递归的出口
		// 下面部分为解决当前要做的(可以从最后一步或第一步着手思考要做的事)---相当与(n)
		// ===================================================
		while (b <= n) {//
			p[b - 1] = (p[b - 1] == 0) ? 1 : 0;//
			b = 2 * b;// me: 此处为何使用 b 的2 倍 ？？？？
		}
		// ====================================================
		process(a - 1);// 调用自身，解决相同的但规模要小的又一问题---相当于f(n-1)

	}
	//me: processMe() 和 process() 的最终结果是一样的
	public void processMe(int a){
		int b = a;
		
		if (a > 52) return;
		int count=1;
		while(b <=n){
			p[b - 1] = (p[b - 1] == 0) ? 1 : 0;//
			b = b*(count+1);
		}
		processMe(a + 1);
	}
	public void printThis() {
		process(n);
//		processMe(2);
		
		for (int i = 0; i < n; i++) {
			System.out.println("第" + (i + 1) + "张的正反面序号为：" + p[i]);
		}
	}

	public static void main(String[] args) {
		DiGui digui = new DiGui(52);
		digui.printThis();
		/*
		 * result
		 *  第1张的正反面序号为：0
			第2张的正反面序号为：1
			第3张的正反面序号为：1
			第4张的正反面序号为：0
			第5张的正反面序号为：1
			第6张的正反面序号为：0
			第7张的正反面序号为：1
			第8张的正反面序号为：1
			第9张的正反面序号为：1
			第10张的正反面序号为：0
			第11张的正反面序号为：1
			第12张的正反面序号为：1
			第13张的正反面序号为：1
			第14张的正反面序号为：0
			第15张的正反面序号为：1
			第16张的正反面序号为：0
			第17张的正反面序号为：1
			第18张的正反面序号为：0
			第19张的正反面序号为：1
			第20张的正反面序号为：1
			第21张的正反面序号为：1
			第22张的正反面序号为：0
			第23张的正反面序号为：1
			第24张的正反面序号为：0
			第25张的正反面序号为：1
			第26张的正反面序号为：0
			第27张的正反面序号为：1
			第28张的正反面序号为：1
			第29张的正反面序号为：1
			第30张的正反面序号为：0
			第31张的正反面序号为：1
			第32张的正反面序号为：1
			第33张的正反面序号为：1
			第34张的正反面序号为：0
			第35张的正反面序号为：1
			第36张的正反面序号为：1
			第37张的正反面序号为：1
			第38张的正反面序号为：0
			第39张的正反面序号为：1
			第40张的正反面序号为：0
			第41张的正反面序号为：1
			第42张的正反面序号为：0
			第43张的正反面序号为：1
			第44张的正反面序号为：1
			第45张的正反面序号为：1
			第46张的正反面序号为：0
			第47张的正反面序号为：1
			第48张的正反面序号为：1
			第49张的正反面序号为：1
			第50张的正反面序号为：0
			第51张的正反面序号为：1
			第52张的正反面序号为：1
		 */
	}
}