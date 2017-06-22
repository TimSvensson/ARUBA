package com;/*
 * Project: ARUBA 
 * Class:   com.Output
 *
 * Version info
 * Created: 4/26/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

import com.Debug.Debugger;
import com.Sorting.SortList;
import com.TravelRoutes;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class Output {
    private SortList sortList;
    //private Debugger debugger;
    private String JSONrepresentation;

    public Output(List<TravelRoutes> travelRoutes/*, Debugger debugger*/) {
        (this.sortList = new SortList(travelRoutes)).sortList();
        //this.debugger = debugger;
    }

    public SortList getSortList() {
        return sortList;
    }

    public void setSortList(SortList sortList) {
        this.sortList = sortList;
    }

    public void setSortList(List<TravelRoutes> travelRoutes) {
        (this.sortList = new SortList(travelRoutes)).sortList();
    }

    /*
    public Debugger getDebugger() {
        return debugger;
    }

    public void setDebugger(Debugger debugger) {
        this.debugger = debugger;
    }
    */

    public String getJSONrepresentation() {
        return new Gson().toJson(this);
    }
}