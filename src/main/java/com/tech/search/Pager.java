package com.tech.search;

import lombok.Data;

@Data
public class Pager {
    public static final int DEFAULT_PAGE_NUM = 1;
    public static final int DEFAULT_PAGE_SIZE = 5;
    public static final int DEFAULT_SEARCH_RESULT_SIZE = 9;
    public static final int DEFAULT_LATEST_BLOG_NUM = 3;

    /**
     * currnet page number
     */
    private int pageNum;

    /**
     * number of pagination that should appear on the page
     */
    private int pageSize;

    /**
     * How many results should be offset.
     * This is being calculated with the currentPageNum & BlogNumSize per page.
     */
    private int offset;

    /**
     * Limit for searching query for mySQL.
     */
    private int searchMaxNum;

    public Pager(int pageNum) {
        this.pageNum = pageNum;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.offset = calculateOffset();
        this.searchMaxNum = 3 * DEFAULT_SEARCH_RESULT_SIZE;
    }

    public Pager() {
        this.pageNum = DEFAULT_PAGE_NUM;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.offset = calculateOffset();
        this.searchMaxNum = pageSize * DEFAULT_SEARCH_RESULT_SIZE;
    }

    private int calculateOffset() {
        return this.DEFAULT_SEARCH_RESULT_SIZE * (this.pageNum - 1);
    }

    public int[] getPaginationNumbers(int resultSize) {
        int lowerBound = this.pageNum - pageSize / 2;
        if (lowerBound <= 0) {
            lowerBound = 1;
        }

        int upperBound = this.pageNum + resultSize / this.pageSize;

        int[] results = new int[upperBound - lowerBound + 1];
        for (int i = lowerBound; i <= upperBound; i++) {
            results[i - lowerBound] = i;
        }

        return results;
    }

}
