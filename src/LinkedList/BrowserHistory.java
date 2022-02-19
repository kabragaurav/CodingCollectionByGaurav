/**
 * You have a browser of one tab where you start on the homepage and you can visit another url,
 * get back in the history number
 * of steps or move forward in the history number of steps.
 *
 * Implement the BrowserHistory class:
 *
 *     BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 *
 *     void visit(string url) Visits url from the current page. It clears up all the forward
 *     history.
 *
 *     string back(int steps) Move steps back in history. If you can only return x steps in
 *     the history and steps > x, you will return only x steps. Return the current url after
 *     moving back in history at most steps.
 *
 *     string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
 */
package LinkedList;

/**
 * @author gkabra
 * @since 19-02-2022 Sat
 **/

public class BrowserHistory {

    private static class LL {
        String url;
        LL next;
        LL prev;

        LL(String url) {
            this.url = url;
        }
    }

    LL curr;

    public BrowserHistory(String homepage) {
        curr = new LL(homepage);
    }

    public void visit(String url) {
        LL newVisit = new LL(url);
        curr.next = newVisit;
        newVisit.prev = curr;
        this.curr = newVisit;
    }

    public String back(int steps) {
        while(steps != 0) {
            if(this.curr.prev == null) {
                break;
            }
            this.curr = this.curr.prev;
            steps--;
        }
        return this.curr.url;
    }

    public String forward(int steps) {
        while(steps != 0) {
            if(this.curr.next == null) {
                break;
            }
            this.curr = this.curr.next;
            steps--;
        }
        return this.curr.url;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        BrowserHistory browserHistory = new BrowserHistory("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("utube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));

    }

}
