package fr.paris.lutece.plugins.enroll.business.enrollment;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import fr.paris.lutece.plugins.enroll.business.ProjectFilter;
// import fr.paris.lutece.plugins.enroll.business.slot.Slot;
import fr.paris.lutece.plugins.enroll.business.user.User;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.util.sql.DAOUtil;

/**
 * This class provides Data Access methods for Enrollment objects
 *
 * @author Evan Hsia
 *
 */
public final class EnrollmentDAO implements IEnrollmentDAO
{

    private static final String SQL_QUERY_NEW_PK = "SELECT max(id_enrollment) FROM enroll_enrollment";
    private static final String SQL_QUERY_INSERT = "INSERT INTO enroll_enrollment (id_enrollment, reference, nb_places, is_cancelled, id_action_cancelled, notification, id_admin_user, id_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_QUERY_UPDATE = "UPDATE enroll_enrollment SET reference = ?, nb_places = ?, is_cancelled = ?, id_action_cancelled = ?, notification = ?, id_admin_user = ?, id_user = ? WHERE id_enrollment = ?";
    private static final String SQL_QUERY_DELETE = "DELETE FROM enroll_enrollment WHERE id_enrollment = ?";
    private static final String SQL_QUERY_SELECT_COLUMNS = "SELECT enrollment.id_enrollment, enrollment.reference, enrollment.nb_places, enrollment.is_cancelled, enrollment.id_action_cancelled, enrollment.notification, enrollment.id_admin_user, enrollment.id_user FROM enroll_enrollment enrollment";
    private static final String SQL_QUERY_SELECT = SQL_QUERY_SELECT_COLUMNS + " WHERE id_enrollment = ?";
    private static final String SQL_QUERY_SELECT_BY_ID_USER = SQL_QUERY_SELECT_COLUMNS + " WHERE id_user = ?";
    private static final String SQL_QUERY_SELECT_BY_REFERENCE = SQL_QUERY_SELECT_COLUMNS + " WHERE reference = ?";
    private static final String SQL_QUERY_SELECT_BY_FILTER = "SELECT "
            + "app.id_enrollment, app.reference, app.nb_places, app.is_cancelled, app.id_action_cancelled, app.notification, app.id_admin_user, app.id_user, "
            + "user.id_user, user.guid, user.first_name, user.last_name, user.email, user.phone_number, "
            + "FROM enroll_enrollment app " + "INNER JOIN enrollment_user user ON app.id_user = user.id_user ";

    private static final String SQL_FILTER_FIRST_NAME = "UPPER(user.first_name) LIKE ?";
    private static final String SQL_FILTER_LAST_NAME = "UPPER(user.last_name) LIKE ?";
    private static final String SQL_FILTER_EMAIL = "UPPER(user.email) LIKE ?";
    private static final String SQL_FILTER_REFERENCE = "UPPER(app.reference) LIKE ?";
    private static final String SQL_QUERY_USERID = "SELECT id_user FROM enroll_enrollment";
    private static final String SQL_QUERY_SELECTALL = "SELECT * FROM enroll_user";

    private static final String CONSTANT_AND = " AND ";
    private static final String CONSTANT_PERCENT = "%";

