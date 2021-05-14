package controller;

public class test {
	/*
	 * 用来记录的文件
	 * 
	 * 上一个写完并测试成功的是myBrought相关类
	 * 现在是正在写mySoldController
	 * 写的时候模仿myBroughtController
	 * 需要调用TransactionDocDAO的getPersonalTransactions
	 * 现在需要改造getPersonalTransactions，
	 * 一是取消mapper，换成xml——需要重写
	 * 二是增加给getTransaction对应的SQL增加动态SQL
	 * 		增加的动态SQL需要用Map<String,Stirng>，
	 * 		transactionDAO。getPersonalTransactions需要改造，取缔换成参数sellerId一个函数，buyerId一个函数
	 * 
	 * 下一次启动注意AuthFilter能否正常运作
	 * 
	 */
}
