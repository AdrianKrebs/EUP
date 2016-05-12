

package org.mobi.bluemoon.ui;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import org.mobi.bluemoon.R;

/**
 * Pager adapter
 */
public class BootstrapPagerAdapter extends FragmentPagerAdapter {

    private final Resources resources;

    /**
     * Create pager adapter
     *
     * @param resources
     * @param fragmentManager
     */
    public BootstrapPagerAdapter(final Resources resources, final FragmentManager fragmentManager) {
        super(fragmentManager);
        this.resources = resources;
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Fragment getItem(final int position) {
        final Fragment result;
        switch (position) {
            case 0:
                result = new OverviewFragment();
                break;
            case 1:
                result = new DateFragment();
                break;
            case 2:
                result = new MapFragment();
                break;
            case 3:
                result = new DetailsFragment();
                break;
            case 4:
                result = new ElevationDragFragment();
                break;
            case 5:
                result = new PictureFragment();
                break;
            case 6:
                result = new DrawingFragment();
                break;
            case 7:
                result = new SignatureFragment();
                break;
            default:
                result = null;
                break;
        }
        if (result != null) {
            result.setArguments(new Bundle()); //TODO do we need this?
        }
        return result;
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        switch (position) {
            case 0:
                return resources.getString(R.string.home);
            case 1:
                return resources.getString(R.string.page_date);
            case 2:
                return resources.getString(R.string.location);
            case 3:
                return resources.getString(R.string.page_details);
            case 4:
                return resources.getString(R.string.page_sketch);
            case 5:
                return "Bilder";
            case 6:
                return resources.getString(R.string.page_drawing);
            case 7:
                return resources.getString(R.string.page_signature);

            default:
                return null;
        }
    }
}
