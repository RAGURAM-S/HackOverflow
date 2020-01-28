package com.beerDistribution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerDistributionServlet
 */
@WebServlet("/BeerDistributionServlet")
public class BeerDistributionServlet extends HttpServlet {

	dc dec;
	int startinv;
	int sum=0,avg=0,sum1=0,avg1=0,dcbacklog;
	int dcstartinv;
	double rIntCost;
	static int rOutCost, dcOutCost;
	double totalCost;
	double dcInvCost;

	ArrayList<Integer> rdeman =new ArrayList<Integer>();
	ArrayList<Integer> ddeman=new ArrayList<Integer>();
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BeerDistributionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// code from kasi

		String rDemand = request.getParameter("rdemand");
		String rInventory = request.getParameter("rinventory");
		String dcDemand = request.getParameter("dcDemand");

		int demand = Integer.parseInt(rDemand);
		rdeman.add(demand);
		sum = sum + demand;

		avg = sum / rdeman.size();
		System.out.println(avg);

//		if (count == 1) {
		startinv = Integer.parseInt(rInventory);
		dcstartinv = Integer.parseInt(dcDemand);
//		}

		int d1 = demand / 2;
		int d2 = demand;
		int d3 = demand + (demand / 2);

		dec = new dc(d2, startinv, d1, d3, dcstartinv, dcbacklog, avg, avg1);
		startinv = dec.endinv + dec.dcfullfilled;
		dcstartinv = dec.dcendinv + dec.dcorder;
		dcbacklog = dec.dcbacklog;
		ddeman.add(dec.dcdemand);
		sum1 = sum1 + dec.dcdemand;
		avg1 = sum1 / ddeman.size();

		rIntCost = dec.inventorycost + rIntCost;
		dcInvCost = dec.dcinventorycost + dcInvCost;
		rOutCost = dec.outofstockcost + rOutCost;
		dcOutCost = dec.dcoutofstockcost + dcOutCost;
		totalCost = rIntCost + dcInvCost + rOutCost + dcOutCost;

		request.setAttribute("dcdemand", dec.dcdemand);
		request.setAttribute("dcstartinv", dec.dcstartinv);
		request.setAttribute("dcfullfilled", dec.dcfullfilled);
		request.setAttribute("dcorder", dec.dcorder);
		request.setAttribute("dcoutofstockcost", dec.dcoutofstockcost);
		request.setAttribute("dcinventorycost", dec.dcinventorycost);
		request.setAttribute("dcbacklog", dec.dcbacklog);
		request.setAttribute("dcendinv", dec.dcendinv);
		request.setAttribute("demand", dec.demand);
		request.setAttribute("startinv", dec.startinv);
		request.setAttribute("fullfilled", dec.fullfilled);
		request.setAttribute("endinv", dec.endinv);
		request.setAttribute("order", dec.order);
		request.setAttribute("backalog", dec.backalog);
		request.setAttribute("outofstockcost", dec.outofstockcost);
		request.setAttribute("inventorycost", dec.inventorycost);
		request.setAttribute("rIntCost", rIntCost);
		request.setAttribute("dcInvCost", dcInvCost);
		request.setAttribute("rOutCost", rOutCost);
		request.setAttribute("dcOutCost", dcOutCost);
		request.setAttribute("totalCost", totalCost);
		request.setAttribute("rdeman", rdeman);
		RequestDispatcher rd = request.getRequestDispatcher("calculation.jsp");

		// The request will be forwarded to the resource
		// specified, here the resource is a JSP named,
		// "stdlist.jsp"
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);	
		String dcDemand = request.getParameter("rdemand1");

		int demand = Integer.parseInt(dcDemand);
		rdeman.add(demand);
		sum = sum + demand;

		avg = sum / rdeman.size();
		System.out.println(avg);


		int d1 = demand / 2;
		int d2 = demand;
		int d3 = demand + (demand / 2);

		dec = new dc(d2, startinv, d1, d3, dcstartinv, dcbacklog, avg, avg1);
		startinv = dec.endinv + dec.dcfullfilled;
		dcstartinv = dec.dcendinv + dec.dcorder;
		dcbacklog = dec.dcbacklog;
		ddeman.add(dec.dcdemand);
		sum1 = sum1 + dec.dcdemand;
		avg1 = sum1 / ddeman.size();

		rIntCost = dec.inventorycost + rIntCost;
		dcInvCost = dec.dcinventorycost + dcInvCost;
		rOutCost = dec.outofstockcost + rOutCost;
		dcOutCost = dec.dcoutofstockcost + dcOutCost;
		totalCost = rIntCost + dcInvCost + rOutCost + dcOutCost;

		request.setAttribute("dcdemand", dec.dcdemand);
		request.setAttribute("dcstartinv", dec.dcstartinv);
		request.setAttribute("dcfullfilled", dec.dcfullfilled);
		request.setAttribute("dcorder", dec.dcorder);
		request.setAttribute("dcoutofstockcost", dec.dcoutofstockcost);
		request.setAttribute("dcinventorycost", dec.dcinventorycost);
		request.setAttribute("dcbacklog", dec.dcbacklog);
		request.setAttribute("dcendinv", dec.dcendinv);
		request.setAttribute("demand", dec.demand);
		request.setAttribute("startinv", dec.startinv);
		request.setAttribute("fullfilled", dec.fullfilled);
		request.setAttribute("endinv", dec.endinv);
		request.setAttribute("order", dec.order);
		request.setAttribute("backalog", dec.backalog);
		request.setAttribute("outofstockcost", dec.outofstockcost);
		request.setAttribute("inventorycost", dec.inventorycost);
		request.setAttribute("rIntCost", rIntCost);
		request.setAttribute("dcInvCost", dcInvCost);
		request.setAttribute("rOutCost", rOutCost);
		request.setAttribute("dcOutCost", dcOutCost);
		request.setAttribute("totalCost", totalCost);
		request.setAttribute("rdeman", rdeman);
		RequestDispatcher rd = request.getRequestDispatcher("calculation.jsp");

		// The request will be forwarded to the resource
		// specified, here the resource is a JSP named,
		// "stdlist.jsp"
		rd.forward(request, response);

}
}