    /**
     * Generates a new primary key
     * @param plugin The Plugin
     * @return The new primary key
     */
    public int newPrimaryKey( Plugin plugin)
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_NEW_PK , plugin  );
        daoUtil.executeQuery( );
        int nKey = 1;

        if( daoUtil.next( ) )
        {
            nKey = daoUtil.getInt( 1 ) + 1;
        }

        daoUtil.free();
        return nKey;
    }

    @Override
    public synchronized void insert( Enrollment enrollment, Plugin plugin )
    {
        enrollment.setIdEnrollment( newPrimaryKey( plugin ) );
        DAOUtil daoUtil = buildDaoUtil( SQL_QUERY_INSERT, enrollment, plugin, true );
        executeUpdate( daoUtil );
    }

    @Override
    public void update( Enrollment enrollment, Plugin plugin )
    {
        DAOUtil daoUtil = buildDaoUtil( SQL_QUERY_UPDATE, enrollment, plugin, false );
        executeUpdate( daoUtil );
    }

    @Override
    public void delete( int nIdEnrollment, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE, plugin );
        daoUtil.setInt( 1, nIdEnrollment );
        executeUpdate( daoUtil );
    }

    @Override
    public Enrollment select( int nIdEnrollment, Plugin plugin )
    {
        DAOUtil daoUtil = null;
        Enrollment enrollment = null;
        try
        {
            daoUtil = new DAOUtil( SQL_QUERY_SELECT, plugin );
            daoUtil.setInt( 1, nIdEnrollment );
            daoUtil.executeQuery( );
            if ( daoUtil.next( ) )
            {
                enrollment = buildEnrollment( daoUtil );
            }
        }
        finally
        {
            if ( daoUtil != null )
            {
                daoUtil.free( );
            }
        }
        return enrollment;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Enrollment> selectEnrollmentsList( Plugin plugin )
    {
        List<Enrollment> listEnrollment = new ArrayList<Enrollment>(  );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT_BY_FILTER, plugin );
        // DAOUtil daoUtilUser = new DAOUtil( SQL_QUERY_USERID, plugin);
        daoUtil.executeQuery(  );

        while ( daoUtil.next(  ) )
        {
            listEnrollment.add( buildEnrollmentHeavy( daoUtil ) );
        }

        daoUtil.free( );
        return listEnrollment;
    }

    @Override
    public List<Enrollment> findByIdUser( int nIdUser, Plugin plugin )
    {
        DAOUtil daoUtil = null;
        List<Enrollment> listEnrollment = new ArrayList<>( );
        try
        {
            daoUtil = new DAOUtil( SQL_QUERY_SELECT_BY_ID_USER, plugin );
            daoUtil.setInt( 1, nIdUser );
            daoUtil.executeQuery( );
            while ( daoUtil.next( ) )
            {
                listEnrollment.add( buildEnrollment( daoUtil ) );
            }
        }
        finally
        {
            if ( daoUtil != null )
            {
                daoUtil.free( );
            }
        }
        return listEnrollment;
    }

    // @Override
    // public List<Enrollment> findByIdSlot( int nIdSlot, Plugin plugin )
    // {
    //     DAOUtil daoUtil = null;
    //     List<Enrollment> listEnrollment = new ArrayList<>( );
    //     try
    //     {
    //         daoUtil = new DAOUtil( SQL_QUERY_SELECT_BY_ID_SLOT, plugin );
    //         daoUtil.setInt( 1, nIdSlot );
    //         daoUtil.executeQuery( );
    //         while ( daoUtil.next( ) )
    //         {
    //             listEnrollment.add( buildEnrollment( daoUtil ) );
    //         }
    //     }
    //     finally
    //     {
    //         if ( daoUtil != null )
    //         {
    //             daoUtil.free( );
    //         }
    //     }
    //     return listEnrollment;
    // }

    @Override
    public Enrollment findByReference( String strReference, Plugin plugin )
    {
        DAOUtil daoUtil = null;
        Enrollment enrollment = null;
        try
        {
            daoUtil = new DAOUtil( SQL_QUERY_SELECT_BY_REFERENCE, plugin );
            daoUtil.setString( 1, strReference );
            daoUtil.executeQuery( );
            if ( daoUtil.next( ) )
            {
                enrollment = buildEnrollment( daoUtil );
            }
        }
        finally
        {
            if ( daoUtil != null )
            {
                daoUtil.free( );
            }
        }
        return enrollment;
    }

    @Override
    public List<Enrollment> findByFilter( ProjectFilter enrollmentFilter, Plugin plugin )
    {
        List<Enrollment> listEnrollment = new ArrayList<Enrollment>( );
        DAOUtil daoUtil = new DAOUtil( getSqlQueryFromFilter( enrollmentFilter ), plugin );
        addFilterParametersToDAOUtil( enrollmentFilter, daoUtil );
        daoUtil.executeQuery( );
        while ( daoUtil.next( ) )
        {
            listEnrollment.add( buildEnrollmentHeavy( daoUtil ) );
        }
        daoUtil.free( );
        return listEnrollment;
    }

    /**
     * Add all the filters to the daoUtil
     *
     * @param enrollmentFilter
     *            the filter
     * @param daoUtil
     *            the daoutil
     */
    private void addFilterParametersToDAOUtil( ProjectFilter enrollmentFilter, DAOUtil daoUtil )
    {
        int nIndex = 1;
        daoUtil.setInt( nIndex++, enrollmentFilter.getIdForm( ) );
        if ( enrollmentFilter.getFirstName( ) != null )
        {
            daoUtil.setString( nIndex++, CONSTANT_PERCENT + enrollmentFilter.getFirstName( ).toUpperCase( ) + CONSTANT_PERCENT );
        }
        if ( enrollmentFilter.getLastName( ) != null )
        {
            daoUtil.setString( nIndex++, CONSTANT_PERCENT + enrollmentFilter.getLastName( ).toUpperCase( ) + CONSTANT_PERCENT );
        }
        if ( enrollmentFilter.getEmail( ) != null )
        {
            daoUtil.setString( nIndex++, CONSTANT_PERCENT + enrollmentFilter.getEmail( ).toUpperCase( ) + CONSTANT_PERCENT );
        }
        if ( enrollmentFilter.getReference( ) != null )
        {
            daoUtil.setString( nIndex++, CONSTANT_PERCENT + enrollmentFilter.getReference( ).toUpperCase( ) + CONSTANT_PERCENT );
        }
        // if ( enrollmentFilter.getStartingDateOfSearch( ) != null )
        // {
        //     Timestamp startingTimestamp;
        //     if ( StringUtils.isNotEmpty( enrollmentFilter.getStartingTimeOfSearch( ) ) )
        //     {
        //         startingTimestamp = Timestamp.valueOf( enrollmentFilter.getStartingDateOfSearch( ).toLocalDate( )
        //                 .atTime( LocalTime.parse( enrollmentFilter.getStartingTimeOfSearch( ) ) ) );
        //     }
        //     else
        //     {
        //         startingTimestamp = Timestamp.valueOf( enrollmentFilter.getStartingDateOfSearch( ).toLocalDate( ).atStartOfDay( ) );
        //     }
        //     daoUtil.setTimestamp( nIndex++, startingTimestamp );
        // }
        // if ( enrollmentFilter.getEndingDateOfSearch( ) != null )
        // {
        //     Timestamp endingTimestamp;
        //     if ( StringUtils.isNotEmpty( enrollmentFilter.getEndingTimeOfSearch( ) ) )
        //     {
        //         endingTimestamp = Timestamp.valueOf( enrollmentFilter.getEndingDateOfSearch( ).toLocalDate( )
        //                 .atTime( LocalTime.parse( enrollmentFilter.getEndingTimeOfSearch( ) ) ) );
        //     }
        //     else
        //     {
        //         endingTimestamp = Timestamp.valueOf( enrollmentFilter.getEndingDateOfSearch( ).toLocalDate( ).atTime( LocalTime.MAX ) );
        //     }
        //     daoUtil.setTimestamp( nIndex++, endingTimestamp );
        // }
    }

    /**
     * Build the sql query with the elements of the filter
     *
     * @param enrollmentFilter
     *            the filter
     * @return the query
     */
    private String getSqlQueryFromFilter( ProjectFilter enrollmentFilter )
    {
        StringBuilder sbSql = new StringBuilder( SQL_QUERY_SELECT_BY_FILTER );
        if ( enrollmentFilter.getFirstName( ) != null )
        {
            sbSql.append( CONSTANT_AND );
            sbSql.append( SQL_FILTER_FIRST_NAME );
        }
        if ( enrollmentFilter.getLastName( ) != null )
        {
            sbSql.append( CONSTANT_AND );
            sbSql.append( SQL_FILTER_LAST_NAME );
        }
        if ( enrollmentFilter.getEmail( ) != null )
        {
            sbSql.append( CONSTANT_AND );
            sbSql.append( SQL_FILTER_EMAIL );
        }
        if ( enrollmentFilter.getReference( ) != null )
        {
            sbSql.append( CONSTANT_AND );
            sbSql.append( SQL_FILTER_REFERENCE );
        }
        // if ( enrollmentFilter.getStartingDateOfSearch( ) != null )
        // {
        //     sbSql.append( CONSTANT_AND );
        //     sbSql.append( SQL_FILTER_DATE_APPOINTMENT_MIN );
        // }
        // if ( enrollmentFilter.getEndingDateOfSearch( ) != null )
        // {
        //     sbSql.append( CONSTANT_AND );
        //     sbSql.append( SQL_FILTER_DATE_APPOINTMENT_MAX );
        // }
        return sbSql.toString( );
    }

    // @Override
    // public List<Enrollment> findByIdForm( int nIdForm, Plugin plugin )
    // {
    //     DAOUtil daoUtil = null;
    //     List<Enrollment> listEnrollment = new ArrayList<>( );
    //     try
    //     {
    //         daoUtil = new DAOUtil( SQL_QUERY_SELECT_BY_ID_FORM, plugin );
    //         daoUtil.setInt( 1, nIdForm );
    //         daoUtil.executeQuery( );
    //         while ( daoUtil.next( ) )
    //         {
    //             listEnrollment.add( buildEnrollment( daoUtil ) );
    //         }
    //     }
    //     finally
    //     {
    //         if ( daoUtil != null )
    //         {
    //             daoUtil.free( );
    //         }
    //     }
    //     return listEnrollment;
    // }

    /**
     * Build an Enrollment business object from the resultset
     *
     * @param daoUtil
     *            the prepare statement util object
     * @return a new Enrollment business object with all its attributes assigned
     */
    private Enrollment buildEnrollment( DAOUtil daoUtil )
    {
        int nIndex = 1;
        Enrollment enrollment = new Enrollment( );
        enrollment.setIdEnrollment( daoUtil.getInt( nIndex++ ) );
        enrollment.setReference( daoUtil.getString( nIndex++ ) );
        enrollment.setNbPlaces( daoUtil.getInt( nIndex++ ) );
        enrollment.setIsCancelled( daoUtil.getBoolean( nIndex++ ) );
        enrollment.setIdActionCancelled( daoUtil.getInt( nIndex++ ) );
        enrollment.setNotification( daoUtil.getInt( nIndex++ ) );
        enrollment.setIdAdminUser( daoUtil.getInt( nIndex++ ) );
        enrollment.setIdUser( daoUtil.getInt( nIndex++ ) );
        // enrollment.setIdSlot( daoUtil.getInt( nIndex ) );
        return enrollment;
    }

    /**
     * Build an enrollment business object with its complete slot and its complete user
     *
     * @param daoUtil
     *            the daoutil
     * @return the enrollment
     */
    private Enrollment buildEnrollmentHeavy( DAOUtil daoUtil )
    {
        int nIndex = 1;
        Enrollment enrollment = new Enrollment( );
        enrollment.setIdEnrollment( daoUtil.getInt( nIndex++ ) );
        enrollment.setReference( daoUtil.getString( nIndex++ ) );
        enrollment.setNbPlaces( daoUtil.getInt( nIndex++ ) );
        enrollment.setIsCancelled( daoUtil.getBoolean( nIndex++ ) );
        enrollment.setIdActionCancelled( daoUtil.getInt( nIndex++ ) );
        enrollment.setNotification( daoUtil.getInt( nIndex++ ) );
        enrollment.setIdAdminUser( daoUtil.getInt( nIndex++ ) );
        enrollment.setIdUser( daoUtil.getInt( nIndex++ ) );
        // enrollment.setIdSlot( daoUtil.getInt( nIndex++ ) );
        User user = new User( );
        user.setIdUser( daoUtil.getInt( nIndex++ ) );
        user.setGuid( daoUtil.getString( nIndex++ ) );
        user.setFirstName( daoUtil.getString( nIndex++ ) );
        user.setLastName( daoUtil.getString( nIndex++ ) );
        user.setEmail( daoUtil.getString( nIndex++ ) );
        user.setPhoneNumber( daoUtil.getString( nIndex++ ) );
        enrollment.setUser( user );
        return enrollment;
    }

    /**
     * Build a daoUtil object with the query and all the attributes of the Enrollment
     *
     * @param suery
     *            the query
     * @param enrollment
     *            the Enrollment
     * @param plugin
     *            the plugin
     * @param isInsert
     *            true if it is an insert query (in this case, need to set the id). If false, it is an update, in this case, there is a where parameter id to
     *            set
     * @return a new daoUtil with all its values assigned
     */
    private DAOUtil buildDaoUtil( String query, Enrollment enrollment, Plugin plugin, boolean isInsert )
    {
        int nIndex = 1;
        DAOUtil daoUtil = new DAOUtil( query, plugin );
        if ( isInsert )
        {
            daoUtil.setInt( nIndex++, enrollment.getIdEnrollment( ) );
        }
        daoUtil.setString( nIndex++, enrollment.getReference( ) );
        daoUtil.setInt( nIndex++, enrollment.getNbPlaces( ) );
        daoUtil.setBoolean( nIndex++, enrollment.getIsCancelled( ) );
        daoUtil.setInt( nIndex++, enrollment.getIdActionCancelled( ) );
        daoUtil.setInt( nIndex++, enrollment.getNotification( ) );
        daoUtil.setInt( nIndex++, enrollment.getIdAdminUser( ) );
        daoUtil.setInt( nIndex++, enrollment.getIdUser( ) );
        // daoUtil.setInt( nIndex++, enrollment.getIdSlot( ) );
        if ( !isInsert )
        {
            daoUtil.setInt( nIndex, enrollment.getIdEnrollment( ) );
        }
        return daoUtil;
    }

    /**
     * Execute a safe update (Free the connection in case of error when execute the query)
     *
     * @param daoUtil
     *            the daoUtil
     */
    private void executeUpdate( DAOUtil daoUtil )
    {
        try
        {
            daoUtil.executeUpdate( );
        }
        finally
        {
            if ( daoUtil != null )
            {
                daoUtil.free( );
            }
        }
    }

}
