package com.somiya.algorithm.easy;

import com.somiya.algorithm.easy.models.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
		    return null;
		}
		ListNode p = head;
		while(p.next != null) {
			if (p.val != p.next.val) {
				p = p.next;
			} else {
				p.next = p.next.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		l1.next = l2;
		ListNode l3 = new ListNode(3);
		l2.next = l3;
		ListNode l4 = new ListNode(4);
		l3.next = l4;
		ListNode l5 = new ListNode(5);
		l4.next = l5;
		ListNode l11 = new ListNode(5);
		l5.next = l11;
		ListNode l12 = new ListNode(5);
		l11.next = l12;
		ListNode l13 = new ListNode(7);
		l12.next = l13;
		l13.next = null;

		ListNode ret = deleteDuplicates(l1);
		ListNode t = ret;
		while(t != null) {
			System.out.println(t.val);
			t = t.next;
		}
	}
}
