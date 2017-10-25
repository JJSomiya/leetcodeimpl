package com.somiya.algorithm.easy;

import com.somiya.algorithm.easy.models.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		ListNode nl = new ListNode(-1); // 头
		ListNode p = nl;
		while(l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				p.next = l2;
				l2 = l2.next;
			} else {
				p.next = l1;
				l1 = l1.next;
			}
			p = p.next;
		}

		while(l1 != null && l2 != null) {
			ListNode temp;
			if (l1.val > l2.val) {
				temp = l2;
				l2 = l2.next;
			} else {
				temp = l1;
				l1 = l1.next;
			}
			p.next = temp;
			p = p.next;
		}

		if (l1 != null) {
		    p.next = l1;
		} else if (l2 != null) {
		    p.next = l2;
		}
		return nl.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		//ListNode l2 = new ListNode(3);
		//l1.next = l2;
		//ListNode l3 = new ListNode(6);
		//l2.next = l3;
		//ListNode l4 = new ListNode(8);
		//l3.next = l4;
		//ListNode l5 = new ListNode(21);
		//l4.next = l5;
		//l5.next = null;

		ListNode l11 = new ListNode(2);
		//ListNode l12 = new ListNode(4);
		//l11.next = l12;
		//ListNode l13 = new ListNode(7);
		//l12.next = l13;
		//l13.next = null;

		ListNode ret = mergeTwoLists(l1, l11);
		ListNode t = ret;
		while(t != null) {
			System.out.println(t.val);
			t = t.next;
		}
	}
}
