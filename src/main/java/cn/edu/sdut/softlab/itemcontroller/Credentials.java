/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.itemcontroller;

import javax.inject.Named;

/**
 *
 * @author gaoziqiang
 */
@Named("credentials")
public class Credentials {

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
