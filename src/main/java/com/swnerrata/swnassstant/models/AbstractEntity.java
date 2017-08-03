package com.swnerrata.swnassstant.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by seanburk on 7/27/17.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int uid;

    private boolean approved = false;

    private boolean ancestor = false;

    private int uidToEdit;

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isAncestor() {
        return ancestor;
    }

    public void setAncestor(boolean ancestor) {
        this.ancestor = ancestor;
    }

    public int getUidToEdit() {
        return uidToEdit;
    }

    public void setUidToEdit(int uidToEdit) {
        this.uidToEdit = uidToEdit;
    }
}
