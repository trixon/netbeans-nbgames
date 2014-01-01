package org.nbgames.yaya.gamedef;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ResourceBundle;
import org.nbgames.yaya.YayaAction;
import org.openide.util.NbBundle;

/**
 *
 * @author Patrik Karlsson <patrik@trixon.se>
 */
public class GameType {

    public static Comparator<GameType> NameComparator = new Comparator<GameType>() {

        @Override
        public int compare(GameType type1, GameType type2) {

            return type1.getTitle().compareTo(type2.getTitle());
        }

    };
    public static final String VARIANT = "Variant.";
    public static final String VARIANT_ASCENDING = "ascending";
    public static final String VARIANT_DESCENDING = "descending";
    public static final String VARIANT_LOWER_UPPER = "lower_upper";
    public static final String VARIANT_RANDOM = "random";
    public static final String VARIANT_STANDARD = "standard";
    public static final String VARIANT_UPPER_LOWER = "upper_lower";
    private String mAuthor;
    private final ResourceBundle mBundle = NbBundle.getBundle(YayaAction.class);
    private int mDefaultVariant;
    private String mId;
    private String[] mLocalizedVariants;
    private int mNumOfDice;
    private int mNumOfRolls;
    private int mResultRow;
    private LinkedList<GameRow> mRows = new LinkedList<GameRow>();
    private String mTitle;
    private String[] mVariants;
    private String mVersionDate;
    private String mVersionName;

    public String dump() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getId()).append("\n");
        stringBuilder.append(getTitle()).append("\n");
        stringBuilder.append(getAuthor()).append("\n");
        stringBuilder.append(getDefaultVariant()).append("\n");
        stringBuilder.append(getVersionDate()).append("\n");
        stringBuilder.append(getVersionName()).append("\n");
        stringBuilder.append("resultRow ").append(getResultRow()).append("\n");
        stringBuilder.append("numOfDice ").append(getNumOfDice()).append("\n");
        stringBuilder.append("numOfRolls ").append(getNumOfRolls()).append("\n");

        for (GameRow row : getRows()) {
            stringBuilder.append(row.dump()).append("\n");
        }

        return stringBuilder.toString();
    }

    public String getAuthor() {
        return mAuthor;
    }

    public int getDefaultVariant() {
        return mDefaultVariant;
    }

    public String getId() {
        return mId;
    }

    public int getLocalizedIndexForVariantId(String id) {
        int index = -1;
        String[] localizedVariants = mLocalizedVariants.clone();
        Arrays.sort(localizedVariants);
        String localizedVariant = mBundle.getString(GameType.VARIANT + id);

        for (int i = 0; i < localizedVariants.length; i++) {
            if (localizedVariant.equalsIgnoreCase(localizedVariants[i])) {
                index = i;
                break;
            }
        }

        return index;
    }

    public String[] getLocalizedVariants() {
        return mLocalizedVariants;
    }

    public int getNumOfDice() {
        return mNumOfDice;
    }

    public int getNumOfRolls() {
        return mNumOfRolls;
    }

    public int getResultRow() {
        return mResultRow;
    }

    public LinkedList<GameRow> getRows() {
        return mRows;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getVariantByTitle(String title) {
        String result = "standard";

        for (int i = 0; i < mLocalizedVariants.length; i++) {
            if (mLocalizedVariants[i].equalsIgnoreCase(title)) {
                result = mVariants[i];
                break;
            }
        }

        return result;
    }

    public String[] getVariants() {
        return mVariants;
    }

    public String getVersionDate() {
        return mVersionDate;
    }

    public String getVersionName() {
        return mVersionName;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public void setDefaultVariant(int defaultVariant) {
        mDefaultVariant = defaultVariant;
    }

    public void setId(String id) {
        mId = id;
    }

    public void setNumOfDice(int numOfDice) {
        mNumOfDice = numOfDice;
    }

    public void setNumOfRolls(int numOfRolls) {
        mNumOfRolls = numOfRolls;
    }

    public void setResultRow(int resultRow) {
        mResultRow = resultRow;
    }

    public void setRows(LinkedList<GameRow> rows) {
        mRows = rows;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setVariants(String variants) {
        mVariants = variants.split(" ");
        updateLocalizedVariants();
    }

    public void setVariants(String[] variants) {
        mVariants = variants;
        updateLocalizedVariants();
    }

    public void setVersionDate(String versionDate) {
        mVersionDate = versionDate;
    }

    public void setVersionName(String versionName) {
        mVersionName = versionName;
    }

    private void updateLocalizedVariants() {
        mLocalizedVariants = new String[mVariants.length];

        for (int i = 0; i < mVariants.length; i++) {
            mLocalizedVariants[i] = mBundle.getString(GameType.VARIANT + mVariants[i]);
        }
    }
}
