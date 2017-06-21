/**
 * The Output class will assist in the sorting 
 *
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 *                              jagheterhaubir@gmail.com
 * @version JDK 1.8
 * @since JDK 1.8
 */

package com;

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