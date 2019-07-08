package com.shangyang.syn;

/**
 * 快乐影院
 * @author shangyang
 *
 */
public class HappyCinema {

	public static void main(String[] args) {
		Cinema c = new Cinema(2,"happy sy");
		new Thread(new Customer(c,2),"dog").start();
		new Thread(new Customer(c,1),"cat").start();
	}
}

class Customer implements Runnable {
	Cinema cinema;
	int seats;

	public Customer(Cinema cinema, int seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		synchronized(cinema) {
			boolean flag = cinema.bookTickets(seats);
			if(flag) {
				System.out.println("出票成功" + Thread.currentThread().getName() + "-<位置为：" + seats);
			} else {
				System.out.println("出票失败" + Thread.currentThread().getName() + "-<位置不够");
			}
		}
	}
}

class Cinema{
	int available;	//可用的位置
	String name;	//名称
	public Cinema(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	
	//购票
	public boolean bookTickets(int seats) {
		System.out.println("可用位置为" + available);
		if( seats > available) {
			return false;
		}
		available -= seats;
		return true;
	}
}