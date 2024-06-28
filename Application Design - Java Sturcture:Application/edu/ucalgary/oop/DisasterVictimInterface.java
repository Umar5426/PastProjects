package edu.ucalgary.oop;

import java.util.Set;

public interface DisasterVictimInterface {
    /**
     * Sets basic information for the DisasterVictim using date of birth.
     * 
     * @param firstName   the first name of the victim
     * @param lastName    the last name of the victim
     * @param dateOfBirth the date of birth of the victim
     * @param gender      the gender of the victim
     * @param comments    additional comments about the victim
     */
    void setBasicInfoUsingDateofBirth(String firstName, String lastName, String dateOfBirth, String gender, String comments);

    /**
     * Sets basic information for the DisasterVictim using age.
     * 
     * @param firstName the first name of the victim
     * @param lastName  the last name of the victim
     * @param age       the age of the victim
     * @param gender    the gender of the victim
     * @param comments  additional comments about the victim
     */
    void setBasicInfoUsingAge(String firstName, String lastName, Integer age, String gender, String comments);

    /**
     * Sets dietary restrictions for the DisasterVictim.
     * 
     * @param dietaryRestrictions the set of dietary restrictions to be set
     */
    void setDietaryRestrictions(Set<DisasterVictim.DietaryRestriction> dietaryRestrictions);

    /**
     * Gets the basic information of the DisasterVictim.
     * 
     * @return a string containing the basic information of the victim
     */
    String getBasicInfo();

    /**
     * Gets the basic information of the DisasterVictim with date of birth.
     * 
     * @return a string containing the basic information of the victim along with the date of birth
     */
    String getBasicInfoWithDateofBirth();

    /**
     * Gets the basic information of the DisasterVictim with age.
     * 
     * @return a string containing the basic information of the victim along with the age
     */
    String getBasicInfoWithAge();

    /**
     * Gets the dietary restrictions of the DisasterVictim.
     * 
     * @return the set of dietary restrictions of the victim
     */
    Set<DisasterVictim.DietaryRestriction> getDietaryRestrictions();
}
