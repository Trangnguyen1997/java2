/**
 * 
 */
package array.simple;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

/**
 * @author Trang
 *
 */
public class SimpleArray_Trang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = 0;
		try {
			System.out.println("Nhap so phan tu mang: ");
			n = t.nextInt();
		} catch (Exception e) {
			System.out.println("Nhap so nguyen duong!");
		}
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap Phan tu thu " + i);
			arr[i] = t.nextInt();
		}
		System.out.println("Cac so chia het cho 7 hoac 2: ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 7 == 0 || arr[i] % 2 == 0) {
				System.out.format("%4d", arr[i], " ");
			}
		}
		System.out.println();
		System.out.println("Cac so chia het cho 5 va khong chia het 3: ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 5 == 0 && arr[i] % 3 != 0) {
				System.out.format("%4d", arr[i], " ");
			}
		}

	}

}
