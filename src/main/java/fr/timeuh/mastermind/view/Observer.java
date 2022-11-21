package fr.timeuh.mastermind.view;

import fr.timeuh.mastermind.model.Subject;

/**
 * Observer watches for changes in the subject, and updates their content subsequently
 */
public interface Observer {

    /**
     * Update their content
     * @param subject the subject they are watching
     */
    public void update(Subject subject);
}
