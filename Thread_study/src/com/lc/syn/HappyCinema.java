package com.lc.syn;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema {
	public static void main(String[] args) {
		List<Integer> available=new ArrayList<Integer>();
		for(int i=1;i<8;i++)
		{
			available.add(i);
		}
		
		List<Integer> seats1 = new ArrayList<Integer>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2 = new ArrayList<Integer>();
		seats2.add(3);
		seats2.add(5);
		seats2.add(6);
		
		
		HiCinema c= new HiCinema(available,"hahaha");
		new Thread(new HappyCustomer(c,seats1),"高").start();
		new Thread(new HappyCustomer(c,seats2),"飞").start();
		
		
	}
}

class HappyCustomer implements Runnable{
	
	HiCinema cinema;
	List<Integer> seats;
	
	
	
	public HappyCustomer(HiCinema cinema, List<Integer> seats) {
		this.cinema = cinema;
		this.seats = seats;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(cinema) {
			boolean flag= cinema.bookTickets(seats);
		
			if(flag)
			{
				System.out.println("出票成功-->"+Thread.currentThread().getName()+"->位置为"+seats);
			}
			else {
				System.out.println("出票失败-->"+Thread.currentThread().getName());
			}

		}	
	}
}

class HiCinema{
	List<Integer> available; //可用的位置
	String name;
	
	public HiCinema(List<Integer> available, String name) {
		this.available=available;
		this.name=name;
	}
	
	public boolean bookTickets(List<Integer> seats) {
			System.out.println("可用位置为"+available);
			List<Integer> copy = new ArrayList<Integer>();
			copy.addAll(available);
			
			//相减
			copy.removeAll(seats);
			//判断大小
			if(available.size() - copy.size() != seats.size()) {
				return false;
			}
			//成功
			available=copy;
			return true;
	}
}