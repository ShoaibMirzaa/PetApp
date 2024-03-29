package com.example.android.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
/*
* This is a Class in which we have define the structure of our database.
i.e. how many Columns we want in our database with the Column name defined below.
* This contains all the constant value in the database.
*/

public class petContract {

    // give it an empty constructor.
    private petContract(){};

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.pets";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_PETS = "pets";




    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static abstract class petEntry implements BaseColumns{

        /** The content URI to access the pet data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);


        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;


        //Name of the Database Table for pets.
         public static final String TABLE_NAME = "pets";

        //Name of the columns that the Table will have.
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_BREED = "breed";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String COLUMN_GENDER = "gender";

        //Possible value for gender of the pet
        public static final int MALE = 1;
        public static final int FEMALE = 2;
        public static final int UNKNOWN = 0;

        /**
         * Returns whether or not the given gender is {@link #UNKNOWN}, {@link #MALE},
         * or {@link #FEMALE}.
         */
        public static boolean isValidGender(int gender) {
            if (gender == UNKNOWN || gender == MALE || gender == FEMALE) {
                return true;
            }
            return false;
        }

    }


}
