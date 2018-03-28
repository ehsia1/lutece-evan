package fr.paris.lutece.plugins.enroll.business.enrollment;

import java.io.Serializable;

// import fr.paris.lutece.plugins.enroll.business.slot.Slot;
import fr.paris.lutece.plugins.enroll.business.user.User;

/**
 * Business class of the Enrollment
 *
 * @author Evan Hsia
 *
 */
public class Enrollment extends User implements Serializable
{

    /**
     * enrollment resource type
     */
    public static final String ENROLLMENT_RESOURCE_TYPE = "enrollment";

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = -132212832777629802L;

    /**
     * enrollment Id
     */
    private int _nIdEnrollment;

    /**
     * Reference of the enrollment
     */
    private String _strReference;

    /**
     * Number of places for the enrollment
     */
    private int _nNbPlaces;
    /**
     * Tell if the enrollment is cancelled or not
     */
    private boolean _bIsCancelled;

    /**
     * Id for a cancelled enrollment
     */
    private int _nIdActionCancelled;

    /**
     * The rank for the notification (0 : no notification)
     */
    private int _notification;

    /**
     * The Admin User Id
     */
    private int _nIdAdminUser;

    /**
     * User id
     */
    private int _nIdUser;

    // /**
    //  * Slot id
    //  */
    // private int _nIdSlot;

    // /**
    //  * The slot on which the enrollment is
    //  */
    // private Slot _slot;

    /**
     * The user of the enrollment
     */
    private User _user;

    /**
     * Get the reference of the enrollment
     *
     * @return the reference
     */
    public String getReference( )
    {
        return _strReference;
    }

    /**
     * Set the reference of the enrollment
     *
     * @param strReference
     *            the reference to set
     */
    public void setReference( String strReference )
    {
        this._strReference = strReference;
    }

    /**
     * Get the number of places of the enrollment
     *
     * @return the number of places
     */
    public int getNbPlaces( )
    {
        return _nNbPlaces;
    }

    /**
     * Set the number of places for the enrollment
     *
     * @param nNbPlaces
     *            the number of places to set
     */
    public void setNbPlaces( int nNbPlaces )
    {
        this._nNbPlaces = nNbPlaces;
    }

    /**
     * Get if the enrollment is cancelled
     *
     * @return true if the enrollment is cancelled
     */
    public boolean getIsCancelled( )
    {
        return _bIsCancelled;
    }

    /**
     * Set if the enrollment is cancelled
     *
     * @param bIsCancelled
     *            the boolean value to set
     */
    public void setIsCancelled( boolean bIsCancelled )
    {
        this._bIsCancelled = bIsCancelled;
    }

    /**
     * Get the id for the cancelled enrollment
     *
     * @return the id
     */
    public int getIdActionCancelled( )
    {
        return _nIdActionCancelled;
    }

    /**
     * Set the id for the cancelled action
     *
     * @param nIdActionCancelled
     *            the id to set
     */
    public void setIdActionCancelled( int nIdActionCancelled )
    {
        this._nIdActionCancelled = nIdActionCancelled;
    }

    /**
     * Get the rank for the notification (0 = no notification)
     *
     * @return the rank
     */
    public int getNotification( )
    {
        return _notification;
    }

    /**
     * Set the rank for the notification
     *
     * @param notification
     *            the rank (default : 0, no notification)
     */
    public void setNotification( int notification )
    {
        this._notification = notification;
    }

    /**
     * Get the enrollment Id
     *
     * @return the enrollment Id
     */
    public int getIdEnrollment( )
    {
        return _nIdEnrollment;
    }

    /**
     * Set the enrollment Id
     *
     * @param nIdEnrollment
     *            the enrollment Id to set
     */
    public void setIdEnrollment( int nIdEnrollment )
    {
        this._nIdEnrollment = nIdEnrollment;
    }

    /**
     * Get the User Id of the enrollment
     *
     * @return the User Id of the enrollment
     */
    public int getIdUser( )
    {
        return _nIdUser;
    }

    /**
     * Set the User Id of the enrollment
     *
     * @param nIdUser
     *            the User Id of the enrollment
     */
    public void setIdUser( int nIdUser )
    {
        this._nIdUser = nIdUser;
    }

    public int getIdAdminUser( )
    {
        return _nIdAdminUser;
    }

    public void setIdAdminUser( int nIdAdminUser )
    {
        this._nIdAdminUser = nIdAdminUser;
    }

    // /**
    //  * Get the Slot Id of the enrollment
    //  *
    //  * @return the Slot Id of the enrollment
    //  */
    // public int getIdSlot( )
    // {
    //     return _nIdSlot;
    // }

    // /**
    //  * Set the Slot Id of the enrollment
    //  *
    //  * @param nIdSlot
    //  *            the Slot Id of the enrollment
    //  */
    // public void setIdSlot( int nIdSlot )
    // {
    //     this._nIdSlot = nIdSlot;
    // }

    // /**
    //  * Get the slot of the enrollment
    //  *
    //  * @return the slot
    //  */
    // public Slot getSlot( )
    // {
    //     return _slot;
    // }

    // /**
    //  * Set the slot of the enrollment
    //  *
    //  * @param slot
    //  *            the slot to set
    //  */
    // public void setSlot( Slot slot )
    // {
    //     this._slot = slot;
    // }

    /**
     * Get the user of the enrollment
     *
     * @return the user
     */
    public User getUser( )
    {
        return _user;
    }

    /**
     * Set the user of the enrollment
     *
     * @param user
     *            the user
     */
    public void setUser( User user )
    {
        this._user = user;
    }

}
