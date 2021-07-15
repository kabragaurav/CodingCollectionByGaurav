/**
 * Microsoft
 * Design a class, MovingAverage, which contains a method, 
 * next that is responsible for returning the moving average from a stream of integers.
 * A moving average is the average of a subset of data at a given point in time.
 * Define a constructor as : MovingAverage movingAverage = new MovingAverage(capacity);
 */
package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author gaurav kabra
 * @since June 5, 2021
 */
public class MovingAverage {
	/**
	 * Time Complexity : O(N) since movingAverage method has O(1) time complexity and is repeated for each of N numbers
	 * Space Complexity : O(C) where C is capacity provided in one argument constructor
	 */
	
	private Deque<Double> deque;			// will be used to hold numbers
	private double sum; 			// sum that will be used to calculate average
	private int capacity;			// max number of numbers in deque at any time
	
	public MovingAverage(int capacity) {
		this.capacity = capacity;
		this.deque = new ArrayDeque<>(capacity);
	}
	
	private double movingAverage(double number) {
		// if deque is full, remove first element (oldest one) before assing new number to last place
		if(deque.size() == this.capacity) {
			// since removing element, subtract its value from sum
			sum -= (double) deque.removeFirst();
		}
		deque.addLast(number);
		// add value of newly added number to sum
		sum += number;
		// Formula: avg = sum/size
		return sum/deque.size();
	}
	
	// driver - main method
	public static void main(String[] args) {
		MovingAverage ma = new MovingAverage(3);
		
		// TESTCASES
		System.out.println(ma.movingAverage(3));
		System.out.println(ma.movingAverage(5));
		System.out.println(ma.movingAverage(7));
		System.out.println(ma.movingAverage(6));
		
	}

}
