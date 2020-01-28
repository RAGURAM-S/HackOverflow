package com.beerDistribution;

public class retailer {
	int demand;
	int startinv;
	int fullfilled;
	int endinv;
	int order;
	int backalog;
	int outofstockcost;
	double inventorycost;
	int w=3;
	int sum=0;
	public retailer(int d2,int startinv,int d1,int d3,int avg)
	{ 
	this.demand=d2;
	this.startinv=startinv;

	sum=sum+demand;
	//System.out.println(sum);
	if(startinv<=d2)
	{
	fullfilled= startinv;
	endinv=0;
	backalog=d2-startinv;
	}
	else
	{
	fullfilled=d2;
	endinv=startinv-fullfilled;
	}
	inventorycost=endinv*0.5;
	outofstockcost=backalog*1;
	System.out.println("Retailer \norder:\t"+demand+"\nstartinv:\t"+startinv+"\nfullfilled:\t"+fullfilled+"\nendinv:\t"+endinv+"\noutofstockcost:\t"+(backalog*1)+"\ninvcost:\t"+(endinv*0.5));
	int expect=avg;
	//System.out.println("hi"+expect);
	if(endinv>=expect)
	{
	order=0;
	startinv=endinv;
	}
	else
	{
	order=expect-endinv;
	startinv=expect;
	}


	}



}