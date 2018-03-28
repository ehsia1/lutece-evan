package fr.paris.lutece.plugins.enroll.business.enrollment;

import java.util.List;

import fr.paris.lutece.plugins.enroll.business.ProjectFilter;
import fr.paris.lutece.portal.service.plugin.Plugin;

/**
 * Enrollment DAO Interface
 *
 * @author Evan Hsia
 *
 */
public interface IEnrollmentDAO
{

    /**
     * The name of the bean of the DAO
     */
    static String BEAN_NAME = "enrollment.enrollmentDAO";

    /**
     * Insert a new record in the table
     *
     * @param enrollment
     *            instance of the enrollment object to insert
     * @param plugin
     *            the plugin
     */
    void insert( Enrollment enrollment, Plugin plugin );

    /**
     * Update the record in the table
     *
     * @param enrollment
     *            the reference of the enrollment
     * @param plugin
     *            the plugin
     */
    void update( Enrollment enrollment, Plugin plugin );

    /**
     * Delete a record from the table
     *
     * @param nIdEnrollment
     *            int identifier of the enrollment to delete
     * @param plugin
     *            the plugin
     */
    void delete( int nIdEnrollment, Plugin plugin );

    /**
     * Load the data from the table
     *
     * @param nIdEnrollment
     *            the identifier of the enrollment
     * @param plugin
     *            the plugin
     * @return the instance of the enrollment
     */
    Enrollment select( int nIdEnrollment, Plugin plugin );

    /**
     * Load the data of all the project objects and returns them as a list
     * @param plugin the Plugin
     * @return The list which contains the data of all the project objects
     */
    List<Enrollment> selectEnrollmentsList( Plugin plugin );

    /**
     * Returns all the enrollments of a user
     *
     * @param nIdUser
     *            the User Id
     * @param plugin
     *            the Plugin
     * @return a list of the enrollments of the user
     */
    List<Enrollment> findByIdUser( int nIdUser, Plugin plugin );

    // /**
    //  * Returns the enrollments of a slot
    //  *
    //  * @param nIdSlot
    //  *            the Slot Id
    //  * @param plugin
    //  *            the plugin
    //  * @return a list of the enrollments
    //  */
    // List<Enrollment> findByIdSlot( int nIdSlot, Plugin plugin );

    /**
     * Returns the enrollment with its reference
     *
     * @param strReference
     *            the enrollment reference
     * @param plugin
     *            the plugin
     * @return the enrollment
     */
    Enrollment findByReference( String strReference, Plugin plugin );

    // /**
    //  * Returns a list of all the enrollment of a form
    //  *
    //  * @param nIdForm
    //  *            the form id
    //  * @param plugin
    //  *            the plugin
    //  * @return a list of the enrollments
    //  */
    // List<Enrollment> findByIdForm( int nIdForm, Plugin plugin );

    /**
     * Returns a list of enrollments matching the filter
     *
     * @param enrollmentFilter
     *            the filter
     * @param plugin
     *            the plugin
     * @return a list of enrollments
     */
    List<Enrollment> findByFilter( ProjectFilter enrollmentFilter, Plugin plugin );
}
