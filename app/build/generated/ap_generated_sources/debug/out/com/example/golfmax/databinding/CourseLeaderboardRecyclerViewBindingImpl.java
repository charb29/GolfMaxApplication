package com.example.golfmax.databinding;
import com.example.golfmax.R;
import com.example.golfmax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CourseLeaderboardRecyclerViewBindingImpl extends CourseLeaderboardRecyclerViewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ("") + (score.rank)
            //         is score.setRank((int) androidx.databinding.ViewDataBinding.parse(callbackArg_0, score.rank))
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView1);
            // localize variables for thread safety
            // (int) androidx.databinding.ViewDataBinding.parse(callbackArg_0, score.rank)
            int intAndroidxDatabindingViewDataBindingParseCallbackArg0ScoreRank = 0;
            // score
            com.example.golfmax.models.Score score = mScore;
            // score.rank
            int scoreRank = 0;
            // ("") + (score.rank)
            java.lang.String javaLangStringScoreRank = null;
            // androidx.databinding.ViewDataBinding.parse(callbackArg_0, score.rank)
            int androidxDatabindingViewDataBindingParseCallbackArg0ScoreRank = 0;
            // score != null
            boolean scoreJavaLangObjectNull = false;



            scoreJavaLangObjectNull = (score) != (null);
            if (scoreJavaLangObjectNull) {





                scoreRank = score.getRank();

                androidxDatabindingViewDataBindingParseCallbackArg0ScoreRank = androidx.databinding.ViewDataBinding.parse(callbackArg_0, scoreRank);

                intAndroidxDatabindingViewDataBindingParseCallbackArg0ScoreRank = ((int) (androidxDatabindingViewDataBindingParseCallbackArg0ScoreRank));

                score.setRank(intAndroidxDatabindingViewDataBindingParseCallbackArg0ScoreRank);
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of score.user.username
            //         is score.user.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // score
            com.example.golfmax.models.Score score = mScore;
            // score != null
            boolean scoreJavaLangObjectNull = false;
            // score.user
            com.example.golfmax.models.User scoreUser = null;
            // score.user.username
            java.lang.String scoreUserUsername = null;
            // score.user != null
            boolean scoreUserJavaLangObjectNull = false;



            scoreJavaLangObjectNull = (score) != (null);
            if (scoreJavaLangObjectNull) {


                scoreUser = score.getUser();

                scoreUserJavaLangObjectNull = (scoreUser) != (null);
                if (scoreUserJavaLangObjectNull) {




                    scoreUser.setUsername(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ("") + (score.userScore)
            //         is score.setUserScore((int) androidx.databinding.ViewDataBinding.parse(callbackArg_0, score.userScore))
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // score
            com.example.golfmax.models.Score score = mScore;
            // (int) androidx.databinding.ViewDataBinding.parse(callbackArg_0, score.userScore)
            int intAndroidxDatabindingViewDataBindingParseCallbackArg0ScoreUserScore = 0;
            // score != null
            boolean scoreJavaLangObjectNull = false;
            // score.userScore
            int scoreUserScore = 0;
            // ("") + (score.userScore)
            java.lang.String javaLangStringScoreUserScore = null;
            // androidx.databinding.ViewDataBinding.parse(callbackArg_0, score.userScore)
            int androidxDatabindingViewDataBindingParseCallbackArg0ScoreUserScore = 0;



            scoreJavaLangObjectNull = (score) != (null);
            if (scoreJavaLangObjectNull) {





                scoreUserScore = score.getUserScore();

                androidxDatabindingViewDataBindingParseCallbackArg0ScoreUserScore = androidx.databinding.ViewDataBinding.parse(callbackArg_0, scoreUserScore);

                intAndroidxDatabindingViewDataBindingParseCallbackArg0ScoreUserScore = ((int) (androidxDatabindingViewDataBindingParseCallbackArg0ScoreUserScore));

                score.setUserScore(intAndroidxDatabindingViewDataBindingParseCallbackArg0ScoreUserScore);
            }
        }
    };

    public CourseLeaderboardRecyclerViewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private CourseLeaderboardRecyclerViewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
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
                return onChangeScoreUser((com.example.golfmax.models.User) object, fieldId);
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
    private boolean onChangeScoreUser(com.example.golfmax.models.User ScoreUser, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.username) {
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
        int scoreRank = 0;
        java.lang.String javaLangStringScoreUserScore = null;
        com.example.golfmax.models.User scoreUser = null;
        java.lang.String javaLangStringScoreRank = null;
        int scoreUserScore = 0;
        java.lang.String scoreUserUsername = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0x9L) != 0) {

                    if (score != null) {
                        // read score.rank
                        scoreRank = score.getRank();
                        // read score.userScore
                        scoreUserScore = score.getUserScore();
                    }


                    // read ("") + (score.rank)
                    javaLangStringScoreRank = ("") + (scoreRank);
                    // read ("") + (score.userScore)
                    javaLangStringScoreUserScore = ("") + (scoreUserScore);
            }

                if (score != null) {
                    // read score.user
                    scoreUser = score.getUser();
                }
                updateRegistration(1, scoreUser);


                if (scoreUser != null) {
                    // read score.user.username
                    scoreUserUsername = scoreUser.getUsername();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, javaLangStringScoreRank);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, javaLangStringScoreUserScore);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
        }
        if ((dirtyFlags & 0xfL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, scoreUserUsername);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): score
        flag 1 (0x2L): score.user
        flag 2 (0x3L): score.user.username
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}