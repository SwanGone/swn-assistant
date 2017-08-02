package com.swnerrata.swnassstant.models;

/**
 * Created by seanburk on 8/1/17.
 */
public class ChangeStager {

    private Object original;

    private Object proposedChange;

    private boolean approved;

    public Object getOriginal() {
        return original;
    }

    public void setOriginal(Object original) {
        this.original = original;
    }

    public Object getProposedChange() {
        return proposedChange;
    }

    public void setProposedChange(Object proposedChange) {
        this.proposedChange = proposedChange;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
