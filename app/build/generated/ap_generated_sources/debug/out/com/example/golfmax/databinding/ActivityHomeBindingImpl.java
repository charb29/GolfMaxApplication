package com.example.golfmax.databinding;
import com.example.golfmax.R;
import com.example.golfmax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityHomeBindingImpl extends ActivityHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.image_view_logo_icon, 3);
        sViewsWithIds.put(R.id.card_view_my_scores, 4);
        sViewsWithIds.put(R.id.card_view_user_profile, 5);
        sViewsWithIds.put(R.id.card_view_leaderboards, 6);
        sViewsWithIds.put(R.id.card_view_play_round, 7);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ActivityHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.cardview.widget.CardView) bindings[6]
            , (androidx.cardview.widget.CardView) bindings[4]
            , (androidx.cardview.widget.CardView) bindings[7]
            , (androidx.cardview.widget.CardView) bindings[5]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textViewAverageScore.setTag(null);
        this.textViewHandicapIndex.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.presenter == variableId) {
            setPresenter((com.example.golfmax.presenters.PlayerStatisticsPresenter) variable);
        }
        else if (BR.stats == variableId) {
            setStats((com.example.golfmax.models.PlayerStatistics) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPresenter(@Nullable com.example.golfmax.presenters.PlayerStatisticsPresenter Presenter) {
        this.mPresenter = Presenter;
    }
    public void setStats(@Nullable com.example.golfmax.models.PlayerStatistics Stats) {
        updateRegistration(0, Stats);
        this.mStats = Stats;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.stats);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeStats((com.example.golfmax.models.PlayerStatistics) object, fieldId);
        }
        return false;
    }
    private boolean onChangeStats(com.example.golfmax.models.PlayerStatistics Stats, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.handicapIndex) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.averageScore) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        double statsHandicapIndex = 0.0;
        java.lang.String stringValueOfStatsAverageScore = null;
        java.lang.String stringValueOfStatsHandicapIndex = null;
        double statsAverageScore = 0.0;
        com.example.golfmax.models.PlayerStatistics stats = mStats;

        if ((dirtyFlags & 0x1dL) != 0) {


            if ((dirtyFlags & 0x15L) != 0) {

                    if (stats != null) {
                        // read stats.handicapIndex
                        statsHandicapIndex = stats.getHandicapIndex();
                    }


                    // read String.valueOf(stats.handicapIndex)
                    stringValueOfStatsHandicapIndex = java.lang.String.valueOf(statsHandicapIndex);
            }
            if ((dirtyFlags & 0x19L) != 0) {

                    if (stats != null) {
                        // read stats.averageScore
                        statsAverageScore = stats.getAverageScore();
                    }


                    // read String.valueOf(stats.averageScore)
                    stringValueOfStatsAverageScore = java.lang.String.valueOf(statsAverageScore);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewAverageScore, stringValueOfStatsAverageScore);
        }
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewHandicapIndex, stringValueOfStatsHandicapIndex);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): stats
        flag 1 (0x2L): presenter
        flag 2 (0x3L): stats.handicapIndex
        flag 3 (0x4L): stats.averageScore
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}