package ru.pavelnix.start;

import ru.pavelnix.models.Comment;
import ru.pavelnix.models.Item;

/**
 *
 */
public interface Track {
    /**
     * add the proposal to the tracker
     *
     * @param item - proposal
     */
    void add(Item item);

    /**
     * add the comment to the proposal
     *
     * @param comment - comment
     */
    void add(Comment comment);

    /**
     * update the proposal in the tracker
     *
     * @param item - proposal
     */
    void update(Item item);

    /**
     * delete the proposal from the tracker
     *
     * @param id - proposal
     */
    void delete(String id);

    /**
     * Get proposal from the tracker
     *
     * @param id - identifier
     * @return proposal
     */
    Item getById(String id);

    /**
     * Get all proposal from the tracker
     *
     * @return all proposal
     */
    Item[] getAll();

    /**
     * Find the proposal by the filter
     *
     * @param filter - class Filter
     * @return proposal
     */
    Item[] findByKey(Filter filter);
}


