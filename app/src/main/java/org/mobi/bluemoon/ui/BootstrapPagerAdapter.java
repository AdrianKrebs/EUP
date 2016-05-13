

package org.mobi.bluemoon.ui;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import org.mobi.bluemoon.R;
import org.mobi.bluemoon.ui.view.fragments.DateFragment;
import org.mobi.bluemoon.ui.view.fragments.DetailsFragment;
import org.mobi.bluemoon.ui.view.fragments.DrawingFragment;
import org.mobi.bluemoon.ui.view.fragments.FahrzeugFragment;
import org.mobi.bluemoon.ui.view.fragments.FinishFragment;
import org.mobi.bluemoon.ui.view.fragments.MapFragment;
import org.mobi.bluemoon.ui.view.fragments.SignatureFragment;
import org.mobi.bluemoon.ui.view.fragments.UmstaendeFragment;
import org.mobi.bluemoon.ui.view.fragments.VerischerungsunternehmenFragment;

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
        return 13;
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
                result = new FahrzeugFragment();
                break;
            case 5:
                result = new VerischerungsunternehmenFragment();
                break;
            case 6:
                result = new ElevationDragFragment();
                break;
            case 7:
                result = new PictureFragment();
                break;
            case 8:
                result = new DrawingFragment();
                break;
            case 9:
                result = new ZeugenFragment();
                break;
            case 10:
                result = new UmstaendeFragment();
                break;
            case 11:
                result = new SignatureFragment();
                break;
            case 12:
                result = new FinishFragment();
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
                return "Fahrzeuge";
            case 5:
                return "Versicherungen";
            case 6:
                return resources.getString(R.string.page_sketch);
            case 7:
                return "Bilder";
            case 8:
                return resources.getString(R.string.page_drawing);
            case 9:
                return "Zeugen";
            case 10:
                return "Umstände";
            case 11:
                return "Unterschriften";
            case 12:
                return "Abschluss";

            default:
                return null;
        }
    }
}
