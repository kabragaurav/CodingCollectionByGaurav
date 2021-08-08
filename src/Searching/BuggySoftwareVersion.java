/**
 * Facebook
 * Releasing software can be tricky and sometimes we release new versions of our software with bugs. 
 * When we release a version with a bug it’s referred to as a bad release. 
 * Your product manager has just informed you that a bug you created was released in one of the past versions
 * and has caused all versions that have been released since to also be bad. 
 * Given that your past releases are numbered from zero to N and you have a helper function 
 * isBadRelease(int releaseNumber) that takes a version number and returns a boolean as to whether 
 * or not the given release number is bad, return the release number that your bug was initially shipped in.
 * You should minimize your number of calls made to isBadRelease().
 */
package Searching;

/**
 * @author gaurav kabra
 * @since August 08, 2021
 */

import java.util.Random;

public class BuggySoftwareVersion {
	
	private static int firstBuggyVersion = 0;
	
	// utility method to pick up first bad version randomly
	private static int getRandomBuggyVersion(int n) {
		return firstBuggyVersion = new Random().nextInt(n);
	}
	
	// utility method to return if given version is bad or not
	private static boolean isBadVersion(int version) {
		if(version >= firstBuggyVersion) {
			return true;
		}
		return false;
	}
	
	private static int firstBadVersion(int n) {
		/**
		 * Logic:
		 * Logic is very simple - binary search
		 * 
		 * Actually git bisect command uses this concept.
		 * More read: https://tinyurl.com/git-bisect-concept
		 * 
		 * Time Complexity : O(logN)
		 * Space Complexity : O(1)
		 */
        int l = 0, h = n, mid, last=0;
        boolean response;
        while(l <= h) {
            mid = l + (h-l) /2;
            response = isBadVersion(mid);
            if(response) {
                last = mid;
                h = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return last;
    }
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASE
		getRandomBuggyVersion(5);
		System.out.println("The actual first buggy version was " + firstBuggyVersion);
		System.out.println("The program said the first buggy version was " + firstBadVersion(5));
	}

}
