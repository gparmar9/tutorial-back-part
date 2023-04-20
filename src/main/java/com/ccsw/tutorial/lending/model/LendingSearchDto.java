package com.ccsw.tutorial.lending.model;

import org.springframework.data.domain.Pageable;

/**
 * @author ccsw
 */
public class LendingSearchDto {

    private Pageable pageable;

    /**
     * @return pageable
     */
    public Pageable getPageable() {

        return this.pageable;
    }

    /**
     * @param pageable new value of {@link #getPageable}.
     */
    public void setPageable(Pageable pageable) {

        this.pageable = pageable;
    }

}
