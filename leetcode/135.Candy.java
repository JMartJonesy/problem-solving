/**
  135. Candy
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

Return the minimum number of candies you need to have to distribute the candies to the children.
**/
public class Candy {
	public int candy(int[] ratings) {
		int[] candy = new int[ratings.length];
		candy[0] = 1;
		for(int i = 1; i < ratings.length; ++i) {
			if(ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			} else {
				candy[i] = 1;
			}
		}

		for(int i = ratings.length - 2; i >= 0; --i) {
			if(ratings[i] > ratings[i + 1] && candy[i] <= candy[i - 1]) {
				candy[i]++;
			}
		}

		int total = 0;
		for(int i = 0; i < candy.length; ++i) {
			total += candy[i];
		}

		return total;
	}
}
