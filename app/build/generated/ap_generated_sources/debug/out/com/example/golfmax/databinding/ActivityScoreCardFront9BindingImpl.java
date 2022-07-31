package com.example.golfmax.databinding;
import com.example.golfmax.R;
import com.example.golfmax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityScoreCardFront9BindingImpl extends ActivityScoreCardFront9Binding implements com.example.golfmax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.table_row_hole, 58);
        sViewsWithIds.put(R.id.table_row_par, 59);
        sViewsWithIds.put(R.id.table_row_user, 60);
        sViewsWithIds.put(R.id.table_row_guest1, 61);
        sViewsWithIds.put(R.id.table_row_guest2, 62);
        sViewsWithIds.put(R.id.table_row_guest3, 63);
        sViewsWithIds.put(R.id.text_view_current_score_user, 64);
        sViewsWithIds.put(R.id.text_view_current_score_guest3, 65);
        sViewsWithIds.put(R.id.text_view_current_score_guest2, 66);
        sViewsWithIds.put(R.id.text_view_current_score_guest1, 67);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.RelativeLayout mboundView50;
    @NonNull
    private final android.widget.RelativeLayout mboundView52;
    @NonNull
    private final android.widget.RelativeLayout mboundView54;
    @NonNull
    private final android.widget.RelativeLayout mboundView56;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback6;
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener editTextHole1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userScore.hole1
            //         is userScore.setHole1((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole1);
            // localize variables for thread safety
            // userScore != null
            boolean userScoreJavaLangObjectNull = false;
            // userScore.hole1
            java.lang.String userScoreHole1 = null;
            // userScore
            com.example.golfmax.models.Score userScore = mUserScore;



            userScoreJavaLangObjectNull = (userScore) != (null);
            if (userScoreJavaLangObjectNull) {




                userScore.setHole1(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole1Guest1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1Score.hole1
            //         is guest1Score.setHole1((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole1Guest1);
            // localize variables for thread safety
            // guest1Score
            com.example.golfmax.models.Score guest1Score = mGuest1Score;
            // guest1Score != null
            boolean guest1ScoreJavaLangObjectNull = false;
            // guest1Score.hole1
            java.lang.String guest1ScoreHole1 = null;



            guest1ScoreJavaLangObjectNull = (guest1Score) != (null);
            if (guest1ScoreJavaLangObjectNull) {




                guest1Score.setHole1(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole1Guest2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2Score.hole1
            //         is guest2Score.setHole1((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole1Guest2);
            // localize variables for thread safety
            // guest2Score != null
            boolean guest2ScoreJavaLangObjectNull = false;
            // guest2Score.hole1
            java.lang.String guest2ScoreHole1 = null;
            // guest2Score
            com.example.golfmax.models.Score guest2Score = mGuest2Score;



            guest2ScoreJavaLangObjectNull = (guest2Score) != (null);
            if (guest2ScoreJavaLangObjectNull) {




                guest2Score.setHole1(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole1Guest3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3Score.hole1
            //         is guest3Score.setHole1((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole1Guest3);
            // localize variables for thread safety
            // guest3Score != null
            boolean guest3ScoreJavaLangObjectNull = false;
            // guest3Score
            com.example.golfmax.models.Score guest3Score = mGuest3Score;
            // guest3Score.hole1
            java.lang.String guest3ScoreHole1 = null;



            guest3ScoreJavaLangObjectNull = (guest3Score) != (null);
            if (guest3ScoreJavaLangObjectNull) {




                guest3Score.setHole1(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userScore.hole2
            //         is userScore.setHole2((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole2);
            // localize variables for thread safety
            // userScore != null
            boolean userScoreJavaLangObjectNull = false;
            // userScore.hole2
            java.lang.String userScoreHole2 = null;
            // userScore
            com.example.golfmax.models.Score userScore = mUserScore;



            userScoreJavaLangObjectNull = (userScore) != (null);
            if (userScoreJavaLangObjectNull) {




                userScore.setHole2(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole2Guest1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1Score.hole2
            //         is guest1Score.setHole2((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole2Guest1);
            // localize variables for thread safety
            // guest1Score
            com.example.golfmax.models.Score guest1Score = mGuest1Score;
            // guest1Score != null
            boolean guest1ScoreJavaLangObjectNull = false;
            // guest1Score.hole2
            java.lang.String guest1ScoreHole2 = null;



            guest1ScoreJavaLangObjectNull = (guest1Score) != (null);
            if (guest1ScoreJavaLangObjectNull) {




                guest1Score.setHole2(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole2Guest2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2Score.hole2
            //         is guest2Score.setHole2((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole2Guest2);
            // localize variables for thread safety
            // guest2Score != null
            boolean guest2ScoreJavaLangObjectNull = false;
            // guest2Score.hole2
            java.lang.String guest2ScoreHole2 = null;
            // guest2Score
            com.example.golfmax.models.Score guest2Score = mGuest2Score;



            guest2ScoreJavaLangObjectNull = (guest2Score) != (null);
            if (guest2ScoreJavaLangObjectNull) {




                guest2Score.setHole2(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole2Guest3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3Score.hole2
            //         is guest3Score.setHole2((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole2Guest3);
            // localize variables for thread safety
            // guest3Score != null
            boolean guest3ScoreJavaLangObjectNull = false;
            // guest3Score
            com.example.golfmax.models.Score guest3Score = mGuest3Score;
            // guest3Score.hole2
            java.lang.String guest3ScoreHole2 = null;



            guest3ScoreJavaLangObjectNull = (guest3Score) != (null);
            if (guest3ScoreJavaLangObjectNull) {




                guest3Score.setHole2(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userScore.hole3
            //         is userScore.setHole3((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole3);
            // localize variables for thread safety
            // userScore != null
            boolean userScoreJavaLangObjectNull = false;
            // userScore.hole3
            java.lang.String userScoreHole3 = null;
            // userScore
            com.example.golfmax.models.Score userScore = mUserScore;



            userScoreJavaLangObjectNull = (userScore) != (null);
            if (userScoreJavaLangObjectNull) {




                userScore.setHole3(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole3Guest1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1Score.hole3
            //         is guest1Score.setHole3((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole3Guest1);
            // localize variables for thread safety
            // guest1Score
            com.example.golfmax.models.Score guest1Score = mGuest1Score;
            // guest1Score != null
            boolean guest1ScoreJavaLangObjectNull = false;
            // guest1Score.hole3
            java.lang.String guest1ScoreHole3 = null;



            guest1ScoreJavaLangObjectNull = (guest1Score) != (null);
            if (guest1ScoreJavaLangObjectNull) {




                guest1Score.setHole3(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole3Guest2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2Score.hole3
            //         is guest2Score.setHole3((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole3Guest2);
            // localize variables for thread safety
            // guest2Score != null
            boolean guest2ScoreJavaLangObjectNull = false;
            // guest2Score.hole3
            java.lang.String guest2ScoreHole3 = null;
            // guest2Score
            com.example.golfmax.models.Score guest2Score = mGuest2Score;



            guest2ScoreJavaLangObjectNull = (guest2Score) != (null);
            if (guest2ScoreJavaLangObjectNull) {




                guest2Score.setHole3(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole3Guest3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3Score.hole3
            //         is guest3Score.setHole3((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole3Guest3);
            // localize variables for thread safety
            // guest3Score != null
            boolean guest3ScoreJavaLangObjectNull = false;
            // guest3Score
            com.example.golfmax.models.Score guest3Score = mGuest3Score;
            // guest3Score.hole3
            java.lang.String guest3ScoreHole3 = null;



            guest3ScoreJavaLangObjectNull = (guest3Score) != (null);
            if (guest3ScoreJavaLangObjectNull) {




                guest3Score.setHole3(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userScore.hole4
            //         is userScore.setHole4((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole4);
            // localize variables for thread safety
            // userScore != null
            boolean userScoreJavaLangObjectNull = false;
            // userScore.hole4
            java.lang.String userScoreHole4 = null;
            // userScore
            com.example.golfmax.models.Score userScore = mUserScore;



            userScoreJavaLangObjectNull = (userScore) != (null);
            if (userScoreJavaLangObjectNull) {




                userScore.setHole4(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole4Guest1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1Score.hole4
            //         is guest1Score.setHole4((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole4Guest1);
            // localize variables for thread safety
            // guest1Score
            com.example.golfmax.models.Score guest1Score = mGuest1Score;
            // guest1Score != null
            boolean guest1ScoreJavaLangObjectNull = false;
            // guest1Score.hole4
            java.lang.String guest1ScoreHole4 = null;



            guest1ScoreJavaLangObjectNull = (guest1Score) != (null);
            if (guest1ScoreJavaLangObjectNull) {




                guest1Score.setHole4(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole4Guest2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2Score.hole4
            //         is guest2Score.setHole4((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole4Guest2);
            // localize variables for thread safety
            // guest2Score != null
            boolean guest2ScoreJavaLangObjectNull = false;
            // guest2Score.hole4
            java.lang.String guest2ScoreHole4 = null;
            // guest2Score
            com.example.golfmax.models.Score guest2Score = mGuest2Score;



            guest2ScoreJavaLangObjectNull = (guest2Score) != (null);
            if (guest2ScoreJavaLangObjectNull) {




                guest2Score.setHole4(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole4Guest3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3Score.hole4
            //         is guest3Score.setHole4((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole4Guest3);
            // localize variables for thread safety
            // guest3Score != null
            boolean guest3ScoreJavaLangObjectNull = false;
            // guest3Score.hole4
            java.lang.String guest3ScoreHole4 = null;
            // guest3Score
            com.example.golfmax.models.Score guest3Score = mGuest3Score;



            guest3ScoreJavaLangObjectNull = (guest3Score) != (null);
            if (guest3ScoreJavaLangObjectNull) {




                guest3Score.setHole4(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole5androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userScore.hole5
            //         is userScore.setHole5((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole5);
            // localize variables for thread safety
            // userScore != null
            boolean userScoreJavaLangObjectNull = false;
            // userScore
            com.example.golfmax.models.Score userScore = mUserScore;
            // userScore.hole5
            java.lang.String userScoreHole5 = null;



            userScoreJavaLangObjectNull = (userScore) != (null);
            if (userScoreJavaLangObjectNull) {




                userScore.setHole5(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole5Guest1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1Score.hole5
            //         is guest1Score.setHole5((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole5Guest1);
            // localize variables for thread safety
            // guest1Score
            com.example.golfmax.models.Score guest1Score = mGuest1Score;
            // guest1Score != null
            boolean guest1ScoreJavaLangObjectNull = false;
            // guest1Score.hole5
            java.lang.String guest1ScoreHole5 = null;



            guest1ScoreJavaLangObjectNull = (guest1Score) != (null);
            if (guest1ScoreJavaLangObjectNull) {




                guest1Score.setHole5(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole5Guest2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2Score.hole5
            //         is guest2Score.setHole5((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole5Guest2);
            // localize variables for thread safety
            // guest2Score.hole5
            java.lang.String guest2ScoreHole5 = null;
            // guest2Score != null
            boolean guest2ScoreJavaLangObjectNull = false;
            // guest2Score
            com.example.golfmax.models.Score guest2Score = mGuest2Score;



            guest2ScoreJavaLangObjectNull = (guest2Score) != (null);
            if (guest2ScoreJavaLangObjectNull) {




                guest2Score.setHole5(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole5Guest3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3Score.hole5
            //         is guest3Score.setHole5((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole5Guest3);
            // localize variables for thread safety
            // guest3Score != null
            boolean guest3ScoreJavaLangObjectNull = false;
            // guest3Score
            com.example.golfmax.models.Score guest3Score = mGuest3Score;
            // guest3Score.hole5
            java.lang.String guest3ScoreHole5 = null;



            guest3ScoreJavaLangObjectNull = (guest3Score) != (null);
            if (guest3ScoreJavaLangObjectNull) {




                guest3Score.setHole5(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole6androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userScore.hole6
            //         is userScore.setHole6((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole6);
            // localize variables for thread safety
            // userScore != null
            boolean userScoreJavaLangObjectNull = false;
            // userScore
            com.example.golfmax.models.Score userScore = mUserScore;
            // userScore.hole6
            java.lang.String userScoreHole6 = null;



            userScoreJavaLangObjectNull = (userScore) != (null);
            if (userScoreJavaLangObjectNull) {




                userScore.setHole6(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole6Guest1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1Score.hole6
            //         is guest1Score.setHole6((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole6Guest1);
            // localize variables for thread safety
            // guest1Score
            com.example.golfmax.models.Score guest1Score = mGuest1Score;
            // guest1Score != null
            boolean guest1ScoreJavaLangObjectNull = false;
            // guest1Score.hole6
            java.lang.String guest1ScoreHole6 = null;



            guest1ScoreJavaLangObjectNull = (guest1Score) != (null);
            if (guest1ScoreJavaLangObjectNull) {




                guest1Score.setHole6(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole6Guest2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2Score.hole6
            //         is guest2Score.setHole6((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole6Guest2);
            // localize variables for thread safety
            // guest2Score != null
            boolean guest2ScoreJavaLangObjectNull = false;
            // guest2Score.hole6
            java.lang.String guest2ScoreHole6 = null;
            // guest2Score
            com.example.golfmax.models.Score guest2Score = mGuest2Score;



            guest2ScoreJavaLangObjectNull = (guest2Score) != (null);
            if (guest2ScoreJavaLangObjectNull) {




                guest2Score.setHole6(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole6Guest3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3Score.hole6
            //         is guest3Score.setHole6((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole6Guest3);
            // localize variables for thread safety
            // guest3Score != null
            boolean guest3ScoreJavaLangObjectNull = false;
            // guest3Score.hole6
            java.lang.String guest3ScoreHole6 = null;
            // guest3Score
            com.example.golfmax.models.Score guest3Score = mGuest3Score;



            guest3ScoreJavaLangObjectNull = (guest3Score) != (null);
            if (guest3ScoreJavaLangObjectNull) {




                guest3Score.setHole6(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole7androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userScore.hole7
            //         is userScore.setHole7((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole7);
            // localize variables for thread safety
            // userScore != null
            boolean userScoreJavaLangObjectNull = false;
            // userScore
            com.example.golfmax.models.Score userScore = mUserScore;
            // userScore.hole7
            java.lang.String userScoreHole7 = null;



            userScoreJavaLangObjectNull = (userScore) != (null);
            if (userScoreJavaLangObjectNull) {




                userScore.setHole7(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole7Guest1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1Score.hole7
            //         is guest1Score.setHole7((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole7Guest1);
            // localize variables for thread safety
            // guest1Score
            com.example.golfmax.models.Score guest1Score = mGuest1Score;
            // guest1Score != null
            boolean guest1ScoreJavaLangObjectNull = false;
            // guest1Score.hole7
            java.lang.String guest1ScoreHole7 = null;



            guest1ScoreJavaLangObjectNull = (guest1Score) != (null);
            if (guest1ScoreJavaLangObjectNull) {




                guest1Score.setHole7(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole7Guest2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2Score.hole7
            //         is guest2Score.setHole7((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole7Guest2);
            // localize variables for thread safety
            // guest2Score != null
            boolean guest2ScoreJavaLangObjectNull = false;
            // guest2Score.hole7
            java.lang.String guest2ScoreHole7 = null;
            // guest2Score
            com.example.golfmax.models.Score guest2Score = mGuest2Score;



            guest2ScoreJavaLangObjectNull = (guest2Score) != (null);
            if (guest2ScoreJavaLangObjectNull) {




                guest2Score.setHole7(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole7Guest3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3Score.hole7
            //         is guest3Score.setHole7((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole7Guest3);
            // localize variables for thread safety
            // guest3Score != null
            boolean guest3ScoreJavaLangObjectNull = false;
            // guest3Score.hole7
            java.lang.String guest3ScoreHole7 = null;
            // guest3Score
            com.example.golfmax.models.Score guest3Score = mGuest3Score;



            guest3ScoreJavaLangObjectNull = (guest3Score) != (null);
            if (guest3ScoreJavaLangObjectNull) {




                guest3Score.setHole7(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole8androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userScore.hole8
            //         is userScore.setHole8((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole8);
            // localize variables for thread safety
            // userScore.hole8
            java.lang.String userScoreHole8 = null;
            // userScore != null
            boolean userScoreJavaLangObjectNull = false;
            // userScore
            com.example.golfmax.models.Score userScore = mUserScore;



            userScoreJavaLangObjectNull = (userScore) != (null);
            if (userScoreJavaLangObjectNull) {




                userScore.setHole8(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole8Guest1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1Score.hole8
            //         is guest1Score.setHole8((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole8Guest1);
            // localize variables for thread safety
            // guest1Score
            com.example.golfmax.models.Score guest1Score = mGuest1Score;
            // guest1Score != null
            boolean guest1ScoreJavaLangObjectNull = false;
            // guest1Score.hole8
            java.lang.String guest1ScoreHole8 = null;



            guest1ScoreJavaLangObjectNull = (guest1Score) != (null);
            if (guest1ScoreJavaLangObjectNull) {




                guest1Score.setHole8(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole8Guest2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2Score.hole8
            //         is guest2Score.setHole8((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole8Guest2);
            // localize variables for thread safety
            // guest2Score != null
            boolean guest2ScoreJavaLangObjectNull = false;
            // guest2Score.hole8
            java.lang.String guest2ScoreHole8 = null;
            // guest2Score
            com.example.golfmax.models.Score guest2Score = mGuest2Score;



            guest2ScoreJavaLangObjectNull = (guest2Score) != (null);
            if (guest2ScoreJavaLangObjectNull) {




                guest2Score.setHole8(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole8Guest3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3Score.hole8
            //         is guest3Score.setHole8((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole8Guest3);
            // localize variables for thread safety
            // guest3Score != null
            boolean guest3ScoreJavaLangObjectNull = false;
            // guest3Score.hole8
            java.lang.String guest3ScoreHole8 = null;
            // guest3Score
            com.example.golfmax.models.Score guest3Score = mGuest3Score;



            guest3ScoreJavaLangObjectNull = (guest3Score) != (null);
            if (guest3ScoreJavaLangObjectNull) {




                guest3Score.setHole8(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole9androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userScore.hole9
            //         is userScore.setHole9((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole9);
            // localize variables for thread safety
            // userScore.hole9
            java.lang.String userScoreHole9 = null;
            // userScore != null
            boolean userScoreJavaLangObjectNull = false;
            // userScore
            com.example.golfmax.models.Score userScore = mUserScore;



            userScoreJavaLangObjectNull = (userScore) != (null);
            if (userScoreJavaLangObjectNull) {




                userScore.setHole9(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole9Guest1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1Score.hole9
            //         is guest1Score.setHole9((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole9Guest1);
            // localize variables for thread safety
            // guest1Score
            com.example.golfmax.models.Score guest1Score = mGuest1Score;
            // guest1Score != null
            boolean guest1ScoreJavaLangObjectNull = false;
            // guest1Score.hole9
            java.lang.String guest1ScoreHole9 = null;



            guest1ScoreJavaLangObjectNull = (guest1Score) != (null);
            if (guest1ScoreJavaLangObjectNull) {




                guest1Score.setHole9(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole9Guest2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2Score.hole9
            //         is guest2Score.setHole9((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole9Guest2);
            // localize variables for thread safety
            // guest2Score != null
            boolean guest2ScoreJavaLangObjectNull = false;
            // guest2Score
            com.example.golfmax.models.Score guest2Score = mGuest2Score;
            // guest2Score.hole9
            java.lang.String guest2ScoreHole9 = null;



            guest2ScoreJavaLangObjectNull = (guest2Score) != (null);
            if (guest2ScoreJavaLangObjectNull) {




                guest2Score.setHole9(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextHole9Guest3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3Score.hole9
            //         is guest3Score.setHole9((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextHole9Guest3);
            // localize variables for thread safety
            // guest3Score != null
            boolean guest3ScoreJavaLangObjectNull = false;
            // guest3Score.hole9
            java.lang.String guest3ScoreHole9 = null;
            // guest3Score
            com.example.golfmax.models.Score guest3Score = mGuest3Score;



            guest3ScoreJavaLangObjectNull = (guest3Score) != (null);
            if (guest3ScoreJavaLangObjectNull) {




                guest3Score.setHole9(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener textInputEditTextGuest1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1.username
            //         is guest1.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textInputEditTextGuest1);
            // localize variables for thread safety
            // guest1
            com.example.golfmax.models.User guest1 = mGuest1;
            // guest1.username
            java.lang.String guest1Username = null;
            // guest1 != null
            boolean guest1JavaLangObjectNull = false;



            guest1JavaLangObjectNull = (guest1) != (null);
            if (guest1JavaLangObjectNull) {




                guest1.setUsername(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener textInputEditTextGuest2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2.username
            //         is guest2.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textInputEditTextGuest2);
            // localize variables for thread safety
            // guest2
            com.example.golfmax.models.User guest2 = mGuest2;
            // guest2 != null
            boolean guest2JavaLangObjectNull = false;
            // guest2.username
            java.lang.String guest2Username = null;



            guest2JavaLangObjectNull = (guest2) != (null);
            if (guest2JavaLangObjectNull) {




                guest2.setUsername(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener textInputEditTextGuest3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3.username
            //         is guest3.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textInputEditTextGuest3);
            // localize variables for thread safety
            // guest3
            com.example.golfmax.models.User guest3 = mGuest3;
            // guest3 != null
            boolean guest3JavaLangObjectNull = false;
            // guest3.username
            java.lang.String guest3Username = null;



            guest3JavaLangObjectNull = (guest3) != (null);
            if (guest3JavaLangObjectNull) {




                guest3.setUsername(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener textViewCurrentScoreGuest1NameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest1.username
            //         is guest1.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textViewCurrentScoreGuest1Name);
            // localize variables for thread safety
            // guest1
            com.example.golfmax.models.User guest1 = mGuest1;
            // guest1.username
            java.lang.String guest1Username = null;
            // guest1 != null
            boolean guest1JavaLangObjectNull = false;



            guest1JavaLangObjectNull = (guest1) != (null);
            if (guest1JavaLangObjectNull) {




                guest1.setUsername(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener textViewCurrentScoreGuest2NameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest2.username
            //         is guest2.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textViewCurrentScoreGuest2Name);
            // localize variables for thread safety
            // guest2
            com.example.golfmax.models.User guest2 = mGuest2;
            // guest2 != null
            boolean guest2JavaLangObjectNull = false;
            // guest2.username
            java.lang.String guest2Username = null;



            guest2JavaLangObjectNull = (guest2) != (null);
            if (guest2JavaLangObjectNull) {




                guest2.setUsername(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener textViewCurrentScoreGuest3NameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of guest3.username
            //         is guest3.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textViewCurrentScoreGuest3Name);
            // localize variables for thread safety
            // guest3
            com.example.golfmax.models.User guest3 = mGuest3;
            // guest3 != null
            boolean guest3JavaLangObjectNull = false;
            // guest3.username
            java.lang.String guest3Username = null;



            guest3JavaLangObjectNull = (guest3) != (null);
            if (guest3JavaLangObjectNull) {




                guest3.setUsername(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener textViewCurrentScoreUsernameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.username
            //         is user.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textViewCurrentScoreUsername);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.example.golfmax.models.User user = mUser;
            // user.username
            java.lang.String userUsername = null;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setUsername(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener textViewUsernameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.username
            //         is user.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textViewUsername);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.example.golfmax.models.User user = mUser;
            // user.username
            java.lang.String userUsername = null;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setUsername(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public ActivityScoreCardFront9BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 68, sIncludes, sViewsWithIds));
    }
    private ActivityScoreCardFront9BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 9
            , (android.widget.EditText) bindings[11]
            , (android.widget.EditText) bindings[21]
            , (android.widget.EditText) bindings[31]
            , (android.widget.EditText) bindings[41]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[22]
            , (android.widget.EditText) bindings[32]
            , (android.widget.EditText) bindings[42]
            , (android.widget.EditText) bindings[13]
            , (android.widget.EditText) bindings[23]
            , (android.widget.EditText) bindings[33]
            , (android.widget.EditText) bindings[43]
            , (android.widget.EditText) bindings[14]
            , (android.widget.EditText) bindings[24]
            , (android.widget.EditText) bindings[34]
            , (android.widget.EditText) bindings[44]
            , (android.widget.EditText) bindings[15]
            , (android.widget.EditText) bindings[25]
            , (android.widget.EditText) bindings[35]
            , (android.widget.EditText) bindings[45]
            , (android.widget.EditText) bindings[16]
            , (android.widget.EditText) bindings[26]
            , (android.widget.EditText) bindings[36]
            , (android.widget.EditText) bindings[46]
            , (android.widget.EditText) bindings[17]
            , (android.widget.EditText) bindings[27]
            , (android.widget.EditText) bindings[37]
            , (android.widget.EditText) bindings[47]
            , (android.widget.EditText) bindings[18]
            , (android.widget.EditText) bindings[28]
            , (android.widget.EditText) bindings[38]
            , (android.widget.EditText) bindings[48]
            , (android.widget.EditText) bindings[19]
            , (android.widget.EditText) bindings[29]
            , (android.widget.EditText) bindings[39]
            , (android.widget.EditText) bindings[49]
            , (android.widget.TableRow) bindings[61]
            , (android.widget.TableRow) bindings[62]
            , (android.widget.TableRow) bindings[63]
            , (android.widget.TableRow) bindings[58]
            , (android.widget.TableRow) bindings[59]
            , (android.widget.TableRow) bindings[60]
            , (com.google.android.material.textfield.TextInputEditText) bindings[20]
            , (com.google.android.material.textfield.TextInputEditText) bindings[30]
            , (com.google.android.material.textfield.TextInputEditText) bindings[40]
            , (android.widget.TextView) bindings[67]
            , (android.widget.TextView) bindings[57]
            , (android.widget.TextView) bindings[66]
            , (android.widget.TextView) bindings[55]
            , (android.widget.TextView) bindings[65]
            , (android.widget.TextView) bindings[53]
            , (android.widget.TextView) bindings[64]
            , (android.widget.TextView) bindings[51]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            );
        this.editTextHole1.setTag(null);
        this.editTextHole1Guest1.setTag(null);
        this.editTextHole1Guest2.setTag(null);
        this.editTextHole1Guest3.setTag(null);
        this.editTextHole2.setTag(null);
        this.editTextHole2Guest1.setTag(null);
        this.editTextHole2Guest2.setTag(null);
        this.editTextHole2Guest3.setTag(null);
        this.editTextHole3.setTag(null);
        this.editTextHole3Guest1.setTag(null);
        this.editTextHole3Guest2.setTag(null);
        this.editTextHole3Guest3.setTag(null);
        this.editTextHole4.setTag(null);
        this.editTextHole4Guest1.setTag(null);
        this.editTextHole4Guest2.setTag(null);
        this.editTextHole4Guest3.setTag(null);
        this.editTextHole5.setTag(null);
        this.editTextHole5Guest1.setTag(null);
        this.editTextHole5Guest2.setTag(null);
        this.editTextHole5Guest3.setTag(null);
        this.editTextHole6.setTag(null);
        this.editTextHole6Guest1.setTag(null);
        this.editTextHole6Guest2.setTag(null);
        this.editTextHole6Guest3.setTag(null);
        this.editTextHole7.setTag(null);
        this.editTextHole7Guest1.setTag(null);
        this.editTextHole7Guest2.setTag(null);
        this.editTextHole7Guest3.setTag(null);
        this.editTextHole8.setTag(null);
        this.editTextHole8Guest1.setTag(null);
        this.editTextHole8Guest2.setTag(null);
        this.editTextHole8Guest3.setTag(null);
        this.editTextHole9.setTag(null);
        this.editTextHole9Guest1.setTag(null);
        this.editTextHole9Guest2.setTag(null);
        this.editTextHole9Guest3.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView50 = (android.widget.RelativeLayout) bindings[50];
        this.mboundView50.setTag(null);
        this.mboundView52 = (android.widget.RelativeLayout) bindings[52];
        this.mboundView52.setTag(null);
        this.mboundView54 = (android.widget.RelativeLayout) bindings[54];
        this.mboundView54.setTag(null);
        this.mboundView56 = (android.widget.RelativeLayout) bindings[56];
        this.mboundView56.setTag(null);
        this.textInputEditTextGuest1.setTag(null);
        this.textInputEditTextGuest2.setTag(null);
        this.textInputEditTextGuest3.setTag(null);
        this.textViewCurrentScoreGuest1Name.setTag(null);
        this.textViewCurrentScoreGuest2Name.setTag(null);
        this.textViewCurrentScoreGuest3Name.setTag(null);
        this.textViewCurrentScoreUsername.setTag(null);
        this.textViewPar1.setTag(null);
        this.textViewPar2.setTag(null);
        this.textViewPar3.setTag(null);
        this.textViewPar4.setTag(null);
        this.textViewPar5.setTag(null);
        this.textViewPar6.setTag(null);
        this.textViewPar7.setTag(null);
        this.textViewPar8.setTag(null);
        this.textViewPar9.setTag(null);
        this.textViewUsername.setTag(null);
        setRootTag(root);
        // listeners
        mCallback6 = new com.example.golfmax.generated.callback.OnClickListener(this, 4);
        mCallback5 = new com.example.golfmax.generated.callback.OnClickListener(this, 3);
        mCallback4 = new com.example.golfmax.generated.callback.OnClickListener(this, 2);
        mCallback3 = new com.example.golfmax.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8000000000000000L;
                mDirtyFlags_1 = 0x0L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0 || mDirtyFlags_1 != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.guest1Score == variableId) {
            setGuest1Score((com.example.golfmax.models.Score) variable);
        }
        else if (BR.scorePresenter == variableId) {
            setScorePresenter((com.example.golfmax.presenters.ScorePresenter) variable);
        }
        else if (BR.course == variableId) {
            setCourse((com.example.golfmax.models.Course) variable);
        }
        else if (BR.guest3Presenter == variableId) {
            setGuest3Presenter((com.example.golfmax.presenters.UserPresenter) variable);
        }
        else if (BR.userScore == variableId) {
            setUserScore((com.example.golfmax.models.Score) variable);
        }
        else if (BR.user == variableId) {
            setUser((com.example.golfmax.models.User) variable);
        }
        else if (BR.userPresenter == variableId) {
            setUserPresenter((com.example.golfmax.presenters.UserPresenter) variable);
        }
        else if (BR.guest1Presenter == variableId) {
            setGuest1Presenter((com.example.golfmax.presenters.UserPresenter) variable);
        }
        else if (BR.guest2Presenter == variableId) {
            setGuest2Presenter((com.example.golfmax.presenters.UserPresenter) variable);
        }
        else if (BR.guest2 == variableId) {
            setGuest2((com.example.golfmax.models.User) variable);
        }
        else if (BR.guest3 == variableId) {
            setGuest3((com.example.golfmax.models.User) variable);
        }
        else if (BR.guest2Score == variableId) {
            setGuest2Score((com.example.golfmax.models.Score) variable);
        }
        else if (BR.guest3Score == variableId) {
            setGuest3Score((com.example.golfmax.models.Score) variable);
        }
        else if (BR.guest1 == variableId) {
            setGuest1((com.example.golfmax.models.User) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setGuest1Score(@Nullable com.example.golfmax.models.Score Guest1Score) {
        updateRegistration(0, Guest1Score);
        this.mGuest1Score = Guest1Score;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.guest1Score);
        super.requestRebind();
    }
    public void setScorePresenter(@Nullable com.example.golfmax.presenters.ScorePresenter ScorePresenter) {
        this.mScorePresenter = ScorePresenter;
        synchronized(this) {
            mDirtyFlags |= 0x200L;
        }
        notifyPropertyChanged(BR.scorePresenter);
        super.requestRebind();
    }
    public void setCourse(@Nullable com.example.golfmax.models.Course Course) {
        updateRegistration(1, Course);
        this.mCourse = Course;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.course);
        super.requestRebind();
    }
    public void setGuest3Presenter(@Nullable com.example.golfmax.presenters.UserPresenter Guest3Presenter) {
        this.mGuest3Presenter = Guest3Presenter;
    }
    public void setUserScore(@Nullable com.example.golfmax.models.Score UserScore) {
        updateRegistration(2, UserScore);
        this.mUserScore = UserScore;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.userScore);
        super.requestRebind();
    }
    public void setUser(@Nullable com.example.golfmax.models.User User) {
        updateRegistration(3, User);
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }
    public void setUserPresenter(@Nullable com.example.golfmax.presenters.UserPresenter UserPresenter) {
        this.mUserPresenter = UserPresenter;
    }
    public void setGuest1Presenter(@Nullable com.example.golfmax.presenters.UserPresenter Guest1Presenter) {
        this.mGuest1Presenter = Guest1Presenter;
    }
    public void setGuest2Presenter(@Nullable com.example.golfmax.presenters.UserPresenter Guest2Presenter) {
        this.mGuest2Presenter = Guest2Presenter;
    }
    public void setGuest2(@Nullable com.example.golfmax.models.User Guest2) {
        updateRegistration(4, Guest2);
        this.mGuest2 = Guest2;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.guest2);
        super.requestRebind();
    }
    public void setGuest3(@Nullable com.example.golfmax.models.User Guest3) {
        updateRegistration(5, Guest3);
        this.mGuest3 = Guest3;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.guest3);
        super.requestRebind();
    }
    public void setGuest2Score(@Nullable com.example.golfmax.models.Score Guest2Score) {
        updateRegistration(6, Guest2Score);
        this.mGuest2Score = Guest2Score;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.guest2Score);
        super.requestRebind();
    }
    public void setGuest3Score(@Nullable com.example.golfmax.models.Score Guest3Score) {
        updateRegistration(7, Guest3Score);
        this.mGuest3Score = Guest3Score;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.guest3Score);
        super.requestRebind();
    }
    public void setGuest1(@Nullable com.example.golfmax.models.User Guest1) {
        updateRegistration(8, Guest1);
        this.mGuest1 = Guest1;
        synchronized(this) {
            mDirtyFlags |= 0x100L;
        }
        notifyPropertyChanged(BR.guest1);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeGuest1Score((com.example.golfmax.models.Score) object, fieldId);
            case 1 :
                return onChangeCourse((com.example.golfmax.models.Course) object, fieldId);
            case 2 :
                return onChangeUserScore((com.example.golfmax.models.Score) object, fieldId);
            case 3 :
                return onChangeUser((com.example.golfmax.models.User) object, fieldId);
            case 4 :
                return onChangeGuest2((com.example.golfmax.models.User) object, fieldId);
            case 5 :
                return onChangeGuest3((com.example.golfmax.models.User) object, fieldId);
            case 6 :
                return onChangeGuest2Score((com.example.golfmax.models.Score) object, fieldId);
            case 7 :
                return onChangeGuest3Score((com.example.golfmax.models.Score) object, fieldId);
            case 8 :
                return onChangeGuest1((com.example.golfmax.models.User) object, fieldId);
        }
        return false;
    }
    private boolean onChangeGuest1Score(com.example.golfmax.models.Score Guest1Score, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.hole1) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000L;
            }
            return true;
        }
        else if (fieldId == BR.hole2) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000L;
            }
            return true;
        }
        else if (fieldId == BR.hole3) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000L;
            }
            return true;
        }
        else if (fieldId == BR.hole4) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000L;
            }
            return true;
        }
        else if (fieldId == BR.hole5) {
            synchronized(this) {
                    mDirtyFlags |= 0x40000L;
            }
            return true;
        }
        else if (fieldId == BR.hole6) {
            synchronized(this) {
                    mDirtyFlags |= 0x80000L;
            }
            return true;
        }
        else if (fieldId == BR.hole7) {
            synchronized(this) {
                    mDirtyFlags |= 0x100000L;
            }
            return true;
        }
        else if (fieldId == BR.hole8) {
            synchronized(this) {
                    mDirtyFlags |= 0x200000L;
            }
            return true;
        }
        else if (fieldId == BR.hole9) {
            synchronized(this) {
                    mDirtyFlags |= 0x400000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeCourse(com.example.golfmax.models.Course Course, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.hole1) {
            synchronized(this) {
                    mDirtyFlags |= 0x800000L;
            }
            return true;
        }
        else if (fieldId == BR.hole2) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole3) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole4) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole5) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole6) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole7) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole8) {
            synchronized(this) {
                    mDirtyFlags |= 0x40000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole9) {
            synchronized(this) {
                    mDirtyFlags |= 0x80000000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeUserScore(com.example.golfmax.models.Score UserScore, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.hole1) {
            synchronized(this) {
                    mDirtyFlags |= 0x100000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole2) {
            synchronized(this) {
                    mDirtyFlags |= 0x200000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole3) {
            synchronized(this) {
                    mDirtyFlags |= 0x400000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole4) {
            synchronized(this) {
                    mDirtyFlags |= 0x800000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole5) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole6) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole7) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole8) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole9) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000000000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeUser(com.example.golfmax.models.User User, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.username) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000000000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeGuest2(com.example.golfmax.models.User Guest2, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        else if (fieldId == BR.username) {
            synchronized(this) {
                    mDirtyFlags |= 0x40000000000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeGuest3(com.example.golfmax.models.User Guest3, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        else if (fieldId == BR.username) {
            synchronized(this) {
                    mDirtyFlags |= 0x80000000000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeGuest2Score(com.example.golfmax.models.Score Guest2Score, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        else if (fieldId == BR.hole1) {
            synchronized(this) {
                    mDirtyFlags |= 0x100000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole2) {
            synchronized(this) {
                    mDirtyFlags |= 0x200000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole3) {
            synchronized(this) {
                    mDirtyFlags |= 0x400000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole4) {
            synchronized(this) {
                    mDirtyFlags |= 0x800000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole5) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole6) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole7) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole8) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole9) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000000000000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeGuest3Score(com.example.golfmax.models.Score Guest3Score, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        else if (fieldId == BR.hole1) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole2) {
            synchronized(this) {
                    mDirtyFlags |= 0x40000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole3) {
            synchronized(this) {
                    mDirtyFlags |= 0x80000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole4) {
            synchronized(this) {
                    mDirtyFlags |= 0x100000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole5) {
            synchronized(this) {
                    mDirtyFlags |= 0x200000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole6) {
            synchronized(this) {
                    mDirtyFlags |= 0x400000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole7) {
            synchronized(this) {
                    mDirtyFlags |= 0x800000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole8) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000000000000000L;
            }
            return true;
        }
        else if (fieldId == BR.hole9) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000000000000000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeGuest1(com.example.golfmax.models.User Guest1, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        else if (fieldId == BR.username) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000000000000000L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        long dirtyFlags_1 = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
            dirtyFlags_1 = mDirtyFlags_1;
            mDirtyFlags_1 = 0;
        }
        java.lang.String userScoreHole8 = null;
        java.lang.String guest1Username = null;
        int courseHole7 = 0;
        com.example.golfmax.models.Score guest1Score = mGuest1Score;
        java.lang.String guest2ScoreHole3 = null;
        java.lang.String guest1ScoreHole5 = null;
        com.example.golfmax.presenters.ScorePresenter scorePresenter = mScorePresenter;
        java.lang.String stringValueOfCourseHole1 = null;
        java.lang.String guest3ScoreHole8 = null;
        int courseHole6 = 0;
        com.example.golfmax.models.Course course = mCourse;
        java.lang.String userScoreHole7 = null;
        java.lang.String stringValueOfCourseHole8 = null;
        java.lang.String guest2ScoreHole4 = null;
        java.lang.String guest2Username = null;
        java.lang.String guest1ScoreHole6 = null;
        java.lang.String guest3ScoreHole7 = null;
        int courseHole5 = 0;
        java.lang.String userScoreHole2 = null;
        java.lang.String stringValueOfCourseHole6 = null;
        java.lang.String guest2ScoreHole1 = null;
        java.lang.String stringValueOfCourseHole5 = null;
        java.lang.String guest2ScoreHole9 = null;
        com.example.golfmax.models.Score userScore = mUserScore;
        java.lang.String stringValueOfCourseHole7 = null;
        com.example.golfmax.models.User user = mUser;
        java.lang.String guest1ScoreHole7 = null;
        java.lang.String guest3ScoreHole6 = null;
        java.lang.String userScoreHole9 = null;
        int courseHole4 = 0;
        java.lang.String userScoreHole1 = null;
        java.lang.String guest2ScoreHole2 = null;
        java.lang.String guest1ScoreHole8 = null;
        java.lang.String guest3ScoreHole5 = null;
        java.lang.String userUsername = null;
        java.lang.String userScoreHole4 = null;
        java.lang.String guest2ScoreHole7 = null;
        java.lang.String guest1ScoreHole1 = null;
        int courseHole3 = 0;
        java.lang.String guest1ScoreHole9 = null;
        java.lang.String guest3ScoreHole4 = null;
        java.lang.String guest3Username = null;
        java.lang.String userScoreHole3 = null;
        java.lang.String guest2ScoreHole8 = null;
        int courseHole2 = 0;
        java.lang.String stringValueOfCourseHole2 = null;
        java.lang.String guest1ScoreHole2 = null;
        java.lang.String guest3ScoreHole3 = null;
        int courseHole9 = 0;
        java.lang.String userScoreHole6 = null;
        com.example.golfmax.models.User guest2 = mGuest2;
        java.lang.String guest2ScoreHole5 = null;
        int courseHole1 = 0;
        java.lang.String stringValueOfCourseHole4 = null;
        java.lang.String guest1ScoreHole3 = null;
        com.example.golfmax.models.User guest3 = mGuest3;
        java.lang.String guest3ScoreHole2 = null;
        int courseHole8 = 0;
        java.lang.String stringValueOfCourseHole3 = null;
        com.example.golfmax.models.Score guest2Score = mGuest2Score;
        java.lang.String stringValueOfCourseHole9 = null;
        java.lang.String userScoreHole5 = null;
        java.lang.String guest2ScoreHole6 = null;
        java.lang.String guest1ScoreHole4 = null;
        com.example.golfmax.models.Score guest3Score = mGuest3Score;
        com.example.golfmax.models.User guest1 = mGuest1;
        java.lang.String guest3ScoreHole9 = null;
        java.lang.String guest3ScoreHole1 = null;

        if ((dirtyFlags & 0x80000000007fc001L) != 0) {


            if ((dirtyFlags & 0x8000000000040001L) != 0) {

                    if (guest1Score != null) {
                        // read guest1Score.hole5
                        guest1ScoreHole5 = guest1Score.getHole5();
                    }
            }
            if ((dirtyFlags & 0x8000000000080001L) != 0) {

                    if (guest1Score != null) {
                        // read guest1Score.hole6
                        guest1ScoreHole6 = guest1Score.getHole6();
                    }
            }
            if ((dirtyFlags & 0x8000000000100001L) != 0) {

                    if (guest1Score != null) {
                        // read guest1Score.hole7
                        guest1ScoreHole7 = guest1Score.getHole7();
                    }
            }
            if ((dirtyFlags & 0x8000000000200001L) != 0) {

                    if (guest1Score != null) {
                        // read guest1Score.hole8
                        guest1ScoreHole8 = guest1Score.getHole8();
                    }
            }
            if ((dirtyFlags & 0x8000000000004001L) != 0) {

                    if (guest1Score != null) {
                        // read guest1Score.hole1
                        guest1ScoreHole1 = guest1Score.getHole1();
                    }
            }
            if ((dirtyFlags & 0x8000000000400001L) != 0) {

                    if (guest1Score != null) {
                        // read guest1Score.hole9
                        guest1ScoreHole9 = guest1Score.getHole9();
                    }
            }
            if ((dirtyFlags & 0x8000000000008001L) != 0) {

                    if (guest1Score != null) {
                        // read guest1Score.hole2
                        guest1ScoreHole2 = guest1Score.getHole2();
                    }
            }
            if ((dirtyFlags & 0x8000000000010001L) != 0) {

                    if (guest1Score != null) {
                        // read guest1Score.hole3
                        guest1ScoreHole3 = guest1Score.getHole3();
                    }
            }
            if ((dirtyFlags & 0x8000000000020001L) != 0) {

                    if (guest1Score != null) {
                        // read guest1Score.hole4
                        guest1ScoreHole4 = guest1Score.getHole4();
                    }
            }
        }
        if ((dirtyFlags & 0x80000000ff800002L) != 0) {


            if ((dirtyFlags & 0x8000000020000002L) != 0) {

                    if (course != null) {
                        // read course.hole7
                        courseHole7 = course.getHole7();
                    }


                    // read String.valueOf(course.hole7)
                    stringValueOfCourseHole7 = java.lang.String.valueOf(courseHole7);
            }
            if ((dirtyFlags & 0x8000000010000002L) != 0) {

                    if (course != null) {
                        // read course.hole6
                        courseHole6 = course.getHole6();
                    }


                    // read String.valueOf(course.hole6)
                    stringValueOfCourseHole6 = java.lang.String.valueOf(courseHole6);
            }
            if ((dirtyFlags & 0x8000000008000002L) != 0) {

                    if (course != null) {
                        // read course.hole5
                        courseHole5 = course.getHole5();
                    }


                    // read String.valueOf(course.hole5)
                    stringValueOfCourseHole5 = java.lang.String.valueOf(courseHole5);
            }
            if ((dirtyFlags & 0x8000000004000002L) != 0) {

                    if (course != null) {
                        // read course.hole4
                        courseHole4 = course.getHole4();
                    }


                    // read String.valueOf(course.hole4)
                    stringValueOfCourseHole4 = java.lang.String.valueOf(courseHole4);
            }
            if ((dirtyFlags & 0x8000000002000002L) != 0) {

                    if (course != null) {
                        // read course.hole3
                        courseHole3 = course.getHole3();
                    }


                    // read String.valueOf(course.hole3)
                    stringValueOfCourseHole3 = java.lang.String.valueOf(courseHole3);
            }
            if ((dirtyFlags & 0x8000000001000002L) != 0) {

                    if (course != null) {
                        // read course.hole2
                        courseHole2 = course.getHole2();
                    }


                    // read String.valueOf(course.hole2)
                    stringValueOfCourseHole2 = java.lang.String.valueOf(courseHole2);
            }
            if ((dirtyFlags & 0x8000000080000002L) != 0) {

                    if (course != null) {
                        // read course.hole9
                        courseHole9 = course.getHole9();
                    }


                    // read String.valueOf(course.hole9)
                    stringValueOfCourseHole9 = java.lang.String.valueOf(courseHole9);
            }
            if ((dirtyFlags & 0x8000000000800002L) != 0) {

                    if (course != null) {
                        // read course.hole1
                        courseHole1 = course.getHole1();
                    }


                    // read String.valueOf(course.hole1)
                    stringValueOfCourseHole1 = java.lang.String.valueOf(courseHole1);
            }
            if ((dirtyFlags & 0x8000000040000002L) != 0) {

                    if (course != null) {
                        // read course.hole8
                        courseHole8 = course.getHole8();
                    }


                    // read String.valueOf(course.hole8)
                    stringValueOfCourseHole8 = java.lang.String.valueOf(courseHole8);
            }
        }
        if ((dirtyFlags & 0x800001ff00000004L) != 0) {


            if ((dirtyFlags & 0x8000008000000004L) != 0) {

                    if (userScore != null) {
                        // read userScore.hole8
                        userScoreHole8 = userScore.getHole8();
                    }
            }
            if ((dirtyFlags & 0x8000004000000004L) != 0) {

                    if (userScore != null) {
                        // read userScore.hole7
                        userScoreHole7 = userScore.getHole7();
                    }
            }
            if ((dirtyFlags & 0x8000000200000004L) != 0) {

                    if (userScore != null) {
                        // read userScore.hole2
                        userScoreHole2 = userScore.getHole2();
                    }
            }
            if ((dirtyFlags & 0x8000010000000004L) != 0) {

                    if (userScore != null) {
                        // read userScore.hole9
                        userScoreHole9 = userScore.getHole9();
                    }
            }
            if ((dirtyFlags & 0x8000000100000004L) != 0) {

                    if (userScore != null) {
                        // read userScore.hole1
                        userScoreHole1 = userScore.getHole1();
                    }
            }
            if ((dirtyFlags & 0x8000000800000004L) != 0) {

                    if (userScore != null) {
                        // read userScore.hole4
                        userScoreHole4 = userScore.getHole4();
                    }
            }
            if ((dirtyFlags & 0x8000000400000004L) != 0) {

                    if (userScore != null) {
                        // read userScore.hole3
                        userScoreHole3 = userScore.getHole3();
                    }
            }
            if ((dirtyFlags & 0x8000002000000004L) != 0) {

                    if (userScore != null) {
                        // read userScore.hole6
                        userScoreHole6 = userScore.getHole6();
                    }
            }
            if ((dirtyFlags & 0x8000001000000004L) != 0) {

                    if (userScore != null) {
                        // read userScore.hole5
                        userScoreHole5 = userScore.getHole5();
                    }
            }
        }
        if ((dirtyFlags & 0x8000020000000008L) != 0) {



                if (user != null) {
                    // read user.username
                    userUsername = user.getUsername();
                }
        }
        if ((dirtyFlags & 0x8000040000000010L) != 0) {



                if (guest2 != null) {
                    // read guest2.username
                    guest2Username = guest2.getUsername();
                }
        }
        if ((dirtyFlags & 0x8000080000000020L) != 0) {



                if (guest3 != null) {
                    // read guest3.username
                    guest3Username = guest3.getUsername();
                }
        }
        if ((dirtyFlags & 0x801ff00000000040L) != 0) {


            if ((dirtyFlags & 0x8000400000000040L) != 0) {

                    if (guest2Score != null) {
                        // read guest2Score.hole3
                        guest2ScoreHole3 = guest2Score.getHole3();
                    }
            }
            if ((dirtyFlags & 0x8000800000000040L) != 0) {

                    if (guest2Score != null) {
                        // read guest2Score.hole4
                        guest2ScoreHole4 = guest2Score.getHole4();
                    }
            }
            if ((dirtyFlags & 0x8000100000000040L) != 0) {

                    if (guest2Score != null) {
                        // read guest2Score.hole1
                        guest2ScoreHole1 = guest2Score.getHole1();
                    }
            }
            if ((dirtyFlags & 0x8010000000000040L) != 0) {

                    if (guest2Score != null) {
                        // read guest2Score.hole9
                        guest2ScoreHole9 = guest2Score.getHole9();
                    }
            }
            if ((dirtyFlags & 0x8000200000000040L) != 0) {

                    if (guest2Score != null) {
                        // read guest2Score.hole2
                        guest2ScoreHole2 = guest2Score.getHole2();
                    }
            }
            if ((dirtyFlags & 0x8004000000000040L) != 0) {

                    if (guest2Score != null) {
                        // read guest2Score.hole7
                        guest2ScoreHole7 = guest2Score.getHole7();
                    }
            }
            if ((dirtyFlags & 0x8008000000000040L) != 0) {

                    if (guest2Score != null) {
                        // read guest2Score.hole8
                        guest2ScoreHole8 = guest2Score.getHole8();
                    }
            }
            if ((dirtyFlags & 0x8001000000000040L) != 0) {

                    if (guest2Score != null) {
                        // read guest2Score.hole5
                        guest2ScoreHole5 = guest2Score.getHole5();
                    }
            }
            if ((dirtyFlags & 0x8002000000000040L) != 0) {

                    if (guest2Score != null) {
                        // read guest2Score.hole6
                        guest2ScoreHole6 = guest2Score.getHole6();
                    }
            }
        }
        if ((dirtyFlags & 0xbfe0000000000080L) != 0) {


            if ((dirtyFlags & 0x9000000000000080L) != 0) {

                    if (guest3Score != null) {
                        // read guest3Score.hole8
                        guest3ScoreHole8 = guest3Score.getHole8();
                    }
            }
            if ((dirtyFlags & 0x8800000000000080L) != 0) {

                    if (guest3Score != null) {
                        // read guest3Score.hole7
                        guest3ScoreHole7 = guest3Score.getHole7();
                    }
            }
            if ((dirtyFlags & 0x8400000000000080L) != 0) {

                    if (guest3Score != null) {
                        // read guest3Score.hole6
                        guest3ScoreHole6 = guest3Score.getHole6();
                    }
            }
            if ((dirtyFlags & 0x8200000000000080L) != 0) {

                    if (guest3Score != null) {
                        // read guest3Score.hole5
                        guest3ScoreHole5 = guest3Score.getHole5();
                    }
            }
            if ((dirtyFlags & 0x8100000000000080L) != 0) {

                    if (guest3Score != null) {
                        // read guest3Score.hole4
                        guest3ScoreHole4 = guest3Score.getHole4();
                    }
            }
            if ((dirtyFlags & 0x8080000000000080L) != 0) {

                    if (guest3Score != null) {
                        // read guest3Score.hole3
                        guest3ScoreHole3 = guest3Score.getHole3();
                    }
            }
            if ((dirtyFlags & 0x8040000000000080L) != 0) {

                    if (guest3Score != null) {
                        // read guest3Score.hole2
                        guest3ScoreHole2 = guest3Score.getHole2();
                    }
            }
            if ((dirtyFlags & 0xa000000000000080L) != 0) {

                    if (guest3Score != null) {
                        // read guest3Score.hole9
                        guest3ScoreHole9 = guest3Score.getHole9();
                    }
            }
            if ((dirtyFlags & 0x8020000000000080L) != 0) {

                    if (guest3Score != null) {
                        // read guest3Score.hole1
                        guest3ScoreHole1 = guest3Score.getHole1();
                    }
            }
        }
        if ((dirtyFlags & 0xc000000000000100L) != 0) {



                if (guest1 != null) {
                    // read guest1.username
                    guest1Username = guest1.getUsername();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x8000000100000004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole1, userScoreHole1);
        }
        if ((dirtyFlags & 0x8000000000000000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole1Guest1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole1Guest1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole1Guest2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole1Guest2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole1Guest3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole1Guest3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole2Guest1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole2Guest1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole2Guest2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole2Guest2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole2Guest3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole2Guest3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole3Guest1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole3Guest1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole3Guest2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole3Guest2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole3Guest3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole3Guest3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole4androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole4Guest1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole4Guest1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole4Guest2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole4Guest2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole4Guest3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole4Guest3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole5, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole5androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole5Guest1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole5Guest1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole5Guest2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole5Guest2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole5Guest3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole5Guest3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole6, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole6androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole6Guest1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole6Guest1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole6Guest2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole6Guest2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole6Guest3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole6Guest3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole7, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole7androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole7Guest1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole7Guest1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole7Guest2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole7Guest2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole7Guest3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole7Guest3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole8, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole8androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole8Guest1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole8Guest1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole8Guest2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole8Guest2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole8Guest3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole8Guest3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole9, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole9androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole9Guest1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole9Guest1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole9Guest2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole9Guest2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextHole9Guest3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextHole9Guest3androidTextAttrChanged);
            this.mboundView50.setOnClickListener(mCallback3);
            this.mboundView52.setOnClickListener(mCallback4);
            this.mboundView54.setOnClickListener(mCallback5);
            this.mboundView56.setOnClickListener(mCallback6);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textInputEditTextGuest1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textInputEditTextGuest1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textInputEditTextGuest2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textInputEditTextGuest2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textInputEditTextGuest3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textInputEditTextGuest3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textViewCurrentScoreGuest1Name, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textViewCurrentScoreGuest1NameandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textViewCurrentScoreGuest2Name, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textViewCurrentScoreGuest2NameandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textViewCurrentScoreGuest3Name, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textViewCurrentScoreGuest3NameandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textViewCurrentScoreUsername, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textViewCurrentScoreUsernameandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textViewUsername, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textViewUsernameandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x8000000000004001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole1Guest1, guest1ScoreHole1);
        }
        if ((dirtyFlags & 0x8000100000000040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole1Guest2, guest2ScoreHole1);
        }
        if ((dirtyFlags & 0x8020000000000080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole1Guest3, guest3ScoreHole1);
        }
        if ((dirtyFlags & 0x8000000200000004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole2, userScoreHole2);
        }
        if ((dirtyFlags & 0x8000000000008001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole2Guest1, guest1ScoreHole2);
        }
        if ((dirtyFlags & 0x8000200000000040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole2Guest2, guest2ScoreHole2);
        }
        if ((dirtyFlags & 0x8040000000000080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole2Guest3, guest3ScoreHole2);
        }
        if ((dirtyFlags & 0x8000000400000004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole3, userScoreHole3);
        }
        if ((dirtyFlags & 0x8000000000010001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole3Guest1, guest1ScoreHole3);
        }
        if ((dirtyFlags & 0x8000400000000040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole3Guest2, guest2ScoreHole3);
        }
        if ((dirtyFlags & 0x8080000000000080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole3Guest3, guest3ScoreHole3);
        }
        if ((dirtyFlags & 0x8000000800000004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole4, userScoreHole4);
        }
        if ((dirtyFlags & 0x8000000000020001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole4Guest1, guest1ScoreHole4);
        }
        if ((dirtyFlags & 0x8000800000000040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole4Guest2, guest2ScoreHole4);
        }
        if ((dirtyFlags & 0x8100000000000080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole4Guest3, guest3ScoreHole4);
        }
        if ((dirtyFlags & 0x8000001000000004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole5, userScoreHole5);
        }
        if ((dirtyFlags & 0x8000000000040001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole5Guest1, guest1ScoreHole5);
        }
        if ((dirtyFlags & 0x8001000000000040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole5Guest2, guest2ScoreHole5);
        }
        if ((dirtyFlags & 0x8200000000000080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole5Guest3, guest3ScoreHole5);
        }
        if ((dirtyFlags & 0x8000002000000004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole6, userScoreHole6);
        }
        if ((dirtyFlags & 0x8000000000080001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole6Guest1, guest1ScoreHole6);
        }
        if ((dirtyFlags & 0x8002000000000040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole6Guest2, guest2ScoreHole6);
        }
        if ((dirtyFlags & 0x8400000000000080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole6Guest3, guest3ScoreHole6);
        }
        if ((dirtyFlags & 0x8000004000000004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole7, userScoreHole7);
        }
        if ((dirtyFlags & 0x8000000000100001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole7Guest1, guest1ScoreHole7);
        }
        if ((dirtyFlags & 0x8004000000000040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole7Guest2, guest2ScoreHole7);
        }
        if ((dirtyFlags & 0x8800000000000080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole7Guest3, guest3ScoreHole7);
        }
        if ((dirtyFlags & 0x8000008000000004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole8, userScoreHole8);
        }
        if ((dirtyFlags & 0x8000000000200001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole8Guest1, guest1ScoreHole8);
        }
        if ((dirtyFlags & 0x8008000000000040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole8Guest2, guest2ScoreHole8);
        }
        if ((dirtyFlags & 0x9000000000000080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole8Guest3, guest3ScoreHole8);
        }
        if ((dirtyFlags & 0x8000010000000004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole9, userScoreHole9);
        }
        if ((dirtyFlags & 0x8000000000400001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole9Guest1, guest1ScoreHole9);
        }
        if ((dirtyFlags & 0x8010000000000040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole9Guest2, guest2ScoreHole9);
        }
        if ((dirtyFlags & 0xa000000000000080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextHole9Guest3, guest3ScoreHole9);
        }
        if ((dirtyFlags & 0xc000000000000100L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textInputEditTextGuest1, guest1Username);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewCurrentScoreGuest1Name, guest1Username);
        }
        if ((dirtyFlags & 0x8000040000000010L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textInputEditTextGuest2, guest2Username);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewCurrentScoreGuest2Name, guest2Username);
        }
        if ((dirtyFlags & 0x8000080000000020L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textInputEditTextGuest3, guest3Username);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewCurrentScoreGuest3Name, guest3Username);
        }
        if ((dirtyFlags & 0x8000020000000008L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewCurrentScoreUsername, userUsername);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewUsername, userUsername);
        }
        if ((dirtyFlags & 0x8000000000800002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewPar1, stringValueOfCourseHole1);
        }
        if ((dirtyFlags & 0x8000000001000002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewPar2, stringValueOfCourseHole2);
        }
        if ((dirtyFlags & 0x8000000002000002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewPar3, stringValueOfCourseHole3);
        }
        if ((dirtyFlags & 0x8000000004000002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewPar4, stringValueOfCourseHole4);
        }
        if ((dirtyFlags & 0x8000000008000002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewPar5, stringValueOfCourseHole5);
        }
        if ((dirtyFlags & 0x8000000010000002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewPar6, stringValueOfCourseHole6);
        }
        if ((dirtyFlags & 0x8000000020000002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewPar7, stringValueOfCourseHole7);
        }
        if ((dirtyFlags & 0x8000000040000002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewPar8, stringValueOfCourseHole8);
        }
        if ((dirtyFlags & 0x8000000080000002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewPar9, stringValueOfCourseHole9);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // guest1Score
                com.example.golfmax.models.Score guest1Score = mGuest1Score;
                // scorePresenter != null
                boolean scorePresenterJavaLangObjectNull = false;
                // scorePresenter
                com.example.golfmax.presenters.ScorePresenter scorePresenter = mScorePresenter;



                scorePresenterJavaLangObjectNull = (scorePresenter) != (null);
                if (scorePresenterJavaLangObjectNull) {



                    scorePresenter.onShowGuest1Score(guest1Score);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // scorePresenter != null
                boolean scorePresenterJavaLangObjectNull = false;
                // guest2Score
                com.example.golfmax.models.Score guest2Score = mGuest2Score;
                // scorePresenter
                com.example.golfmax.presenters.ScorePresenter scorePresenter = mScorePresenter;



                scorePresenterJavaLangObjectNull = (scorePresenter) != (null);
                if (scorePresenterJavaLangObjectNull) {



                    scorePresenter.onShowGuest2Score(guest2Score);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // scorePresenter != null
                boolean scorePresenterJavaLangObjectNull = false;
                // guest3Score
                com.example.golfmax.models.Score guest3Score = mGuest3Score;
                // scorePresenter
                com.example.golfmax.presenters.ScorePresenter scorePresenter = mScorePresenter;



                scorePresenterJavaLangObjectNull = (scorePresenter) != (null);
                if (scorePresenterJavaLangObjectNull) {



                    scorePresenter.onShowGuest3Score(guest3Score);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // scorePresenter != null
                boolean scorePresenterJavaLangObjectNull = false;
                // scorePresenter
                com.example.golfmax.presenters.ScorePresenter scorePresenter = mScorePresenter;
                // userScore
                com.example.golfmax.models.Score userScore = mUserScore;



                scorePresenterJavaLangObjectNull = (scorePresenter) != (null);
                if (scorePresenterJavaLangObjectNull) {



                    scorePresenter.onShowUserScore(userScore);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    private  long mDirtyFlags_1 = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): guest1Score
        flag 1 (0x2L): course
        flag 2 (0x3L): userScore
        flag 3 (0x4L): user
        flag 4 (0x5L): guest2
        flag 5 (0x6L): guest3
        flag 6 (0x7L): guest2Score
        flag 7 (0x8L): guest3Score
        flag 8 (0x9L): guest1
        flag 9 (0xaL): scorePresenter
        flag 10 (0xbL): guest3Presenter
        flag 11 (0xcL): userPresenter
        flag 12 (0xdL): guest1Presenter
        flag 13 (0xeL): guest2Presenter
        flag 14 (0xfL): guest1Score.hole1
        flag 15 (0x10L): guest1Score.hole2
        flag 16 (0x11L): guest1Score.hole3
        flag 17 (0x12L): guest1Score.hole4
        flag 18 (0x13L): guest1Score.hole5
        flag 19 (0x14L): guest1Score.hole6
        flag 20 (0x15L): guest1Score.hole7
        flag 21 (0x16L): guest1Score.hole8
        flag 22 (0x17L): guest1Score.hole9
        flag 23 (0x18L): course.hole1
        flag 24 (0x19L): course.hole2
        flag 25 (0x1aL): course.hole3
        flag 26 (0x1bL): course.hole4
        flag 27 (0x1cL): course.hole5
        flag 28 (0x1dL): course.hole6
        flag 29 (0x1eL): course.hole7
        flag 30 (0x1fL): course.hole8
        flag 31 (0x20L): course.hole9
        flag 32 (0x21L): userScore.hole1
        flag 33 (0x22L): userScore.hole2
        flag 34 (0x23L): userScore.hole3
        flag 35 (0x24L): userScore.hole4
        flag 36 (0x25L): userScore.hole5
        flag 37 (0x26L): userScore.hole6
        flag 38 (0x27L): userScore.hole7
        flag 39 (0x28L): userScore.hole8
        flag 40 (0x29L): userScore.hole9
        flag 41 (0x2aL): user.username
        flag 42 (0x2bL): guest2.username
        flag 43 (0x2cL): guest3.username
        flag 44 (0x2dL): guest2Score.hole1
        flag 45 (0x2eL): guest2Score.hole2
        flag 46 (0x2fL): guest2Score.hole3
        flag 47 (0x30L): guest2Score.hole4
        flag 48 (0x31L): guest2Score.hole5
        flag 49 (0x32L): guest2Score.hole6
        flag 50 (0x33L): guest2Score.hole7
        flag 51 (0x34L): guest2Score.hole8
        flag 52 (0x35L): guest2Score.hole9
        flag 53 (0x36L): guest3Score.hole1
        flag 54 (0x37L): guest3Score.hole2
        flag 55 (0x38L): guest3Score.hole3
        flag 56 (0x39L): guest3Score.hole4
        flag 57 (0x3aL): guest3Score.hole5
        flag 58 (0x3bL): guest3Score.hole6
        flag 59 (0x3cL): guest3Score.hole7
        flag 60 (0x3dL): guest3Score.hole8
        flag 61 (0x3eL): guest3Score.hole9
        flag 62 (0x3fL): guest1.username
        flag 63 (0x40L): null
    flag mapping end*/
    //end
}