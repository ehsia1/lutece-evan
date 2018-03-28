package fr.paris.lutece.plugins.enroll.business.enrollment;

import java.util.List;

import fr.paris.lutece.plugins.enroll.business.ProjectFilter;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;

/**
 * This class provides instances management methods for Enrollment objects
 *
 * @author Evan Hsia
 *
 */
public final class EnrollmentHome
{

    // Static variable pointed at the DAO instance
    private static IEnrollmentDAO _dao = SpringContextService.getBean( IEnrollmentDAO.BEAN_NAME );
    private static Plugin _plugin = PluginService.getPlugin( "enroll" );

    /**
     * Private constructor - this class does not need to be instantiated
     */
    private EnrollmentHome( )
    {
    }

    /**
     * Create an instance of the Enrollment class
     *
     * @param enrollment
     *            The instance of the Enrollment which contains the informations to store
     * @return The instance of the Enrollment which has been created with its primary key.
     */
    public static Enrollment create( Enrollment enrollment )
    {
        _dao.insert( enrollment, _plugin );

        return enrollment;
    }

    /**
     * Update of the Enrollment which is specified in parameter
     *
     * @param enrollment
     *            The instance of the Enrollment which contains the data to store
     * @return The instance of the Enrollment which has been updated
     */
    public static Enrollment update( Enrollment enrollment )
    {
        _dao.update( enrollment, _plugin );

        return enrollment;
    }

    /**
     * Delete the Enrollment whose identifier is specified in parameter
     *
     * @param nKey
     *            The enrollment Id
     */
    public static void delete( int nKey )
    {
        _dao.delete( nKey, _plugin );
    }

    /**
     * Load the data of all the project objects and returns them as a list
     * @return the list which contains the data of all the project objects
     */
    public static List<Enrollment> getEnrollmentsList( )
    {
        return _dao.selectEnrollmentsList( _plugin );
    }

    /**
     * Return an instance of the Enrollment whose identifier is specified in parameter
     *
     * @param nKey
     *            The Enrollment primary key
     * @return an instance of the Enrollment
     */
    public static Enrollment findByPrimaryKey( int nKey )
    {
        return _dao.select( nKey, _plugin );
    }

    /**
     * Return an instance of the Enrollment whose reference is specified in parameter
     *
     * @param strReference
     *            The Enrollment reference
     * @return an instance of the Enrollment
     */
    public static Enrollment findByReference( String strReference )
    {
        return _dao.findByReference( strReference, _plugin );
    }

    /**
     * Return the enrollments of a user
     *
     * @param nIdUser
     *            the User Id
     * @return a list of the user enrollments
     */
    public static List<Enrollment> findByIdUser( int nIdUser )
    {
        return _dao.findByIdUser( nIdUser, _plugin );
    }

    // /**
    //  * Return the enrollments of a slot
    //  *
    //  * @param nIdSlot
    //  * @return a list of the enrollments of the slot
    //  */
    // public static List<Enrollment> findByIdSlot( int nIdSlot )
    // {
    //     return _dao.findByIdSlot( nIdSlot, _plugin );
    // }

    // /**
    //  * Return a list of enrollment of a form
    //  *
    //  * @param nIdForm
    //  *            the form id
    //  * @return the list of the enrollments
    //  */
    // public static List<Enrollment> findByIdForm( int nIdForm )
    // {
    //     return _dao.findByIdForm( nIdForm, _plugin );
    // }

    /**
     * Returns a list of enrollment matching the filter
     *
     * @param enrollmentFilter
     *            the filter
     * @return a list of enrollments
     */
    public static List<Enrollment> findByFilter( ProjectFilter enrollmentFilter )
    {
        return _dao.findByFilter( enrollmentFilter, _plugin );
    }
}
