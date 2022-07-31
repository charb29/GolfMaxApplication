package com.example.golfmax.databinding;
import com.example.golfmax.R;
import com.example.golfmax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCourseLeaderboardBindingImpl extends ActivityCourseLeaderboardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.image_view_leaderboard_icon, 2);
        sViewsWithIds.put(R.id.viewScores, 3);
        sViewsWithIds.put(R.id.navigation_view_course_leaderboard, 4);
    }
    // views
    @NonNull
    private final android.widget.TextView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of score.course.courseName
            //         is score.course.setCourseName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView1);
            // localize variables for thread safety
            // score
            com.example.golfmax.models.Score score = mScore;
            // score.course != null
            boolean scoreCourseJavaLangObjectNull = false;
            // score.course.courseName
            java.lang.String scoreCourseCourseName = null;
            // score != null
            boolean scoreJavaLangObjectNull = false;
            // score.course
            com.example.golfmax.models.Course scoreCourse = null;



            scoreJavaLangObjectNull = (score) != (null);
            if (scoreJavaLangObjectNull) {


                scoreCourse = score.getCourse();

                scoreCourseJavaLangObjectNull = (scoreCourse) != (null);
                if (scoreCourseJavaLangObjectNull) {




                    scoreCourse.setCourseName(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityCourseLeaderboardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityCourseLeaderboardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (androidx.drawerlayout.widget.DrawerLayout) bindings[0]
            , (android.widget.ImageView) bindings[2]
            , (com.google.android.material.navigation.NavigationView) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[3]
            );
        this.drawerLayout.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.score == variableId) {
            setScore((com.example.golfmax.models.Score) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setScore(@Nullable com.example.golfmax.models.Score Score) {
        updateRegistration(0, Score);
        this.mScore = Score;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.score);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeScore((com.example.golfmax.models.Score) object, fieldId);
            case 1 :
                return onChangeScoreCourse((com.example.golfmax.models.Course) object, fieldId);
        }
        return false;
    }
    private boolean onChangeScore(com.example.golfmax.models.Score Score, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeScoreCourse(com.example.golfmax.models.Course ScoreCourse, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.courseName) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        com.example.golfmax.models.Score score = mScore;
        java.lang.String scoreCourseCourseName = null;
        com.example.golfmax.models.Course scoreCourse = null;

        if ((dirtyFlags & 0xfL) != 0) {



                if (score != null) {
                    // read score.course
                    scoreCourse = score.getCourse();
                }
                updateRegistration(1, scoreCourse);


                if (scoreCourse != null) {
                    // read score.course.courseName
                    scoreCourseCourseName = scoreCourse.getCourseName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0xfL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, scoreCourseCourseName);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView1androidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): score
        flag 1 (0x2L): score.course
        flag 2 (0x3L): score.course.courseName
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}