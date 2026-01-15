/*
* “Page Count problem” usually refers to the Drawing Book problem (popular on HackerRank).

Problem in simple words:

You have a book with n pages.
You want to reach page p.

You can:

Flip pages from the front (page 1 → 2 → 3 …), or

Flip pages from the back (page n → n-1 → n-2 …)

Each flip turns one sheet = two pages.

Find the minimum number of page flips needed to reach page p.
*
* */

import geektrust.cricket.tie.breaker.Match;

public class PageCounter {

    // frontFlips = p / 2
    // backFlips = (n / 2) - (p / 2)
    // min(frontFlips, backFlips)
    public static int pages(int totalPages, int pageSeek){
        return Math.min(pageSeek/2, (totalPages/2)-(pageSeek/2));
    }

    public static void main(String[] args) {
        System.out.println(pages(6,2));
    }
}
