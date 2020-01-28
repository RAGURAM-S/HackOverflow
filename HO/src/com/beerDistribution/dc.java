package com.beerDistribution;

public class dc extends retailer{
	int dcdemand;
	int dcstartinv;
	int dcfullfilled;
	int dcorder;
	int dcoutofstockcost;
	double dcinventorycost;
	int dcbacklog;
	int dcendinv;

	public dc(int d2,int startinv,int d1,int d3,int dcstartinv,int dcbackalog,int avg,int avg1)
	{
	super(d2,startinv,d1, d3,avg);
	dcdemand=order;
	this.dcstartinv=dcstartinv;
	if(dcstartinv<=dcdemand)
	{
		dcfullfilled=dcstartinv;
		dcbacklog=dcbacklog+dcbackalog+(dcdemand-dcstartinv);
		dcendinv=0;

	}
	else
	{

	dcfullfilled=dcbackalog;
// dcbackalog=0;
	dcendinv=dcstartinv-dcfullfilled;

	if(dcendinv>dcdemand)
	{
	dcfullfilled=dcfullfilled+dcdemand;
	dcendinv=dcendinv-dcdemand;
	}
	else
	{
	dcfullfilled=dcfullfilled+(dcendinv);
	dcbacklog=dcdemand-dcendinv;
	dcendinv=0;

	}
	}
	dcoutofstockcost=dcbacklog*1;
	dcinventorycost=dcendinv*0.5;

	System.out.println();
	System.out.print("DC\ndcdemand:\t"+dcdemand+"\nstartinv:\t"+dcstartinv+"\nfullfileed:\t"+dcfullfilled+"\ndcbacklog:\t"+dcbacklog+"\ndcendinv:\t"+dcendinv +"\ndcoutofstockcost:\t"+(dcbacklog*1)+"\ndcinvcost:\t"+(dcendinv*0.5));
	int expect=order;
	if(dcendinv>=expect)
	{
	dcorder=0;
	dcstartinv=dcendinv;
	}
	else
	{
	dcorder=(expect-dcendinv)+dcbacklog;
	dcstartinv=dcorder+dcendinv;
	}
	System.out.print("\ndcorder:\t"+dcorder);
	}

}