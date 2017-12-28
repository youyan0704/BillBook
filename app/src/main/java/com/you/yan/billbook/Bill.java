package com.you.yan.billbook;

import org.w3c.dom.Text;

import java.util.Date;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Yan on 2017/12/27.
 */

@Entity
public class Bill {
    @Id
    long id;

    String typeName;
    String typeIcon;
    boolean in; //收入或支出
    double money;
    String comment;
    Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(String typeIcon) {
        this.typeIcon = typeIcon;
    }

    public boolean isIn() {
        return in;
    }

    public void setIn(boolean in) {
        this.in = in;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
