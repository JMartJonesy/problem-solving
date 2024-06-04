/**
21. Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
**/
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if(list1 == null) {
			return list2;
		}

		if(list2 == null) {
			return list2;
		}

		ListNode mergedList = null;
		ListNode currMerge = null;
		while(list1 != null && list2 != null) {
			ListNode mergeMe = null
			if(list1.val <= list2.val) {
				mergeMe = list1;
				list1 = list1.next;
			} else {
				mergeMe = list2;
				list2 = list2.next;
			}

			if(mergedList == null) {
				mergedList = mergeMe;
				currMerge = mergedList;
			} else {
				currMerge.next = mergeMe;
				currMerge = currMerge.next;
			}
		}

		if(list1 != null) {
			currMerge.next = list1;
		} else {
			currMerge.next = list2;
		}

		return mergedList;
	}
}
