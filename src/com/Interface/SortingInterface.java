/*
 * %W% %E% Haubir Mariwani
 *
 * Version info
 * First pass 4/19/17
 *
 * Property of Fasbros IT. Do not copy, rewrite, ues or distribute without permission from
 * Fasbros IT
 * Email: contact@fasbros.it
 */

package com.Interface;

import java.util.List;

/**
 * Interface for the functionalities and duties of the sorting algorithm in this system.
 * <p>
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public interface SortingInterface<T> {

    /**
     * Adds an element to the list.
     *
     * @return true if the element was successfully added, otherwise false.
     */
    boolean addToList(T object);

    /**
     * Returns the list.
     *
     * @return The list.
     */
    List<T> getList();

    /**
     * Sorts the list according to the criteria.
     *
     * @return true if the list was successfully sorted, otherwise false.
     */
    boolean sortList();
}

